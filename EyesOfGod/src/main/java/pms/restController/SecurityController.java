package pms.restController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import pms.entity.Owner;
import pms.entity.VisitorRecord;

@Controller
public class SecurityController {

	/**
	 * -离开小区修改该访问记录（可选择缴费
	 * @param visitorRecord
	 * @return
	 */
	@GetMapping("/visitorDepature")
	@ResponseBody 
	public String visitorDepature(@RequestBody VisitorRecord visitorRecord) {
		
		return null;
	}
	
	/**
	 * -添加访客
	 * @param visitorRecord
	 * @return
	 */
	@GetMapping("/addVisitor")
	@ResponseBody 
	public String addVisitor(@RequestBody VisitorRecord visitorRecord) {
		
		return null;
	}
	
	
	/**
	 * -模糊查询业主车辆
	 * @param a
	 * @return
	 */
	@GetMapping("/FindOwnerParkingSpace")
	public String FindOwnerParkingSpace(String a) {
		
		return null;
	}
	
	
	
	/**
	 * -保安今日公告
	 * @param model
	 * @return
	 */
	@GetMapping("/securityAnnouncement")
	public String securityAnnouncement(Model model) {

		return null;

	}
	
	
	
	
	
}
