package fr.eservices.ifi.user_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eservices.ifi.user_manager.dao.UserDAO;
import fr.eservices.ifi.user_manager.entity.User;
import fr.eservices.ifi.user_manager.srv.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDAO userDao;

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest req) {
		User user = userService.getAuthenticatedUser(req.getSession());
		if (user != null) {
			model.addAttribute("user", user);
			return "index";
		} else {
			return "redirect:login";
		}
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAll(Model model, @RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "role", required = false) String role, HttpServletRequest req) {
		User user = userService.getAuthenticatedUser(req.getSession());
		if (user != null && user.getRole().equals("ADMIN")) {
			if (role != null && !role.isEmpty()) {
				model.addAttribute("listUser", userDao.listUserByRole(role));
			} else if (name != null && !name.isEmpty()) {
				model.addAttribute("listUser", userDao.listUserByLastName(name));
			} else {
				model.addAttribute("listUser", userDao.listUser());
			}
			return "list";
		} else if (user != null) {
			return "redirect:index";
		} else {
			return "redirect:login";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String initPage(Model model, HttpServletResponse res, HttpServletRequest req) {
    HttpSession session = req.getSession();
    session.invalidate();

		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginSubmit(@ModelAttribute User user, HttpServletResponse res, HttpServletRequest req) {
		List<User> retrievedUser = userDao.retrieveUserByAuth(user.getEmail(), user.getPassword());

		if (retrievedUser.size() != 1) {
			return "login";
		}
		HttpSession session = req.getSession();
		session.setAttribute("user_id", retrievedUser.get(0).getId());
		if (retrievedUser.get(0).getRole().equals("ADMIN")) {
			return "redirect:list";
		} else {
			return "redirect:index";
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String initRegisterPage(Model model, HttpServletRequest req) {
		User user = userService.getAuthenticatedUser(req.getSession());
		if (user != null && user.getRole().equals("ADMIN")) {
			model.addAttribute("user", new User());
			return "register";
		} else if (user != null) {
			return "redirect:index";
		} else {
			return "redirect:login";
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerForm(@ModelAttribute User user, HttpServletRequest req) {
		User user2 = userService.getAuthenticatedUser(req.getSession());
		if (user2 != null && user2.getRole().equals("ADMIN")) {
			userDao.createUser(user);
			return "redirect:list";
		} else if (user2 != null) {
			return "redirect:index";
		} else {
			return "redirect:login";
		}
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String initUpdateForm(Model model, @RequestParam("id") Long id) {
		model.addAttribute("user", userDao.find(id));
		return "edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String updateForm(@ModelAttribute User user) {
		System.out.println(user.getFirstname());
		userDao.updateUser(user);
		return "redirect:list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteForm(@RequestParam("id") Long id) {
		userDao.deleteUser(id);
		return "redirect:list";
	}
}
