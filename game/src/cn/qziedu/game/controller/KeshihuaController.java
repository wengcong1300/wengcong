package cn.qziedu.game.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qziedu.game.pojoCustom.Keshihua;
import cn.qziedu.game.pojoCustom.Lunbo;
import cn.qziedu.game.service.KeshihuaService;

@Controller
@RequestMapping("/keshihua")
public class KeshihuaController {
	
	@Autowired
	private KeshihuaService keshihuaService;
	
	//商家发布赛事次数可视化数据
	@RequestMapping("/fabucishu.action")
	@ResponseBody
	public List<Keshihua> selectfabucishu() {
		List<Keshihua> list=keshihuaService.selectFabucishu();
		return list;
	}
	
	//用户参加所有竞赛总获胜次数可视化
	@RequestMapping("/cansaiwinnum.action")
	@ResponseBody
	public List<Keshihua> selectcansaiwinnum() {
		List<Keshihua> list=keshihuaService.selectwinnum();
		return list;
	}
	
	
	@RequestMapping("/cansaiwinnummax.action")
	@ResponseBody
	public List<Keshihua> selectcansaiwinnummax() {
		List<Keshihua> list=new ArrayList<Keshihua>();
		//查询参赛用户获胜总次数最多
		list.add(keshihuaService.selectwinnumMax().get(0));
		//查询用户参赛次数最多
		list.add(keshihuaService.selectbaomingMax().get(0));
		//参赛用户获奖最大
		Keshihua k=new Keshihua();
		k.setEmail("普通用户");
		k.setCount(keshihuaService.selectPutongUserNumber());
		list.add(k);
		//店铺发布赛事最多
		list.add(keshihuaService.selectFabugameMax().get(0));
		//铺发布总奖金最多
		list.add(keshihuaService.selectFabumoneyMax().get(0));
		Keshihua k2=new Keshihua();
		k2.setEmail("发布数量");
		k2.setCount(keshihuaService.selectFabuallNumber());
		list.add(k2);
		return list;
	}
	
	//获胜总次数前5
	@RequestMapping("/huoshengcishupaihang.action")
	@ResponseBody
	public List<Keshihua> selectBaominginfowinnumpaihang() {
		List<Keshihua> list=keshihuaService.selectBaominginfowinnumpaihang();
		return list;
	}
	
	
	//发布总次数前5
	@RequestMapping("/jubancishupaihang.action")
	@ResponseBody
	public List<Keshihua> selectFabuinfoNumpaihang() {
		List<Keshihua> list=keshihuaService.selectFabuinfoNumpaihang();
		return list;
	}
	
	//姓名，参赛总次数，胜利总次数，奖金总额度
	@RequestMapping("/lunbo.action")
	@ResponseBody
	public List<Lunbo> lunbo() {		
		List<Lunbo> list=keshihuaService.lunbo();
		return list;
	}

}
