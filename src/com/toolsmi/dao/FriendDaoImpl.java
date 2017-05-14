package com.toolsmi.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.toolsmi.entity.Friend;
import com.toolsmi.entity.User;

@Repository("friendDao")
public class FriendDaoImpl implements FriendDao {
	private BaseDao baseDao;
	@Autowired
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public Integer queryCount(Integer userId) {
		String hql="select count(id) from Friend where userid=?";
		return baseDao.queryCount(hql,userId);
	}
	@Override
	public List<User> queryAllAddress(Integer currentPage, Integer pageSize,Integer userId) {
		String hql="select new Friend(id,realname,sex,birthday,phone,address,email) from Friend  where userid=?";
		return baseDao.queryEntitiesForPage(hql,currentPage,pageSize,userId);
	}
	@Override
	public List<User> queryAllAddressByPhone(Integer currentPage,
			Integer pageSize, String phone,Integer userId) {
		String hql="select new Friend(id,realname,sex,birthday,phone,address,email) from Friend where phone like ? and userid=?";
		return baseDao.queryEntitiesForPage(hql,currentPage,pageSize,phone,userId);
	}
	@Override
	public Integer queryCountByPhone(String phone,Integer userId) {
		String hql="select count(id) from Friend where phone like ? and userid=?";
		return baseDao.queryCount(hql, phone,userId);
	}
	@Override
	public List<User> queryAllAddressByRealname(Integer currentPage,
			Integer pageSize, String realname,Integer userId) {
		String hql="select new Friend(id,realname,sex,birthday,phone,address,email) from Friend where realname like ? and userid=?";
		return baseDao.queryEntitiesForPage(hql,currentPage,pageSize,realname,userId);
	}
	
	@Override
	public Integer queryCountByRealname(String realname,Integer userId) {
		String hql="select count(id) from Friend where realname like ? and userid=?";
		return baseDao.queryCount(hql, realname,userId);
	}
	@Override
	public Integer queryCountByRealnameAndPhone(String realname, String phone,Integer userId) {
		String hql="select count(id) from Friend where realname like ? and phone like ? and userid=?";
		return baseDao.queryCount(hql, realname,phone,userId);
	}
	@Override
	public List<User> queryAllAddressByRealnameAndPhone(Integer currentPage,
			Integer pageSize, String realname, String phone, Integer id) {
		String hql="select new Friend(id,realname,sex,birthday,phone,address,email) from Friend where realname like ? and phone like ? and userid=?";
		return baseDao.queryEntitiesForPage(hql,currentPage,pageSize,realname,phone,id);
	}
	@Override
	public Friend queryFriendById(Integer id) {
		String hql="select new Friend(id,realname,sex,birthday,phone,address,email) from Friend where id=?";
		return baseDao.queryEntity(hql, id);
	}
	@Override
	public int addFriend(Friend friend) {
		return baseDao.addEntity(friend);
	}
	@Override
	public int updateFriend(Friend friend) {
		return baseDao.updateEntity(friend);
	}
	@Override
	public int deleteById(Integer id) {
		return baseDao.deleteEntityById(id,"Friend");
	}
	
}
