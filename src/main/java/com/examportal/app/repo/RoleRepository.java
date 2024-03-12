package com.examportal.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examportal.app.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
