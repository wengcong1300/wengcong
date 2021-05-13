package cn.qziedu.game.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qziedu.game.mapper.ZuduiinfoMapper;
import cn.qziedu.game.mappercustom.ZuduiinfoMapperCustom;
import cn.qziedu.game.pojo.Zuduiinfo;
import cn.qziedu.game.pojo.ZuduiinfoExample;
import cn.qziedu.game.pojo.ZuduiinfoExample.Criteria;
import cn.qziedu.game.service.ZuduiinfoService;

@Service
public class ZuduiinfoServiceImpl implements ZuduiinfoService{
	
	@Autowired
	private ZuduiinfoMapper zuduiinfoMapper;
	
	@Autowired
	private ZuduiinfoMapperCustom zuduiinfoMapperCustom;

	
	//添加组队信息
	@Override
	public int insertZuduiinfo(Zuduiinfo zuduiinfo) {
		
		return zuduiinfoMapper.insert(zuduiinfo);
	}

	//查询所有组队信息
	@Override
	public List<Zuduiinfo> selectZuduiinfoAll() {
		ZuduiinfoExample example=new ZuduiinfoExample();
		
		return zuduiinfoMapper.selectByExample(example);
	}

	//根据fabuinfoid查询组队信息
	@Override
	public List<Zuduiinfo> selectZuduiinfoByFabuinfoid(int fabuinfoid) {
		ZuduiinfoExample example=new ZuduiinfoExample();
		Criteria criteria=example.createCriteria();
		criteria.andFabuinfoidEqualTo(fabuinfoid);
		return zuduiinfoMapper.selectByExample(example);
	}

	
	//根据id查询组队信息
	@Override
	public Zuduiinfo selectZuduiinfoById(int id) {
		return zuduiinfoMapper.selectByPrimaryKey(id);
	}

	//根据id修改组队获胜场次
	@Override
	public int updateZuduiinfoByIdTowinnum(int id, Zuduiinfo zuduiinfo) {
		ZuduiinfoExample example=new ZuduiinfoExample();
		Criteria criteria=example.createCriteria();
		criteria.andIdEqualTo(id);
		return zuduiinfoMapper.updateByExample(zuduiinfo, example);
	}
	
	//根据获胜次数查询组队信息
	@Override
	public List<Zuduiinfo> selectzuduiinfoByWinnum(int fabuinfoid,int winnum) {
		ZuduiinfoExample example=new ZuduiinfoExample();
		Criteria criteria=example.createCriteria();
		criteria.andWinnumEqualTo(winnum);
		criteria.andFabuinfoidEqualTo(fabuinfoid);
		return zuduiinfoMapper.selectByExample(example);
	}

	//返回查询获胜次数的最大值
	@Override
	public int selectZuduiinfoReturnMaxwinnum(int fabuinfoid) {
		
		return zuduiinfoMapperCustom.selectZuduiinfoReturnWinnum(fabuinfoid);
	}

	//查询排行榜
	@Override
	public List<Zuduiinfo> selectZuduiinfoPaihan(int fabuinfoid) {
		
		return zuduiinfoMapperCustom.selectZuduiinfoByfabuinfoid(fabuinfoid);
	}
	
	

}
