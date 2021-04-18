package com.mySpringPorject.rest.webservices.restfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPAResourceRepo extends JpaRepository<User, Integer> {

}
