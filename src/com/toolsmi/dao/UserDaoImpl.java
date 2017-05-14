package com.toolsmi.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.toolsmi.entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	private BaseDao baseDao;

	@Autowired
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public User queryUser(String username, String password) {
		String hql = "select new User(id,username,realname,sex,"
				+ "birthday,age,phone,address,"
				+ "email,status,roleid,credit) from User where username=? and password=?";
		return baseDao.queryEntity(hql, username, password);
	}

	@Override
	public String queryPassword(Integer id) {
		String hql = "select password from User where id=?";
		return baseDao.queryEntity(hql, id);
	}

	@Override
	public int changePassword(String newPassword, Integer id) {
		String hql = "update User set password=? where id=?";
		return baseDao.updateEntity(hql, newPassword, id);
	}

	@Override
	public int changeInfo(User user) {
		Session session = baseDao.getSession();
		User u = (User) session.merge(user);
		if (u != null) {
			ActionContext.getContext().getSession().put("user", u);
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public List<User> queryAllAddress(Integer currentPage, Integer pageSize) {
		String hql="select new User(id,realname,sex,birthday,phone,address,email) from User";
		return baseDao.queryEntitiesForPage(hql,currentPage,pageSize);
	}

	@Override
	public Integer queryCount() {
		String hql="select count(id) from User";
		return baseDao.queryCount(hql);
	}

	@Override
	public List<User> queryAllAddressByPhone(Integer currentPage,
			Integer pageSize, String phone) {
		String hql="select new User(id,realname,sex,birthday,phone,address,email) from User where phone like ?";
		return baseDao.queryEntitiesForPage(hql,currentPage,pageSize,phone);
	}

	@Override
	public List<User> queryAllAddressByRealname(Integer currentPage,
			Integer pageSize, String realname) {
		String hql="select new User(id,realname,sex,birthday,phone,address,email) from User where realname like ?";
		return baseDao.queryEntitiesForPage(hql,currentPage,pageSize,realname);
	}

	@Override
	public Integer queryCountByPhone(String phone) {
		String hql="select count(id) from User where phone like ?";
		return baseDao.queryCount(hql, phone);
	}

	@Override
	public Integer queryCountByRealname(String realname) {
		String hql="select count(id) from User where realname like ?";
		return baseDao.queryCount(hql, realname);
	}

	@Override
	public Integer queryCountByRealnameAndPhone(String realname, String phone) {
		String hql="select count(id) from User where realname like ? and phone like ?";
		return baseDao.queryCount(hql, realname,phone);
	}

	@Override
	public List<User> queryAllAddressByRealnameAndPhone(Integer currentPage,
			Integer pageSize, String realname, String phone) {
		String hql="select new User(id,realname,sex,birthday,phone,address,email) from User where realname like ? and phone like ?";
		return baseDao.queryEntitiesForPage(hql,currentPage,pageSize,realname,phone);
	}

	@Override
	public User queryUserById(Integer id) {
		String hql= "select new User(id,username,realname,sex,"
				+ "birthday,age,phone,address,"
				+ "email,status,roleid,credit) from User where id=?";
		return baseDao.queryEntity(hql, id);
	}

}
