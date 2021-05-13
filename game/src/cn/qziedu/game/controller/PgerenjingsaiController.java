package cn.qziedu.game.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qziedu.game.pojo.Baominginfo;
import cn.qziedu.game.pojo.Dpinfo;
import cn.qziedu.game.pojo.Fabuinfo;
import cn.qziedu.game.pojo.User;
import cn.qziedu.game.pojo.Userinfo;
import cn.qziedu.game.service.BaominginfoService;
import cn.qziedu.game.service.DpinfoService;
import cn.qziedu.game.service.FabuinfoService;
import cn.qziedu.game.service.UserService;
import cn.qziedu.game.service.UserinfoService;
import cn.qziedu.game.service.ZuduiinfoService;
import cn.qziedu.game.utils.Msg;

@Controller
@RequestMapping("/ptyh/grjs")
public class PgerenjingsaiController {

	
	@Autowired
	private BaominginfoService baominginfoService;
	@Autowired
	private FabuinfoService fabuinfoService;
	@Autowired
	private UserinfoService userinfoService;
	@Autowired
	private ZuduiinfoService zuduiinfoService;
	@Autowired
	private DpinfoService dpinfoService;
	
	//显示个人报名记录
	@RequestMapping("/xianshibaoming.action")
	public String xianshibaoming(Model model,HttpSession session) {
		User user=(User) session.getAttribute("user");
		//查询个人报名信息
		List<Baominginfo> baominginfo=baominginfoService.selectBaominginfoByEmailid(user.getId());
		List<Fabuinfo> fabuinfo=fabuinfoService.selectFabuinfo();
		List<Dpinfo> dpinfo=dpinfoService.selectDpinfoAll();
		List<Userinfo> userinfo=userinfoService.selectUserinfoAll();
		model.addAttribute("userinfo", userinfo);
		model.addAttribute("dpinfo", dpinfo);
		model.addAttribute("baominginfo", baominginfo);
		model.addAttribute("fabuinfo", fabuinfo);
		model.addAttribute("count", baominginfo.size());
		return "index/indexputonuser/gerenjingsaiguanli/selectbaomingjilu";
	}
	
	//取消报名
	@RequestMapping("/quxiaobaoming.action")
	@ResponseBody
	public Msg quxiaobaoming(HttpSession session,int id) {
		Msg msg=null;
		//竞赛开始前两天不能取消报名
		//查询要取消竞赛的开始竞赛时间
		Baominginfo baominginfo=baominginfoService.selectBaominginfoById(id);
		Fabuinfo fabuinfo=fabuinfoService.selectFabuinfoByid(baominginfo.getFabuinfoid());
		//判断系统时间是否比查询到的时间小于两天
		Date datetime=new Date();
		if(fabuinfo.getTime3().after(new Date(datetime.getTime()-(long)2*24*60*60*1000))) {
			//是就取消成功
			baominginfoService.deleteBaominginfo(id);
			Fabuinfo fabu=new Fabuinfo();
			fabu.setNumber(fabuinfo.getNumber()+1);
			fabuinfoService.updateFabuinfo(baominginfo.getFabuinfoid(), fabu);
			msg=new Msg();
			msg.setCode(1);
			msg.setMessage("取消报名成功");
			//报名人数+1
		}
		else{
			//否就取消失败
			msg=new Msg();
			msg.setCode(0);
			msg.setMessage("取消报名失败,注意在比赛开始两天之前才能取消报名");
		}
		return msg;
	}
	
	//查看个人参赛记录
	@RequestMapping("/gerencansai.action")
	public String gerencansai(HttpSession session,Model model) {
		User user=(User) session.getAttribute("user");
		Date datetime=new Date();
		List<Baominginfo> list=new ArrayList<>();
		//获取个人参赛记录
		List<Baominginfo> baominginfos=baominginfoService.selectBaominginfoByEmailid(user.getId());
		List<Fabuinfo> fabuinfos=fabuinfoService.selectFabuinfo();
		List<Dpinfo> dpinfo=dpinfoService.selectDpinfoAll();
		model.addAttribute("dpinfo", dpinfo);
		//判断时间是否未超过系统时间
		for(Baominginfo baominginfo:baominginfos) {
			int fabuinfoid=baominginfo.getFabuinfoid();
			Fabuinfo fabuinfo=fabuinfoService.selectFabuinfoByid(fabuinfoid);
			//是，就是竞赛已经结束
			//进行返回
			if(datetime.after(fabuinfo.getTime4())) {
				//保存到list集合里面去
				list.add(baominginfo);
			}
			//否，就是竞赛还没结束
			//continue
			else {
				continue;
			}
		}
		model.addAttribute("baominginfo", list);
		model.addAttribute("fabuinfo", fabuinfos);
		model.addAttribute("count", list.size());
		return "index/indexputonuser/gerenjingsaiguanli/selectgerencansai";
	}
	
	//普通用户个人参赛（已结束）详细信息
	@RequestMapping("/selectgerencansaixiangqing.action")
	public String selectgerencansaixiangqing(Model model,int fabuinfoid) {
		List<Baominginfo> baominginfo=baominginfoService.selectBaominginfoByFabuinfoidTopaihang(fabuinfoid);
		List<Userinfo> userinfo=userinfoService.selectUserinfoAll();
		List<Fabuinfo> fabuinfo=fabuinfoService.selectFabuinfo();
		model.addAttribute("baominginfo", baominginfo);
		model.addAttribute("userinfo", userinfo);
		model.addAttribute("fabuinfo", fabuinfo);
		model.addAttribute("count", baominginfo.size());
		return "index/indexputonuser/gerenjingsaiguanli/selectgerencansaixiangqing";
	}
	
	//普通用户个人获奖记录
	@RequestMapping("/selectgerenhuojiang.action")
	public String selectgerenhuojiang(HttpSession session,Model model) {
		User user=(User) session.getAttribute("user");
		Date datetime=new Date();
		List<Baominginfo> list=new ArrayList<>();
		//获取个人参赛记录
		List<Baominginfo> baominginfos=baominginfoService.selectBaominginfoByEmailid(user.getId());
		List<Fabuinfo> fabuinfos=fabuinfoService.selectFabuinfo();
		List<Dpinfo> dpinfo=dpinfoService.selectDpinfoAll();
		model.addAttribute("dpinfo", dpinfo);
		//遍历判断时间是否未超过系统时间，并且判断获胜次数是否是该竞赛的最大次数
		for(Baominginfo baominginfo:baominginfos) {
			Integer baominginfonum= baominginfo.getNumwin();
			if(baominginfonum==null) {
				continue;
			}else {
				int fabuinfoid=baominginfo.getFabuinfoid();
				Fabuinfo fabuinfo=fabuinfoService.selectFabuinfoByid(fabuinfoid);
				//是，就是竞赛已经结束
				//进行返回
				Integer maxnum=zuduiinfoService.selectZuduiinfoReturnMaxwinnum(fabuinfoid);
				if(datetime.after(fabuinfo.getTime4())&&maxnum==baominginfo.getNumwin()) {
					//保存到list集合里面去
					list.add(baominginfo);
				}
				//否，就是竞赛还没结束
				//continue
				else {
					continue;
				}
			}
		}
		model.addAttribute("baominginfo", list);
		model.addAttribute("fabuinfo", fabuinfos);
		model.addAttribute("count", list.size());
		return "index/indexputonuser/gerenjingsaiguanli/selectgerenhuojiang";
	}
}
