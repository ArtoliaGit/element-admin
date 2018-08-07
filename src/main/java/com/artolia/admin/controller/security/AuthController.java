package com.artolia.admin.controller.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artolia.admin.config.security.JwtTokenProvider;
import com.artolia.admin.domain.system.Roles;
import com.artolia.admin.domain.system.User;

@RestController
@RequestMapping("auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager providerManager;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@PostMapping("/login")
	public String login(@RequestBody User user) {
		UsernamePasswordAuthenticationToken upToken=new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
		// 进行安全认证
        final Authentication authentication = providerManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
		List<Roles> roles = new ArrayList<Roles>();
//		roles.add(Role.ROLE_ADMIN);
		Roles role = new Roles();
		role.setCode("admin");
		role.setName("管理员");
		roles.add(role);
		String token = jwtTokenProvider.createToken(user.getUsername(), roles);
		System.out.println(token);
		return token;
	}
}
