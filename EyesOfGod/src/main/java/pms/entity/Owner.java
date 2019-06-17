package pms.entity;

import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

@Component
public class Owner {
	
    @Pattern(regexp="[0-9|]{11}",message="请输入11位手机号码")
    private String ownerPhoneNumber;//业主联系电话

    @Pattern(regexp="[0-9|]{6}",message="请输入6位数字")
    private String ownerPassword;//业主密码
    
    private String ownerSex;//业主性别
    private int ownerId;//业主id
    private String ownerName;//业主姓名
    
    
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerPhoneNumber() {
		return ownerPhoneNumber;
	}
	public void setOwnerPhoneNumber(String ownerPhoneNumber) {
		this.ownerPhoneNumber = ownerPhoneNumber;
	}
	public String getOwnerSex() {
		return ownerSex;
	}
	public void setOwnerSex(String ownerSex) {
		this.ownerSex = ownerSex;
	}
	public String getOwnerPassword() {
		return ownerPassword;
	}
	public void setOwnerPassword(String ownerPassword) {
		this.ownerPassword = ownerPassword;
	}
    
}
