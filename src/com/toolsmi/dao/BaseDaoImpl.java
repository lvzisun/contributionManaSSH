package com.toolsmi.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.toolsmi.entity.Friend;

@Repository("baseDao")
public class BaseDaoImpl implements BaseDao {
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public <T> T queryEntity(String hql, Object... params) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			if (params[i] != null) {
				query.setParameter(i, params[i]);
			}
		}
		query.setMaxResults(1);
		return (T) query.uniqueResult();
	}

	@Override
	public <T> List<T> queryManyEntity(String hql, Object... params) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			if (params[i] != null) {
				query.setParameter(i, params[i]);
			}
		}
		return query.list();
	}

	@Override
	public int updateEntity(String hql, Object... params) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			if (params[i] != null) {
				query.setParameter(i, params[i]);
			}
		}
		return query.executeUpdate();
	}

	@Override
	public <T> List<T> queryEntitiesForPage(String hql, Integer currentPage,
			Integer pageSize, Object... params) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			if (params[i] != null) {
				query.setParameter(i, params[i]);
			}
		}
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<T> objs = query.list();
		return objs;
	}

	@Override
	public Integer queryCount(String hql, Object... params) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			if (params[i] != null) {
				query.setParameter(i, params[i]);
			}
		}
		Long count = (Long) query.uniqueResult();
		return count.intValue();
	}

	@Override
	public int addEntity(Object... params) {
		Session session = getSession();
		if (params.length > 0) {
			return (Integer) session.save(params[0]);
		} else {
			return 0;
		}
	}

	@Override
	public int updateEntity(Object... params) {
		Session session = getSession();
		if (params.length > 0) {
			Friend f = (Friend) session.merge(params[0]);
			if (f != null) {
				return 1;
			}
		}
		return 0;
	}

	@Override
	public int deleteEntityById(Integer id, String tableName) {
		Session session = getSession();
		String hql = "delete from " + tableName + " where id=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, id);
		return query.executeUpdate();
	}

	@Override
	public Integer query_count(String hql, Map<String, Object> map) {
		hql = getHql(hql, map);
		Session session = getSession();
		Query query = session.createQuery(hql);
		Long count = (Long) query.uniqueResult();
		return count.intValue();
	}

	private String getHql(String hql, Map<String, Object> map) {
		StringBuffer sb = new StringBuffer(hql);
		sb.append(" where ");
		Set<String> keys = map.keySet();
		for (String key : keys) {
			if (key.equals("sendid")) {
				sb.append(key);
				sb.append("=");
				sb.append(map.get(key));
				sb.append(" and ");
			} else if (key.equals("receiveid")) {
				sb.append(key);
				sb.append("=");
				sb.append(map.get(key));
				sb.append(" and ");
			} else {
				sb.append(key);
				sb.append(" like ");
				sb.append(map.get(key));
				sb.append(" and ");
			}
		}
		sb.append(" 1=1");
		String hql1 = sb.toString();
		System.out.println(hql1);
		return hql1;
	}

	@Override
	public <T> List<T> query_entities(String hql, Integer currentPage,
			Integer pageSize, Map<String, Object> map) {
		hql = getHql(hql, map);
		Session session = getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult((currentPage - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	@Override
	public <T> List<T> query_suitEntities(String hql, Map<String, Object> map) {
		hql = getHql(hql, map);
		Session session = getSession();
		Query query = session.createQuery(hql);
		return query.list();
	}
}
