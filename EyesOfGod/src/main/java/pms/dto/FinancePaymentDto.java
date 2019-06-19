package pms.dto;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class FinancePaymentDto {

    private int ownerId;//业主id
    private String ownerName;//业主姓名
    private Date paymentTime;//缴费时间
    private String expenseContent;//缴费内容即消费内容
    private String paymentMoney;//缴费总额
    private String paymentType;//收费方式//需修改数据库 收费人员变方式
	public int getOwnerId() {
		return ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public Date getPaymentTime() {
		return paymentTime;
	}
	public String getExpenseContent() {
		return expenseContent;
	}
	public String getPaymentMoney() {
		return paymentMoney;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}
	public void setExpenseContent(String expenseContent) {
		this.expenseContent = expenseContent;
	}
	public void setPaymentMoney(String paymentMoney) {
		this.paymentMoney = paymentMoney;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
   
   
    
}
