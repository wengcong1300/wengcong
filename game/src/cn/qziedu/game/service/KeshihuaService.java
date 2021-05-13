package cn.qziedu.game.service;

import java.util.List;
import java.util.Map;

import cn.qziedu.game.pojoCustom.Keshihua;
import cn.qziedu.game.pojoCustom.Lunbo;

public interface KeshihuaService {
	
	/**
	 * 查询商家发布赛事次数
	 * @return
	 */
	List<Keshihua> selectFabucishu();
	
	/**
	 * 查询参赛用户的获胜次数
	 * @return
	 */
	List<Keshihua> selectwinnum();
	
	/**
	 * 查询参赛用户获胜总次数最多
	 * @return
	 */
	List<Keshihua> selectwinnumMax();
	
	/**
	 * 查询用户参赛次数最多
	 * @return
	 */
	List<Keshihua> selectbaomingMax();
	
	/**
	 * 普通用户数量
	 * @return
	 */
	int selectPutongUserNumber();
	
	/**
	 * 店铺发布赛事最多
	 * @return
	 */
	List<Keshihua> selectFabugameMax();
	
	/**
	 * 店铺发布总奖金最多
	 * @return
	 */
	List<Keshihua> selectFabumoneyMax();
	
	/**
	 * 总发布赛事总数
	 * @return
	 */
	int selectFabuallNumber();
	
	/**
	 * 获胜总次数前5
	 * @return
	 */
	List<Keshihua> selectBaominginfowinnumpaihang();
	
	/**
	 * 发布总次数前5
	 * @return
	 */
	List<Keshihua> selectFabuinfoNumpaihang();
	
	
	/**
	 * 轮播
	 * @return
	 */
	List<Lunbo> lunbo();

}
