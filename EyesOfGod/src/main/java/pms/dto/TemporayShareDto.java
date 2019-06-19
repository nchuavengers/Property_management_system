package pms.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class TemporayShareDto {
	
    private int parkingSpaceId;//车位id
    private String parkingSpaceLocation;//车位位置
    private Date shareingBeginTime;//共享开始时间
    private Date shareingEndingTime;//共享结束时间
  
    private String ownerName;//业主姓名
    private String ownerPhoneNumber;//业主联系电话
    
    
    
    
	public int getParkingSpaceId() {
		return parkingSpaceId;
	}
	public void setParkingSpaceId(int parkingSpaceId) {
		this.parkingSpaceId = parkingSpaceId;
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
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerPhoneNumber() {
		return ownerPhoneNumber;
	}
	public void setOwnerPhoneNumber(String ownerPhoneNumber) {
		this.ownerPhoneNumber = ownerPhoneNumber;
	}
	
	
    
}
