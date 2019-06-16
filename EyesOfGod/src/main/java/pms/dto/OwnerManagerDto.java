package pms.dto;

import org.springframework.stereotype.Component;

@Component
public class OwnerManagerDto {

	
    private int ownerId;//业主id
    private String ownerName;//业主姓名
    private String ownerPhoneNumber;//业主联系电话
    private String ownerSex;//业主性别
    private String ownerPassword;//业主密码

    private String houseNumber;//门牌号码
    private String houseBuildingNumber;//楼栋号
    private String houseUnit;//所在单元
    private String houseFloor;//楼层
    
    
    
    
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
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getHouseBuildingNumber() {
		return houseBuildingNumber;
	}
	public void setHouseBuildingNumber(String houseBuildingNumber) {
		this.houseBuildingNumber = houseBuildingNumber;
	}
	public String getHouseUnit() {
		return houseUnit;
	}
	public void setHouseUnit(String houseUnit) {
		this.houseUnit = houseUnit;
	}
	public String getHouseFloor() {
		return houseFloor;
	}
	public void setHouseFloor(String houseFloor) {
		this.houseFloor = houseFloor;
	}
    
    
   
}
