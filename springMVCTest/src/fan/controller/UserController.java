package fan.controller;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fan.model.Pager;
import fan.model.SystemContext;
import fan.model.User;
import fan.service.IUserService;




@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private IUserService userService;

	/*public IUserService getUserService() {
		return userService;
	}
	
	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}*/
/*
	@RequestMapping(value={"/users","/"},method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("pagers", userService.find());
		return "user/list1";//修改
	}*/
	//修改的
	@RequestMapping(value={"/users","/"},method=RequestMethod.GET)
	public String list(Model model) {
		//int size = SystemContext.getSize();
		int offset = SystemContext.getOffset();
		int size=5;
		//int offset=0;
		int total=userService.count();
		List<User> datas = userService.find(size,offset);
		Pager<User> us = new Pager<User>();
		us.setDatas(datas);
		us.setOffset(offset);
		us.setSize(size);
		us.setTotal(total);
		model.addAttribute("pagers", us);
		return "user/list";//修改
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(new User());
		return "user/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Validated User user,BindingResult br) {
		if(br.hasErrors()) {
			return "user/add";
		}
		userService.add(user);
		return "redirect:/user/users";
	}
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String show(@PathVariable int id,Model model) {
		model.addAttribute(userService.load(id));
		return "user/show";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String update(@PathVariable int id,Model model) {
		model.addAttribute(userService.load(id));
		return "user/update";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String update(@PathVariable int id,@Validated User user,BindingResult br,Model model) {
		if(br.hasErrors()) {
			return "user/update";
		}
		User tu = userService.load(id);
		tu.setPassword(user.getPassword());
		tu.setNickname(user.getNickname());
		tu.setEmail(user.getEmail());
		userService.update(tu);
		return "redirect:/user/users";
	}
	
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/user/users";
	}
}
