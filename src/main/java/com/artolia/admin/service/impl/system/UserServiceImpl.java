package com.artolia.admin.service.impl.system;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artolia.admin.domain.system.Roles;
import com.artolia.admin.domain.system.User;
import com.artolia.admin.mapper.system.UserMapper;
import com.artolia.admin.service.system.UserService;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

@Service
public class UserServiceImpl implements UserService {
	
	Cache<String, User> userCache = CacheBuilder.newBuilder().expireAfterAccess(1, TimeUnit.HOURS).build();
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserByCache(String username) {
		User user = null;
		try {
			user = userCache.get(username, new Callable<User>() {

				@Override
				public User call() throws Exception {
					return getUserByDb(username);
				}
				
			});
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User getUserByDb(String username) {
		User user = userMapper.getUserByUsername(username);
		List<Roles> roles = userMapper.getRolesByUser(user.getId());
		user.setRoles(roles);
		return user;
	}

}
