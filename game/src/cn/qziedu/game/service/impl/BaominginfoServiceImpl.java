package cn.qziedu.game.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qziedu.game.mapper.BaominginfoMapper;
import cn.qziedu.game.mappercustom.BaominginfoMapperCustom;
import cn.qziedu.game.pojo.Baominginfo;
import cn.qziedu.game.pojo.BaominginfoExample;
import cn.qziedu.game.pojo.BaominginfoExample.Criteria;
import cn.qziedu.game.service.BaominginfoService;

@Service
public class BaominginfoServiceImpl implements BaominginfoService{
	
	@Autowired
	private BaominginfoMapper baominginfoMapper;
	@Autowired
	private BaominginfoMapperCustom baominginfoMapperCustom;

	//查看个人报名记录
	@Override
	public List<Baominginfo> selectBaominginfoByEmailid(int emailid) {
		BaominginfoExample example=new BaominginfoExample();
		Criteria criteria=example.createCriteria();
		criteria.andEmailidEqualTo(emailid);
		return baominginfoMapper.selectByExample(example);
	}
	
	//报名（添加报名信息）
	@Override
	public int insertBaominginfo(Baominginfo baominginfo) {
		return baominginfoMapper.insert(baominginfo);
	}
	
	//取消报名（删除报名信息）
	@Override
	public int deleteBaominginfo(int id) {
		return baominginfoMapper.deleteByPrimaryKey(id);
	}
	
	//根据报名信息id查询报名信息
	@Override
	public Baominginfo selectBaominginfoById(int id) {
		return baominginfoMapper.selectByPrimaryKey(id);
	}

	
	//根据发布id查询报名同一个竞赛项目的人员
	@Override
	public List<Baominginfo> selectBaominginfoByFabuinfoid(int fabuinfoid) {
		BaominginfoExample example=new BaominginfoExample();
		Criteria criteria=example.createCriteria();
		criteria.andFabuinfoidEqualTo(fabuinfoid);
		return baominginfoMapper.selectByExample(example);
	}

	//统计数量
	@Override
	public long count(int fabuinfoid) {
		BaominginfoExample example=new BaominginfoExample();
		Criteria criteria=example.createCriteria();
		criteria.andFabuinfoidEqualTo(fabuinfoid);
		return baominginfoMapper.countByExample(example);
	}

	//根据用户id和发布赛事id查询报名信息
	@Override
	public List<Baominginfo> selectBaominginfoByEmailidAndFabuinfoid(int emailid, int fabuinfoid) {
		BaominginfoExample example=new BaominginfoExample();
		Criteria criteria=example.createCriteria();
		criteria.andEmailidEqualTo(emailid);
		criteria.andFabuinfoidEqualTo(fabuinfoid);
		return baominginfoMapper.selectByExample(example);
	}

	//更新baominginfo的获胜次数
	@Override
	public int updateBaominginfoBywinnum(Baominginfo baominginfo,int id) {
		BaominginfoExample example=new BaominginfoExample();
		Criteria criteria=example.createCriteria();
		criteria.andIdEqualTo(id);
		return baominginfoMapper.updateByExampleSelective(baominginfo, example);
	}

	//查询报名信息比赛排行榜
	@Override
	public List<Baominginfo> selectBaominginfoByFabuinfoidTopaihang(int fabuinfoid) {
		
		return baominginfoMapperCustom.selectBaominginfoByFabuinfoid(fabuinfoid);
	}
	

}
