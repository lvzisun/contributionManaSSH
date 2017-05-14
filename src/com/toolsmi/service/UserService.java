package com.toolsmi.service;

import java.util.Map;

import com.toolsmi.entity.Condition;
import com.toolsmi.entity.User;

public interface UserService {

	Map<String, Object> queryUser(User user);

	boolean changePassword(String oldPassword, String newPassword,
			String rePassword);

	boolean changeInfo(User user);

	Map<String, Object> queryUserAddress(Condition condition);

	Map<String, Object> queryConditionUserAddress(Condition condition);


}
