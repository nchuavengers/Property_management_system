package pms;


/**
 * 保存订单中的一些属性
 */
public class AlipayVo {

    //订单号
    private String out_trade_no;
    //订单名称
    private String subject;
     //付款金额
    private double total_amount;
    //销售产品码
    private String product_code;

    public AlipayVo() {
    }

    public AlipayVo(String out_trade_no, String subject, double total_amount, String product_code) {
        this.out_trade_no = out_trade_no;
        this.subject = subject;
        this.total_amount = total_amount;
        this.product_code = product_code;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

}
