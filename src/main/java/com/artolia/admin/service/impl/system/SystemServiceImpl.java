package com.artolia.admin.service.impl.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artolia.admin.common.Result;
import com.artolia.admin.domain.system.Roles;
import com.artolia.admin.mapper.system.SystemMapper;
import com.artolia.admin.service.system.SystemService;

import reactor.core.publisher.Mono;

@Service
public class SystemServiceImpl implements SystemService {
	
	@Autowired
	private SystemMapper systemMapper;

	@Override
	public Mono<String> getRoleList() {
		Result result = new Result();
		try {
			List<Roles> roleList = systemMapper.getRoleList();
			result.setCode(200);
			result.setData(roleList);
			result.setMessage("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(500);
			result.setData(null);
			result.setMessage("系统错误");
		}
		return Mono.just(result.toJson());
	}

	@Override
	public Mono<String> insertRoles(Roles roles) {
		Result result = new Result();
		try {
			int num = systemMapper.insertRoles(roles);
			if (num > 0) {
				result.setCode(200);
				result.setData(num);
				result.setMessage("保存成功");
			} else {
				result.setCode(601);
				result.setData(num);
				result.setMessage("保存失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(500);
			result.setData(null);
			result.setMessage("系统错误");
		}
		return Mono.just(result.toJson());
	}

	@Override
	public Mono<String> updateRoles(Roles roles) {
		Result result = new Result();
		try {
			int num = systemMapper.updateRoles(roles);
			if (num > 0) {
				result.setCode(200);
				result.setData(num);
				result.setMessage("保存成功");
			} else {
				result.setCode(601);
				result.setData(num);
				result.setMessage("保存失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(500);
			result.setData(null);
			result.setMessage("系统错误");
		}
		return Mono.just(result.toJson());
	}

	@Override
	public Mono<String> deleteRoles(String id) {
		Result result = new Result();
		try {
			int num = systemMapper.deleteRoles(id);
			if (num > 0) {
				result.setCode(200);
				result.setData(num);
				result.setMessage("删除成功");
			} else {
				result.setCode(601);
				result.setData(num);
				result.setMessage("删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(500);
			result.setData(null);
			result.setMessage("系统错误");
		}
		return Mono.just(result.toJson());
	}

}
