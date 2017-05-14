package com.toolsmi.dao;

import java.util.List;

import com.toolsmi.entity.Firstpower;
import com.toolsmi.entity.Secondpower;

public interface RoleDao {

	List<Firstpower> queryFirstpower(Integer roleid);

	List<Secondpower> querySecondpower(Integer id);

}
