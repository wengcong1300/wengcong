package cn.qziedu.game.service;

import java.util.List;

import cn.qziedu.game.pojo.China;

public interface ChinaService {
	
	/**
	 * 查省
	 * @return
	 */
	List<China> selectsheng();
	
	/**
	 * 查市
	 * @param dizhi1
	 * @return
	 */
	List<China> selectshi(int dizhi1);
	
	/**
	 * 查区
	 * @param dizhi2
	 * @return
	 */
	List<China> selectqu(int dizhi2);
	
	/**
	 * 根据查询的地址名查询地址数据
	 * @param name
	 * @return
	 */
	China selectChinaByName(String name);
	

}
