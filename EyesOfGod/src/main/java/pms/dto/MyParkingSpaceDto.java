package pms.dto;

import java.util.Date;

public class MyParkingSpaceDto {
    private int parkingSpaceId;//车位id
    private String parkingSpaceType;//车位类型
    private String parkingSpaceLocation;//车位位置
    private Date shareingBeginTime;//共享开始时间
    private Date shareingEndingTime;//共享结束时间
    private boolean leaned;//是否正有人租用
    private int  income;//累计收入
}
