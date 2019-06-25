package pms.entity;

import org.springframework.stereotype.Component;

@Component
public class Repairer {
    private int repairerId;//维修人员id
    private String repairerName;//维修人员姓名
    private String repairerPhoneNumber;//维修人员联系电话
    private String repairerSex;//维修人员性别
	public int getRepairerId() {
		return repairerId;
	}
	public void setRepairerId(int repairerId) {
		this.repairerId = repairerId;
	}
	public String getRepairerName() {
		return repairerName;
	}
	public void setRepairerName(String repairerName) {
		this.repairerName = repairerName;
	}
	public String getRepairerPhoneNumber() {
		return repairerPhoneNumber;
	}
	public void setRepairerPhoneNumber(String repairerPhoneNumber) {
		this.repairerPhoneNumber = repairerPhoneNumber;
	}
	public String getRepairerSex() {
		return repairerSex;
	}
	public void setRepairerSex(String repairerSex) {
		this.repairerSex = repairerSex;
	}
}
