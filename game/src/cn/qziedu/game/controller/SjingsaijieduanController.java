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

import com.google.gson.Gson;

import cn.qziedu.game.pojo.Baominginfo;
import cn.qziedu.game.pojo.Dpinfo;
import cn.qziedu.game.pojo.Fabuinfo;
import cn.qziedu.game.pojo.User;
import cn.qziedu.game.pojo.Userinfo;
import cn.qziedu.game.pojo.Zuduiinfo;
import cn.qziedu.game.service.BaominginfoService;
import cn.qziedu.game.service.DpinfoService;
import cn.qziedu.game.service.FabuinfoService;
import cn.qziedu.game.service.UserService;
import cn.qziedu.game.service.UserinfoService;
import cn.qziedu.game.service.ZuduiinfoService;
import cn.qziedu.game.utils.ZdFbUs;

@Controller
@RequestMapping("/tzs/jsjd")
public class SjingsaijieduanController {
	
	@Autowired
	private ZuduiinfoService zuduiinfoService;
	@Autowired
	private UserinfoService userinfoService;
	@Autowired
	private BaominginfoService baominginfoService;
	@Autowired
	private FabuinfoService fabuinfoService;
	@Autowired
	private UserService userService;
	@Autowired
	private DpinfoService dpinfoService;
	
	//显示个人待开始的比赛
	@RequestMapping("/seldaikaishi.action")
	public String seldaikaishi(HttpSession session,Model model) {
		User user=(User) session.getAttribute("user");
		Date datetime=new Date();
		List<Fabuinfo> list=new ArrayList<Fabuinfo>();
		List<Fabuinfo> fabuinfos=fabuinfoService.selectFabuinfo();
		for(Fabuinfo fabuinfo:fabuinfos) {
			if(fabuinfo.getTime2().before(datetime)&&datetime.before(fabuinfo.getTime3())&&fabuinfo.getUserid()==user.getId()) {
				list.add(fabuinfo);
			}
		}
		List<Dpinfo> dpinfo=dpinfoService.selectDpinfoAll();
		model.addAttribute("dpinfo", dpinfo);
		model.addAttribute("fabuinfo", list);
		model.addAttribute("count", list.size());
		return "index/indextouzishang/jingsaijieduanguanli/selectdaikaishi";
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
		model.addAttribute("count", baominginfos.size());
		return "index/indextouzishang/jingsaijieduanguanli/selectbisaiuserinfo";
	}
	
	//显示个人正在进行的比赛
	@RequestMapping("/seljinxingzhong.action")
	public String seljinxingzhong(HttpSession session,Model model) {
		User user=(User) session.getAttribute("user");
		Date datetime=new Date();
		List<Fabuinfo> list=new ArrayList<Fabuinfo>();
		List<Fabuinfo> fabuinfos=fabuinfoService.selectFabuinfo();
		for(Fabuinfo fabuinfo:fabuinfos) {
			if(fabuinfo.getTime3().before(datetime)&&datetime.before(fabuinfo.getTime4())&&fabuinfo.getUserid()==user.getId()) {
				list.add(fabuinfo);
			}
		}
		List<Dpinfo> dpinfo=dpinfoService.selectDpinfoAll();
		model.addAttribute("dpinfo", dpinfo);
		model.addAttribute("fabuinfo", list);
		model.addAttribute("count", list.size());
		return "index/indextouzishang/jingsaijieduanguanli/selectjinxingzhong";
	}
	
	//详情信息（比赛进行中）随机分组
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
		model.addAttribute("count", baominginfos.size());
		return "index/indextouzishang/jingsaijieduanguanli/selectbisaiuserinfosuijifenzu";
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
			String[] idss=ids.split(",");
			List<Object> list=new ArrayList<>();
			for(int i=0;i<idss.length;i++) {
				list.add(Integer.parseInt(idss[i]));
			}
			List<Object> d=new ArrayList<Object>();
			Zuduiinfo zuduiinfo=new Zuduiinfo();
			System.out.println(list.size());
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
	
	
	//显示随机分组页面
	@RequestMapping("/tosuijifenzu.action")
	public String tosuijifenzu(Model model,int fabuinfoid) {
		int winnum=zuduiinfoService.selectZuduiinfoReturnMaxwinnum(fabuinfoid);
		if(winnum==0) {
			List<Zuduiinfo> zuduiinfo=zuduiinfoService.selectZuduiinfoByFabuinfoid(fabuinfoid);
			List<Fabuinfo> fabuinfo=fabuinfoService.selectFabuinfo();
			List<Userinfo> userinfo=userinfoService.selectUserinfoAll();
			model.addAttribute("userinfo",userinfo);
			model.addAttribute("zuduiinfo",zuduiinfo);
			model.addAttribute("fabuinfo",fabuinfo);
			model.addAttribute("count", zuduiinfo.size());
		}
		else {
			List<Zuduiinfo> zuduiinfo=zuduiinfoService.selectzuduiinfoByWinnum(fabuinfoid,winnum);
			List<Fabuinfo> fabuinfo=fabuinfoService.selectFabuinfo();
			List<Userinfo> userinfo=userinfoService.selectUserinfoAll();
			model.addAttribute("userinfo",userinfo);
			model.addAttribute("zuduiinfo",zuduiinfo);
			model.addAttribute("fabuinfo",fabuinfo);
			model.addAttribute("count", zuduiinfo.size());
		}
		return "index/indextouzishang/jingsaijieduanguanli/selectzuduiinfo";
		
	}
	
	
	//显示已完成的比赛
	@RequestMapping("/selyiwancheng.action")
	public String selyiwancheng(HttpSession session,Model model) {
		User user=(User) session.getAttribute("user");
		Date datetime=new Date();
		List<Fabuinfo> list=new ArrayList<Fabuinfo>();
		List<Fabuinfo> fabuinfos=fabuinfoService.selectFabuinfo();
		for(Fabuinfo fabuinfo:fabuinfos) {
			if(fabuinfo.getTime4().before(datetime)&&fabuinfo.getUserid()==user.getId()) {
				list.add(fabuinfo);
			}
		}
		List<Dpinfo> dpinfo=dpinfoService.selectDpinfoAll();
		model.addAttribute("dpinfo", dpinfo);
		model.addAttribute("fabuinfo", list);
		model.addAttribute("count", list.size());
		return "index/indextouzishang/jingsaijieduanguanli/selectyiwancheng";
	}
	
	//详情信息（比赛结束）（排行榜）
	@RequestMapping("/selectbisaiinfopaihang.action")
	public String selectbisaiinfopaihang(Model model,int fabuinfoid) {
		List<Zuduiinfo> zuduiinfo=zuduiinfoService.selectZuduiinfoPaihan(fabuinfoid);
		List<Fabuinfo> fabuinfo=fabuinfoService.selectFabuinfo();
		model.addAttribute("zuduiinfo", zuduiinfo);
		model.addAttribute("fabuinfo", fabuinfo);
		model.addAttribute("count", zuduiinfo.size());
		return "index/indextouzishang/jingsaijieduanguanli/selectbisaiinfopaihang";
	}
	
	
	

}
