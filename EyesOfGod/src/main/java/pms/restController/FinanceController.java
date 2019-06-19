package pms.restController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	//@RequestMapping("doPayment")
	@PostMapping("doPayment")
    public String doPayment(String expenseId,String test) {
		
		System.out.println(test+" ----->ID"+expenseId);
		//业务逻辑层：
		FinancePaymentDto pay=new FinancePaymentDto();
//		boolean b=expenseService.modifyExpense(expenseRecordId);
//		boolean a=paymentService.addPayment(null);
//		if(b){
//			//封装正确消息
//			result.put("status", "succcessful");//succcessful
//			result.put("msg", "succcessful！");
//		}
//		else {
//			//封装错误消息
//			result.put("status", "fail");//fail
//			result.put("msg", "修改失败！");
//		}
	
		return "financeManage";
	}
	
	/**
	 * -我的缴费业主的财务管理(个人
	 * @param model   FinanceExpenseDto   FinancePaymentDto
	 * @return
	 */
	@GetMapping("/ownerFinance")
	public String ownerFinance(Model model) {
		expenseList=expenseService.findAllExpenseDto();
		model.addAttribute("expenseList", expenseList);
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
