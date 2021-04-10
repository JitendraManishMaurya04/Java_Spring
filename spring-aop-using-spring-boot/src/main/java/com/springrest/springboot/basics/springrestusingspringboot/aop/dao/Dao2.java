package com.springrest.springboot.basics.springrestusingspringboot.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class Dao2 {

	public String retrieveSomething() {
		return "DAO2";
	}

}
