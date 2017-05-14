package com.toolsmi.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.toolsmi.entity.User;

public interface UserDao {
	
	User queryUser(String username, String password);

	String queryPassword(Integer id);

	int changePassword(String newPassword, Integer id);

	int changeInfo(User user);

	List<User> queryAllAddress(Integer currentPage, Integer pageSize);

	Integer queryCount();

	List<User> queryAllAddressByPhone(Integer currentPage, Integer pageSize,
			String phone);

	List<User> queryAllAddressByRealname(Integer currentPage, Integer pageSize,
			String realname);

	Integer queryCountByPhone(String phone);

	Integer queryCountByRealname(String realname);

	Integer queryCountByRealnameAndPhone(String realname, String phone);

	List<User> queryAllAddressByRealnameAndPhone(Integer currentPage,
			Integer pageSize, String realname, String phone);

	User queryUserById(Integer id);

}
