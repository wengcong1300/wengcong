package cn.qziedu.game.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qziedu.game.mapper.BisaiinfoMapper;
import cn.qziedu.game.pojo.Bisaiinfo;
import cn.qziedu.game.pojo.BisaiinfoExample;
import cn.qziedu.game.pojo.BisaiinfoExample.Criteria;
import cn.qziedu.game.service.BisaiinfoService;

@Service
public class BisaiinfoServiceImpl implements BisaiinfoService{
	
	@Autowired
	private BisaiinfoMapper bisaiinfoMapper;
	
	

	//根据获取的报名信息id查询比赛详情
	@Override
	public Bisaiinfo selectBisaiinfoByBaominginfoid(int baominginfoid) {
		BisaiinfoExample example=new BisaiinfoExample();
		Criteria criteria=example.createCriteria();
		criteria.andBaominginfoidEqualTo(baominginfoid);
		return (Bisaiinfo) bisaiinfoMapper.selectByExample(example);
	}

}
