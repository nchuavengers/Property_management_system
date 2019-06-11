package pms.restController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import pms.dto.OwnerHouseDto;
import pms.entity.Owner;

@Controller
public class OwnerController {

	/**
	 * -管理员进入业主管理页面
	 * -显示该页面的数据     OwnerManagerDto
	 * @param model
	 * @return
	 */
	@GetMapping("/ownerManage")
	public String ownerManage(Model model) {
		System.out.print(" here is ownerManage.html\n");
		return "ownerManage";
	}
	
	/**
	 * -修改业主信息
	 * @param 待修改  owner 对象
	 * @return
	 */
	@GetMapping("/updateOwner")
	@ResponseBody 
	public String updateOwner(@RequestBody Owner owner) {
		
		return null;
	}
	/**
	 * -删除业主信息
	 * --同时删除业主房屋，业主车位
	 * @param ownerId
	 * @return
	 */
	@GetMapping("/deleteOwner/{ownerId}")
	public String deleteOwner(@PathVariable (value="ownerId") int ownerId){
		
		return null;
	}
	
	/**
	 * -添加业主信息
	 * @param 待添加 owner 对象
	 * @return
	 */
	@GetMapping("/addOwner")
	@ResponseBody 
	public String addOwner(@RequestBody Owner owner) {
		
		return null;
	}
	
	/**
	 * -添加业主房屋
	 * @param ownerHouseDto
	 * @return
	 */
	@GetMapping("/addOwnerHouse")
	@ResponseBody 
	public String addOwnerHouse(@RequestBody OwnerHouseDto ownerHouseDto) {
		
		return null;
	}
	
	
	



	
	
	
}
