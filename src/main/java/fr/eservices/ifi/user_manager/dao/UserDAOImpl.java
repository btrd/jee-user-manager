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
	/*
	@Transactional
	public User createUser(String firstname, String lastname, String email, String password, String role) {
		TypedQuery<User> query = em.createQuery(
				"INSERT INTO User VALUES(:firstname, :lastname, :email, :password, :role)", User.class);
		
		Query query = em.createNativeQuery("INSERT INTO User(firstname, lastname, email, password, role) VALUES(:firstname, :lastname, :email, :password, :role)", User.class);
		query.setParameter("firstname", firstname).setParameter("lastname", lastname).setParameter("email", email).setParameter("password", password).setParameter("role", role);
		query.executeUpdate();
		return new User();
	}
	*/
	
	public User find(Long id){
		return em.find(User.class,id);
	}
	
	// Shijin
	// pas encore tester / ?role type Role et String / ?update user by email ou by id
	@Transactional
	public User updateUser(User user) {
		System.out.println(user.getId());
		int userUpdate = em.createQuery(
				"UPDATE User SET firstname = :firstname, lastname = :lastname, password = :password, role = :role, email = :email WHERE id = :id")
				.setParameter("firstname", user.getFirstname())
				.setParameter("lastname", user.getLastname())
				.setParameter("email", user.getEmail())
				.setParameter("password", user.getPassword())
				.setParameter("role", user.getRole())
				.setParameter("id", user.getId())
				.executeUpdate();
		return userUpdate == 1 ? user : null;
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

  public User retrieveUserById(Long id) {
		TypedQuery<User> query = em.createQuery("SELECT u from User u WHERE id=:id", User.class);
		query.setParameter("id", id);
		List<User> result = query.getResultList();
    if(result.size() == 1) {
      // model.addAttribute("error", "Mauvaise connexion");
      return result.get(0);
    } else {
    	return null;
    }
	}

	// Antoine
	public List<User> listUserByRole(String role) {

		TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.role = :role", User.class);

		q.setParameter("role", role);

		return q.getResultList();
	}

	@Transactional
	public User createUser(User user) {
		if(!em.contains(user)){
			em.persist(user);
			em.flush();
			return user;		
		}else{
			return null;
		}		
	}

}
