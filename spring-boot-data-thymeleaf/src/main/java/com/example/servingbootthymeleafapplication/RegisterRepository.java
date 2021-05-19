package com.example.servingbootthymeleafapplication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long>{
	List<Register> findByName(String firstName);

}
