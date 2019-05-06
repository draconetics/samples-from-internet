package com.telusko.secureapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println(username);
		User user = repo.findByUsername(username);
		System.out.println(user.getUsername()+ " " + user.getPassword());
		if(user==null)
			throw new UsernameNotFoundException("User 404");
		else
			System.out.println(user);
		return new UserPrincipal(user);
	}

}
