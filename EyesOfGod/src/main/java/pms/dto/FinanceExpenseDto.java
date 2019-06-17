package pms.dto;

import java.util.Date;

public class FinanceExpenseDto {

    private int ownerId;//业主id
    private String ownerName;//业主姓名
    
    private String expenseContent;//消费内容
    private String expenseMoney;//消费金额
    private Date expenseTime;//消费时间
    private String paymentStatus;//缴费状态
}
