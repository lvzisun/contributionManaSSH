package com.toolsmi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.toolsmi.entity.User;
import com.toolsmi.service.RoleService;

@Controller("roleAction")
public class RoleAction extends ActionSupport {

	private RoleService roleService;
	private Map<String,Object> result;
	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	
	public String queryRole(){
		User u=(User)(ActionContext.getContext().getSession().get("user"));
		result=roleService.queryPower(u.getRoleid());
		return SUCCESS;
	}
	
}
