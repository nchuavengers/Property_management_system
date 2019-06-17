package pms.dto;

import java.util.Date;

public class FinancePaymentDto {

    private int ownerId;//业主id
    private String ownerName;//业主姓名
    
    private String expenseContent;//缴费内容即消费内容
    
    private String paymentType;//收费方式//需修改数据库 收费人员变方式
    private String paymentMoney;//缴费总额
    private Date paymentTime;//缴费时间
}
