package com.computerdesign.whutHouseMgmt.service.fix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.fix.Fix;
import com.computerdesign.whutHouseMgmt.bean.fix.FixExample;
import com.computerdesign.whutHouseMgmt.bean.fix.FixExample.Criteria;
import com.computerdesign.whutHouseMgmt.bean.houseregister.Resident;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample;
import com.computerdesign.whutHouseMgmt.dao.fix.FixMapper;
import com.computerdesign.whutHouseMgmt.dao.houseregister.ResidentMapper;

@Service
public class FixService {

	@Autowired
	private FixMapper fixMapper;
	@Autowired
	private ResidentMapper residentMapper;
	

	/**
	 * 根据id获取一个fix
	 * @param id
	 * @return
	 */
	public Fix get(Integer id) {
		return fixMapper.selectByPrimaryKey(id);
	}
	/**
	 * 增加一个fix
	 * @param fix
	 */
	public void add(Fix fix) {
		fixMapper.insertSelective(fix);
	}
	
	/**
	 * 通过PrimaryKey修改
	 * @param fix
	 */
	public void update(Fix fix){
		fixMapper.updateByPrimaryKeySelective(fix);
	}
	
	public void getRegister(String staffId) {
		ResidentExample example = new ResidentExample();
		com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample.Criteria criteria = example.createCriteria();
		//等待谢豪修改数据库
		
		residentMapper.selectByExample(example);
	}
}