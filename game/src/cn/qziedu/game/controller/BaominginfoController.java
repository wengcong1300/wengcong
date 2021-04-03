package cn.qziedu.game.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import cn.qziedu.game.pojo.Baominginfo;
import cn.qziedu.game.pojo.Fabuinfo;
import cn.qziedu.game.pojo.User;
import cn.qziedu.game.pojo.Userinfo;
import cn.qziedu.game.pojo.Zuduiinfo;
import cn.qziedu.game.service.BaominginfoService;
import cn.qziedu.game.service.FabuinfoService;
import cn.qziedu.game.service.UserService;
import cn.qziedu.game.service.UserinfoService;
import cn.qziedu.game.service.ZuduiinfoService;
import cn.qziedu.game.utils.Msg;
import cn.qziedu.game.utils.ZdFbUs;

@Controller
@RequestMapping("/ptyh")
public class BaominginfoController {

	@Autowired
	private BaominginfoService baominginfoService;
	@Autowired
	private FabuinfoService fabuinfoService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserinfoService userinfoService;
	@Autowired
	private ZuduiinfoService zuduiinfoService;

	
	//报名
	@RequestMapping("/insertbaoming.action")
	@ResponseBody
	public Msg insertbaoming(HttpSession session,int fabuinfoid) {
		Msg msg=null;
		User user=(User) session.getAttribute("user");
		//查看个人报名记录
		List<Baominginfo> list=baominginfoService.selectBaominginfoByEmailid(user.getId());
		Fabuinfo fabuinfonew=fabuinfoService.selectFabuinfoByid(fabuinfoid);
		Userinfo userinfo=userinfoService.selectUserinfoByEmailid(user.getId());
		int n=0;
		//判断用户信息是否存在
		if(userinfo==null) {
			msg=new Msg();
			msg.setCode(-1);
			msg.setMessage("报名失败，请先完善个人信息");
		}
		else {
			if(fabuinfonew.getNumber()>0) {
				for(Baominginfo baoming:list) {
					//判断是否已经报名
					//排除自己本身的信息
					if(fabuinfoid!=baoming.getFabuinfoid()) {
						//判断比赛名额是否充足
						//判断所报名的竞赛开始时间是否与已存在的竞赛开始时间冲突
						Fabuinfo fabuinfo=fabuinfoService.selectFabuinfoByid(baoming.getFabuinfoid());
						if(fabuinfonew.getTime3().after(fabuinfo.getTime4())||fabuinfonew.getTime4().before(fabuinfo.getTime3())){
							continue;
						}
						else {
							n=n+1;
							break;
						}
					}
					else {
						n=n+1;
						break;
					}
				}
				if(n==0) {
					Baominginfo baominginfo=new Baominginfo();
					baominginfo.setFabuinfoid(fabuinfoid);
					baominginfo.setEmailid(user.getId());
					//报名成员信息添加到报名信息表
					baominginfoService.insertBaominginfo(baominginfo);
					//报名成功人数减1
					Fabuinfo fabuinfo=new Fabuinfo();
					fabuinfo.setNumber(fabuinfonew.getNumber()-1);
					fabuinfoService.updateFabuinfo(fabuinfoid, fabuinfo);
					msg=new Msg();
					msg.setCode(1);
					msg.setMessage("报名成功");
				}
				else {
					msg=new Msg();
					msg.setCode(0);
					msg.setMessage("报名失败,请不要重复报名或该竞赛开始时间与已报名的竞赛开始时间冲突。如果想要报名该竞赛请先取消与已报名时间冲突的竞赛");
				}
			}
			else {
				msg=new Msg();
				msg.setCode(2);
				msg.setMessage("报名失败，该竞赛项目报名名额已满");
			}
		}
		return msg;
	}
	
	//显示个人报名记录
	@RequestMapping("/xianshibaoming.action")
	public String xianshibaoming(Model model,HttpSession session) {
		User user=(User) session.getAttribute("user");
		//查询个人报名信息
		List<Baominginfo> baominginfo=baominginfoService.selectBaominginfoByEmailid(user.getId());
		List<Fabuinfo> fabuinfo=fabuinfoService.selectFabuinfo();
		List<User> users=userService.findAllUser();
		model.addAttribute("baominginfo", baominginfo);
		model.addAttribute("fabuinfo", fabuinfo);
		model.addAttribute("users", users);
		return "index/selectbaomingjilu";
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
	
	//详情
	@RequestMapping("/toxiangqing.action")
	public String toxiangqng(int fabuinfoid,Model model){
		//获取竞赛项目的id
		//查询报名此项目的全部人员信息
		List<Baominginfo> list= baominginfoService.selectBaominginfoByFabuinfoid(fabuinfoid);
		List<Userinfo> userinfo=userinfoService.selectUserinfoAll();
		List<Fabuinfo> fabuinfo=fabuinfoService.selectFabuinfo();
		model.addAttribute("baominginfo", list);
		model.addAttribute("userinfo", userinfo);
		model.addAttribute("fabuinfo", fabuinfo);
		//统计报名人数
		long count=baominginfoService.count(fabuinfoid);
		//返回显示
		model.addAttribute("count", count);
		return "index/selectxiangqing";
	}
	

	//随机分组
	@RequestMapping("/suijifenzu.action")
	@ResponseBody
	public List<Zuduiinfo> xiangqng(String ids,int fabuinfoid){
		
		//判断是否已经随机分组（已经随机直接显示，否则随机）
		List<Zuduiinfo> zuduiinfos=zuduiinfoService.selectZuduiinfoByFabuinfoid(fabuinfoid);
		if(zuduiinfos.size()>0) {
			return zuduiinfos;
		}
		else {
			//获取该竞赛项目的id
			//获取全部参赛用户的id
			Msg msg=null;
			String[] idss=ids.split(",");
			List<Object> list=new ArrayList<>();
			for(int i=0;i<idss.length;i++) {
				list.add(Integer.parseInt(idss[i]));
			}
			List<Object> d=new ArrayList<Object>();
			Zuduiinfo zuduiinfo=new Zuduiinfo();
			System.out.println(list.size());
			int n=0;
			//随机分组
			while(list.size()>5) {
				for (int i = 0; i < 5; i++) {
					int a=(int) (Math.random()*list.size());
					d.add(list.get(a));
					//System.out.print(" "+c.get(a));
					list.remove(a);	
				}
				zuduiinfo.setFabuinfoid(fabuinfoid);
				zuduiinfo.setEmailid1((int)(d.get(0)));
				zuduiinfo.setEmailid2((int)(d.get(1)));
				zuduiinfo.setEmailid3((int)(d.get(2)));
				zuduiinfo.setEmailid4((int)(d.get(3)));
				zuduiinfo.setEmailid5((int)(d.get(4)));
				zuduiinfo.setWinnum(0);
				zuduiinfoService.insertZuduiinfo(zuduiinfo);
				System.err.println(d);
				d.clear();
			}
			int[] arr=new int[5];
			for (int i = 0; i < list.size(); i++) {
				arr[i]=(int) list.get(i);
				
				System.err.println(list.get(i));
			}
			zuduiinfo.setFabuinfoid(fabuinfoid);
			zuduiinfo.setEmailid1(arr[0]);
			zuduiinfo.setEmailid2(arr[1]);
			zuduiinfo.setEmailid3(arr[2]);
			zuduiinfo.setEmailid4(arr[3]);
			zuduiinfo.setEmailid5(arr[4]);
			zuduiinfo.setWinnum(0);
			zuduiinfoService.insertZuduiinfo(zuduiinfo);
			List<Zuduiinfo> zuduiinfos1=zuduiinfoService.selectZuduiinfoByFabuinfoid(fabuinfoid);
			//随机分组
			return zuduiinfos1;
		}
		
	}
	
	
	//显示随机分组页面
	@RequestMapping("/tosuijifenzu.action")
	public String tosuijifenzu(Model model,int fabuinfoid) {
		int winnum=zuduiinfoService.selectZuduiinfoReturnMaxwinnum(fabuinfoid);
		if(winnum==0) {
			Map<Integer,String> mapname=new HashMap<>();
			List<Zuduiinfo> zuduiinfo=zuduiinfoService.selectZuduiinfoByFabuinfoid(fabuinfoid);
			List<Fabuinfo> fabuinfo=fabuinfoService.selectFabuinfo();
			List<Userinfo> userinfo=userinfoService.selectUserinfoAll();
			model.addAttribute("userinfo",userinfo);
			model.addAttribute("zuduiinfo",zuduiinfo);
			model.addAttribute("fabuinfo",fabuinfo);
		}
		else {
			List<Zuduiinfo> zuduiinfo=zuduiinfoService.selectzuduiinfoByWinnum(fabuinfoid,winnum);
			List<Fabuinfo> fabuinfo=fabuinfoService.selectFabuinfo();
			List<Userinfo> userinfo=userinfoService.selectUserinfoAll();
			model.addAttribute("userinfo",userinfo);
			model.addAttribute("zuduiinfo",zuduiinfo);
			model.addAttribute("fabuinfo",fabuinfo);
		}
		return "index/selectzuduiinfo";
		
	}
	
	//批量晋级
	@RequestMapping("/jinji.action")
	@ResponseBody
	public ZdFbUs jinji(String ids,int fabuinfoid) {
		ZdFbUs zdFbUs=null;
		String[] idss=ids.split(",");
		for(int i=0;i<idss.length;i++) {
			Zuduiinfo zuduiinfo=zuduiinfoService.selectZuduiinfoById(Integer.parseInt(idss[i]));
			List<Baominginfo> list1=baominginfoService.selectBaominginfoByEmailidAndFabuinfoid(zuduiinfo.getEmailid1(), fabuinfoid);
			List<Baominginfo> list2=baominginfoService.selectBaominginfoByEmailidAndFabuinfoid(zuduiinfo.getEmailid2(), fabuinfoid);
			List<Baominginfo> list3=baominginfoService.selectBaominginfoByEmailidAndFabuinfoid(zuduiinfo.getEmailid3(), fabuinfoid);
			List<Baominginfo> list4=baominginfoService.selectBaominginfoByEmailidAndFabuinfoid(zuduiinfo.getEmailid4(), fabuinfoid);
			List<Baominginfo> list5=baominginfoService.selectBaominginfoByEmailidAndFabuinfoid(zuduiinfo.getEmailid5(), fabuinfoid);
			int winnum=zuduiinfo.getWinnum()+1;
			zuduiinfo.setWinnum(winnum);
			if(list1.size()>0) {
				list1.get(0).setNumwin(winnum);
				baominginfoService.updateBaominginfoBywinnum(list1.get(0), list1.get(0).getId());
			}
			if(list2.size()>0) {
				list2.get(0).setNumwin(winnum);
				baominginfoService.updateBaominginfoBywinnum(list2.get(0), list2.get(0).getId());
			}
			if(list3.size()>0) {
				list3.get(0).setNumwin(winnum);
				baominginfoService.updateBaominginfoBywinnum(list3.get(0), list3.get(0).getId());
			}
			if(list4.size()>0) {
				list4.get(0).setNumwin(winnum);
				baominginfoService.updateBaominginfoBywinnum(list4.get(0), list4.get(0).getId());
			}
			if(list5.size()>0) {
				list5.get(0).setNumwin(winnum);
				baominginfoService.updateBaominginfoBywinnum(list5.get(0), list5.get(0).getId());
			}
			
			int n=zuduiinfoService.updateZuduiinfoByIdTowinnum(zuduiinfo.getId(), zuduiinfo);
			
			if(n>0) {
				
				List<Zuduiinfo> zuduiinfoend=zuduiinfoService.selectzuduiinfoByWinnum(fabuinfoid,winnum);
				List<Fabuinfo> fabuinfo=fabuinfoService.selectFabuinfo();
				List<Userinfo> userinfo=userinfoService.selectUserinfoAll();
				Gson gson=new Gson();
				String retString=gson.toJson(zuduiinfoend);
				String retString1=gson.toJson(fabuinfo);
				String retString2=gson.toJson(userinfo);
				zdFbUs=new ZdFbUs();
				zdFbUs.setCode(1);
				zdFbUs.setZd(retString);
				zdFbUs.setFb(retString1);
				zdFbUs.setUs(retString2);
			}
			else {
				zdFbUs=new ZdFbUs();
				zdFbUs.setCode(0);
				zdFbUs.setMessage("操作失败");
			}
		}
		return zdFbUs;
	}
	

	//查看个人参赛记录
	@RequestMapping("/gerencansai.action")
	public String gerencansai(HttpSession session,Model model) {
		User user=(User) session.getAttribute("user");
		Date datetime=new Date();
		Msg msg=null;
		List<Baominginfo> list=new ArrayList<>();
		//获取个人参赛记录
		List<Baominginfo> baominginfos=baominginfoService.selectBaominginfoByEmailid(user.getId());
		List<Fabuinfo> fabuinfos=fabuinfoService.selectFabuinfo();
		List<User> users=userService.findAllUser();
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
		model.addAttribute("users", users);
		return "index/selectgerencansai";
	}
	
	//详情信息（待开始，显示报名用户信息）
	@RequestMapping("/selectbisaiuserinfo.action")
	public String selectbisaiuserinfo(Model model,int fabuinfoid) {
		//根据fabuinfoid查询所有报名信息
		List<Baominginfo> baominginfos=baominginfoService.selectBaominginfoByFabuinfoid(fabuinfoid);
		List<Userinfo> userinfos=userinfoService.selectUserinfoAll();
		List<User> users=userService.findAllUser();
		List<Fabuinfo> fabuinfos=fabuinfoService.selectFabuinfo();
		model.addAttribute("baominginfo", baominginfos);
		model.addAttribute("userinfo", userinfos);
		model.addAttribute("user", users);
		model.addAttribute("fabuinfo", fabuinfos);
		return "index/selectbisaiuserinfo";
	}
	
	//详情信息（比赛进行中）
	@RequestMapping("/selectbisaiuserinfosuijifenzu.action")
	public String selectbisaiuserinfosuijifenzu(Model model,int fabuinfoid) {
		//根据fabuinfoid查询所有报名信息
		List<Baominginfo> baominginfos=baominginfoService.selectBaominginfoByFabuinfoid(fabuinfoid);
		List<Userinfo> userinfos=userinfoService.selectUserinfoAll();
		List<User> users=userService.findAllUser();
		List<Fabuinfo> fabuinfos=fabuinfoService.selectFabuinfo();
		model.addAttribute("baominginfo", baominginfos);
		model.addAttribute("userinfo", userinfos);
		model.addAttribute("user", users);
		model.addAttribute("fabuinfo", fabuinfos);
		return "index/selectbisaiuserinfosuijifenzu";
	}
	
	//详情信息（比赛结束）（排行榜）
	@RequestMapping("/selectbisaiinfopaihang.action")
	public String selectbisaiinfopaihang(Model model,int fabuinfoid) {
		List<Zuduiinfo> zuduiinfo=zuduiinfoService.selectZuduiinfoPaihan(fabuinfoid);
		List<Fabuinfo> fabuinfo=fabuinfoService.selectFabuinfo();
		model.addAttribute("zuduiinfo", zuduiinfo);
		model.addAttribute("fabuinfo", fabuinfo);
		return "index/selectbisaiinfopaihang";
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
		return "index/selectgerencansaixiangqing";
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
		List<User> users=userService.findAllUser();
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
		model.addAttribute("users", users);
		return "index/selectgerenhuojiang";
	}
	

}
