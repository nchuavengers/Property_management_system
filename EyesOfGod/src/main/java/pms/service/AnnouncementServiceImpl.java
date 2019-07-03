package pms.service;

import java.util.List;

import pms.dto.AnnouncementManageDto;
import pms.entity.Announcement;
/*
 * *用于实现公告信息服务接口
 * 懒得写了service了，心累。
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

	@Override
	public boolean deleteAnnouncement(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
