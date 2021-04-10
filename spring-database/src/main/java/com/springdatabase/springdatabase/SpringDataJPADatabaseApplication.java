package com.springdatabase.springdatabase;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.springdatabase.springdatabase.entity.Person;
import com.springdatabase.springdatabase.springdata.PersonSpringDataRepo;

//@SpringBootApplication
public class SpringDataJPADatabaseApplication implements CommandLineRunner {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonSpringDataRepo jpaRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJPADatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("All users -> {}", jpaRepo.findById(1001));
		LOGGER.info("Insert User ID 1004 -> {}", jpaRepo.save(new Person(1004, "Pooja", "Mumbai", new Date())));
		jpaRepo.deleteById(1003);
	}

}
