package com.toolsmi.service;

import java.util.Map;

import com.toolsmi.entity.Condition;

public interface EmailService {

	Map<String, Object> queryEmailBySendid(Condition condition);

	Map<String, Object> queryEmailByReceiveid(Condition condition);

	Map<String, Object> queryEmailBySendidWithCondition(Condition condition);

}
