package pms.service;

import java.util.List;

import pms.dto.FinanceExpenseDto;
import pms.dto.FinancePaymentDto;
import pms.dto.OwnerManagerDto;

public interface FinanceService {

	/**
	 * -查询所有消费信息FinanceExpenseDto
	 * @return
	 */
	public List<FinanceExpenseDto>  findAllFinanceExpenseDto();
	
	/**
	 * -查询所有缴费信息FinancePaymentDto
	 * @return
	 */
	public List<FinancePaymentDto>  findAllFinancePaymentDto();
	
	/**
	 * -缴费(修改消费记录状态)
	 * @return   expenseRecordId
	 */
	public boolean  Payment(int  expenseRecordId);
	
	
	
	
	/**
	 * -查询指定业主消费信息FinanceExpenseDto
	 * @return
	 */
	public List<FinanceExpenseDto>  findOwnerFinanceExpenseDto(int ownerId);
	
	/**
	 * -查询指定业主缴费信息FinancePaymentDto
	 * @return
	 */
	public List<FinancePaymentDto>  findOwnerFinancePaymentDto(int ownerId);
	
	
	
	
	
	
	
	
	
	
	
}
