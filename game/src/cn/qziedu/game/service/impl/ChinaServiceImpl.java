package cn.qziedu.game.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qziedu.game.mapper.ChinaMapper;
import cn.qziedu.game.pojo.China;
import cn.qziedu.game.pojo.ChinaExample;
import cn.qziedu.game.pojo.ChinaExample.Criteria;
import cn.qziedu.game.service.ChinaService;

@Service
public class ChinaServiceImpl implements ChinaService{
	@Autowired
	private ChinaMapper chinaMapper;

	@Override
	public List<China> selectsheng() {
		ChinaExample example=new ChinaExample();
		Criteria criteria=example.createCriteria();
		criteria.andParentIdEqualTo(0);
		return chinaMapper.selectByExample(example);
	}

	@Override
	public List<China> selectshi(int dizhi1) {
		ChinaExample example=new ChinaExample();
		Criteria criteria=example.createCriteria();
		criteria.andParentIdEqualTo(dizhi1);
		return chinaMapper.selectByExample(example);
	}

	@Override
	public List<China> selectqu(int dizhi2) {
		ChinaExample example=new ChinaExample();
		Criteria criteria=example.createCriteria();
		criteria.andParentIdEqualTo(dizhi2);
		return chinaMapper.selectByExample(example);
	}

	@Override
	public China selectChinaByName(String name) {
		
		return chinaMapper.selectChinaByName(name);
	}

}
