package pms.dto;

import org.springframework.stereotype.Component;

@Component
public class NavigationMessage {
	private int numOwner;//业主数量
	private int numAnn;//广告数量
	private int numPaking;//停车位总数量
	private int peopleFlew;//人流量
	private int carFlew;//车流量
	private int usedParking;//当前占用停车位
	public int getNumOwner() {
		return numOwner;
	}
	public int getNumAnn() {
		return numAnn;
	}
	public int getNumPaking() {
		return numPaking;
	}
	public int getPeopleFlew() {
		return peopleFlew;
	}
	public int getCarFlew() {
		return carFlew;
	}
	public int getUsedParking() {
		return usedParking;
	}
	public void setNumOwner(int numOwner) {
		this.numOwner = numOwner;
	}
	public void setNumAnn(int numAnn) {
		this.numAnn = numAnn;
	}
	public void setNumPaking(int numPaking) {
		this.numPaking = numPaking;
	}
	public void setPeopleFlew(int peopleFlew) {
		this.peopleFlew = peopleFlew;
	}
	public void setCarFlew(int carFlew) {
		this.carFlew = carFlew;
	}
	public void setUsedParking(int usedParking) {
		this.usedParking = usedParking;
	}
	
	
}
