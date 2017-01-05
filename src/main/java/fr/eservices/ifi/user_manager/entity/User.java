package fr.eservices.ifi.user_manager.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue
	Long id;

	String firstname, lastname, email, password;
	Role role;

	// Shijin
	public User() {
	}

	// Shijin
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	// Shijin
	public User(String firstname, String lastname, String email, String password, Role role) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
