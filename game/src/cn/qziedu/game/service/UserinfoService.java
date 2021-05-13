package cn.qziedu.game.service;

import java.util.List;

import cn.qziedu.game.pojo.Userinfo;

public interface UserinfoService {
	//添加该用户信息
	int insUserinfo(Userinfo userinfo);
	
	//修改该用户信息
	int updUserinfo(Userinfo userinfo,int emailid);
	
	//查询该用户信息
	List<Userinfo> selUserinfoByEid(int emailid);
	
	//查询所有用户信息
	List<Userinfo> selectUserinfoAll();
	
	//根据emailid查询用户信息
	Userinfo selectUserinfoByEmailid(int emailid);
	
}
