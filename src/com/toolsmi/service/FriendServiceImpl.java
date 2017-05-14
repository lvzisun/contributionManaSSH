package com.toolsmi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.toolsmi.dao.FriendDao;
import com.toolsmi.entity.Condition;
import com.toolsmi.entity.Friend;
import com.toolsmi.entity.User;
import com.toolsmi.util.Format;

@Service("service")
public class FriendServiceImpl implements FriendService {
	private FriendDao friendDao;
	private Map<String, Object> map = new HashMap<String, Object>();

	@Autowired
	public void setFriendDao(FriendDao friendDao) {
		this.friendDao = friendDao;
	}

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> queryFriendAddress(Condition condition) {
		map.clear();
		if (Format.isEmpty(condition.getRealname())
				&& Format.isEmpty(condition.getPhone())) {
			return this.getFriendAddress(condition);
		} else if (Format.isEmpty(condition.getRealname())
				&& !Format.isEmpty(condition.getPhone())) {
			List<User> users2 = friendDao.queryAllAddressByPhone(condition
					.getCurrentPage(), condition.getPageSize(), Format
					.praseCondition(condition.getPhone()), getUser().getId());
			if (users2==null ||users2.size() == 0) {
				map=this.getFriendAddress(condition);
				map.put("addressMessage", "没有找到符合信息");
				return map;
			}
			condition.setTotalCount(friendDao.queryCountByPhone(Format
					.praseCondition(condition.getPhone()), getUser().getId()));
			map.put("condition", condition);
			map.put("userAddresses", users2);
			return map;
		} else if (!Format.isEmpty(condition.getRealname())
				&& Format.isEmpty(condition.getPhone())) {
			List<User> users3 = friendDao
					.queryAllAddressByRealname(condition.getCurrentPage(),
							condition.getPageSize(),
							Format.praseCondition(condition.getRealname()),
							getUser().getId());
			if (users3 == null || users3.size()==0) {
				map=this.getFriendAddress(condition);
				map.put("addressMessage", "没有找到符合信息");
				return map;
			}
			condition
					.setTotalCount(friendDao.queryCountByRealname(
							Format.praseCondition(condition.getRealname()),
							getUser().getId()));
			map.put("condition", condition);
			map.put("userAddresses", users3);
			return map;
		} else if (!Format.isEmpty(condition.getRealname())
				&& !Format.isEmpty(condition.getPhone())) {
			List<User> users3 = friendDao.queryAllAddressByRealnameAndPhone(
					condition.getCurrentPage(), condition.getPageSize(), Format
							.praseCondition(condition.getRealname()), Format
							.praseCondition(condition.getPhone()), getUser()
							.getId());
			if (users3 == null || users3.size()==0) {
				map=this.getFriendAddress(condition);
				map.put("addressMessage", "没有找到符合信息");
				return map;
			}
			condition.setTotalCount(friendDao.queryCountByRealnameAndPhone(
					Format.praseCondition(condition.getRealname()), Format
							.praseCondition(condition.getPhone()), getUser()
							.getId()));
			map.put("condition", condition);
			map.put("userAddresses", users3);
			return map;
		} else {
			return null;
		}
	}

	private Map<String, Object> getFriendAddress(Condition condition) {
		map.clear();
		condition.setTotalCount(friendDao.queryCount(getUser().getId()));
		map.put("condition", condition);
		List<User> users = friendDao.queryAllAddress(
				condition.getCurrentPage(), condition.getPageSize(), getUser()
						.getId());
		map.put("userAddresses", users);
		return map;
	}

	private User getUser() {
		User u = (User) ActionContext.getContext().getSession().get("user");
		return u;
	}

	@Override
	@Transactional(readOnly=true)
	public Map<String, Object> queryAFriendAddress(Integer id) {
		Friend f=friendDao.queryFriendById(id);
		if(f!=null){
			map.put("addressInfo", f);
		}
		return map;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean updateAFriend(Friend friend) {
		friend.setUserid(getUser().getId());
		int count=0;
		if(friend.getId()==null){
			count=friendDao.addFriend(friend);
		}else{
			count=friendDao.updateFriend(friend);
		}
		if(count>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean deleteAFriend(Integer id) {
		int count=friendDao.deleteById(id);
		if(count>0){
			return true;
		}
		return false;
	}
}
