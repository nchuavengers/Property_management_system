package pms.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MyParkingSpaceDto {
	
//	#类型公有1 私有2   
//	状态   可用1  不可用0 
	
    private int parkingSpaceId;//车位id
    private String parkingSpaceType;//车位类型
    private String parkingSpaceLocation;//车位位置
    private Date shareingBeginTime;//共享开始时间
    private Date shareingEndingTime;//共享结束时间
    private String parkingSpaceStatus;//是否正有人租用  ()状态
    private int  income;//累计收入 ()//触发器
    
    
    
	public int getParkingSpaceId() {
		return parkingSpaceId;
	}
	public void setParkingSpaceId(int parkingSpaceId) {
		this.parkingSpaceId = parkingSpaceId;
	}
	public String getParkingSpaceType() {
		return parkingSpaceType;
	}
	public void setParkingSpaceType(String parkingSpaceType) {
		this.parkingSpaceType = parkingSpaceType;
	}
	public String getParkingSpaceLocation() {
		return parkingSpaceLocation;
	}
	public void setParkingSpaceLocation(String parkingSpaceLocation) {
		this.parkingSpaceLocation = parkingSpaceLocation;
	}
	public Date getShareingBeginTime() {
		return shareingBeginTime;
	}
	public void setShareingBeginTime(Date shareingBeginTime) {
		this.shareingBeginTime = shareingBeginTime;
	}
	public Date getShareingEndingTime() {
		return shareingEndingTime;
	}
	public void setShareingEndingTime(Date shareingEndingTime) {
		this.shareingEndingTime = shareingEndingTime;
	}
	public String getParkingSpaceStatus() {
		return parkingSpaceStatus;
	}
	public void setParkingSpaceStatus(String parkingSpaceStatus) {
		this.parkingSpaceStatus = parkingSpaceStatus;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
    
    

}
