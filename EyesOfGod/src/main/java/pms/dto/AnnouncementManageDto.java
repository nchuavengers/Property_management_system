package pms.dto;

import org.springframework.stereotype.Component;

//15202137 汪浩
@Component
public class AnnouncementManageDto {
	
    private int announcementId;//公告id
    private String announcementTitle;//公告标题
    private String announcementTime;//公告时间
    private String announcementContent;//公告标题
	public int getAnnouncementId() {
		return announcementId;
	}
	public String getAnnouncementTitle() {
		return announcementTitle;
	}
	public String getAnnouncementTime() {
		return announcementTime;
	}
	public void setAnnouncementId(int announcementId) {
		this.announcementId = announcementId;
	}
	public void setAnnouncementTitle(String announcementTitle) {
		this.announcementTitle = announcementTitle;
	}
	public void setAnnouncementTime(String announcementTime) {
		this.announcementTime = announcementTime;
	}
	public String getAnnouncementContent() {
		return announcementContent;
	}
	public void setAnnouncementContent(String announcementContent) {
		this.announcementContent = announcementContent;
	}
    
}
