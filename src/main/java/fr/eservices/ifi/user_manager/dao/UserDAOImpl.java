package fr.eservices.ifi.user_manager.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Entity;
import org.springframework.stereotype.Component;

import fr.eservices.ifi.user_manager.entity.User;

@Component
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	EntityManager em;
	// EntityManagerFactory emf;
	// EntityTransaction tx;

	// public UserDAOImpl() {
	// 	emf = Persistence.createEntityManagerFactory("userManager");
	// 	em = emf.createEntityManager();
	// 	tx = em.getTransaction();
	// }

	// public void close() {
	// 	em.close();
	// 	emf.close();
	// }

	// Shijin
	// pas encore tester / ?role type Role et String
	public User createUser(String firstname, String lastname, String email, String password, String role) {
		TypedQuery<User> query = em.createQuery(
				"INSERT INTO User(firstname, lastname, email, password, role) values(:firstname, :lastname, :email, :password, :role)", User.class);
		query.setParameter("firstname", firstname).setParameter("lastname", lastname).setParameter("email", email).setParameter("password", password).setParameter("role", role);
		return query.getResultList().get(0);
	}

	// Shijin
	// pas encore tester / ?role type Role et String / ?update user by email ou by id
	public User updateUser(Long id, String firstname, String lastname, String email, String password, String role) {
		TypedQuery<User> query = em.createQuery(
				"UPDATE User SET firstname = :firstname, lastname = :lastname, password = :password, role = :role WHERE email = :email WHERE id = :id",
				User.class);
		query.setParameter("firstname", firstname).setParameter("lastname", lastname).setParameter("email", email).setParameter("password", password).setParameter("role", role);
		return query.getResultList().get(0);
	}

	// Shijin
	// pas encore tester
	public boolean deleteUser(Long id) {
		int count = em
			.createQuery("DELETE FROM User where id = :id")
			.setParameter("id", id)
			.executeUpdate();
		return count == 1;
	}

	public List<User> listUser() {
		return (List<User>) em.createQuery("SELECT u from User u", User.class).getResultList();
	}

	// Antoine
	public List<User> listUserByLastName(String lastname) {
		TypedQuery<User> query = em.createQuery("SELECT u from User u WHERE lastname = :lastname", User.class);

		query.setParameter("lastname", lastname);

		return query.getResultList();
	}
  
  // Antoine
  public List<User> retrieveUserByAuth(String email, String password) {
		TypedQuery<User> query = em.createQuery("SELECT u from User u WHERE email=:email AND password=:password", User.class);

		query.setParameter("email", email);
    query.setParameter("password", password);

		return query.getResultList();
	}

	// Antoine
	public List<User> listUserByRole(String role) {

		TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.role = :role", User.class);

		q.setParameter("role", role);

		return q.getResultList();
	}

}
