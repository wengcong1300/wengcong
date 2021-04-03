package cn.qziedu.game.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qziedu.game.mapper.BuildinfoMapper;
import cn.qziedu.game.pojo.Buildinfo;
import cn.qziedu.game.pojo.BuildinfoExample;
import cn.qziedu.game.pojo.BuildinfoExample.Criteria;
import cn.qziedu.game.service.BuildinfoService;

@Service
public class BuildinfoServiceImpl implements BuildinfoService{

	@Autowired
	private BuildinfoMapper buildinfoMapper;
	
	//查询所有发布的比赛信息
	@Override
	public List<Buildinfo> selallBuildinfo() {
		BuildinfoExample example=new BuildinfoExample();
		return buildinfoMapper.selectByExample(example);
	}
	
	//根据userid查询个人建立的赛事
	@Override
	public List<Buildinfo> selBuildinfoByUserid(int userid) {
		BuildinfoExample example=new BuildinfoExample();
		Criteria criteria=example.createCriteria();
		criteria.andUseridEqualTo(userid);
		return buildinfoMapper.selectByExample(example);
	}
	
	//根据build查找buildinfo
	@Override
	public Buildinfo selBuildinfoByBuildid(int buildid) {
		
		return buildinfoMapper.selectByPrimaryKey(buildid);
	}

	//模糊查询
	@Override
	public List<Buildinfo> likeBuildinfo(String gamename) {
		// TODO Auto-generated method stub
		return null;
	}

	//建立赛事
	@Override
	public int insBuildinfo(Buildinfo buildinfo) {
		return buildinfoMapper.insert(buildinfo);
	}

	//修改赛事
	@Override
	public int updBuildinfo(int buildid, Buildinfo buildinfo) {
		BuildinfoExample example=new BuildinfoExample();
		Criteria criteria=example.createCriteria();
		criteria.andBuildidEqualTo(buildid);
		return buildinfoMapper.updateByExampleSelective(buildinfo, example);
	}

	
	//删除
	@Override
	public int deletebuildinfo(int buildid) {
		return buildinfoMapper.deleteByPrimaryKey(buildid);
	}

	//统计个人建赛的数量
	@Override
	public long countBuildinfo(int userid) {
		BuildinfoExample example=new BuildinfoExample();
		Criteria criteria=example.createCriteria();
		criteria.andUseridEqualTo(userid);
		return buildinfoMapper.countByExample(example);
	}

	

	


}
