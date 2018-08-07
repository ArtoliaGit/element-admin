package com.artolia.admin.service.system;

import com.artolia.admin.domain.system.User;

public interface UserService {

	User getUserByCache(String username);
	
}
