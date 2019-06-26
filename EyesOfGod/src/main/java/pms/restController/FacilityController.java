package pms.restController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pms.dto.FacilityManageDto;
import pms.dto.NavigationMessage;
import pms.entity.PublicUtility;
import pms.service.FacilityService;
import pms.service.HomeServiceImpl;

@Controller
public class FacilityController {

	@Autowired
	private FacilityService facilityServieImpl;
	@Autowired
	private List<FacilityManageDto> facilityList;
	@Autowired
	private HomeServiceImpl hp;
	@Autowired
	private NavigationMessage navMessage;
	/**
	 * -管理员进入公共设施管理页面
	 * -显示该页面的数据     FacilityManageDto
	 * @param model
	 * @return
	 */
	@GetMapping("/facilityManage")
	public String facilityManage(Model model) {
		navMessage=hp.getNavagationMessage();
		model.addAttribute("navMessage",navMessage);//将导航栏信息(人流量，车流量)放入Model
		facilityList=facilityServieImpl.findAllFacilityManageDto();
		model.addAttribute("facilityList",facilityList);
		return "facilityManage";
	}
	
	/**
	 * -登记维修（添加维修记录）
	 * @param model
	 * @return
	 */
	@GetMapping("/doRepair")
	@ResponseBody
	public Map<String, Object> doRepair(@ModelAttribute  FacilityManageDto facilityManageDto,Model model) {
		System.out.println("维修id------->"+facilityManageDto.getPublicUtilityId());
        Map<String, Object> result = new HashMap<String, Object>();
		
        Date date=new Date();
        facilityManageDto.setRepairTime(date);
        
        boolean b =facilityServieImpl.applyRequired(facilityManageDto);

		System.out.println("b="+b);
		if(b){
			//封装正确消息
			result.put("date", date);
			result.put("status", "succcessful");//succcessful
			result.put("msg", "succcessful！");
		}
		else {
			//封装错误消息
			result.put("status", "fail");//fail
			result.put("msg", "修改失败！");
		}
		return result;
	}
	
	
	/**
	 * -维修已完成(修改设施状态)
	 * @param RepairRecordId
	 * @return
	 */
	@GetMapping("/facilityRepaired/{ficilityId}")
	//@ResponseBody //维修已经完成
	public String finishedRepair(@PathVariable (value="ficilityId")int ficilityId,Model model) {
		System.out.println("维修完成------->"+ficilityId);
		System.out.println(facilityServieImpl.finishedRepair(ficilityId));
		
		facilityList=facilityServieImpl.findAllFacilityManageDto();
		model.addAttribute("facilityList",facilityList);
		//return "facilityManage";
		return "redirect:/facilityManage"; 
	}
	
	/**
	 * -添加公共设施
	 * @param 待添加 PublicUtility 对象
	 * @return
	 */
	@PostMapping("/addFacility")
	public String addFacility(String ficinityName,String ficinityType,Model model) {
		 PublicUtility a=new PublicUtility();
		 a.setPublicUtilityName(ficinityName);
		 a.setPublicUtilityType(ficinityType);
		 facilityServieImpl.addFacility(a);
		facilityList=facilityServieImpl.findAllFacilityManageDto();
		model.addAttribute("facilityList",facilityList);
		return "redirect:/facilityManage"; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
