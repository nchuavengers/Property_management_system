package pms.dto;

import org.springframework.stereotype.Component;


@Component
public class SetShareTimeDto {
    private int parkingSpaceId;//车位id
    private String shareingBeginTime;//共享开始时间
    private String shareingEndingTime;//共享结束时间
    
    
    
	public int getParkingSpaceId() {
		return parkingSpaceId;
	}
	public void setParkingSpaceId(int parkingSpaceId) {
		this.parkingSpaceId = parkingSpaceId;
	}
	public String getShareingBeginTime() {
		return shareingBeginTime;
	}
	public void setShareingBeginTime(String shareingBeginTime) {
		this.shareingBeginTime = shareingBeginTime;
	}
	public String getShareingEndingTime() {
		return shareingEndingTime;
	}
	public void setShareingEndingTime(String shareingEndingTime) {
		this.shareingEndingTime = shareingEndingTime;
	}
    
}
