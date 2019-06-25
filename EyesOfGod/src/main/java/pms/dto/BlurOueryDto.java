package pms.dto;
import org.springframework.stereotype.Component;

@Component
public class BlurOueryDto {

	 private int ownerId;
	 private String ownerName;
	 private String ownerPhoneNumber;
	 private String  ownerSex;
	 private int  parkingSpaceId;
	 private String parkingSpaceLocation;
	 
	 
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
	public int getParkingSpaceId() {
		return parkingSpaceId;
	}
	public void setParkingSpaceId(int parkingSpaceId) {
		this.parkingSpaceId = parkingSpaceId;
	}
	public String getParkingSpaceLocation() {
		return parkingSpaceLocation;
	}
	public void setParkingSpaceLocation(String parkingSpaceLocation) {
		this.parkingSpaceLocation = parkingSpaceLocation;
	}
	 
	 

}
