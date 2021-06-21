package com.springdatabase.springdatabase;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springdatabase.springdatabase.entity.Person;
import com.springdatabase.springdatabase.jpa.PersonJpaRepository;

@SpringBootApplication
public class SpringJPADatabaseApplication implements CommandLineRunner {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository jpaRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringJPADatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("All users -> {}", jpaRepo.findById(1001));
		LOGGER.info("Insert User ID 1004 -> {}", jpaRepo.update(new Person(1004, "Raju", "Mumbai", new Date())));
		jpaRepo.deleteById(1003);
		LOGGER.info("All users -> {}", jpaRepo.findAll());

	}

}
