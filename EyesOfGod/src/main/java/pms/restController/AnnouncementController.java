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

import pms.dto.AnnouncementManageDto;
import pms.repository.AnnouncementRepository;

@Controller
public class AnnouncementController {
	@Autowired
	private AnnouncementRepository ar;
	@Autowired
	private List<AnnouncementManageDto> announceList;
	/**
	 * -管理员进入公告管理页面
	 * -显示该页面的数据     announcementManageDto
	 * @param model
	 * @return
	 */
	@GetMapping("/announcementManage")
	public String announcementManage(Model model) {
		announceList=ar.findAllannouncementManageDto();
		model.addAttribute("announceList",announceList);
		System.out.print(" here is announcementManage.html\n");
		return "announcementManage";
	}
	@GetMapping("/announcementMessage")
	public String announcementMessage(Model model) {
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
		announceList=ar.findAllannouncementManageDto();
		model.addAttribute("announceList",announceList);
		System.out.print(" here is ownerFinance.html\n");
		return "ownerAnnouncement";

	}
	
	@PostMapping("/findAnn")
	public String findAnn(String announceId,Model model){
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
		return "announcementManage";
	}
}
