package fr.eservices.ifi.user_manager.srv;

import java.util.List;

import fr.eservices.ifi.user_manager.entity.User;

public interface UserService {
  
  // Pass SESSION/COOKIES/SOMETHING in params
  public User getAuthenticatedUser();

  public String getLoginPageUrl();

  public User create(String firstname, String lastname, String email, String password, String role);

  public User update(Long id, String firstname, String lastname, String email, String password, String role);

  public boolean delete(Long id);

  public List<User> list();

  public List<User> listByLastName(String lastname);

  public List<User> listByRole(String role);
}
