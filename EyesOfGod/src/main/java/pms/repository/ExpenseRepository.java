package pms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pms.dto.FinanceExpenseDto;

@Mapper
public interface ExpenseRepository {

	/**
	 * -查询所有消费信息FinanceExpenseDto
	 * @return
	 */
	@Select("SELECT pms.`expenserecord`.`expenseId`, pms.`owner`.`ownerId`, pms.`owner`.`ownerName`,pms.`expenserecord`.`expenseTime`,pms.`expenserecord`.`expenseContent`,pms.`expenserecord`.`expenseMoney`,\r\n" + 
			"pms.`expenserecord`.`paymentStatus` FROM pms.`owner`,pms.`expenserecord`\r\n" + 
			"WHERE pms.`owner`.`ownerId`=pms.`expenserecord`.`ownerId`;") 
	public List<FinanceExpenseDto>  findAllFinanceExpenseDto();
	
	@Select("SELECT pms.`expenserecord`.`expenseId`, pms.`owner`.`ownerId`, pms.`owner`.`ownerName`,pms.`expenserecord`.`expenseTime`,pms.`expenserecord`.`expenseContent`,pms.`expenserecord`.`expenseMoney`,\r\n" + 
			"pms.`expenserecord`.`paymentStatus` FROM pms.`owner`,pms.`expenserecord`\r\n" + 
			"WHERE pms.`owner`.`ownerId`=pms.`expenserecord`.`ownerId` AND pms.`owner`.`ownerId`=#{ownerId};") 
	public List<FinanceExpenseDto>  findPersonalDto(int ownerId);
	
	/**
	 * -缴费更新消费信息记录信息
	 * @param expenseRecordId
	 * @return
	 */
	@Update("UPDATE pms.`expenserecord` SET pms.`expenserecord`.`paymentStatus`='已缴费'  WHERE  pms.`expenserecord`.`expenseId`=#{expenseRecordId} ;")
	public boolean updateExpenseRecord(int  expenseRecordId);
	
	@Insert("INSERT INTO pms.`expenserecord`(ownerId,expenseContent,expenseMoney,expenseTime,paymentStatus) VALUE(#{ownerId},#{expenseContent},'200,2019-05-15 08:00:00',#{paymentStatus});")
	public boolean addExpenseRecord(FinanceExpenseDto expense);
	
	
	
	
	
	
	
	

}
