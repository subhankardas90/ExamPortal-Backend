package com.examportal.app.service;

import java.util.Set;

import com.examportal.app.entity.User;
import com.examportal.app.entity.UserRole;

public interface UserService {
	
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	//get User By User Name
	public User getUser(String userName);
	
	//Delete User By Id
	public void deleteUser(Long userId);

}
