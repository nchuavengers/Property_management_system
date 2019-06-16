package pms.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pms.dto.FacilityManageDto;
import pms.entity.PublicUtility;
import pms.service.FacilityService;

@Controller
public class FacilityController {

	@Autowired
	private FacilityService facilityServieImpl;
	@Autowired
	private List<FacilityManageDto> facilityList;
	/**
	 * -管理员进入公共设施管理页面
	 * -显示该页面的数据     FacilityManageDto
	 * @param model
	 * @return
	 */
	@GetMapping("/facilityManage")
	public String facilityManage(Model model) {
		facilityList=facilityServieImpl.findAllFacilityManageDto();
		model.addAttribute("facilityList",facilityList);
		return "facilityManage";
	}
	
	/**
	 * -登记维修（添加维修记录）
	 * @param model
	 * @return
	 */
	@GetMapping("/doRepair/{ficilityId2}")
	//@ResponseBody
	public String doRepair(@PathVariable (value="ficilityId2")int ficilityId,Model model) {
		System.out.println("申请维修------->"+ficilityId);
		boolean a=facilityServieImpl.applyRequired(ficilityId);
		System.out.println(a);
		facilityList=facilityServieImpl.findAllFacilityManageDto();
		model.addAttribute("facilityList",facilityList);
		//return "facilityManage";
		return facilityManage(model);
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
		return facilityManage(model);
	}
	
	/**
	 * -添加公共设施
	 * @param 待添加 PublicUtility 对象
	 * @return
	 */
	@GetMapping("/addFacility")
	@ResponseBody 
	public String addFacility(@RequestBody PublicUtility publicUtility  ) {
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
