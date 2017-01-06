package fr.eservices.ifi.user_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eservices.ifi.user_manager.dao.UserDAO;
import fr.eservices.ifi.user_manager.entity.User;
import fr.eservices.ifi.user_manager.srv.UserServiceImpl;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserDAO userDao;

  @Autowired
  private UserServiceImpl userService;
	
  @RequestMapping(value="/index", method=RequestMethod.GET)
  public String index(HttpServletRequest req) {
    User user = userService.getAuthenticatedUser(req);
    if(user != null) {
      return "index";
    } else {
      return "login";
    }
  }

  @RequestMapping(value="/list", method=RequestMethod.GET)
  public String listAll(Model model, @RequestParam(value="name", required=false) String name,  @RequestParam(value="role", required=false) String role, HttpServletRequest req) {
    User user = userService.getAuthenticatedUser(req);
    if(user != null && user.getRole().equals("ADMIN")) {
      if(role != null && !role.isEmpty()) {
        model.addAttribute("listUser", userDao.listUserByRole(role));
      } else if(name != null && !name.isEmpty()) {
        model.addAttribute("listUser", userDao.listUserByLastName(name));
      } else {
        model.addAttribute("listUser", userDao.listUser());
      }
      return "list";
    } else if(user != null) {
      return "index";
    } else {
      return "login";
    }
  }

  @RequestMapping(value="/login", method=RequestMethod.GET)
  public String initPage(Model model) {
    model.addAttribute("user", new User());
    return "login";
  }
  
  @RequestMapping(value="/login", method=RequestMethod.POST)
  public String loginSubmit(@ModelAttribute User user, HttpServletResponse res) {
    List<User> retrievedUser = userDao.retrieveUserByAuth(user.getEmail(), user.getPassword());

    if(retrievedUser.size() != 1) {
      return "login";
    }
    Cookie c = new Cookie("user_id", String.valueOf(retrievedUser.get(0).getId()));
    res.addCookie(c);
    if(retrievedUser.get(0).getRole().equals("ADMIN")) {
      return "list";
    } else {
      return "index";
    }
  }
  
  @RequestMapping(value="/register", method=RequestMethod.GET)
  public String initRegisterPage(Model model, HttpServletRequest req) {
    User user = userService.getAuthenticatedUser(req);
    if(user != null && user.getRole().equals("ADMIN")) {
      model.addAttribute("user", new User());
      return "register";
    } else if(user != null) {
      return "index";
    } else {
      return "login";
    }
  }
  
  @RequestMapping(value="/register", method=RequestMethod.POST)
  public String registerForm(@ModelAttribute User user, HttpServletRequest req) {
    User user2 = userService.getAuthenticatedUser(req);
    if(user2 != null && user2.getRole().equals("ADMIN")) {
      userDao.createUser(user);
      return "list";
    } else if(user2 != null) {
      return "index";
    } else {
      return "login";
    }
  }
}
