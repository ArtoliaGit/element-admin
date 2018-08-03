package com.artolia.admin.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artolia.admin.domain.system.Roles;
import com.artolia.admin.service.system.SystemService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("system")
public class SystemController {

	@Autowired
	private SystemService systemService;
	
	@GetMapping("/getRoleList")
	public Mono<String> getRoleList() {
		return this.systemService.getRoleList();
	}
	
	@PostMapping("/insertRoles")
	public Mono<String> insertRoles(@RequestBody Roles roles) {
		return this.systemService.insertRoles(roles);
	}
	
	@PostMapping("/updateRoles")
	public Mono<String> updateRoles(@RequestBody Roles roles) {
		return this.systemService.updateRoles(roles);
	}
	
	@GetMapping("/deleteRoles")
	public Mono<String> deleteRoles(String id) {
		return this.systemService.deleteRoles(id);
	}
}
