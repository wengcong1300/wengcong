package cn.qziedu.game.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qziedu.game.mappercustom.KeshihuaMapperCustom;
import cn.qziedu.game.pojoCustom.Keshihua;
import cn.qziedu.game.pojoCustom.Lunbo;
import cn.qziedu.game.service.KeshihuaService;

@Service
public class KeshihuaServiceImpl implements KeshihuaService{

	
	@Autowired
	private KeshihuaMapperCustom keshihuaMapper;
	
	/**
	 * 查询商家发布赛事次数
	 * @return
	 */
	@Override
	public List<Keshihua> selectFabucishu() {
		return keshihuaMapper.selectFabuinfoJubancishu();
	}


	/**
	 * 查询参赛用户的获胜次数
	 * @return
	 */
	@Override
	public List<Keshihua> selectwinnum() {
		return keshihuaMapper.selectBaominginfowinnum();
	}

	/**
	 * 查询参赛用户获胜总次数最多
	 * @return
	 */
	@Override
	public List<Keshihua> selectwinnumMax() {
		return keshihuaMapper.selectBaominginfowinnumMax();
	}
	
	/**
	 * 查询用户参赛次数最多
	 * @return
	 */
	@Override
	public List<Keshihua> selectbaomingMax() {
		return keshihuaMapper.selectBaominginfobaomingMax();
	}

	/**
	 * 普通用户数量
	 */
	@Override
	public int selectPutongUserNumber() {
		return keshihuaMapper.selectPutongUserNumber();
	}
	
	/**
	 * 店铺发布赛事最多
	 * @return
	 */
	@Override
	public List<Keshihua> selectFabugameMax() {
		return keshihuaMapper.selectFabugameMax();
	}
	
	/**
	 * 店铺发布总奖金最多
	 * @return
	 */
	@Override
	public List<Keshihua> selectFabumoneyMax() {
		return keshihuaMapper.selectFabumoneyMax();
	}
	
	/**
	 * 总发布竞赛总数
	 */
	@Override
	public int selectFabuallNumber() {
		return keshihuaMapper.selectFabuallNumber();
	}
	
	/**
	 * 获胜总次数前5
	 * @return
	 */
	@Override
	public List<Keshihua> selectBaominginfowinnumpaihang() {
		return keshihuaMapper.selectBaominginfowinnumpaihang();
	}
	
	/**
	 * 发布总次数前5
	 * @return
	 */
	@Override
	public List<Keshihua> selectFabuinfoNumpaihang() {
		return keshihuaMapper.selectFabuinfoNumpaihang();
	}
	
	/**
	 * 轮播
	 * @return
	 */
	public List<Lunbo> lunbo(){
		return keshihuaMapper.lunbo();
	}
	
}
