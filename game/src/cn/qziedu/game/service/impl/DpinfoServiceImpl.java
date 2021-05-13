package cn.qziedu.game.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.qziedu.game.mapper.DpinfoMapper;
import cn.qziedu.game.pojo.Dpinfo;
import cn.qziedu.game.pojo.DpinfoExample;
import cn.qziedu.game.pojo.DpinfoExample.Criteria;
import cn.qziedu.game.service.DpinfoService;


@Service
public class DpinfoServiceImpl implements DpinfoService{
	@Autowired
	private DpinfoMapper dpinfoMapper;
	
	//添加dpinfo
	@Override
	public int insDpinfo(Dpinfo dpinfo) {
		
		return dpinfoMapper.insert(dpinfo);
	}

	//根据emid更新dpinfo
	@Override
	public int updDpinfo(Dpinfo dpinfo, int emailid) {
		DpinfoExample example=new DpinfoExample();
		Criteria criteria=example.createCriteria();
		criteria.andEmailidEqualTo(emailid);
		return dpinfoMapper.updateByExampleSelective(dpinfo, example);
	}

	//根据emid查询dpinfo
	@Override
	public List<Dpinfo> selDpinfoByEid(int emailid) {
		DpinfoExample example=new DpinfoExample();
		Criteria criteria=example.createCriteria();
		criteria.andEmailidEqualTo(emailid);
		return dpinfoMapper.selectByExample(example);
	}

	//查询所有用户信息
	@Override
	public List<Dpinfo> selectDpinfoAll() {
		DpinfoExample example=new DpinfoExample();
		return dpinfoMapper.selectByExample(example);
	}

	//根据emailid查询用户信息
	@Override
	public Dpinfo selectDpinfoByEmailid(int emailid) {
		DpinfoExample example=new DpinfoExample();
		Criteria criteria=example.createCriteria();
		criteria.andEmailidEqualTo(emailid);
		List<Dpinfo> dpinfos=dpinfoMapper.selectByExample(example);
		if(dpinfos.size()>0) {
			return dpinfos.get(0);
		}
		else{
			return null;
		}
	}
}
