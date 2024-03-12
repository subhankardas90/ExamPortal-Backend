package com.examportal.app.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.app.entity.User;
import com.examportal.app.entity.UserRole;
import com.examportal.app.repo.RoleRepository;
import com.examportal.app.repo.UserRepository;
import com.examportal.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User createUser(User user, Set<UserRole> userRoles)throws Exception {

		User local = this.userRepository.findByUserName(user.getUsername());
		if(local!=null) {
			System.out.println("User alredy there");
			throw new Exception("User alredy there");
		} else {
			for(UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
		return local;
	}
	//Getting User by Username
	@Override
	public User getUser(String userName) {
		return this.userRepository.findByUserName(userName);
	}
	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
	}

}
