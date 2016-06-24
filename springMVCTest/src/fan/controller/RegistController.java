package fan.controller;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fan.model.User;
import fan.service.IUserService;


@Controller
public class RegistController {
	@Resource
	private IUserService userService;
	@RequestMapping(value="/regist",method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute(new User());
			return "regist";
}
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String login(@Validated User user,BindingResult br,Model model) {
		if(br.hasErrors()) {
			//List<ObjectError> allErrors=br.getAllErrors();model.addAttribute("allErrors",allErrors);
			return "regist";
			
		}
		{userService.add(user);}
		return "redirect:login";
	}
}
