package pms.entity;

import java.util.Date;

public class VisitorRecord {
    private int visitorId;//访客记录id
    private int parkingSpaceId;//车位id
    private int securityId;//保安id
    private String licensePlate;//车牌
    private Date entryTime;//入区时间
    private Date departureTime;//离开时间
    private String paymentMoney;//缴费金额
}
