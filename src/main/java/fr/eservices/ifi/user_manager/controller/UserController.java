package fr.eservices.ifi.user_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.eservices.ifi.user_manager.dao.UserDAO;
import fr.eservices.ifi.user_manager.dao.UserDAOImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import fr.eservices.ifi.user_manager.entity.User;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserDAO userDao;
	
  @RequestMapping(value="/index", method=RequestMethod.GET)
  public String index(){
    return "index";
  }

  @RequestMapping(value="/list", method=RequestMethod.GET)
  public String listAll(Model model, @RequestParam(value="name", required=false) String name,  @RequestParam(value="role", required=false) String role) {
    if(role != null && !role.isEmpty()) {
      model.addAttribute("listUser", userDao.listUserByRole(role));
    } else if(name != null && !name.isEmpty()) {
      model.addAttribute("listUser", userDao.listUserByLastName(name));
    } else {
      model.addAttribute("listUser", userDao.listUser());
    }
    return "list";
  }

  @RequestMapping(value="/login", method=RequestMethod.GET)
  public String initPage(Model model) {
    model.addAttribute("user", new User());
    return "login";
  }
  
  @RequestMapping(value="/login", method=RequestMethod.POST)
  public String loginSubmit(@ModelAttribute User user) {
    List<User> retrievedUser = userDao.retrieveUserByAuth(user.getEmail(), user.getPassword());
    if(retrievedUser.size() != 1) {
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
    userDao.createUser(user);
    return "index";
  }
  
  @RequestMapping(value="/edit", method=RequestMethod.GET)
  public String initUpdateForm(Model model, @RequestParam("id") Long id){
	model.addAttribute("user",userDao.find(id));
	return "edit";
  }
  
  @RequestMapping(value="/edit", method=RequestMethod.POST)
  public String updateForm(@ModelAttribute User user){
	System.out.println(user.getFirstname());
    userDao.updateUser(user);
    return "index";
  }
}
