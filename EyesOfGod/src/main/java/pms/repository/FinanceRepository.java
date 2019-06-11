package pms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pms.dto.FinanceExpenseDto;
import pms.dto.FinancePaymentDto;
import pms.dto.OwnerManagerDto;
import pms.entity.Owner;

public interface FinanceRepository {

	/**
	 * -查询所有消费信息FinanceExpenseDto
	 * @return
	 */
	@Select("") 
	public List<FinanceExpenseDto>  findAllFinanceExpenseDto();
	/**
	 * -查询所有缴费信息FinancePaymentDto
	 * @return
	 */
	@Select("") 
	public List<FinancePaymentDto>  findAllFinancePaymentDto();
	
	/**
	 * -缴费更新消费信息记录信息
	 * @param expenseRecordId
	 * @return
	 */
	@Update("")
	public boolean updateExpenseRecord(int  expenseRecordId);
	
	
	
	
	
	/**
	 * -查询指定业主消费信息FinanceExpenseDto
	 * @return
	 */
	@Select("") 
	public List<FinanceExpenseDto>  findOwnerFinanceExpenseDto(int ownerId);
	
	/**
	 * -查询指定业主缴费信息FinancePaymentDto
	 * @return
	 */
	@Select("") 
	public List<FinancePaymentDto>  findOwnerFinancePaymentDto(int ownerId);
	
	
	
	
	
	
	
	
	
	

}
