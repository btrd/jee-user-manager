package fr.eservices.ifi.user_manager.srv;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fr.eservices.ifi.user_manager.entity.User;

public interface UserService {
	public User getAuthenticatedUser(HttpServletRequest req);

	public String getLoginPageUrl();

	public User create(User user);

	public User update(User user);

	public boolean delete(Long id);

	public List<User> list();

	public List<User> listByLastName(String lastname);

	public List<User> listByRole(String role);
}
