package pms.dto;

/*
 * *用于封装广告管理录界面用户输入的数据
 * 15202137 汪浩 6.15
 */


import java.util.Date;

public class announcementManageDto {
	
    private int announcementId;//公告id
    private String announcementTitle;//公告标题
    private Date announcementTime;//公告时间
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
	public Date getAnnouncementTime() {
		return announcementTime;
	}
	public void setAnnouncementTime(Date announcementTime) {
		this.announcementTime = announcementTime;
	}
    
    
}
