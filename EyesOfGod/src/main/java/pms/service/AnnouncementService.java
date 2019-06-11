package pms.service;

import java.util.List;

import pms.dto.announcementManageDto;
import pms.entity.Announcement;

public interface AnnouncementService {
	
	/**
	 * -查询所有公告信息announcementManageDto
	 * @return
	 */
	public List<announcementManageDto>  findAllannouncementManageDto();
	
	/**
	 * -查询指定公告详情
	 * @param announcementId
	 * @return String详情
	 */
	public String  findAnnouncementDescription(int announcementId);
	
	/**
	 * -发布公告
	 * @param announcement
	 * @return 
	 */
	public boolean  publicAnnouncement(Announcement announcement);

	
	/**
	 * -查询今日公告
	 * @return
	 */
	public Announcement  findTodayAnnouncement();
	
	
	
	
	
	
}
