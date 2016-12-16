package fr.eservices.ifi.user_manager.dao;

import java.util.List;

import fr.eservices.ifi.user_manager.entity.User;

public interface UserDAO {

	public User createUser(String name, String mail, String password, String role);

	public User updateUser(String name, String mail, String password, String role);

	public boolean deleteUser(Long userId);

	public List<User> listUser();

	public List<User> listUserByLastName(String lastname);

	public List<User> listUserByRole(String role);

}
