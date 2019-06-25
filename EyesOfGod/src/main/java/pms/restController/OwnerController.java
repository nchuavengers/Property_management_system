package pms.restController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pms.dto.OwnerHouseDto;
import pms.dto.OwnerManagerDto;
import pms.dto.UserDto;
import pms.entity.House;
import pms.entity.Owner;
import pms.repository.OwnerRepository;
import pms.service.HouseServiceImpl;
import pms.service.OwnerServiceImpl;

@Controller
public class OwnerController {

    @Autowired
    private OwnerServiceImpl ownerServiceImpl;    
    
	@Autowired
    private HouseServiceImpl houseServiceImpl;    
    
    @Autowired
    private List<OwnerManagerDto> ownerManagerDtoList;  
    
    @Autowired
    private OwnerRepository ownerRepository;     
    
	/**
	 * -管理员进入业主管理页面    小区所有业主信息
	 * -显示该页面的数据     OwnerManagerDto 
	 * @param model
	 * @return
	 */
	@GetMapping("/ownerManage")
	public String ownerManage(Model model) {
		System.out.print(" here is ownerManage.html\n");
		//ownerManagerDtoList.clear();
		ownerManagerDtoList = ownerServiceImpl.findAllOwnerManagerDto();
		
		System.out.print(ownerManagerDtoList.get(0).getOwnerId());
		
		model.addAttribute("list",ownerManagerDtoList);
		
        //或者作为参数注入		@ModelAttribute("product") Product product
		return "ownerManage";
	}
	
	/**
	 * -修改业主信息
	 * @param 待修改  owner 对象
	 * @return
	 */
	@GetMapping("/updateOwner")
	@ResponseBody 
    //List<Map<String,Object>>
	public  Map<String, Object> updateOwner(@ModelAttribute Owner owner) {

		//修改owner
		//不需要判断直接修改
		
		Map<String, Object> result = new HashMap<String, Object>();
		boolean b=true;
		//判断手机号是否已存在一个用户一个手机号
		Owner isExistOwner = ownerRepository.fingOwnerByOwnerPhoneNumber(owner);
		if(isExistOwner!=null) {
			b=false;
			System.out.println("手机号存在");
		}
		else {
		//调用service修改

			System.out.println("正在update...");
		b=ownerServiceImpl.UpdateOwner(owner);
		
		}
		
		System.out.println("b="+b);
		if(b){
			//封装正确消息
			result.put("status", "succcessful");//succcessful
			result.put("msg", "修改业主信息  succcessful！");
		}
		else {
			//封装错误消息
			result.put("status", "fail");//fail
			result.put("msg", "已有用户的手机号为此号码，由于手机号用于登录，不能相同！");
		}
		return result;
	}
	/**
	 * -删除业主信息
	 * --同时删除业主房屋，缴费信息，业主车位
	 * @param ownerId
	 * @return
	 */
	@GetMapping("/deleteOwner/{ownerId}")
	@ResponseBody 
	public Map<String, Object> deleteOwner(@PathVariable (value="ownerId") int ownerId){
		
        Map<String, Object> result = new HashMap<String, Object>();
        
        //删除业主所有信息
		//删除房屋关系
        //删除车位关系
        //删除消费信息
        //删除缴费信息
        
		//删除业主再  使用触发器欧克
        
        boolean b=ownerServiceImpl.deleteOwner(ownerId);
        
		System.out.println("ownerId="+ownerId);
		System.out.println("正在删除...");
		
		if(true){
			//封装正确消息
			result.put("status", "succcessful");//succcessful
			result.put("msg", "succcessful！");
		}
		return result;
		
	}
	
	
	/**
	 * -添加业主信息
	 * @param 待添加 owner 对象
	 * @return
	 */
	@PostMapping("/addOwner")
	public String addOwner(Model model,
			String ownerName,
			String ownerSex,
			String ownerPhoneNumber,
			String ownerPassword
			) {
		System.out.print("添加业主\n");
		Owner owner =new Owner();
		owner.setOwnerName(ownerName);
		owner.setOwnerPassword(ownerPassword);
		owner.setOwnerPhoneNumber(ownerPhoneNumber);
		owner.setOwnerSex(ownerSex);
		
		boolean  b=ownerServiceImpl.addOwner(owner);
		
		ownerManagerDtoList = ownerServiceImpl.findAllOwnerManagerDto();

		
		model.addAttribute("list",ownerManagerDtoList);
		
		return "ownerManage";
	}
	
	
	/**
	 * -判断业主是否存在
	 * @param 
	 * @return
	 */
	@GetMapping("/isExistedOwner/{ownerId}")
	@ResponseBody 
	public Map<String, Object> isExistedOwner(@PathVariable (value="ownerId") int ownerId){
        Map<String, Object> result = new HashMap<String, Object>();
        
		System.out.println("ownerId="+ownerId);
		System.out.println("正在查找业主...");	
		Owner owner=ownerServiceImpl.findOwner(ownerId);
	
		if(owner!=null){			//封装正确消息
			result.put("status", "succcessful");//succcessful
			result.put("msg", "业主存在succcessful！");
		}
		else {//错误消息业主不存在
			result.put("status", "fail");//fail
			result.put("msg", "业主不存在！");
		}
		return result;
	}
	
	
	/**
	 * -判断房屋是否存在/或者已有业主
	 * @param 
	 * @return
	 */
	@GetMapping("/isExistedHouse/{houseId}")
	@ResponseBody 
	public Map<String, Object> isExistedHouse(@PathVariable (value="houseId") int houseId){
        Map<String, Object> result = new HashMap<String, Object>();
        
		System.out.println("houseId="+houseId);
		System.out.println("查找中...");
		
		House house=houseServiceImpl.fingHouseByHouseId(houseId);
		
		if(house!=null){			//封装正确消息
			int id=houseServiceImpl.IsHouseFromOwnerHouse(houseId);
			if( id==0) {
				result.put("status", "succcessful");//succcessful
				result.put("msg", "房屋存在succcessful！");
			}
			else {       //错误消息房屋存在业主
				result.put("status", "fail");//fail
				result.put("msg", "该房屋当前属于业主:"+id+"!!!");
			}
		}
		else {       //错误消息房屋不存在
			result.put("status", "fail");//fail
			result.put("msg", "房屋不存在！");
		}
		return result;	
	}
	
	
	
	/**
	 * -添加业主房屋
	 * @param ownerHouseDto
	 * @return
	 */
	@GetMapping("/addOwnerHouse")
	@ResponseBody 
	public Map<String, Object> addOwnerHouse(@ModelAttribute OwnerHouseDto ownerHouseDto) {
      
		System.out.println("11111...");
		
		Map<String, Object> result = new HashMap<String, Object>();

        System.out.println("ownerHouseDto:   "+ownerHouseDto);
		System.out.println("添加中...");
		boolean b=ownerServiceImpl.addOwnerHouse(ownerHouseDto);
				
		if(b){			//封装正确消息
			result.put("status", "succcessful");//succcessful
			result.put("msg", "succcessful！");
		}
		else {       //错误消息房屋不存在
			result.put("status", "fail");//fail
			result.put("msg", "业主不存在！");
		}
		return result;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@PostMapping("/addOwner")
//	public  String  addOwner(@Validated Owner newOwner, BindingResult bindingResult,Model model) {
//
//			System.out.print("有新业主来了！\n");
//
//			//正则表达式判断
//			if (bindingResult.hasFieldErrors()) {
//				System.out.print("格式错误");
//				
////				model.addAttribute("list",ownerManagerDtoList);
//				
//				model.addAttribute("newOwner",newOwner);
//				return "ownerManage";
//			}else {
//				System.out.print("格式ok");
//				
//			}
//			
//			//添加成功，model 返回页面
//			//add一个owner
//			//返回ownerManagerDtoList
////			model.addAttribute("list",ownerManagerDtoList);
////			model.addAttribute("newOwner",newOwner);
//			
//			return "ownerManage";
//	}
	
	
	
	

//方法一：jquery局部刷新，未能触发事件，也不能贴切模板排序查询	
	
//	@GetMapping("/addOwner")
//	@ResponseBody 
//	public  Map<String, Object> addOwner(@ModelAttribute Owner owner) {
//		
//		 Map<String, Object> result = new HashMap<String, Object>();
//	        
//	        //添加业主
////			boolean b=ownerServiceImpl.UpdateOwner(owner);
//
//			
//	        //假设添加业主成功
//	        
//	        
//			System.out.println("name="+owner.getOwnerName());
//			System.out.println("正在添加...");
//			if(true){
//				//封装正确消息
//				result.put("status", "succcessful");//succcessful
//				result.put("msg", "succcessful！");
//				result.put("ownerId", 1003);
//			}
////			else {
////				//封装错误消息
////				result.put("status", "fail");//fail
////				result.put("msg", "修改失败！");
////			}
//			return result;
//	}
	
}
