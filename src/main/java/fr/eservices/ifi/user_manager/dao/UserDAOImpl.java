package fr.eservices.ifi.user_manager.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import fr.eservices.ifi.user_manager.entity.User;

@Component
public class UserDAOImpl implements UserDAO {

	EntityManager em;
	EntityManagerFactory emf;
	EntityTransaction tx;

	public UserDAOImpl() {
		emf = Persistence.createEntityManagerFactory("myApp");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	public void close() {
		em.close();
		emf.close();
	}
	
	public User createUser(String name, String mail, String password, String role) {
		// TODO Auto-generated method stub
		return null;
	}

	public User updateUser(String name, String mail, String password, String role) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteUser(Long userId) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<User> listUser() {
		return em.createQuery("SELECT u from user u",User.class).getResultList();
	}

  // Antoine
	public List<User> listUserByLastName(String lastname) {
		TypedQuery<User> query = em.createQuery("SELECT u from User u WHERE lastname = :lastname", User.class);
    
    query.setParameter("lastname", lastname);
		
		return query.getResultList();
	}

  // Antoine
	public List<User> listUserByRole(String role) {
    
    TypedQuery<Pilote> q = em.createQuery("SELECT u FROM User u WHERE u.role = :role", User.class);
    
		q.setParameter("role", role);
    
    return q.getResultList();
	}

}
