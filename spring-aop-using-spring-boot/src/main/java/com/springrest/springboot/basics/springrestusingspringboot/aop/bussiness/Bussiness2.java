package com.springrest.springboot.basics.springrestusingspringboot.aop.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springboot.basics.springrestusingspringboot.aop.dao.Dao2;

@Service
public class Bussiness2 {

	@Autowired
	private Dao2 dao2;

	public String calculateSomething() {
		// BussinessLogic
		return dao2.retrieveSomething();
	}

}
