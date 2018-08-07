package com.artolia.admin.service.system;

import com.artolia.admin.domain.system.Roles;

import reactor.core.publisher.Mono;

public interface SystemService {

	Mono<String> getRoleList(String code);
	
	Mono<String> insertRoles(Roles roles);
	
	Mono<String> updateRoles(Roles roles);
	
	Mono<String> deleteRoles(String id);
}
