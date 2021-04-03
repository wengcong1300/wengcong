package cn.qziedu.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.qziedu.game.pojo.Baominginfo;
import cn.qziedu.game.service.BaominginfoService;
import cn.qziedu.game.service.BisaiinfoService;

@Controller
@RequestMapping("/ptyh")
public class BisaiinfoController {
	
	@Autowired
	private BisaiinfoService bisaiinfoService;
	@Autowired
	private BaominginfoService baominginfoService;
	
	
	
	//根据获取的id查询显示比赛详情
	@RequestMapping("/selectbisaiinfo.action")
	public String selectbisaiinfo(int baominginfoid) {
		//获取报名id
		//Baominginfo baominginfo=baominginfoService.selectBaominginfoByFabuinfoid(fabuinfoid);
		
		
		
		//bisaiinfoService.selectBisaiinfoByBaominginfoid(baominginfoid);
		
		
		return "index/selectbisaiinfo";
	}

}
