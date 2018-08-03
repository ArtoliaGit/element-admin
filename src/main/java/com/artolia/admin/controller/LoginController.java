package com.artolia.admin.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.artolia.admin.common.Result;
import com.artolia.admin.domain.system.User;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("login")
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Mono<String> Login(@RequestBody User user) {
		Result result = new Result();
		Map<String, Object> admin = new HashMap<>();
		String[] roles = {"admin"};
		admin.put("roles", roles);
		admin.put("token", "admin");
		admin.put("indtroduction", "我是超级管理员");
		admin.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
		admin.put("name", "Super Admin");
		
		result.setCode(200);
		result.setMessage("验证成功");
		result.setData(admin);
		return Mono.just(result.toJson());
	}
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public Mono<String> info(String token) {
		Result result = new Result();
		Map<String, Object> admin = new HashMap<>();
		String[] roles = {"admin"};
		admin.put("roles", roles);
		admin.put("token", "admin");
		admin.put("indtroduction", "我是超级管理员");
		admin.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
		admin.put("name", "Super Admin");
		
		result.setCode(200);
		result.setMessage("验证成功");
		result.setData(admin);
		return Mono.just(result.toJson());
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public Mono<String> logout() {
		Result result = new Result();
		result.setCode(200);
		result.setMessage("退出成功");
		result.setData("success");
		return Mono.just(result.toJson());
	}
}
