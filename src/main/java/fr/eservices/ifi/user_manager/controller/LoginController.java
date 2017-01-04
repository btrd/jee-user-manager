package fr.eservices.ifi.user_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.eservices.ifi.user_manager.dao.UserDAOImpl;
import fr.eservices.ifi.user_manager.entity.User;

public class LoginController {
  
  @Autowired
  private UserDAOImpl userdao;
  
  @GetMapping("/login")
  public String initPage(Model model) {
    model.addAttribute("user", new User());
    return "login.jsp";
  }
	
	@PostMapping("/login")
  public String loginSubmit(@ModelAttribute User user) {
    List<User> retrieveduser = userdao.retrieveUserByAuth(user.getEmail(), user.getPassword());
    
    if(retrieveduser.size() != 1) {
      return "ERROR: incorrect login or password";
    }
    else {
      new ModelAndView("redirect:/loggedin");
    }
    
    return "login procedure";
  }
	
	public List<User> getAllUser(){
		return userdao.listUser();
	}
}
