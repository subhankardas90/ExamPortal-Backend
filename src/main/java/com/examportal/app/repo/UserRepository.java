package com.examportal.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examportal.app.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUserName(String userName);

}
