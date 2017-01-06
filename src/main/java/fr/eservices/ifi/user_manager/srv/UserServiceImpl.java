package fr.eservices.ifi.user_manager.srv;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.eservices.ifi.user_manager.dao.UserDAO;
import fr.eservices.ifi.user_manager.dao.UserDAOImpl;
import fr.eservices.ifi.user_manager.entity.User;

@Component
public class UserServiceImpl implements UserService {
  
  @Autowired
  UserDAO dao;
  
  @Override
  public User getAuthenticatedUser(HttpServletRequest req) {
    Long user_id = null;
    Cookie[] cookies = req.getCookies();
    if (cookies != null) {
      for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals("user_id")) {
          user_id = Long.parseLong(cookies[i].getValue());
          break;
        }
      }
    }

    return dao.retrieveUserById(user_id);
  }

  @Override
  public String getLoginPageUrl() {
    return "/user/login";
  }

  @Override
  public User create(User user) {
    return dao.createUser(user);
  }

  @Override
  public User update(User user) {
    return dao.updateUser(user);
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
