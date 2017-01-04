package fr.eservices.ifi.user_manager.dao;

import java.util.List;

import fr.eservices.ifi.user_manager.entity.User;

public interface UserDAO {

	public User createUser(String firstname, String lastname, String email, String password, String role);

	public User updateUser(Long id, String firstname, String lastname, String email, String password, String role);

	public boolean deleteUser(Long id);

	public List<User> listUser();

	public List<User> listUserByLastName(String lastname);
  
	public List<User> retrieveUserByAuth(String email, String password);

	public List<User> listUserByRole(String role);

}
