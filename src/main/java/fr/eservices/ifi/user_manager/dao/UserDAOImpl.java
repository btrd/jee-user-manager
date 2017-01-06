package fr.eservices.ifi.user_manager.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.eservices.ifi.user_manager.entity.User;

@Component
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	EntityManager em;

	public User find(Long id) {
		return em.find(User.class, id);
	}

	@Transactional
	public User updateUser(User user) {
		System.out.println(user.getId());
		int userUpdate = em
				.createQuery(
						"UPDATE User SET firstname = :firstname, lastname = :lastname, password = :password, role = :role, email = :email WHERE id = :id")
				.setParameter("firstname", user.getFirstname()).setParameter("lastname", user.getLastname())
				.setParameter("email", user.getEmail()).setParameter("password", user.getPassword())
				.setParameter("role", user.getRole()).setParameter("id", user.getId()).executeUpdate();
		return userUpdate == 1 ? user : null;
	}

	@Transactional
	public boolean deleteUser(Long id) {
		User user = this.find(id);
		if (user != null) {
			em.remove(user);
			return true;
		}
		return false;
	}

	public List<User> listUser() {
		return (List<User>) em.createQuery("SELECT u from User u", User.class).getResultList();
	}

	public List<User> listUserByLastName(String lastname) {
		TypedQuery<User> query = em.createQuery("SELECT u from User u WHERE lastname = :lastname", User.class);

		query.setParameter("lastname", lastname);

		return query.getResultList();
	}

	public List<User> retrieveUserByAuth(String email, String password) {
		TypedQuery<User> query = em.createQuery("SELECT u from User u WHERE email=:email AND password=:password",
				User.class);

		query.setParameter("email", email);
		query.setParameter("password", password);

		return query.getResultList();
	}

	public List<User> listUserByRole(String role) {

		TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.role = :role", User.class);

		q.setParameter("role", role);

		return q.getResultList();
	}

	@Transactional
	public User createUser(User user) {
		if (!em.contains(user)) {
			em.persist(user);
			em.flush();
			return user;
		} else {
			return null;
		}
	}
}
