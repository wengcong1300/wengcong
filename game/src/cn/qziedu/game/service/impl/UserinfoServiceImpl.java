package cn.qziedu.game.service.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qziedu.game.mapper.UserinfoMapper;
import cn.qziedu.game.pojo.UserinfoExample.Criteria;
import cn.qziedu.game.pojo.Userinfo;
import cn.qziedu.game.pojo.UserinfoExample;
import cn.qziedu.game.service.UserinfoService;

@Service
public class UserinfoServiceImpl implements UserinfoService{
	@Autowired
	private UserinfoMapper userinfoMapper;
	
	//添加userinfo
	@Override
	public int insUserinfo(Userinfo userinfo) {
		
		return userinfoMapper.insert(userinfo);
	}

	//根据emid更新userinfo
	@Override
	public int updUserinfo(Userinfo userinfo, int emailid) {
		UserinfoExample example=new UserinfoExample();
		Criteria criteria=example.createCriteria();
		criteria.andEmailidEqualTo(emailid);
		return userinfoMapper.updateByExampleSelective(userinfo, example);
	}

	//根据emid查询userinfo
	@Override
	public List<Userinfo> selUserinfoByEid(int emailid) {
		UserinfoExample example=new UserinfoExample();
		Criteria criteria=example.createCriteria();
		criteria.andEmailidEqualTo(emailid);
		return userinfoMapper.selectByExample(example);
	}

	//查询所有用户信息
	@Override
	public List<Userinfo> selectUserinfoAll() {
		UserinfoExample example=new UserinfoExample();
		return userinfoMapper.selectByExample(example);
	}

	//根据emailid查询用户信息
	@Override
	public Userinfo selectUserinfoByEmailid(int emailid) {
		UserinfoExample example=new UserinfoExample();
		Criteria criteria=example.createCriteria();
		criteria.andEmailidEqualTo(emailid);
		List<Userinfo> userinfos=userinfoMapper.selectByExample(example);
		if(userinfos.size()>0) {
			return userinfos.get(0);
		}
		else{
			return null;
		}
	}
}
