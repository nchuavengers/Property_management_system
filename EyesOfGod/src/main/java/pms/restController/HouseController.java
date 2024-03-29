package pms.restController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pms.dto.HouseManagerDto;
import pms.dto.NavigationMessage;
import pms.entity.House;
import pms.service.HomeServiceImpl;
import pms.service.HouseService;

@Controller
public class HouseController {

	@Autowired
    private  HouseService houseServiceImpl;    
    @Autowired
    private List<HouseManagerDto> houseManagerDtoList;  
    @Autowired
    private List<House> houseList;  
    @Autowired
	private HomeServiceImpl hp;
	@Autowired
	private NavigationMessage navMessage;
	@GetMapping("/HouseManage")
	public String HouseManage(Model model) {
		navMessage=hp.getNavagationMessage();
		model.addAttribute("navMessage",navMessage);//将导航栏信息(人流量，车流量)放入Model
		houseManagerDtoList = houseServiceImpl.findAllHouseManagerDto();
		houseList=houseServiceImpl.findAllHouse();
		model.addAttribute("houseOwnerList",houseManagerDtoList);
		model.addAttribute("houseList",houseList);
		return "HouseManage";
	}
	
	/**
	 * -删除房屋信息
	 * --同时删除业主关系
	 * @param houseId
	 * @return
	 */
	@GetMapping("/deleteHouse/{houseId}")
	@ResponseBody 
	public Map<String, Object> deleteHouse(@PathVariable (value="houseId") int houseId ,Model model){
		 Map<String, Object> result = new HashMap<String, Object>();
        System.out.println("houseId="+houseId);
		System.out.println("正在删除...");
		houseServiceImpl.deleteHouse(houseId);
		houseManagerDtoList = houseServiceImpl.findAllHouseManagerDto();
		houseList=houseServiceImpl.findAllHouse();
		model.addAttribute("houseOwnerList",houseManagerDtoList);
		model.addAttribute("houseList",houseList);
		if(true){
			//封装正确消息
			result.put("status", "succcessful");//succcessful
			result.put("msg", "succcessful！");
		}
		navMessage=hp.getNavagationMessage();
		model.addAttribute("navMessage",navMessage);//将导航栏信息(人流量，车流量)放入Model
		return result;
	}
	/**
	 * -添加房屋信息
	 * @param 待添加 House 对象
	 * @return
	 */
	@PostMapping("/addHouse")
	public String addHouse(String houseBuildingNumber,
			String houseUnit,
			String houseFloor,
			String houseNumber,Model model) {
	
		boolean a=houseServiceImpl.addHouse(houseBuildingNumber,houseUnit,houseFloor,houseNumber);
		model.addAttribute("Result","添加成功");
		houseManagerDtoList = houseServiceImpl.findAllHouseManagerDto();
		houseList=houseServiceImpl.findAllHouse();
		model.addAttribute("houseOwnerList",houseManagerDtoList);
		model.addAttribute("houseList",houseList);
		navMessage=hp.getNavagationMessage();
		model.addAttribute("navMessage",navMessage);//将导航栏信息(人流量，车流量)放入Model
		return "HouseManage";
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
