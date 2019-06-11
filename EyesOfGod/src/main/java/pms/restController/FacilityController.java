package pms.restController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import pms.entity.Owner;
import pms.entity.PublicUtility;

@Controller
public class FacilityController {

	
	/**
	 * -管理员进入公共设施管理页面
	 * -显示该页面的数据     FacilityManageDto
	 * @param model
	 * @return
	 */
	@GetMapping("/facilityManage")
	public String facilityManage(Model model) {

		return "facilityManage";
	}
	
	/**
	 * -登记维修（添加维修记录）
	 * @param model
	 * @return
	 */
	@GetMapping("/doRepair")
	public String doRepair(Model model) {

		return null;
	}
	
	
	/**
	 * -维修已完成(修改设施状态)
	 * @param RepairRecordId
	 * @return
	 */
	@GetMapping("/finishedRepair/{repairRecordId}")
	public String finishedRepair(@PathVariable (value="repairRecordId") int repairRecordId) {

		return null;
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
