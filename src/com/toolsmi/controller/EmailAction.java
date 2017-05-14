package com.toolsmi.controller;

import java.text.Normalizer.Form;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.toolsmi.entity.Condition;
import com.toolsmi.entity.Email;
import com.toolsmi.service.EmailService;
import com.toolsmi.util.Format;

@Controller("emailAction")
@Scope("request")
public class EmailAction extends ActionSupport{
	private EmailService emailService;
	private Map<String, Object> result=new HashMap<String,Object>();
	private Email email;
	private Condition condition=new Condition();
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	@Autowired
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}
	
	public String loadGiveemail(){
		result=emailService.queryEmailBySendid(condition);
		return SUCCESS;
	}
	
	public String loadReceiveemail(){
		result=emailService.queryEmailByReceiveid(condition);
		return SUCCESS;
	}
	
}
