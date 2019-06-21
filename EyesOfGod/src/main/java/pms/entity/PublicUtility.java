package pms.entity;

import org.springframework.stereotype.Component;

@Component
public class PublicUtility {
    private int publicUtilityId;//公共设施id
    private String publicUtilityName;//公共设施名称
    private String publicUtilityType;//公共设施类型
    private String publicUtilityStatus;//公共设施状态
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
}
