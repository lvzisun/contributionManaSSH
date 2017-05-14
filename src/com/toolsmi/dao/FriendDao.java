package com.toolsmi.dao;

import java.util.List;

import com.toolsmi.entity.Friend;
import com.toolsmi.entity.User;

public interface FriendDao {

	Integer queryCount(Integer userId);

	List<User> queryAllAddress(Integer currentPage, Integer pageSize,Integer userId);

	List<User> queryAllAddressByPhone(Integer currentPage, Integer pageSize,
			String phone,Integer userId);

	Integer queryCountByPhone(String phone,Integer userId);

	List<User> queryAllAddressByRealname(Integer currentPage, Integer pageSize,
			String realname,Integer userId);

	Integer queryCountByRealname(String realname,Integer userId);

	Integer queryCountByRealnameAndPhone(String realname, String phone,Integer userId);

	List<User> queryAllAddressByRealnameAndPhone(Integer currentPage,
			Integer pageSize, String realname, String phone, Integer id);

	Friend queryFriendById(Integer id);

	int addFriend(Friend friend);

	int updateFriend(Friend friend);

	int deleteById(Integer id);

}
