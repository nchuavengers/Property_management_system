package pms.entity;

public class PaymentRecord {
    private int paymentId;//缴费记录编号
    private int ownerId;//业主id
    private int expenseId;//消费记录id
    
    private String paymentType;//收费方式//需修改数据库 收费人员变方式
    private String paymentMoney;//缴费总额
    private String paymentTime;//缴费时间
}
