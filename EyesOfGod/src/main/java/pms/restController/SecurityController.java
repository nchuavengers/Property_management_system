package pms.restController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import pms.dto.AllDayShareDto;
import pms.dto.BlurOueryDto;
import pms.dto.TemporayShareDto;
import pms.dto.VisitorCarDto;
import pms.entity.Security;
import pms.entity.VisitorRecord;
import pms.service.SecurityService;

@Controller
public class SecurityController {

	@Autowired
	private SecurityService securityServiceImpl;
	
	/**
	 * -离开小区修改该访问记录（可选择缴费
	 * @param visitorRecord
	 * @return
	 */
	@GetMapping("/visitorDepature")
	@ResponseBody 
	public Map<String, Object> visitorDepature(@ModelAttribute VisitorRecord visitorRecord) {
				System.out.println("正在离开小区...");
				Map<String, Object> result = new HashMap<String, Object>();
				
				
				System.out.println("金额"+visitorRecord.getPaymentMoney());
				//id 金额 
				//时间
				visitorRecord.setDepartureTime(new Date());
				boolean b=securityServiceImpl.updateVisitorRecord(visitorRecord);
				
				
				System.out.println("b="+b);
				if(b){
					//封装正确消息
					result.put("status", "succcessful");//succcessful
					result.put("msg", "已登记离开小区！");
				}
				else {
					//封装错误消息
					result.put("status", "fail");//fail
					result.put("msg", "修改失败！");
				}
				return result;
	}
	
	/**
	 * -添加访客
	 * @param visitorRecord
	 * @return
	 */
	@PostMapping("/addVisitor")
	//form 车牌   车位
	public String addVisitor(String licensePlate ,int parkingSpaceId, Model model,HttpSession session) {
		System.out.println("添加访客");
		
		//添加访客在service判断  车位不存在 1   车位正在使用 2 返回错误页面     3车位可用成功则添加访客记录   触发器修改车位状态    0数据库失败
		int result=securityServiceImpl.addVisitor(licensePlate, parkingSpaceId);
		System.out.println("1111111111");
		if(result==1) {//错误1
			System.out.println("22222222");
			String err="车位不存在，重新输入";
			model.addAttribute("err",err);
			return "addVisitorError"; 
		}else if(result==2) {//错误2
			System.out.println("3333333333");
			String err="车位正在占用,请重新查看可用车位！";
			model.addAttribute("err",err);
			return "addVisitorError"; 
		}
		//成功
		
		System.out.println("正在添加访客。。。");
		
		
		///////////////////////////返回页面数据///////////////
		//当前访客车辆
		List<VisitorCarDto> visitorList =securityServiceImpl.findNowVisitor();
		//全天共享车辆
		List<AllDayShareDto> allDayList=securityServiceImpl.fingAllDayShareParkingSpace();
		//临时今天共享车辆
		List<TemporayShareDto> tempShareList= securityServiceImpl.FingTemporayShareParkingSpace();
		
		
		Security security=(Security) session.getAttribute("security");
		model.addAttribute("visitorList",visitorList);
		model.addAttribute("allDayList",allDayList);
		model.addAttribute("tempShareList",tempShareList);
	    model.addAttribute("security",security);
	    
		
		return "security"; 
	}
	
	
	/**
	 * -模糊查询业主车辆
	 * @param a
	 * @return
	 */
	@PostMapping("/FindOwnerParkingSpace")
	public String FindOwnerParkingSpace(String blueString,Model model) {
		
		System.out.print("拼命查找中。。。。");
		
		List<BlurOueryDto> blurOueryDtoList=securityServiceImpl.FindOwnerParkingSpace(blueString);
		
		model.addAttribute("blurOueryDtoList",blurOueryDtoList);
		
		return "blurryQueryOwnerParkingSpace"; 
	}
	
	
	
	/**
	 * -保安今日公告
	 * @param model
	 * @return
	 */
	@GetMapping("/securityAnnouncement")
	public String securityAnnouncement(Model model) {

		return "security"; 

	}
	
	
	
	
	
}
