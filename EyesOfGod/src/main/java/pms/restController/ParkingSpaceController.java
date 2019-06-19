package pms.restController;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import pms.dto.MyParkingSpaceDto;
import pms.dto.OwnerParkingSpaceDto;
import pms.dto.SetShareTimeDto;
import pms.entity.Owner;
import pms.entity.ParkingSpace;
import pms.service.ParkingSpaceServiceImpl;

@Controller  
public class ParkingSpaceController {
	
    @Autowired
    private List<MyParkingSpaceDto> myParkingSpaceDtoList;  
    
    @Autowired
    private ParkingSpaceServiceImpl parkingSpaceServiceImpl;
    
    
    @Autowired
   	private Owner owner;
    
//    @Autowired
//    private SetShareTimeDto   setShareTimeDto;
	/**
	 * -我的车位，业主车位
	 * @param model  + ownerParkingSpaceDto
	 * @return
	 */
//	@GetMapping("/ownerParking/{ownerId}")
//
//	public String ownerParking(@PathVariable (value="ownerId") String ownerId,Model model,HttpSession session2) {
	@GetMapping("/ownerParking")

	public String ownerParking(Model model,HttpSession session2) {	
		Owner owner=(Owner) session2.getAttribute("owner");
		
		System.out.print(" here is ownerParking.html\n");
		int id=owner.getOwnerId();
//		int id=Integer.parseInt(ownerId);	
		
		myParkingSpaceDtoList = parkingSpaceServiceImpl.findOwnerParkingSpace(id);
		
		for(MyParkingSpaceDto  m: myParkingSpaceDtoList) {
//			 Date d=new Date();
//			 m.setShareingBeginTime(d);
			System.out.print(" 111");
			if(m.getParkingSpaceType().equals("2")) {
				m.setParkingSpaceType("私有");
			}
			if(m.getParkingSpaceStatus().equals("1")) {
				m.setParkingSpaceStatus("无人");
			}
			else {
				m.setParkingSpaceStatus("有人");
			}
		}
		
		model.addAttribute("list",myParkingSpaceDtoList);
		
		//重定向
		return "ownerParking";
//		return "redirect:/ownerParking";
	}
	
	
	/**
	 * -设置今日共享时间
	 * --修改共享开始结束时间，修改车位状态)
	 * @param 
	 * @return
	 */
	@GetMapping("/setShareTime")
	@ResponseBody 
	public Map<String, Object> setShareTime( @ModelAttribute SetShareTimeDto setShareTimeDto) {
		
	    int parkingSpaceId=setShareTimeDto.getParkingSpaceId();//车位id
	    String shareingBeginTime=setShareTimeDto.getShareingBeginTime();//共享开始时间
	    String shareingEndingTime=setShareTimeDto.getShareingEndingTime();//共享结束时间
	    
	    MyParkingSpaceDto myParkingSpaceDto =new MyParkingSpaceDto();
	    myParkingSpaceDto.setParkingSpaceId(parkingSpaceId);
	    myParkingSpaceDto.setShareingBeginTime(parkingSpaceServiceImpl.strToDate(shareingBeginTime));
	    myParkingSpaceDto.setShareingEndingTime(parkingSpaceServiceImpl.strToDate(shareingEndingTime));
	    
	    
	    Map<String, Object> result = new HashMap<String, Object>();
	    
	    boolean b=parkingSpaceServiceImpl.setShareTime(myParkingSpaceDto);

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
	 * -重置今日共享时间
	 * -取消今日共享（车位在用不可取消）重置共享时间0
	 * @param 
	 * @return
	 */
	@GetMapping("/resetShareTime")
	@ResponseBody 
	public Map<String, Object> resetShareTime( @ModelAttribute  MyParkingSpaceDto myParkingSpaceDto) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		    
		myParkingSpaceDto.setShareingBeginTime(null);
		myParkingSpaceDto.setShareingEndingTime(null);
	    boolean b=parkingSpaceServiceImpl.setShareTime(myParkingSpaceDto);

	    System.out.print(" 重置id\n"+myParkingSpaceDto.getParkingSpaceId());
	    
		System.out.println("b="+b);
		if(b){
			//封装正确消息
			result.put("status", "succcessful");//succcessful
			result.put("msg", "重置succcessful！");
			result.put("parkingSpaceId", myParkingSpaceDto.getParkingSpaceId());
		}
		else {
			//封装错误消息
			result.put("status", "fail");//fail
			result.put("msg", "重置失败！");
		}
		return result;
	}
	
	

	
	
	
	
	
	
	
	
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
	
}
