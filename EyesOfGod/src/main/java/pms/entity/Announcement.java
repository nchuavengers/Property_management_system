package pms.entity;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class Announcement {
    private int announcementId;//公告id
    private String announcementTitle;//公告标题
    private String announcementDescription;//公告说明
    private String announcementTime;//公告发布时间
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
	public String getAnnouncementDescription() {
		return announcementDescription;
	}
	public void setAnnouncementDescription(String announcementDescription) {
		this.announcementDescription = announcementDescription;
	}
	public String getAnnouncementTime() {
		return announcementTime;
	}
	public void setAnnouncementTime(String announcementTime) {
		this.announcementTime = announcementTime;
	}
    
}
