package pms.restController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pms.dto.OwnerHouseDto;
import pms.dto.OwnerManagerDto;
import pms.entity.Owner;
import pms.service.OwnerServiceImpl;

@Controller
public class OwnerController {

    @Autowired
    private OwnerServiceImpl ownerServiceImpl;    
    
    @Autowired
    private List<OwnerManagerDto> ownerManagerDtoList;  
    
	/**
	 * -管理员进入业主管理页面    小区所有业主信息
	 * -显示该页面的数据     OwnerManagerDto 
	 * @param model
	 * @return
	 */
	@GetMapping("/ownerManage")
	public String ownerManage(Model model) {
		System.out.print(" here is ownerManage.html\n");
		
		ownerManagerDtoList = ownerServiceImpl.findAllOwnerManagerDto();
		
		System.out.print(ownerManagerDtoList.get(1).getOwnerId());
		
		model.addAttribute("list",ownerManagerDtoList);
		
		return "ownerManage";
	}
	
	/**
	 * -修改业主信息
	 * @param 待修改  owner 对象
	 * @return
	 */
	@GetMapping("/updateOwner")
	@ResponseBody 
//	List<Map<String,Object>>
	public  Map<String, Object> updateOwner(@ModelAttribute Owner owner) {
		
		//修改owner
		//不需要判断直接修改
		System.out.println("正在update...");
		//调用service修改
		Map<String, Object> result = new HashMap<String, Object>();
		
		boolean b=ownerServiceImpl.UpdateOwner(owner);
		
		
		System.out.println("b="+b);
		if(b){
			//封装正确消息
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
//		boolean b=ownerServiceImpl.UpdateOwner(owner);
		//删除房屋关系
        //删除车位关系
        //删除消费信息
        //删除缴费信息
		
        //假设全部删除成功
        
        
		System.out.println("ownerId="+ownerId);
		System.out.println("正在删除...");
		if(true){
			//封装正确消息
			result.put("status", "succcessful");//succcessful
			result.put("msg", "succcessful！");
		}
//		else {
//			//封装错误消息
//			result.put("status", "fail");//fail
//			result.put("msg", "修改失败！");
//		}
		return result;
	}
	
	/**
	 * -添加业主信息
	 * @param 待添加 owner 对象
	 * @return
	 */
	@GetMapping("/addOwner")
	@ResponseBody 
	public  ModelAndView  addOwner(@ModelAttribute Owner owner,Model model) {
		
		 Map<String, Object> result = new HashMap<String, Object>();
	        
	        //添加业主
            //	boolean b=ownerServiceImpl.UpdateOwner(owner);

			
	        //假设添加业主成功
			System.out.println("name="+owner.getOwnerName());
			System.out.println("正在添加...");
			//封装正确消息
			result.put("status", "succcessful");//succcessful
			result.put("msg", "succcessful！");
			result.put("ownerId", 1003);
			
			model.addAttribute("list",ownerManagerDtoList);
			
			ModelAndView modelAndView=new ModelAndView(); 
			modelAndView.addObject("result",result);
			modelAndView.getModel().put("list",ownerManagerDtoList);
			modelAndView.setViewName("ownerManager");

			return modelAndView;
	}
	
	
	
	

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
