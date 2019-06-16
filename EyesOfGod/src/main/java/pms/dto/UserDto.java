package pms.dto;

import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

/*
 * *用于封装登录界面用户输入的数据
 */


@Component
public class UserDto {
	@Pattern(regexp="[0-9|]{11}",message="请输入11位手机号码")
    private String userAccount;//用户账号//手机号存储还是string
	
	@Pattern(regexp="[0-9|]{6}",message="请输入6位数字")
    private String userPassword;//用户密码  存储还是string
	
//	@Pattern(regexp="[1-3|]{1}",message="请选择用户类型")//还是用js判断选择框

    private String userType;//用户类型
    
    
    
    
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
    
    
}
