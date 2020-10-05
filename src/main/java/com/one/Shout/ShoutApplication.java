package com.one.Shout;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("com.one.Shout.repository")
public class ShoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoutApplication.class, args);
	}

	@RequestMapping(value = "/api")
	public ResponseEntity<String> sayHello() {
		System.out.println("HEllofdghjkl;==============");
		return ResponseEntity.ok("Hello from Server");
	}

	@RequestMapping(value = "/user")
	public Principal user(Principal principal) {
		principal.getName();

		return principal;
	}

}
