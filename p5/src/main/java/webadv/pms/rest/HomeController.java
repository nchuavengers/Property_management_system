package webadv.pms.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import webadv.pms.domin.Teacher;
import webadv.pms.repository.TeacherRepository;

@Controller
public class HomeController {
	@Autowired
	private TeacherRepository repository;	
	@PostMapping("/login")
	public String login(Model model,String account, String password,String loginType) {
		System.out.print("Here is index.html\n");
		String loginResult="------The password or account is wrong !--------------";
		//1.判断用户登陆类型
		if("1".equals(loginType)) { //业主
			//2.判断业主账号密码
			Teacher t=repository.validTeacher(account,password);
			if(t==null) {
				model.addAttribute("loginResult",loginResult);
				return "index";
			}
			model.addAttribute("t",t);
			List<Teacher> list=repository.findAll();
	        model.addAttribute("teachers",list);
			System.out.print("control"+list.get(0).getName());
			System.out.print("control"+list.get(1).getName());
			return "owner";
		}
		else if("2".equals(loginType)) { //保安
			//2.判断保安账号密码
			Teacher t=repository.validTeacher(account,password);
			if(t==null) {
				//2.判断保安账号密码
				model.addAttribute("loginResult",loginResult);
				return "index";
			}
			model.addAttribute("t",t);
			List<Teacher> list=repository.findAll();
	        model.addAttribute("teachers",list);
			System.out.print("control"+list.get(0).getName());
			System.out.print("control"+list.get(1).getName());
			return "security";
		}
		
		else if("3".equals(loginType)) { //管理员
			//2.判断管理账号密码
			Teacher t=repository.validTeacher(account,password);
			if(t==null) {
				model.addAttribute("loginResult",loginResult);
				return "index";
			}
			model.addAttribute("t",t);
			List<Teacher> list=repository.findAll();
	        model.addAttribute("teachers",list);
			System.out.print("control"+list.get(0).getName());
			System.out.print("control"+list.get(1).getName());
			return "manager";
		}
		else {
			model.addAttribute("loginResult","please choose your login Type");
			return "index";
		}
			
	}
	
	@GetMapping("/security")
	public String tables_dynamic(Model model) {
		System.out.print(" here is security.html\n");
		return "security";

	}
	@GetMapping("/owner")
	public String owner(Model model) {
		System.out.print(" here is owner.html\n");
		return "owner";

	}
	@GetMapping("/manager")
	public String manager(Model model) {
		System.out.print(" here is manager.html\n");
		return "manager";

	}
	@GetMapping("/announcementManage")
	public String announcementManage(Model model) {
		System.out.print(" here is announcementManage.html\n");
		return "announcementManage";

	}
	@GetMapping("/facilityManage")
	public String facilityManage(Model model) {
		System.out.print(" here is facilityManage.html\n");
		return "facilityManage";

	}
	@GetMapping("/roomManage")
	public String homeManage(Model model) {
		System.out.print(" here is roomManage.html\n");
		return "roomManage";

	}
	@GetMapping("/ownerManage")
	public String userManage(Model model) {
		System.out.print(" here is ownerManage.html\n");
		return "ownerManage";

	}
	@GetMapping("/parkingSpaceManage")
	public String parkingSpaceManage(Model model) {
		System.out.print(" here is parkingSpaceManage.html\n");
		return "parkingSpaceManage";

	}
}