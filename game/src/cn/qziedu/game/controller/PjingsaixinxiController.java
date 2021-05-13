package cn.qziedu.game.controller;

import java.time.LocalDateTime;
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
import cn.qziedu.game.pojo.Zuduiinfo;
import cn.qziedu.game.service.BaominginfoService;
import cn.qziedu.game.service.DpinfoService;
import cn.qziedu.game.service.FabuinfoService;
import cn.qziedu.game.service.UserService;
import cn.qziedu.game.service.UserinfoService;
import cn.qziedu.game.service.ZuduiinfoService;
import cn.qziedu.game.utils.Msg;

@Controller
@RequestMapping("/ptyh/jsxx")
public class PjingsaixinxiController {
	
	@Autowired
	private BaominginfoService baominginfoService;
	@Autowired
	private FabuinfoService fabuinfoService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserinfoService userinfoService;
	@Autowired
	private DpinfoService dpinfoService;
	@Autowired
	private ZuduiinfoService zuduiinfoService;
	
	//显示所有可报名的比赛
	@RequestMapping("/selkebaoming.action")
	public String selkebaoming(Model model) {
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
		return "index/indexputonuser/jingsaixinxiguanli/selectkebaoming";
	}
	
	//报名
	@RequestMapping("/insertbaoming.action")
	@ResponseBody
	public Msg insertbaoming(HttpSession session,int fabuinfoid) {
		Msg msg=null;
		User user=(User) session.getAttribute("user");
		//查看个人报名记录
		List<Baominginfo> list=baominginfoService.selectBaominginfoByEmailid(user.getId());
		//查看该竞赛的发布信息
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
			//判断是否开始报名
			if(fabuinfonew.getTime1().before(new Date())) {
				//有报名名额
				if(fabuinfonew.getNumber()>0) {
					for(Baominginfo baoming:list) {
						//判断是否已经报名
						if(fabuinfoid!=baoming.getFabuinfoid()) {
							Fabuinfo fabuinfo=fabuinfoService.selectFabuinfoByid(baoming.getFabuinfoid());
							//判断所报名的竞赛开始时间是否与已存在的竞赛开始时间冲突
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
			else {
				msg=new Msg();
				msg.setCode(3);
				msg.setMessage("竞赛未在开始报名时间");
			}
			
		}
		return msg;
	}
	
	
	//显示所有待开始的比赛
	@RequestMapping("/seldaikaishiall.action")
	public String seldaikaishiall(HttpSession session,Model model) {
		Date datetime=new Date();
		List<Fabuinfo> list=new ArrayList<Fabuinfo>();
		List<Fabuinfo> fabuinfos=fabuinfoService.selectFabuinfo();
		for(Fabuinfo fabuinfo:fabuinfos) {
			if(fabuinfo.getTime2().before(datetime)&&datetime.before(fabuinfo.getTime3())) {
				list.add(fabuinfo);
			}
		}
		List<Dpinfo> dpinfo=dpinfoService.selectDpinfoAll();
		model.addAttribute("dpinfo", dpinfo);
		model.addAttribute("fabuinfo", list);
		model.addAttribute("count", list.size());
		return "index/indexputonuser/jingsaixinxiguanli/selectdaikaishiall";
	}
	
	//详情信息（即将开始竞赛，显示报名用户信息）
	@RequestMapping("/selectbaominguserinfo.action")
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
		return "index/indexputonuser/jingsaixinxiguanli/selectbisaiuserinfo";
	}
	
	//查看已经结束的比赛
	@RequestMapping("/selectgameover.action")
	public String selectgameover(HttpSession session,Model model) {
		Date datetime=new Date();
		List<Fabuinfo> list=new ArrayList<Fabuinfo>();
		List<Fabuinfo> fabuinfos=fabuinfoService.selectFabuinfo();
		for(Fabuinfo fabuinfo:fabuinfos) {
			if(fabuinfo.getTime4().before(datetime)) {
				list.add(fabuinfo);
			}
		}
		List<Dpinfo> dpinfo=dpinfoService.selectDpinfoAll();
		model.addAttribute("dpinfo", dpinfo);
		model.addAttribute("fabuinfo", list);
		model.addAttribute("count", list.size());
		return "index/indexputonuser/jingsaixinxiguanli/selectgameover";
	}
	
	//详情信息（比赛结束）（排行榜）
	@RequestMapping("/selectgameoverpaihang.action")
	public String selectbisaiinfopaihang(Model model,int fabuinfoid) {
		List<Zuduiinfo> zuduiinfo=zuduiinfoService.selectZuduiinfoPaihan(fabuinfoid);
		List<Fabuinfo> fabuinfo=fabuinfoService.selectFabuinfo();
		model.addAttribute("zuduiinfo", zuduiinfo);
		model.addAttribute("fabuinfo", fabuinfo);
		model.addAttribute("count", zuduiinfo.size());
		return "index/indexputonuser/jingsaixinxiguanli/selectgameoverpaihang";
	}
}
