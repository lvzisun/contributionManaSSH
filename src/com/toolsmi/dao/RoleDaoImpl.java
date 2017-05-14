package com.toolsmi.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.toolsmi.entity.Firstpower;
import com.toolsmi.entity.Secondpower;
@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {

	private BaseDao baseDao;
	@Autowired
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<Firstpower> queryFirstpower(Integer roleid) {
		String hql="select new Firstpower(fp.id,fp.firstpowername) from Firstpower fp,Rolepowerrelation rpr where fp.id=rpr.fpowerid and rpr.roleid=?";
		return baseDao.queryManyEntity(hql,roleid);
	}

	@Override
	public List<Secondpower> querySecondpower(Integer id) {
		String hql="select new Secondpower(id,firstpowerid,secondpowername,href) from Secondpower where firstpowerid=?";
		return baseDao.queryManyEntity(hql, id);
	}

}
