package pms.restController;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


import pms.entity.Announcement;
import pms.entity.Owner;
/*
 * *用于处理公告管理页面请求，调用AnnouncementManageService服务接口，返回数据到页面
 * 15202137 汪浩 6.15
 */

import pms.dto.AnnouncementManageDto;
import pms.dto.NavigationMessage;
import pms.repository.AnnouncementRepository;
import pms.service.HomeServiceImpl;


@Controller
public class AnnouncementController {
	@Autowired
	private AnnouncementRepository ar;
	@Autowired
	private List<AnnouncementManageDto> announceList;
	@Autowired
	private HomeServiceImpl hp;
	@Autowired
	private NavigationMessage navMessage;
	/**
	 * -管理员进入公告管理页面
	 * -显示该页面的数据     announcementManageDto
	 * @param model
	 * @return
	 */
	@GetMapping("/announcementManage")
	public String announcementManage(Model model) {
		navMessage=hp.getNavagationMessage();
		model.addAttribute("navMessage",navMessage);//将导航栏信息(人流量，车流量)放入Model
		announceList=ar.findAllannouncementManageDto();
		model.addAttribute("announceList",announceList);
		System.out.print(" here is announcementManage.html\n");
		return "announcementManage";
	}
	@GetMapping("/announcementMessage")
	public String announcementMessage(Model model) {
		navMessage=hp.getNavagationMessage();
		model.addAttribute("navMessage",navMessage);//将导航栏信息(人流量，车流量)放入Model
		System.out.print(" here is announcementMessage.html\n");
		return "announcementMessage";
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
	public String publicAnnouncement(@RequestBody AnnouncementManageDto announcement){
		
		return null;
	}
	
	/**
	 * -业主今日公告
	 * @param model
	 * @return
	 */
	@GetMapping("/ownerAnnouncement")
	public String ownerAnnouncement(Model model) {
		System.out.println(ar.numAnnouncement());
		announceList=ar.findAllannouncementManageDto();
		model.addAttribute("announceList",announceList);
		System.out.print(" here is ownerFinance.html\n");
		return "ownerAnnouncement";

	}
	
	@PostMapping("/findAnn")
	public String findAnn(String announceId,Model model){
		navMessage=hp.getNavagationMessage();
		model.addAttribute("navMessage",navMessage);//将导航栏信息(人流量，车流量)放入Model
		System.out.println(announceId);
		AnnouncementManageDto msg=ar.findAnnouncement(Integer.parseInt(announceId));
		model.addAttribute("announceMessage",msg);
		return "announcementMessage";
	}
	@PostMapping("/findAnn2")
	public String ownerAnnounceMessage(String announceId,Model model){
		System.out.println(announceId);
		AnnouncementManageDto msg=ar.findAnnouncement(Integer.parseInt(announceId));
		model.addAttribute("announceMessage",msg);
		return "ownerAnnounceMessage";
	}
	@PostMapping("/addAnn")
	public String addAnn(String title,String time,String content,Model model){
		System.out.println(title+"1");
		System.out.println(time+"2");
		System.out.println(content+"3");
		//Date date =new Date();
		//time=date.getYear()+"."+(date.getMonth()+1)+"."+date.;
		AnnouncementManageDto msg=new AnnouncementManageDto() ;
		msg.setAnnouncementContent(content);
		msg.setAnnouncementTime(time);
		msg.setAnnouncementTitle(title);
		ar.addAnnouncement(msg);
		model.addAttribute("announceMessage",msg);
		announceList=ar.findAllannouncementManageDto();
		model.addAttribute("announceList",announceList);
		System.out.print(" here is announcementManage.html\n");
		navMessage=hp.getNavagationMessage();
		model.addAttribute("navMessage",navMessage);//将导航栏信息(人流量，车流量)放入Model
		return "announcementManage";
	}
	@PostMapping("/deleteAnn")
	public String deleteAnn(String announceId,Model model) {
		boolean a =false;
		try {
			a =ar.deleteAnnouncement(Integer.parseInt(announceId));
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			System.out.println("删除结果： "+a);
		}
		announceList=ar.findAllannouncementManageDto();
		model.addAttribute("announceList",announceList);
		System.out.print(" here is announcementManage.html\n");
		navMessage=hp.getNavagationMessage();
		model.addAttribute("navMessage",navMessage);//将导航栏信息(人流量，车流量)放入Model
		return "announcementManage";
	}
}
