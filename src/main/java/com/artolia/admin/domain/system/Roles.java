package com.artolia.admin.domain.system;

import org.springframework.security.core.GrantedAuthority;

public class Roles implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7214217081569495326L;
	
	private String id;
	private String code;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getAuthority() {
		return code;
	}
}
