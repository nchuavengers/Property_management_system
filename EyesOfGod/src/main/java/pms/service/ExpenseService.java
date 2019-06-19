package pms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pms.dto.FinanceExpenseDto;

@Service  
public interface ExpenseService {
	//查询所有消费记录
	List<FinanceExpenseDto>  findAllExpenseDto();
	//增加消费信息
	boolean addExpense(FinanceExpenseDto expense);
	//修改缴费状态： 未缴费->已缴费
	boolean modifyExpense(int expenseRecordId);
	//查询所有消费记录
	List<FinanceExpenseDto>  findPersonalExpenseDto(int owenerID);
}
