package com.springrest.springboot.basics.springrestusingspringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.springrest.springboot.basics.springrestusingspringboot.aop.bussiness.Bussiness1;
import com.springrest.springboot.basics.springrestusingspringboot.aop.bussiness.Bussiness2;

@SpringBootApplication
@ComponentScan("com.springrest.springboot.basics.springrestusingspringboot.aop")
public class SpringRestUsingSpringBootApplication implements CommandLineRunner {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Bussiness1 bussiness1;

	@Autowired
	private Bussiness2 bussiness2;

	public static void main(String[] args) {
		SpringApplication.run(SpringRestUsingSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info(bussiness1.calculateSomething());
		LOGGER.info(bussiness2.calculateSomething());
	}

}
