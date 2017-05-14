package com.toolsmi.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.toolsmi.entity.Condition;
import com.toolsmi.entity.Friend;
import com.toolsmi.service.FriendService;
import com.toolsmi.util.Format;
@Controller("friendAction")
@Scope("request")
public class FriendAction extends ActionSupport {
	private FriendService friendService;
	private Map<String, Object> result;
	private String birthdayStr;
	private Friend friend;
	private Condition condition=new Condition();
	public Condition getCondition() {
		return condition;
	}
	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public void setBirthdayStr(String birthdayStr) {
		this.birthdayStr = birthdayStr;
	}
	@Autowired
	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
	}
	public String loadFriendAddress(){
		if(condition.getCurrentPage()==null || condition.getCurrentPage()==0){
			condition.setCurrentPage(1);
		}
		result=friendService.queryFriendAddress(condition);
		return SUCCESS;
	}
	public String loadAFriendAddress(){
		result=friendService.queryAFriendAddress(friend.getId());
		result.put("url", "AddressList/index2.jsp");
		return SUCCESS;
	}
	public String updateAFriend(){
		friend.setBirthday(Format.toTimesStamp(birthdayStr));
		boolean answer=friendService.updateAFriend(friend);
		if(answer){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public String deleteAFriend(){
		boolean answer=friendService.deleteAFriend(friend.getId());
		if(answer){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
}
