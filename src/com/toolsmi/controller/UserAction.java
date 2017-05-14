package com.toolsmi.controller;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.toolsmi.entity.Condition;
import com.toolsmi.entity.User;
import com.toolsmi.service.UserService;
import com.toolsmi.util.Format;

@Controller("userAction")
@Scope("request")
public class UserAction extends ActionSupport {

	private UserService userService;
	private Map<String, Object> result;
	private User user;
	private String oldPassword;
	private String newPassword;
	private String rePassword;
	private String birthdayStr;
	private Condition condition=new Condition();
	public Map<String, Object> getResult() {
		return result;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setBirthdayStr(String birthdayStr) {
		this.birthdayStr = birthdayStr;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return this.user;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	
	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public Condition getCondition() {
		return condition;
	}

	public String login() {
		result = userService.queryUser(user);
		if (result.get("user") == null) {
			return INPUT;
		}
		ServletActionContext.getRequest().getSession()
				.setAttribute("user", result.get("user"));
		return SUCCESS;
	}
	
	public String changePassword(){
		boolean answer=userService.changePassword(oldPassword,newPassword,rePassword);
		if(answer){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public String changeInfo(){
		user.setBirthday(Format.toTimesStamp(birthdayStr));
		boolean answer=userService.changeInfo(user);
		if(answer){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public String loadUserAddress(){
		if(condition.getCurrentPage()==null || condition.getCurrentPage()==0){
			condition.setCurrentPage(1);
		}
		result=userService.queryUserAddress(condition);
		return SUCCESS;
	}
	
	public String queryUserAddress(){
		if(condition.getCurrentPage()==null || condition.getCurrentPage()==0){
			condition.setCurrentPage(1);
		}
		result=userService.queryConditionUserAddress(condition);
		return SUCCESS;
	}
	
	public String queryAUserAddress(){
		result=userService.queryUser(user);
		result.put("url", "AddressList/index.jsp");
		return SUCCESS;
	}
}
