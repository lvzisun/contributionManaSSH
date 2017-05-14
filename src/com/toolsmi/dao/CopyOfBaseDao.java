package com.toolsmi.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.toolsmi.entity.Email;
import com.toolsmi.entity.Firstpower;
import com.toolsmi.entity.Friend;
import com.toolsmi.entity.User;

public interface CopyOfBaseDao {

	Session getSession();

	<T> T queryEntity(String hql,Object...params);

	<T> List<T> queryManyEntity(String hql,Object...params);

	int updateEntity(String hql,Object...params);

	<T> List<T> queryEntitiesForPage(String hql, Integer currentPage, Integer pageSize,Object...params);

	Integer queryCount(String hql,Object...params);

	int addEntity(Object...params);

	int updateEntity(Object...params);

	int deleteEntityById(Integer id, String string);

	Integer query_count(String string, Map<String, Object> map);

	<T> List<T> query_entities(String hql, Map<String, Object> map);
}
