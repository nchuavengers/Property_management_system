package pms.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class FacilityManageDto {
    private int publicUtilityId;//公共设施id
    private String publicUtilityName;//公共设施名称
    private String publicUtilityType;//公共设施类型
    private String publicUtilityStatus;//公共设施状态״̬
    
    private String repairerInfomation;//修复
    private String repairMoney;//
    private Date repairTime;//
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
	public Date getRepairTime() {
		return repairTime;
	}
	public void setRepairTime(Date repairTime) {
		this.repairTime = repairTime;
	}
	
    
    
}
