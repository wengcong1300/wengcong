package cn.qziedu.game.service;

import java.util.List;

import cn.qziedu.game.pojo.Buildinfo;

public interface BuildinfoService {
	
	//查看所有发布的比赛
	List<Buildinfo> selallBuildinfo();
	
	//根据userid查看个人建立的赛事
	List<Buildinfo> selBuildinfoByUserid(int userid);
	
	//根据buildid查找buildinfo
	Buildinfo selBuildinfoByBuildid(int buildid);
	
	//根据赛事名称模糊查询个人建的赛事
	List<Buildinfo> likeBuildinfo(String gamename);
	
	//建立赛事
	int insBuildinfo(Buildinfo buildinfo);
	
	//修改赛事信息
	int updBuildinfo(int buildid,Buildinfo buildinfo);
	
	//删除个人建立的赛事
	int deletebuildinfo(int buildid);
	
	//统计个人建立赛事数量
	long countBuildinfo(int userid);

}
