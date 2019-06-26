package pms.service;

import java.util.List;

import pms.dto.AnnouncementManageDto;
import pms.entity.Announcement;
/*
 * *用于实现公告信息服务接口
 * 15202137 汪浩 6.15
 * my batis
 */
public class AnnouncementServiceImpl implements AnnouncementService{

	

	@Override
	public String findAnnouncementDescription(int announcementId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean publicAnnouncement(Announcement announcement) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Announcement findTodayAnnouncement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AnnouncementManageDto> findAllannouncementManageDto() {
		// TODO Auto-generated method stub
		return null;
	}

}
