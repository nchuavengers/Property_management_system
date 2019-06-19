package pms.dto;

import java.util.Date;

import org.springframework.stereotype.Component;
/**
 * @author Lenovo
 *
 */
@Component
public class FinanceExpenseDto {
	private int expenseId;//消费ID
    private int ownerId;//业主id
    private String ownerName;//业主姓名
    private String expenseContent;//消费内容
    private String expenseMoney;//消费金额
    private Date expenseTime;//消费时间
    private String paymentStatus;//缴费状态
    
	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getExpenseContent() {
		return expenseContent;
	}
	public void setExpenseContent(String expenseContent) {
		this.expenseContent = expenseContent;
	}
	public String getExpenseMoney() {
		return expenseMoney;
	}
	public void setExpenseMoney(String expenseMoney) {
		this.expenseMoney = expenseMoney;
	}
	public Date getExpenseTime() {
		return expenseTime;
	}
	public void setExpenseTime(Date expenseTime) {
		this.expenseTime = expenseTime;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
}
