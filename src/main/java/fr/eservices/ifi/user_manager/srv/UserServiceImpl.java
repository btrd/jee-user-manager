package fr.eservices.ifi.user_manager.srv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.eservices.ifi.user_manager.dao.UserDAOImpl;
import fr.eservices.ifi.user_manager.entity.User;

@Component
public class UserServiceImpl implements UserService {
  
  @Autowired
  UserDAOImpl dao;
  
  @Override
  public User getAuthenticatedUser() {
    return null;
  }

  @Override
  public String getLoginPageUrl() {
    return "/user/login";
  }

  @Override
  public User create(String firstname, String lastname, String email, String password, String role) {
    return dao.createUser(firstname, lastname, email, password, role);
  }

  @Override
  public User update(Long id, String firstname, String lastname, String email, String password, String role) {
    return dao.updateUser(id, firstname, lastname, email, password, role);
  }

  @Override
  public boolean delete(Long id) {
    return dao.deleteUser(id);
  }

  @Override
  public List<User> list() {
    return dao.listUser();
  }

  @Override
  public List<User> listByLastName(String lastname) {
    return dao.listUserByLastName(lastname);
  }

  @Override
  public List<User> listByRole(String role) {
    return dao.listUserByRole(role);
  }

}
