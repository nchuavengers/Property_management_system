package pms.entity;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class ParkingSpace {
    private int parkingSpaceId;//车位id
    private String parkingSpaceType;//车位类型
    private String parkingSpaceLocation;//车位位置
    private Date shareingBeginTime;//共享开始时间
    private Date shareingEndingTime;//共享结束时间
    private String parkingSpaceStatus;//可用状态
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
    
}
