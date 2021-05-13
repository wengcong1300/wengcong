package cn.qziedu.game.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qziedu.game.pojo.Buildinfo;
import cn.qziedu.game.pojo.Dpinfo;
import cn.qziedu.game.pojo.Fabuinfo;
import cn.qziedu.game.pojo.User;
import cn.qziedu.game.service.BuildinfoService;
import cn.qziedu.game.service.DpinfoService;
import cn.qziedu.game.service.FabuinfoService;
import cn.qziedu.game.service.UserService;
import cn.qziedu.game.utils.Msg;

@Controller
@RequestMapping("/tzs/jsfb")
public class SjingsaifabuController {
	@Autowired
	private BuildinfoService buildinfoService;
	@Autowired
	private FabuinfoService fabuinfoService;
	@Autowired
	private DpinfoService dpinfoService;
	
	//显示所有可报名的比赛
	@RequestMapping("/selkebaomingall.action")
	public String selkebaoming(HttpSession session,Model model) {
		User user=(User) session.getAttribute("user");
		Date datetime=new Date();
		List<Fabuinfo> list=new ArrayList<Fabuinfo>();
		List<Fabuinfo> fabuinfos=fabuinfoService.selectFabuinfo();
		for(Fabuinfo fabuinfo:fabuinfos) {
			if(fabuinfo.getTime2().after(datetime)) {
				list.add(fabuinfo);
			}
		}
		List<Dpinfo> dpinfo=dpinfoService.selectDpinfoAll();
		model.addAttribute("dpinfo", dpinfo);
		model.addAttribute("fabuinfo", list);
		model.addAttribute("count", list.size());
		return "index/indextouzishang/jingsaifabuguanli/selectkebaomingall";
	}
	
	//查看可发布的赛事
	@RequestMapping("/selkefabu.action")
	public String selselkefabu(HttpSession session,Model model) {
		User user=(User) session.getAttribute("user");
		List<Buildinfo> buildinfo=buildinfoService.selBuildinfoByUserid(user.getId());
		long count=buildinfoService.countBuildinfo(user.getId());
		model.addAttribute("buildinfo", buildinfo);
		model.addAttribute("count", count);
		return "index/indextouzishang/jingsaifabuguanli/selectkefabu";
	}
	
	//显示发布设置页面
	@RequestMapping("/toinsertfabuinfo.action")
	public String toinsertfabuinfo(Model model,int buildid) {
		Buildinfo buildinfo=buildinfoService.selBuildinfoByBuildid(buildid);
		model.addAttribute("buildinfo",buildinfo);
		return "index/indextouzishang/jingsaifabuguanli/insertfabuinfo";
	}
	
	//发布
	@RequestMapping("/insertfabuinfo.action")
	@ResponseBody
	public Msg insertfabuinfo(int buildid,String time1,String time2,String time3,String time4,int userid,int number,int money) throws Exception{
		Msg msg=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date datetime=new Date();
		List<Fabuinfo> list=fabuinfoService.selectFabuinfoByUserid(userid);
		int n=1;
		for(Fabuinfo fb:list) {
			if(sdf.parse(time4).before(new Date(fb.getTime3().getTime()-(long)5*60*60*1000))||sdf.parse(time3).after(new Date(fb.getTime4().getTime()+(long)5*60*60*1000))) {
			}
			else {
				n=0;
				break;
			}
		}
		//sdf.parse(starttime).after(new Date(sdf.parse(endtime).getTime()-(long)2*24*60*60*1000))
		//time1要小于time2 2天,time2要小于time3 7天,time3要小于time4 2天
		if(datetime.before(sdf.parse(time1))&&n==1&&sdf.parse(time1).before(new Date(sdf.parse(time2).getTime()-(long)2*24*60*60*1000))
				&&sdf.parse(time2).before(new Date(sdf.parse(time3).getTime()-(long)3*24*60*60*1000))
				&&sdf.parse(time3).before(new Date(sdf.parse(time4).getTime()-(long)2*24*60*60*1000))) {
			Buildinfo buildinfo=buildinfoService.selBuildinfoByBuildid(buildid);
			Fabuinfo fabuinfo=new Fabuinfo();
			fabuinfo.setBuildid(buildinfo.getBuildid());
			fabuinfo.setGamename(buildinfo.getGamename());
			fabuinfo.setMiaoshu(buildinfo.getMiaoshu());
			fabuinfo.setGuize(buildinfo.getGuize());
			try {
				fabuinfo.setTime1(sdf.parse(time1));
				fabuinfo.setTime2(sdf.parse(time2));
				fabuinfo.setTime3(sdf.parse(time3));
				fabuinfo.setTime4(sdf.parse(time4));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fabuinfo.setUserid(userid);
			fabuinfo.setNumber(number);
			fabuinfo.setMoney(money);
			fabuinfoService.insertfabuinfo(fabuinfo);
			msg=new Msg();
			msg.setCode(1);
			msg.setMessage("发布成功");
		}
		else {
			msg=new Msg();
			msg.setCode(0);
			msg.setMessage("发布失败,注意发布失败原因有以下几点\n"
					+ "1：报名时长与竞赛时长至少要大于2天，报名结束阶段与竞赛开始阶段至少多余3天\n"
					+ "2：报名开始时间<报名结束时间<竞赛开始时间<竞赛结束时间\n"
					+ "3：报名开始时间或结束时间与已发布的时间冲突，两阶段至少相差5小时");
		}
		return msg;
	}
	
	
	
	//查看个人已发布的竞赛列表
	@RequestMapping("/selyifabu.action")
	public String selyifabu(HttpSession session,Model model) {
		//Date datetime=new Date();
		User user=(User) session.getAttribute("user");
		List<Fabuinfo> list=new ArrayList<Fabuinfo>();
		List<Fabuinfo> fabuinfos=fabuinfoService.selectFabuinfo();
		for(Fabuinfo fabuinfo:fabuinfos) {
			if(fabuinfo.getUserid()==user.getId()) {
				list.add(fabuinfo);
			}
		}
		List<Dpinfo> dpinfo=dpinfoService.selectDpinfoAll();
		model.addAttribute("dpinfo", dpinfo);
		model.addAttribute("fabuinfo", list);
		model.addAttribute("count", list.size());
		return "index/indextouzishang/jingsaifabuguanli/selectyifabu";
	}
	
	//显示发布竞赛后修改页面
	@RequestMapping("/tofabuxiugai.action")
	public String tofabuxiugai(HttpSession session,Model model,int id) {
		Fabuinfo fabuinfo=fabuinfoService.selectFabuinfoByid(id);
		model.addAttribute("fabuinfo", fabuinfo);
		return "index/indextouzishang/jingsaifabuguanli/updatefabuinfo";
	}
	
	//发布竞赛后的修改
	@RequestMapping("/fabuxiugai.action")
	@ResponseBody
	public Msg fabuxiugai(String gamename,String miaoshu,String guize,
			String time1,String time2,String time3,String time4,
			int number,int money,int userid,int buildid,int id)  throws Exception{
		Msg msg=null;
		Date datetime=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Fabuinfo> list=fabuinfoService.selectFabuinfoByUserid(userid);
		int n=1;
		Fabuinfo f=fabuinfoService.selectFabuinfoByid(id);
		if(f.getTime3().before(new Date(datetime.getTime()-(long)2*60*60*1000))) {
			msg=new Msg();
			msg.setCode(-1);
			msg.setMessage("修改失败，注意两天内竞赛项目将举行，无法修改");
		}
		else {
			for(Fabuinfo fb:list) {
				if(id!=fb.getId()) {
					if(sdf.parse(time4).before(new Date(fb.getTime3().getTime()-(long)5*60*60*1000))||sdf.parse(time3).after(new Date(fb.getTime4().getTime()+(long)5*60*60*1000))) {
					}
					else {
						n=0;
						break;
					}
				}
			}
			if(datetime.before(sdf.parse(time1))&&n==1&&sdf.parse(time1).before(new Date(sdf.parse(time2).getTime()-(long)2*24*60*60*1000))
					&&sdf.parse(time2).before(new Date(sdf.parse(time3).getTime()-(long)3*24*60*60*1000))
					&&sdf.parse(time3).before(new Date(sdf.parse(time4).getTime()-(long)2*24*60*60*1000))) {
				Fabuinfo fabuinfo=new Fabuinfo();
				fabuinfo.setMiaoshu(miaoshu);
				fabuinfo.setGuize(guize);
				try {
					fabuinfo.setTime1(sdf.parse(time1));
					fabuinfo.setTime2(sdf.parse(time2));
					fabuinfo.setTime3(sdf.parse(time3));
					fabuinfo.setTime4(sdf.parse(time4));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fabuinfo.setNumber(number);
				fabuinfo.setMoney(money);
				fabuinfoService.updateFabuinfo(id,fabuinfo);
				msg=new Msg();
				msg.setCode(1);
				msg.setMessage("修改成功");
			}
			else {
				msg=new Msg();
				msg.setCode(0);
				msg.setMessage("修改失败,注意修改失败原因有以下几点\n"
						+ "1：报名时长与竞赛时长至少要大于2天，报名结束阶段与竞赛开始阶段至少多余3天\n"
						+ "2：报名开始时间<报名结束时间<竞赛开始时间<竞赛结束时间\n"
						+ "3：报名开始时间或结束时间与已发布的时间冲突，两阶段至少相差5小时");
			}
		}
		return msg;
	}
	
}
