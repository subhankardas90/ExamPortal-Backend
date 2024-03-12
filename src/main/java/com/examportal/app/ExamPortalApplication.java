package com.examportal.app;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.examportal.app.entity.Role;
import com.examportal.app.entity.User;
import com.examportal.app.entity.UserRole;
import com.examportal.app.service.UserService;

@SpringBootApplication
public class ExamPortalApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
		System.out.println("Started......");
		
//		User user = new User();
//		user.setFirstName("Subhashish");
//		user.setLastName("Patra");
//		user.setUserName("Subhashish Patra");
//		user.setPassword(this.bCryptPasswordEncoder.encode("password"));
//		user.setEmail("XYZ@gmail.com");
//		user.setProfile("default.png");
//		
//		Role role1 = new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//		
//		Set<UserRole> rset = new HashSet<>();
//		
//		UserRole userrole = new UserRole();
//		userrole.setRole(role1);
//		
//		userrole.setUser(user);
//		rset.add(userrole); 
//		
//		User user1 = this.userService.createUser(user, rset);
		//System.out.println(user1.getUserName());
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
		}
	}

}
