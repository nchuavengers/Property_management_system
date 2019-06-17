package pms.entity;

import java.util.Date;

public class ParkingSpace {
    private int parkingSpaceId;//车位id
    private String parkingSpaceType;//车位类型
    private String parkingSpaceLocation;//车位位置
    private Date shareingBeginTime;//共享开始时间
    private Date shareingEndingTime;//共享结束时间
    private String parkingSpaceStatus;//可用状态
}
