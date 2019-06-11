package pms.restController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FinanceController {

	
	/**
	 * -管理员进入缴费管理页面
	 * -显示该页面的数据     FinanceExpenseDto     FinancePaymentDto 
	 * @param model
	 * @return
	 */
	@GetMapping("/financeManage")
	public String financeManage(Model model) {
		System.out.print(" here is financeManage.html\n");
		return "financeManage";
	}
	
	/**
	 * -缴费(修改消费记录状态)
	 * @param model
	 * @return
	 */
	@GetMapping("/doPayment/{expenseRecordId}")
	public String doPayment(@PathVariable (value="expenseRecordId") int expenseRecordId) {

		return  null;
	}
	
	/**
	 * -我的缴费业主的财务管理
	 * @param model   FinanceExpenseDto   FinancePaymentDto
	 * @return
	 */
	@GetMapping("/ownerFinance")
	public String ownerFinance(Model model) {
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
		System.out.print(" here is ownerFinance.html\n");
		return null;

	}
	
}
