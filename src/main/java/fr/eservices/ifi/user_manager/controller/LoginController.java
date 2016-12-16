package fr.eservices.ifi.user_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.eservices.ifi.user_manager.dao.UserDAO;
import fr.eservices.ifi.user_manager.entity.User;

public class LoginController {

	@Autowired
	UserDAO userDao;
	
	public List<User> getAllUser(){
		return userDao.listUser();
	}
}
