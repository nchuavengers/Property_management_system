package pms.restController;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pms.dto.FinanceExpenseDto;
import pms.dto.FinancePaymentDto;
import pms.service.ExpenseService;
import pms.service.PaymentService;
import pms.entity.Owner;
@Controller
public class FinanceController {
	@Autowired
	private List<FinancePaymentDto> paymentList;
	@Autowired
	private List<FinanceExpenseDto> expenseList;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private ExpenseService expenseService;
	/**
	 * -管理员进入缴费管理页面
	 * -显示该页面的数据     FinanceExpenseDto     FinancePaymentDto 
	 * @param model
	 * @return
	 */
	@GetMapping("/financeManage")
	public String financeManage(Model model) {
		paymentList=paymentService.findAllPayment() ;
		expenseList=expenseService.findAllExpenseDto();
		model.addAttribute("paymentList",paymentList);
		model.addAttribute("expenseList",expenseList);
		System.out.print(" here is financeManage.html\n");
		return "financeManage";
	}
	@GetMapping("/financeView")
	public String financeView(Model model) {
		//由于数据库中物业费和停车费  缴费记录太少，此处为了显示统计报表功能完善，给该表传入24个值测试一下，模拟该24个值是由数据库的来的
		//物业费
		model.addAttribute("money1","100");
		model.addAttribute("money2","152");
		model.addAttribute("money3","546");
		model.addAttribute("money4","478");
		model.addAttribute("money5","245");
		model.addAttribute("money6","348");
		model.addAttribute("money7","782");
		model.addAttribute("money8","557");
		model.addAttribute("money9","752");
		model.addAttribute("money10","726");
		model.addAttribute("money11","522");
		model.addAttribute("money12","351");
		//停车费
		model.addAttribute("m1","472");
		model.addAttribute("m2","872");
		model.addAttribute("m3","778");
		model.addAttribute("m4","473");
		model.addAttribute("m5","378");
		model.addAttribute("m6","787");
		model.addAttribute("m7","774");
		model.addAttribute("m8","254");
		model.addAttribute("m9","254");
		model.addAttribute("m10","782");
		model.addAttribute("m11","281");
		model.addAttribute("m12","585");
		System.out.print(" here is financeView.html\n");
		return "financeView";
	}
	/**
	 * -缴费(修改消费记录状态)
	 * @param model
	 * @return
	 */
	
	/*
	 * 缴费功能，根据payType的值来判断缴费类型
	 * 缴费类型：
	 * 1. 用户网上缴费
	 * 2.业主线下缴费
	 * 
	 */
	@PostMapping("doPayment")
    public String doPayment(String expenseId,Model model,String ownerId,String expenseMoney,String payType,
    		String paymentStatus,String  expenseContent,HttpSession session) {
		
		System.out.println(" ----->ID"+expenseId);
		System.out.println(" ----->ID"+ownerId);
		System.out.println(" ----->ID"+expenseMoney);
		//业务逻辑层：
		FinancePaymentDto pay=new FinancePaymentDto();
		pay.setOwnerId(Integer.parseInt(ownerId));
		pay.setExpenseId(Integer.parseInt(expenseId));
		//pay.setPaymentTime(paymentTime);//时间暂定
		pay.setPaymentMoney(expenseMoney);
		
		//缴费分为两步：
		//1. 修改消费表中状态为已经缴费  2.添加一条缴费信息到数据库中0
	
		if("online".equals(payType)) { // 用户发送过来的请求，跳回用户界面
			if("未缴费".equals(paymentStatus)) {
			model.addAttribute("subject", expenseContent);
			model.addAttribute("expenseMoney", expenseMoney);
			model.addAttribute("expenseId", expenseId);
			
			pay.setPaymentType("网上缴费");
			boolean b=expenseService.modifyExpense(Integer.parseInt(expenseId));
			boolean a=paymentService.addPayment(pay);
			System.out.println("缴费结果："+(a&&b));
			return "ali2";
			}
			Owner o=(Owner)(session.getAttribute("owner"));
			paymentList=paymentService.findPersonalPayment(o.getOwnerId());
			expenseList=expenseService.findPersonalExpenseDto(o.getOwnerId());
			model.addAttribute("expenseList", expenseList);
			model.addAttribute("paymentList", paymentList);
			System.out.print(" here is ownerFinance.html\n");
			return "ownerFinance";
			
		}
		else {
			if("未缴费".equals(paymentStatus)) {
				pay.setPaymentType("收银员:"+"ztx");
				boolean b=expenseService.modifyExpense(Integer.parseInt(expenseId));
				boolean a=paymentService.addPayment(pay);
				System.out.println("缴费结果："+(a&&b));
				}
			paymentList=paymentService.findAllPayment() ;
			expenseList=expenseService.findAllExpenseDto();
			model.addAttribute("paymentList",paymentList);
			model.addAttribute("expenseList",expenseList);
			System.out.print(" here is financeManage.html\n");
			return "financeManage";
		}
			
		
	}
	
	/**
	 * -我的缴费业主的财务管理(个人
	 * @param model   FinanceExpenseDto   FinancePaymentDto
	 * @return
	 */
	@GetMapping("/ownerFinance")
	public String ownerFinance(Model model,HttpSession session) {
		System.out.println("here is ownerFinance.html");
		Owner a=(Owner)(session.getAttribute("owner"));
		
		System.out.println(a.getOwnerId());
		paymentList=paymentService.findPersonalPayment(a.getOwnerId());
		expenseList=expenseService.findPersonalExpenseDto(a.getOwnerId());
		model.addAttribute("expenseList", expenseList);
		model.addAttribute("paymentList", paymentList);
		System.out.print(" here is ownerFinance.html\n");
		return "ownerFinance";

	}
	
	@PostMapping("/addExpense")
	public String addExpense(Model model,String ownerId,String date,String expenseContent,
			String expenseMoney){
	    FinanceExpenseDto expense =new FinanceExpenseDto();
	    //加入参数
	    expense.setOwnerId(Integer.parseInt(ownerId));expense.setExpenseTime(new Date());
	    expense.setExpenseContent(expenseContent);expense.setExpenseMoney(expenseMoney);
		expenseService.addExpense(expense);
		System.out.println(ownerId+date+expenseContent+expenseMoney);
		paymentList=paymentService.findAllPayment() ;
		expenseList=expenseService.findAllExpenseDto();
		model.addAttribute("paymentList",paymentList);
		model.addAttribute("expenseList",expenseList);
		System.out.print(" here is financeManage.html\n");
		return "financeManage";
	}
	
	
	
}
