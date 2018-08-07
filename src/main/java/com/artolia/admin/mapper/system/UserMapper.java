package com.artolia.admin.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.artolia.admin.domain.system.Roles;
import com.artolia.admin.domain.system.User;

@Mapper
public interface UserMapper {

	@Select("select * from user")
	public List<User> getUserList();
	
	@Select("select b.* from user_roles a left join roles b on a.rid = b.id where a.uid = #{uid}")
	public List<Roles> getRolesByUser(String uid);
	
	@Select("select * from user where id = #{id}")
	public User getUserById(String id);
	
	@Select("select username from user where id = #{id}")
	public String getUsernameById(String id);
	
	@Select("select * from user where username = #{username}")
	public User getUserByUsername(String username);
}
