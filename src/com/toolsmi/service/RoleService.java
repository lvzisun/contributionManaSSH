package com.toolsmi.service;

import java.util.Map;

import org.springframework.stereotype.Service;


public interface RoleService {

	Map<String, Object> queryPower(Integer roleid);

}
