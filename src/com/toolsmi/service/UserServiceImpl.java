package com.toolsmi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.toolsmi.dao.UserDao;
import com.toolsmi.entity.Condition;
import com.toolsmi.entity.User;
import com.toolsmi.util.Format;

@Service("userService")
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	Map<String, Object> map = new HashMap<String, Object>();

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 根据登录表单提交的用户名和密码，查找用户： 若正确，则根据角色显示相应菜单内容 若不正确，则回到登录页面，提示用户名密码错误
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> queryUser(User user) {
		map.clear();
		if(user.getId()!=null && user.getId()>0){
			User u=userDao.queryUserById(user.getId());
			if(u!=null){
				map.put("addressInfo",u );
			}
			return map;
		}else if (user.getUsername() == null || user.getUsername().matches("/[ ]+$")) {
			map.put("message", "用户名不能为空");
		} else if (user.getPassword() == null
				|| user.getPassword().matches("/[ ]+$")) {
			map.put("message", "密码不能为空");
		} else {
			User u = userDao.queryUser(user.getUsername(), user.getPassword());
			if (u == null) {
				map.put("message", "用户名密码错误");
			} else {
				map.put("user", u);
				ActionContext.getContext().getSession().put("user", u);
			}
		}
		return map;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean changePassword(String oldPassword, String newPassword,
			String rePassword) {
		if (rePassword.equals(newPassword)) {
			User u = (User) (ActionContext.getContext().getSession()
					.get("user"));
			Integer userId = u.getId();
			if (oldPassword.equals(userDao.queryPassword(userId))) {
				int count = userDao.changePassword(newPassword, userId);
				if (count > 0) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean changeInfo(User user) {
		User u = (User) (ActionContext.getContext().getSession().get("user"));
		user.setCredit(u.getCredit());
		user.setId(u.getId());
		user.setPassword(userDao.queryPassword(u.getId()));
		user.setRoleid(u.getRoleid());
		user.setUsername(u.getUsername());
		int count = userDao.changeInfo(user);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> queryUserAddress(Condition condition) {
		return this.getUserAddress(condition);
	}

	@Override
	@Transactional(readOnly=true)
	public Map<String, Object> queryConditionUserAddress(Condition condition) {
		// TODO Auto-generated method stub
		map.clear();
		if (Format.isEmpty(condition.getRealname())
				&& Format.isEmpty(condition.getPhone())) {
			return this.getUserAddress(condition);
		} else if (Format.isEmpty(condition.getRealname())
				&& !Format.isEmpty(condition.getPhone())) {
			List<User> users2 = userDao.queryAllAddressByPhone(
					condition.getCurrentPage(), condition.getPageSize(),
					Format.praseCondition(condition.getPhone()));
			if (users2==null ||users2.size()==0) {
				map=this.getUserAddress(condition);
				map.put("addressMessage", "没有找到符合信息");
				return map;
			}
			condition.setTotalCount(userDao.queryCountByPhone(Format.praseCondition(condition.getPhone())));
			map.put("condition", condition);
			map.put("userAddresses", users2);
			return map;
		} else if (!Format.isEmpty(condition.getRealname())
				&& Format.isEmpty(condition.getPhone())) {
			List<User> users3 = userDao.queryAllAddressByRealname(
					condition.getCurrentPage(), condition.getPageSize(),
					Format.praseCondition(condition.getRealname()));
			if (users3 == null || users3.size()==0) {
				map=this.getUserAddress(condition);
				map.put("addressMessage", "没有找到符合信息");
				return map;
			}
			condition.setTotalCount(userDao.queryCountByRealname(Format.praseCondition(condition.getRealname())));
			map.put("condition", condition);
			map.put("userAddresses", users3);
			return map;
		} else if (!Format.isEmpty(condition.getRealname())
				&& !Format.isEmpty(condition.getPhone())) {
			List<User> users3 = userDao.queryAllAddressByRealnameAndPhone(
					condition.getCurrentPage(), condition.getPageSize(),
					Format.praseCondition(condition.getRealname()),Format.praseCondition(condition.getPhone()));
			if (users3 == null || users3.size()==0) {
				map=this.getUserAddress(condition);
				map.put("addressMessage", "没有找到符合信息");
				return map;
			}
			condition.setTotalCount(userDao.queryCountByRealnameAndPhone(Format.praseCondition(condition.getRealname()),Format.praseCondition(condition.getPhone())));
			map.put("condition", condition);
			map.put("userAddresses", users3);
			return map;
		} else {
			return null;
		}
	}
	
	private Map<String, Object> getUserAddress(Condition condition){
		map.clear();
		condition.setTotalCount(userDao.queryCount());
		map.put("condition", condition);
		List<User> users = userDao.queryAllAddress(
				condition.getCurrentPage(), condition.getPageSize());
		map.put("userAddresses", users);
		return map;
	}
}