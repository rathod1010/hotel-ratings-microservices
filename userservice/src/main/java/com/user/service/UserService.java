package com.user.service;

import java.util.List;

import com.user.entity.User;

public interface UserService {
	
	User createUser(User user);
	
	List<User> getAllUser();
	
	User getUser(int userId);

}
