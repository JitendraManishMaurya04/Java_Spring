package com.springdatabase.springdatabase.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatabase.springdatabase.entity.Person;

public interface PersonSpringDataRepo extends JpaRepository<Person, Integer> {
}
