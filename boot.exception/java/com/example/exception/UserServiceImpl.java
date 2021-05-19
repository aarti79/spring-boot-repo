package com.example.exception;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	@Transactional
	public Optional<User> findById(long id) {
		Optional<User> user = userRepo.findById(id);
		return user;
	}

	@Override
	@Transactional
	public List<User> findByName(String name) {
		List<User> user = userRepo.findByName(name);
		return user;
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		userRepo.save(user);

	}

	@Override
	@Transactional
	public void updateUser(User user) {
		userRepo.save(user);
	}

	@Override
	@Transactional
	public void deleteUserById(long id) {
		userRepo.deleteById(id);
	}

	@Override
	@Transactional
	public List<User> findAllUsers() {
		List<User> user = userRepo.findAll();
		return user;
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		return false;
	}
}
