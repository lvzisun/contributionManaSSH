package com.toolsmi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.dialect.FirebirdDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toolsmi.dao.RoleDao;
import com.toolsmi.entity.Firstpower;
import com.toolsmi.entity.Secondpower;
import com.toolsmi.util.Format;
@Service("roleService")
public class RoleServiceImpl implements RoleService {

	private RoleDao roleDao;
	private Map<String, Object> map=new HashMap<String, Object>();
	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	@Transactional(readOnly=false)
	public Map<String, Object> queryPower(Integer roleid) {
		List<Firstpower> firstpowerList=(List<Firstpower>)(roleDao.queryFirstpower(roleid));
		for(Firstpower f:firstpowerList){
			List<Secondpower> secondpowers=roleDao.querySecondpower(f.getId());
			f.setSecondpower(Format.changeToSet(secondpowers));
			map.put("firstpower",firstpowerList);
		}
		return map;
	}
	
}
