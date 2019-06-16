package pms.restController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pms.dto.UserDto;
import pms.entity.Manager;
import pms.entity.Owner;
import pms.entity.Security;
import pms.service.HomeServiceImpl;

@Controller
public class HomeController {
	
    @Autowired
    private UserDto userDto;		
   
    @Autowired
    private Manager manager;
    
    @Autowired
    private HomeServiceImpl homeServiceImpl;    
    
    /**
     * 跳至登录界面，传入userDTO实例,待用户输入账号密码类型
     * @param model
     * @return
     */
	@GetMapping("/")
	public String index(Model model) {
		System.out.print(" here is index.html");

		model.addAttribute(userDto);
		return "index";
	}
    
	/**
	 * - 核实用户输入格式
	 * -根据类型调用HomeService方法核实
	 * -validManager(UserDto ) validOwner(UserDto ) validSecurity(UserDto )  
	 * @param： @vaild UserDto 
	 * @return:相应的用户主页页面
	 */
	@PostMapping("/login")
	public String login(@Validated UserDto userDto, BindingResult bindingResult, Model model) {
		System.out.print("来了，老弟！\n");

		String loginResult="------此账号不存在或者用户类型不正确------";
		String userType = userDto.getUserType();
		//正则表达式判断
		if (bindingResult.hasFieldErrors()) {
			model.addAttribute(userDto);//返回index显示格式错误
			return "index";
		}else {
			
            if(userType.equals("1")) {//验证业主	
            	Owner owner=	homeServiceImpl.validOwner(userDto);
            	
    			if(owner==null) {//此账号不存在或者用户类型不正确
				    model.addAttribute("loginResult",loginResult);
				    return "index";
			     }
    			
			    model.addAttribute("owner",owner);
			    return "owner";
			
            }else if(userType.equals("2")) {//验证保安
            	Security security =	homeServiceImpl.validSecurity(userDto);
            	
    			if(security==null) {//此账号不存在或者用户类型不正确
				    model.addAttribute("loginResult",loginResult);
				    return "index";
			     }
    			
			    model.addAttribute("security",security);
			    return "security";  	
            }else {//验证管理员
            	manager = homeServiceImpl.validManager(userDto);
            	
    			if(manager==null) {//此账号不存在或者用户类型不正确
				    model.addAttribute("loginResult",loginResult);
				    return "index";
			     }
    			
			    model.addAttribute("manager",manager);
			    return "manager";
            }
			
			
		}
		
	}
	

	
	/**
	 * -管理员登录主页
	 * @param model
	 * @return
	 */
	@GetMapping("/manager")
	public String manager(Model model) {
		System.out.print(" here is manager.html\n");
		model.addAttribute("manager",manager);

		return "manager";

	}
	
	/**
	 * -业主登录主页
	 * @param model
	 * @return
	 */
	@GetMapping("/owner")
	public String owner(Model model) {
		System.out.print(" here is owner.html\n");
		return "owner";

	}
	
	/**
	 * -保安登录主页(展示当前访客车辆全天共享车辆临时共享车辆)
	 * @param model
	 * @return
	 */
	@GetMapping("/security")
	public String tables_dynamic(Model model) {
		System.out.print(" here is security.html\n");
		return "security";

	}
}


