package cn.qziedu.game.service;

import java.util.List;

import cn.qziedu.game.pojo.Dpinfo;

public interface DpinfoService {
	//添加该店铺信息
	int insDpinfo(Dpinfo dpinfo);
	
	//修改该店铺信息
	int updDpinfo(Dpinfo dpinfo,int emailid);
	
	//查询该店铺信息
	List<Dpinfo> selDpinfoByEid(int emailid);
	
	//查询所有店铺信息
	List<Dpinfo> selectDpinfoAll();
	
	//根据emailid查询店铺信息
	Dpinfo selectDpinfoByEmailid(int emailid);
	
}
