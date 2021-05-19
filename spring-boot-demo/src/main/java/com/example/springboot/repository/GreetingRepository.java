package com.example.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.restservice.Greeting;

@Repository
public interface GreetingRepository extends CrudRepository<Greeting, Long>{

}

