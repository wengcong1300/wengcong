package cn.qziedu.game.service;

import java.util.List;

import cn.qziedu.game.pojo.Fabuinfo;

public interface FabuinfoService {
	
	//设置发布竞赛信息
	int insertfabuinfo(Fabuinfo fabuinfo);

	//查询所有发布的信息
	List<Fabuinfo> selectFabuinfo();
	
	//根据用户id查询发布的信息
	List<Fabuinfo> selectFabuinfoByUserid(int userid);
	
	//根据id查询发布信息
	Fabuinfo selectFabuinfoByid(int id);
	
	//修改发布后的比赛信息
	int updateFabuinfo(int id,Fabuinfo fabuinfo);
}
