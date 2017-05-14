package com.toolsmi.util;

import com.opensymphony.xwork2.ActionContext;
import com.toolsmi.entity.User;

public class SameUserUtil {

	public static User getUser() {
		User u = (User) ActionContext.getContext().getSession().get("user");
		return u;
	}
}
