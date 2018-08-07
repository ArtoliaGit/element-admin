package com.artolia.admin.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.artolia.admin.domain.system.User;
import com.artolia.admin.service.system.UserService;

@Component
public class MyUserDetailsService implements UserDetailsService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final User user = userService.getUserByCache(username);
		
		if (user == null) {
			logger.info("User '" + username + "' not found");
			throw new UsernameNotFoundException("User '" + username + "' not found");
	    }
		
		return org.springframework.security.core.userdetails.User
				.withUsername(username)
				.password(user.getPassword())
				.authorities(user.getRoles())
				.build();
	}

}
