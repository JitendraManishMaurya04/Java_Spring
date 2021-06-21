package com.springdatabase.springdatabase;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.springdatabase.springdatabase.entity.Person;
import com.springdatabase.springdatabase.jdbc.PersonJdbcdao;

//@SpringBootApplication
public class SpringDatabaseApplication implements CommandLineRunner {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcdao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("All users -> {}", dao.findAll());
		LOGGER.info("User ID 1001 -> {}", dao.findById(1002));
		LOGGER.info("Delete User ID 1003 -> {}", dao.deleteById(1003));
		LOGGER.info("Insert User ID 1004 -> {}", dao.insert(new Person(1004, "Raju", "Mumbai", new Date())));
		LOGGER.info("Update User ID 1001 -> {}", dao.update(new Person(1001, "Maurya", "Lucknow", new Date())));
	}

}
