package fr.eservices.ifi.user_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.eservices.ifi.user_manager.dao.UserDAOImpl;
import fr.eservices.ifi.user_manager.entity.User;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserDAOImpl userDao;
	
  @RequestMapping(value="/index", method=RequestMethod.GET)
  public String index(){
    // userDao.createUser("Jean", "Bertrand", "jean@bertrand.me", "password", "ADMIN");
    return "index";
  }

  @RequestMapping(value="/list", method=RequestMethod.GET)
  public String listAll(Model model){
    model.addAttribute("listUser", userDao.listUser());
    return "list";
  }

  @RequestMapping(value="/login", method=RequestMethod.GET)
  public String initPage(Model model) {
    model.addAttribute("user", new User());
    return "login";
  }
  
  @RequestMapping(value="/login", method=RequestMethod.POST)
  public String loginSubmit(@ModelAttribute User user) {
    System.out.println(user.getEmail());
    System.out.println(user.getPassword());
    List<User> retrieveduser = userDao.retrieveUserByAuth(user.getEmail(), user.getPassword());
    
    if(retrieveduser.size() != 1) {
      // model.addAttribute("error", "Mauvaise connexion");
      return "login";
    }
    
    return "index";
  }
  
  @RequestMapping(value="/register", method=RequestMethod.GET)
  public String initRegisterPage(Model model) {
    model.addAttribute("user", new User());
    return "register";
  }
  
  @RequestMapping(value="/register", method=RequestMethod.POST)
  public String registerForm(@ModelAttribute User user) {
    userDao.createUser(user.getFirstname(), user.getLastname(), user.getEmail(), user.getPassword(), "RIGGER");
    
    return "index";
  }
}
