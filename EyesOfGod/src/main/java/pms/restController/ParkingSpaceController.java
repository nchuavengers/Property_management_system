package pms.restController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import pms.dto.MyParkingSpaceDto;
import pms.dto.OwnerHouseDto;
import pms.dto.OwnerParkingSpaceDto;
import pms.entity.Owner;
import pms.entity.ParkingSpace;

@Controller
public class ParkingSpaceController {

	/**
	 * -管理员进入车位管理页面
	 * -显示该页面的数据     ParkingSpaceManagerDto
	 * @param model
	 * @return
	 */
	@GetMapping("/parkingSpaceManage")
	public String parkingSpaceManage(Model model) {
		System.out.print(" here is parkingSpaceManage.html\n");
		return "parkingSpaceManage";
	}
	
	/**
	 * -修改车位信息
	 * @param 待修改  owner 对象
	 * @return
	 */
	@GetMapping("/updateParkingSpace")
	@ResponseBody 
	public String updateParkingSpace(@RequestBody ParkingSpace parkingSpace) {
		
		return null;
	}
	
	/**
	 * -删除车位
	 * --同时删除业主关系
	 * @param parkingSpaceId
	 * @return
	 */
	@GetMapping("/deleteParkingSpace/{parkingSpaceId}")
	public String deleteParkingSpace(@PathVariable (value="parkingSpaceId") int parkingSpaceId){
		
		return null;
	}
	
	/**
	 * -添加车位
	 * @param parkingSpace
	 * @return
	 */
	@GetMapping("/addParkingSpacer")
	@ResponseBody 
	public String addParkingSpacer(@RequestBody ParkingSpace parkingSpace) {
		
		return null;
	}
	
	
	/**
	 * -添加业主车位
	 * @param ownerParkingSpaceDto
	 * @return
	 */
	@GetMapping("/addOwnerParkingSpace")
	@ResponseBody 
	public String addOwnerParkingSpace(@RequestBody OwnerParkingSpaceDto ownerParkingSpaceDto) {
		
		return null;
	}
	
	
	/**
	 * -我的车位，业主车位
	 * @param model  + ownerParkingSpaceDto
	 * @return
	 */
	@GetMapping("/ownerParking")
	public String ownerParking(Model model) {
		System.out.print(" here is ownerParking.html\n");
		return "ownerParking";
	}
	
	
	
	
	/**
	 * -设置今日共享时间
	 * --修改共享开始结束时间，修改车位状态)
	 * @param 
	 * @return
	 */
	@GetMapping("/setShareTime")
	@ResponseBody 
	public String setShareTime(@RequestBody ParkingSpace parkingSpaceDto) {
		
		return null;
	}
	
	/**
	 * -重置今日共享时间
	 * -取消今日共享（车位在用不可取消）重置共享时间0
	 * @param 
	 * @return
	 */
	@GetMapping("/resetShareTime")
	@ResponseBody 
	public String resetShareTime(@RequestBody ParkingSpace ParkingSpace) {
		
		return null;
	}
	
	
	
	
	
}
