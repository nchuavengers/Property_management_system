package pms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import pms.dto.announcementManageDto;
import pms.entity.Announcement;
/**
 *162021班 第10组
 *小区物业管理系统-公告管理模块
 *@author:15202137-汪浩
 *date:2019-6-8
 *主要功能说明：
  	初步设计持久化接口
 *
 */
public interface AnnouncementRepository {

	/**
	 * -查询所有公告信息announcementManageDto
	 * @return
	 */
	@Select("") 
	public List<announcementManageDto>  findAllannouncementManageDto();
	
	/**
	 * -查询指定公告详情
	 * @param announcementId
	 * @return String详情
	 */
	@Select("") 
	public String  findAnnouncementDescription(int announcementId);
	
	/**
	 * -发布公告添加公告信息
	 * @param announcement
	 * @return 
	 */
	@Insert("")
	public boolean  addAnnouncement(Announcement announcement);
	
	
	
	/**
	 * -查询今日公告
	 * @return
	 */
	@Select("")
	public Announcement  findTodayAnnouncement();
	
	
	
	
	
}
