package pms.dto;

import java.util.Date;

public class VisitorCarDto {

	private int visitorId;//访客id
    private int parkingSpaceId;//车位id
    private String parkingSpaceType;//车位类型
    private String licensePlate;//车牌
    private Date entryTime;//入区时间
    
    
    private Date departureTime;//离开小区时间
    private String paymentMoney;//缴费金额
    
    
    
	public int getVisitorId() {
		return visitorId;
	}
	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}
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
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public String getPaymentMoney() {
		return paymentMoney;
	}
	public void setPaymentMoney(String paymentMoney) {
		this.paymentMoney = paymentMoney;
	}
    
    
    
    
	
    
}
