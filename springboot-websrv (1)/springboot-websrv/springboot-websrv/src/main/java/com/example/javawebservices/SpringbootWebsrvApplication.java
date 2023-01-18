package com.example.javawebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//utan 3 sista rader den inte alls och de står att något är fel med BEAN dependancy?
//och man lämnar in dessa linjer så får jag "not found i postman"
//om jag tar ut dom, then the files dont like it are userController,UserService,Webclient config.
@SpringBootApplication
/* @ComponentScan(basePackages = {"com.example.controller"})
@EnableJpaRepositories(basePackages = "com.example.repository")
@EntityScan(basePackages = "com.example.entities")
*/
public class SpringbootWebsrvApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebsrvApplication.class, args);
	}

}
