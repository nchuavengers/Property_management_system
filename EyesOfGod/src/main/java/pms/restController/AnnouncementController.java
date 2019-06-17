package pms.restController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import pms.entity.Announcement;
import pms.entity.Owner;
/*
 * *用于处理公告管理页面请求，调用AnnouncementManageService服务接口，返回数据到页面
 * 15202137 汪浩 6.15
 */
@Controller
public class AnnouncementController {

	/**
	 * -管理员进入公告管理页面
	 * -显示该页面的数据     announcementManageDto
	 * @param model
	 * @return
	 */
	@GetMapping("/announcementManage")
	public String announcementManage(Model model) {
		System.out.print(" here is announcementManage.html\n");
		return "announcementManage";
	}
	/**
	 * -查询指定公告详情
	 * @param announcementId
	 * @return
	 */
	@GetMapping("/findAnnouncementDescription/{announcementId}")
	public String findAnnouncementDescription(@PathVariable (value="announcementId") int announcementId){
		
		return null;
	}
	
	/**
	 * -发布公告
	 * @param announcement
	 * @return
	 */
	@GetMapping("/publicAnnouncement")
	@ResponseBody 
	public String publicAnnouncement(@RequestBody Announcement announcement){
		
		return null;
	}
	
	/**
	 * -业主今日公告
	 * @param model
	 * @return
	 */
	@GetMapping("/ownerAnnouncement")
	public String ownerAnnouncement(Model model) {
		System.out.print(" here is ownerFinance.html\n");
		return "ownerAnnouncement";

	}
	
}
