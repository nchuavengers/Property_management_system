package pms.entity;

public class Announcement {
    private int announcementId;//公告id
    private String announcementTitle;//公告标题
    private String parkingSpaceLocation;//公告描述
    private String announcementDescription;//公告时间
	public int getAnnouncementId() {
		return announcementId;
	}
	public void setAnnouncementId(int announcementId) {
		this.announcementId = announcementId;
	}
	public String getAnnouncementTitle() {
		return announcementTitle;
	}
	public void setAnnouncementTitle(String announcementTitle) {
		this.announcementTitle = announcementTitle;
	}
	public String getParkingSpaceLocation() {
		return parkingSpaceLocation;
	}
	public void setParkingSpaceLocation(String parkingSpaceLocation) {
		this.parkingSpaceLocation = parkingSpaceLocation;
	}
	public String getAnnouncementDescription() {
		return announcementDescription;
	}
	public void setAnnouncementDescription(String announcementDescription) {
		this.announcementDescription = announcementDescription;
	}

}
