package pms.entity;

import org.springframework.stereotype.Component;

@Component
public class Security {
    private int securityId;//保安id
    private String securityName;//保安姓名
    private String securityPhoneNumber;//保安联系电话
    private String securitySex;//保安性别
    private String securityPassword;//保安密码
	public int getSecurityId() {
		return securityId;
	}
	public void setSecurityId(int securityId) {
		this.securityId = securityId;
	}
	public String getSecurityName() {
		return securityName;
	}
	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}
	public String getSecurityPhoneNumber() {
		return securityPhoneNumber;
	}
	public void setSecurityPhoneNumber(String securityPhoneNumber) {
		this.securityPhoneNumber = securityPhoneNumber;
	}
	public String getSecuritySex() {
		return securitySex;
	}
	public void setSecuritySex(String securitySex) {
		this.securitySex = securitySex;
	}
	public String getSecurityPassword() {
		return securityPassword;
	}
	public void setSecurityPassword(String securityPassword) {
		this.securityPassword = securityPassword;
	}
    
}
