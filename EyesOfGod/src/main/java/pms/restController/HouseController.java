package pms.restController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import pms.entity.House;
import pms.entity.Owner;

@Controller
public class HouseController {

	/**
	 * -管理员进入房屋管理页面
	 * -显示该页面的数据     OwnerManagerDto
	 * @param model
	 * @return
	 */
	@GetMapping("/HouseManage")
	public String HouseManage(Model model) {
		
		return "HouseManage";
	}
	
	/**
	 * -删除房屋信息
	 * --同时删除业主关系
	 * @param houseId
	 * @return
	 */
	@GetMapping("/deleteHouse/{houseId}")
	public String deleteHouse(@PathVariable (value="houseId") int houseId){
		
		return null;
	}
	
	/**
	 * -添加房屋信息
	 * @param 待添加 House 对象
	 * @return
	 */
	@GetMapping("/addHouse")
	@ResponseBody 
	public String addHouse(@RequestBody House house) {
		
		return null;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/ownerHouse")
	public String ownerRoom(Model model) {
		System.out.print(" here is ownerHouse.html\n");
		return "ownerHouse";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
