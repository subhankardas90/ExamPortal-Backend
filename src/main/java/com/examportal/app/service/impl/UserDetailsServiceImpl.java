package com.examportal.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.examportal.app.entity.User;
import com.examportal.app.repo.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User dbUser = this.userRepository.findByUserName(username);
		if(dbUser == null) {
			System.out.println("User Not found");
			throw new UsernameNotFoundException("No User Found with this user name");
		}
		return dbUser;
	}

}
