package cn.qziedu.game.service;

import java.util.List;

import cn.qziedu.game.pojo.Baominginfo;

public interface BaominginfoService {
	
	//查看个人报名记录
	List<Baominginfo> selectBaominginfoByEmailid(int emailid);
	
	//报名（添加信息）
	int insertBaominginfo(Baominginfo baominginfo);
	
	//取消报名
	int deleteBaominginfo(int id);
	
	//根据报名id查询报名信息
	Baominginfo selectBaominginfoById(int id);
	
	//查询用户报名同一个竞赛项目的人员
	List<Baominginfo> selectBaominginfoByFabuinfoid(int fabuinfoid);
	
	//根据竞赛项目统计报名人数
	long count(int fabuinfoid);
	
	//根据用户id和发布赛事id查询报名信息
	List<Baominginfo> selectBaominginfoByEmailidAndFabuinfoid(int emailid,int fabuinfoid);
	
	//更新baominginfo的获胜次数
	int updateBaominginfoBywinnum(Baominginfo baominginfo,int id);
	
	//查询报名信息比赛排行榜
	List<Baominginfo> selectBaominginfoByFabuinfoidTopaihang(int fabuinfoid);

}
