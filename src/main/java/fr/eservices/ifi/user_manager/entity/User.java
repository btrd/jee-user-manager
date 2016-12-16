package fr.eservices.ifi.user_manager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	Long id;

	String firstname, lastname, email, password;
	Role role;
}
