package com.spring.interview.respos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.interview.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
