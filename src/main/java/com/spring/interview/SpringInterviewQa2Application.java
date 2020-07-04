package com.spring.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("com.spring.interview.respos.*")
//@ComponentScan(basePackages = { "com.spring.interview.models.*" })
//@EntityScan("com.spring.interview.models.*")
public class SpringInterviewQa2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringInterviewQa2Application.class, args);
	}

}
