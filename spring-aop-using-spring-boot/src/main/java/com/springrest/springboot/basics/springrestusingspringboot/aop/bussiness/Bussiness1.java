package com.springrest.springboot.basics.springrestusingspringboot.aop.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springboot.basics.springrestusingspringboot.aop.dao.Dao1;

@Service
public class Bussiness1 {

	@Autowired
	private Dao1 dao1;

	public String calculateSomething() {
		// BussinessLogic
		return dao1.retrieveSomething();
	}

}
