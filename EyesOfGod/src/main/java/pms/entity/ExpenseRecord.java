package pms.entity;

import java.util.Date;

public class ExpenseRecord {
    private int expenseId;//消费记录id
    private int ownerId;//业主id
    private String expenseContent;//消费内容
    private String expenseMoney;//消费金额
    private Date expenseTime;//消费时间
    private String paymentStatus;//缴费状态
}
