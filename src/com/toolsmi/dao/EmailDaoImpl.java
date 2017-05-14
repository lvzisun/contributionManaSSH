package com.toolsmi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.toolsmi.entity.Email;
import com.toolsmi.entity.User;

@Repository("emailDao")
public class EmailDaoImpl implements EmailDao{

	private BaseDao baseDao;
	Map<String, Object> map=new HashMap<String, Object>();
	@Autowired
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public Integer queryCountBySendid(Integer id) {
		map.clear();
		map.put("sendid", id);
		String hql = "select count(id) from Email ";
		return baseDao.query_count(hql,map);
	}
	@Override
	public List<Email> querySuitBySendid(Integer id) {
		map.clear();
		map.put("sendid", id);
		String hql = "select new Email(status) from Email ";
		return baseDao.query_suitEntities(hql,map);
	}
	@Override
	public List<Email> queryBySendid(Integer currentPage, Integer pageSize,
			Integer id) {
		map.clear();
		map.put("sendid", id);
		String hql = "select new Email(id,sendid,receiveid,title,content,status,maketime) from Email ";
		return baseDao.query_entities(hql,currentPage,pageSize,map);
	}
	@Override
	public Integer queryCountBySendidAndReceiveid(Integer id, Integer receiveid) {
		map.clear();
		map.put("sendid", id);
		map.put("receiveid", receiveid);
		String hql = "select count(id) from Email ";
		return baseDao.query_count(hql,map);
	}
	@Override
	public List<Email> queryBySendidAndReceiveid(Integer currentPage,
			Integer pageSize, Integer sendid, Integer receiveid) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer queryCountBySendidAndContent(Integer id, String content) {
		map.clear();
		map.put("sendid", id);
		map.put("content", content);
		String hql = "select count(id) from Email ";
		return baseDao.query_count(hql,map);
	}
	@Override
	public List<Email> queryBySendidAndContent(Integer currentPage,
			Integer pageSize, Integer id, String content) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer queryCountBySendidAndTitle(Integer id, String title) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Email> queryBySendidAndTitle(Integer currentPage,
			Integer pageSize, Integer id, String title) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer queryCountByReceiveid(Integer id) {
		map.clear();
		map.put("receiveid", id);
		String hql = "select count(id) from Email ";
		return baseDao.query_count(hql,map);
	}
	@Override
	public List<Email> queryByReceiveid(Integer currentPage, Integer pageSize,
			Integer id) {
		map.clear();
		map.put("receiveid", id);
		String hql = "select new Email(id,sendid,receiveid,title,content,status,maketime) from Email ";
		return baseDao.query_entities(hql,currentPage,pageSize,map);
	}
	@Override
	public Integer queryCountByReceiveidAndContent(Integer id, String content) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Email> queryByReceiveidAndContent(Integer currentPage,
			Integer pageSize, Integer id, String content) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer queryCountByReceiveidAndTitle(Integer id, String title) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Email> queryReceiveidAndTitle(Integer currentPage,
			Integer pageSize, Integer id, String title) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String queryUserRealnameById(Integer id) {
		String hql="select new User(realname) from User where id=?";
		User u=baseDao.queryEntity(hql,id);
		return u.getRealname(); 
	}
	@Override
	public List<Email> queryBySendidAndTitleByOrder(Integer currentPage,
			Integer pageSize, Integer id, String title, String order) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Email> querySuitBySendidAndTitle(Integer id, String title) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Email> querySuitBySendidAndContent(Integer id, String content) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Email> queryBySendidAndContentByOrder(Integer currentPage,
			Integer pageSize, Integer id, String content, String order) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
