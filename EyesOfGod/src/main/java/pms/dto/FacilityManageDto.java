package pms.dto;

import org.springframework.stereotype.Component;
/*
 * *用于封装公共设施管理界面用户输入的数据
 * 15202137 汪浩 6.15
 */
@Component
public class FacilityManageDto {
    private int publicUtilityId;//公共设施id
    private String publicUtilityName;//公共设施名称
    private String publicUtilityType;//公共设施类型
    private String publicUtilityStatus;//公共设施状态
    
    private String repairerInfomation;//维修人员id+电话
    private String repairMoney;//
    private String repairTime;//
	public int getPublicUtilityId() {
		return publicUtilityId;
	}
	public void setPublicUtilityId(int publicUtilityId) {
		this.publicUtilityId = publicUtilityId;
	}
	public String getPublicUtilityName() {
		return publicUtilityName;
	}
	public void setPublicUtilityName(String publicUtilityName) {
		this.publicUtilityName = publicUtilityName;
	}
	public String getPublicUtilityType() {
		return publicUtilityType;
	}
	public void setPublicUtilityType(String publicUtilityType) {
		this.publicUtilityType = publicUtilityType;
	}
	public String getPublicUtilityStatus() {
		return publicUtilityStatus;
	}
	public void setPublicUtilityStatus(String publicUtilityStatus) {
		this.publicUtilityStatus = publicUtilityStatus;
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
	public String getRepairTime() {
		return repairTime;
	}
	public void setRepairTime(String repairTime) {
		this.repairTime = repairTime;
	}
}
