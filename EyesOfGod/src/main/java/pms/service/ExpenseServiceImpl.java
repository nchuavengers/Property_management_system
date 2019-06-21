package pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pms.dto.FinanceExpenseDto;
import pms.repository.ExpenseRepository;
@Service
public class ExpenseServiceImpl implements ExpenseService{
	@Autowired
	private ExpenseRepository er;
	@Override
	public List<FinanceExpenseDto> findAllExpenseDto() {
		// TODO Auto-generated method stub
		return er.findAllFinanceExpenseDto();
	}

	@Override
	public boolean addExpense(FinanceExpenseDto expense) {
		// TODO Auto-generated method stub
		return er.addExpenseRecord(expense);
	}

	@Override
	public boolean modifyExpense(int expenseId) {
		// TODO Auto-generated method stub
		return er.updateExpenseRecord(expenseId);
	}

	@Override
	public List<FinanceExpenseDto> findPersonalExpenseDto(int owenerID) {
		// TODO Auto-generated method stub
		return er.findPersonalDto(owenerID);
	}

}
