package com.Employee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.Employee.dao.UserRepository;
import com.Employee.entities.User;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// fetching user from database

		User user = userRepository.getUserByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException("Could not found user !!");
		}

		CustomUserDetails customUserDetails = new CustomUserDetails(user);

		return customUserDetails;
	}

	//	delete employee by id
//	public String deleteUserById(Long id) {
//		//		find an employee by id
//		User emp = UserRepository.getById(id);
//
//		//		if there is not an employee who has the id, throw the error.
//		if (emp == null) {
//			throw new RuntimeException("Employee not found");
//		}
//
//		//		delete an employee who has the id from the database
//		UserRepository.deleteById(id);
//		return "Deleted: " + emp.name();
//	}
}


