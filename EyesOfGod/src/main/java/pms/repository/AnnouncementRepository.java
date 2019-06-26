package pms.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import pms.dto.AnnouncementManageDto;
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

/*
 * *用于增删查改公告信息数据
 * 15202137 汪浩 6.15
 * my batis
 */
@Mapper
public interface AnnouncementRepository {

	/**
	 * -查询所有公告信息announcementManageDto
	 * @return
	 */
	@Select("SELECT announcementId ,announcementTitle , announcementTime,announcementContent FROM announcement; ") 
	public List<AnnouncementManageDto>  findAllannouncementManageDto();
	
	/**
	 * -发布公告添加公告信息
	 * @param msg
	 * @return 
	 */
	@Insert("INSERT INTO `announcement` (`announcementTitle`, `announcementContent`, `announcementTime`) VALUES(#{announcementTitle},#{announcementContent},#{announcementTime});")
	public boolean  addAnnouncement(AnnouncementManageDto msg);
	
	@Delete("DELETE FROM announcement WHERE announcementId=#{id} ;")
	public boolean deleteAnnouncement(int id );
	
	/**
	 * -查询指定公告
	 * @return
	 */
	@Select("")
	public Announcement  findTodayAnnouncement();
	
	
	
	@Select("SELECT announcementId ,announcementTitle , announcementTime,announcementContent FROM announcement WHERE announcementId=#{announcementId};")
	public AnnouncementManageDto findAnnouncement(int announcementId);
	
	/*
	 * 查询公告数量
	 */

	@Select("SELECT COUNT(announcementId) FROM announcement;")
	public int numAnnouncement();
}















/**
 *162021班 第10组
 *小区物业管理系统-公告管理模块
 *@author:15202137-汪浩
 *date:2019-6-8
 *主要功能说明：
  	初步设计持久化接口
 *
 */
/**
 *162021班 第10组
 *小区物业管理系统-公告管理模块
 *@author:15202137-汪浩
 *date:2019-6-8
 *主要功能说明：
  	初步设计持久化接口
 *
 */
/**
 *162021班 第10组
 *小区物业管理系统-公告管理模块
 *@author:15202137-汪浩
 *date:2019-6-8
 *主要功能说明：
  	初步设计持久化接口
 *
 */
/**
 *162021班 第10组
 *小区物业管理系统-公告管理模块
 *@author:15202137-汪浩
 *date:2019-6-8
 *主要功能说明：
  	初步设计持久化接口
 *
 */
/**
 *162021班 第10组
 *小区物业管理系统-公告管理模块
 *@author:15202137-汪浩
 *date:2019-6-8
 *主要功能说明：
  	初步设计持久化接口
 *
 */

