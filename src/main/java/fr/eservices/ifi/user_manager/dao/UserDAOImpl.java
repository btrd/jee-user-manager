package fr.eservices.ifi.user_manager.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.eservices.ifi.user_manager.entity.User;

@Component
public class UserDAOImpl implements UserDAO {

	public User createUser(String name, String mail, String password, String role) {
		// TODO Auto-generated method stub
		return null;
	}

	public User updateUser(String name, String mail, String password, String role) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteUser(Long userId) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<User> listUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> listUserByLastName(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> listUserByRole(String role) {
		// TODO Auto-generated method stub
		return null;
	}

}
