package pms.entity;

import java.util.Date;

import org.springframework.stereotype.Component;


@Component
public class VisitorRecord {
    private int visitorId;//访客记录id
    private int parkingSpaceId;//车位id
    private int securityId;//保安id
    private String licensePlate;//车牌
    private Date entryTime;//入区时间
    private Date departureTime;//离开时间

    private int  paymentMoney;//缴费金额

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
	public int getSecurityId() {
		return securityId;
	}
	public void setSecurityId(int securityId) {
		this.securityId = securityId;
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

	public int getPaymentMoney() {
		return paymentMoney;
	}
	public void setPaymentMoney(int paymentMoney) {
		this.paymentMoney = paymentMoney;
	}

}
