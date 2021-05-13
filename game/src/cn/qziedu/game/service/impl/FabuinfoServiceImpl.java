package cn.qziedu.game.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qziedu.game.mapper.FabuinfoMapper;
import cn.qziedu.game.pojo.Fabuinfo;
import cn.qziedu.game.pojo.FabuinfoExample;
import cn.qziedu.game.pojo.FabuinfoExample.Criteria;
import cn.qziedu.game.service.FabuinfoService;

@Service
public class FabuinfoServiceImpl implements FabuinfoService{

	@Autowired
	private FabuinfoMapper fabuinfoMapper;
	
	//设置发布竞赛信息
	@Override
	public int insertfabuinfo(Fabuinfo fabuinfo) {
		return fabuinfoMapper.insert(fabuinfo);
	}

	//查询所有发布的信息
	@Override
	public List<Fabuinfo> selectFabuinfo() {
		FabuinfoExample example=new FabuinfoExample();
		return fabuinfoMapper.selectByExample(example);
	}

	//根据用户id查询发布信息
	@Override
	public List<Fabuinfo> selectFabuinfoByUserid(int userid) {
		FabuinfoExample example=new FabuinfoExample();
		Criteria criteria=example.createCriteria();
		criteria.andUseridEqualTo(userid);
		return fabuinfoMapper.selectByExample(example);
	}
	
	
	//根据id查询发布信息
	@Override
	public Fabuinfo selectFabuinfoByid(int id) {
		return fabuinfoMapper.selectByPrimaryKey(id);
	}

	//修改发布后的比赛信息
	@Override
	public int updateFabuinfo(int id,Fabuinfo fabuinfo) {
		FabuinfoExample example=new FabuinfoExample();
		Criteria criteria=example.createCriteria();
		criteria.andIdEqualTo(id);
		return fabuinfoMapper.updateByExampleSelective(fabuinfo, example);
	}
	


}
