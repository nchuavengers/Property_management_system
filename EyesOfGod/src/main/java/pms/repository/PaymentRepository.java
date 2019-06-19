package pms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import pms.dto.FinancePaymentDto;


@Mapper
public interface PaymentRepository {
	@Select("SELECT pms.`owner`.`ownerId`, pms.`owner`.`ownerName`,pms.`paymentrecord`.`paymentTime`,pms.`expenserecord`.`expenseContent`,\r\n" + 
			"pms.`paymentrecord`.`paymentMoney`,pms.`paymentrecord`.`paymentType` FROM pms.`paymentrecord` ,pms.`owner`,pms.`expenserecord`\r\n" + 
			"WHERE pms.`owner`.`ownerId`=pms.`paymentrecord`.`ownerId` AND\r\n" + 
			"pms.`paymentrecord`.`expenseId`=pms.`expenserecord`.`expenseId`;")  
	public List<FinancePaymentDto>  findAllPayment();
	@Insert("INSERT INTO pms.`paymentrecord`(ownerId,expenseId,paymentType,paymentMoney,paymentTime) VALUE(${ownerId},${expenseId},${paymentType},${paymentMoney},'2019-05-15 08:00:00');") 
	public boolean  addPayment(FinancePaymentDto pay);

	@Select("") 
	public boolean modifyPayment();
	public boolean delPayment(int payId);
	
	@Select("SELECT pms.`owner`.`ownerId`, pms.`owner`.`ownerName`,pms.`paymentrecord`.`paymentTime`,pms.`expenserecord`.`expenseContent`,\r\n" + 
			"pms.`paymentrecord`.`paymentMoney`,pms.`paymentrecord`.`paymentType` FROM pms.`paymentrecord` ,pms.`owner`,pms.`expenserecord`\r\n" + 
			"WHERE pms.`owner`.`ownerId`=pms.`paymentrecord`.`ownerId` AND\r\n" + 
			"pms.`paymentrecord`.`expenseId`=pms.`expenserecord`.`expenseId` AND pms.`owner`.`ownerId`=${ownerId};")  
	public List<FinancePaymentDto>  findPersonalPayment(int ownerId);
}
