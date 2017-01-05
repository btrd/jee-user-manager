package fr.eservices.ifi.user_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.eservices.ifi.user_manager.srv.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl userSrv;
	
  @RequestMapping(value="/index", method=RequestMethod.GET)
  public String index(){
    return "index";
  }

  @RequestMapping(value="/list", method=RequestMethod.GET)
  public String listAll(Model model){
    model.addAttribute("listUser", userSrv.list());
    return "list";
  }
}
