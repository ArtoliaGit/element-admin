package com.artolia.admin.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.artolia.admin.domain.system.Roles;

@Mapper
public interface SystemMapper {

	@Select("select * from roles")
	public List<Roles> getRoleList();
	
	@Insert("insert into roles(id, code, name) values(#{id}, #{code}, #{name})")
	@SelectKey(statement = "select replace(uuid(),'-','') from dual", keyProperty = "id", before = true, resultType = java.lang.String.class)
	public int insertRoles(Roles roles);
	
	@Update("update roles set code = #{code}, name = #{name} where id = #{id}")
	public int updateRoles(Roles roles);
	
	@Delete("delete from roles where id = #{id}")
	public int deleteRoles(String id);
}
