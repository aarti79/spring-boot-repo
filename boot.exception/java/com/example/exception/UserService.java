package com.example.exception;

import java.util.List;
import java.util.Optional;

public interface UserService {
	Optional<User> findById(long id);

	 List<User> findByName(String name);

	 void saveUser(User user);

	 void updateUser(User user);

	 void deleteUserById(long id);

	 List<User> findAllUsers();

	 void deleteAllUsers();

	 boolean isUserExist(User user);

}
