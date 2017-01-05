import org.springframework.stereotype.Component;
import java.rmi.server.UID;

@Component
public class Session() {
  
  private UID id;
  private String firstname;
  private String email;
  private Role role;  
  
  public Session(User user) {
    this.id = generateSessionId();
    this.firstname = user.getFirstname();
    this.email = user.getEmail();
    this.role = user.getRole();
  }
  
  public String getFirstname() {
    return this.firstname;
  }
  
  public String getLastname() {
    return this.lastname;
  }
  
  public Role getRole() {
    return this.role;
  }
  
  private UID generateSessionId() {
    return new UID();
  }
}