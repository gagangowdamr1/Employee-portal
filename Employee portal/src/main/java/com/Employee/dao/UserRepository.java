package com.Employee.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Employee.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select u from User u where u.email = :email")
	public User getUserByUserName(@Param("email") String email);
	public List<User> findByRole(String role) ;
   // public Optional<User> findById(Integer id);
	//public static User getById(Long id);
	//public static void deleteById(Long id) ;
		
	
}
