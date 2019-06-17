package pms.entity;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class RepairRecord {
    private int repairRecordId;//维修记录id
    private int publicUtilityId;//id
    private String repairerInfomation;//维修人员id+电话
    private String repairMoney;//
    private Date repairTime;//
	public int getRepairRecordId() {
		return repairRecordId;
	}
	public void setRepairRecordId(int repairRecordId) {
		this.repairRecordId = repairRecordId;
	}
	public int getPublicUtilityId() {
		return publicUtilityId;
	}
	public void setPublicUtilityId(int publicUtilityId) {
		this.publicUtilityId = publicUtilityId;
	}
	public String getRepairerInfomation() {
		return repairerInfomation;
	}
	public void setRepairerInfomation(String repairerInfomation) {
		this.repairerInfomation = repairerInfomation;
	}
	public String getRepairMoney() {
		return repairMoney;
	}
	public void setRepairMoney(String repairMoney) {
		this.repairMoney = repairMoney;
	}
	public Date getRepairTime() {
		return repairTime;
	}
	public void setRepairTime(Date repairTime) {
		this.repairTime = repairTime;
	}
    
    
}
