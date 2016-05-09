package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//import com.example.repositories.RepositoryConfig;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.repositories"})
@EntityScan(basePackages = {"com.example.entities"})
public class MlTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MlTestApplication.class, args);
	}
	
}
