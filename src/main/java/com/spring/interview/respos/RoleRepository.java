package com.spring.interview.respos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.interview.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
