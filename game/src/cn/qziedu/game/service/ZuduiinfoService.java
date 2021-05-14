package cn.qziedu.game.service;

import java.util.List;

import cn.qziedu.game.pojo.Zuduiinfo;

public interface ZuduiinfoService {
	//添加组队信息
	int insertZuduiinfo(Zuduiinfo zuduiinfo);
	
	//查询所有组队信息
	List<Zuduiinfo> selectZuduiinfoAll();

	//根据fabuinfoid查询组队信息
	List<Zuduiinfo> selectZuduiinfoByFabuinfoid(int fabuinfoid);
	
	//根据id查询组队信息
	Zuduiinfo selectZuduiinfoById(int id);
	
	//根据id修改组队获胜场次
	int updateZuduiinfoByIdTowinnum(int id,Zuduiinfo zuduiinfo);
	
	//根据获胜次数查询组队信息
	List<Zuduiinfo> selectzuduiinfoByWinnum(int fabuinfoid,int winnum);
	
	//查询该竞赛获胜次数的最大值
	Integer selectZuduiinfoReturnMaxwinnum(int fabuinfoid);
	
	//查询排行榜
	List<Zuduiinfo> selectZuduiinfoPaihan(int fabuinfoid);
}
