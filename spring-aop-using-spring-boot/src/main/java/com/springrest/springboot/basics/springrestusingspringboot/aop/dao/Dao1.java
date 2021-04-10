package com.springrest.springboot.basics.springrestusingspringboot.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {

	public String retrieveSomething() {
		return "DAO1";
	}

}
