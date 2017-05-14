package com.toolsmi.service;

import java.util.Map;

import com.toolsmi.entity.Condition;
import com.toolsmi.entity.Friend;

public interface FriendService {

	Map<String, Object> queryFriendAddress(Condition condition);

	Map<String, Object> queryAFriendAddress(Integer id);

	boolean updateAFriend(Friend friend);

	boolean deleteAFriend(Integer id);

}
