package pms.restController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public String doPayment(String expenseId,Model model,String ownerId,String expenseMoney,String payType,HttpSession session) {
		
		System.out.println(" ----->ID"+expenseId);
		System.out.println(" ----->ID"+ownerId);
		System.out.println(" ----->ID"+expenseMoney);
		//业务逻辑层：
		FinancePaymentDto pay=new FinancePaymentDto();
		pay.setOwnerId(Integer.parseInt(ownerId));
		pay.setExpenseId(Integer.parseInt(expenseId));
		//pay.setPaymentTime(paymentTime);//时间暂定
		pay.setPaymentMoney(expenseMoney);
		if("online".equals(payType))
			pay.setPaymentType("网上缴费");
		else
			pay.setPaymentType("收银员:"+"ztx");
		//缴费分为两步：
		//1. 修改消费表中状态为已经缴费  2.添加一条缴费信息到数据库中0
		boolean a=paymentService.addPayment(pay);
		System.out.println("缴费结果："+a);
		if("online".equals(payType)) {
			Owner o=(Owner)(session.getAttribute("owner"));
			paymentList=paymentService.findPersonalPayment(o.getOwnerId());
			expenseList=expenseService.findPersonalExpenseDto(o.getOwnerId());
			model.addAttribute("expenseList", expenseList);
			model.addAttribute("paymentList", paymentList);
			System.out.print(" here is ownerFinance.html\n");
			return "ownerFinance";
		}
		else {
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
	/**
	 * -业主缴费
	 * --缴自己费(修改消费记录状态)
	 * @param model
	 * @return
	 */
	@GetMapping("/doMyPayment")
	public String doMyPayment(Model model) {
		expenseList=expenseService.findAllExpenseDto();
		System.out.print(" here is ownerFinance.html\n");
		return null;

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
