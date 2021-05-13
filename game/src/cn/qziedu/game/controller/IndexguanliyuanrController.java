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

import cn.qziedu.game.pojo.Dpinfo;
import cn.qziedu.game.pojo.Fabuinfo;
import cn.qziedu.game.pojo.User;
import cn.qziedu.game.pojo.Userinfo;
import cn.qziedu.game.service.DpinfoService;
import cn.qziedu.game.service.FabuinfoService;
import cn.qziedu.game.service.UserService;
import cn.qziedu.game.service.UserinfoService;


@Controller
@RequestMapping("/gly")
public class IndexguanliyuanrController {
	@Autowired
	private UserinfoService userinfoService;
	@Autowired
	private UserService userService;
	@Autowired
	private FabuinfoService fabuinfoService;
	@Autowired
	private DpinfoService dpinfoService;

	// 显示登录后的页面
	@RequestMapping("/toindex.action")
	public String toindex(HttpSession session){
		User user = (User) session.getAttribute("user");
		if(user==null) {
			return "redirect:../qt/logout.action";
		}
		else {
			List<Userinfo> list=userinfoService.selUserinfoByEid(user.getId());
			if(list.size()>0&&list.get(0)!=null) {
				session.setAttribute("userinfo", list.get(0));
			}
			return "index/indexguanliyuan/indexguanliyuan";
		}
	}
	
	//显示所有用户信息
	@RequestMapping("/selectusersetting.action")
	public String selectuserinfoall(HttpSession session,Model model){
		User user = (User) session.getAttribute("user");
		List<User> listuser=new ArrayList<User>();
		List<User> users=userService.findAllUser();
		int count=0;
		for(User us:users) {
			if(us.getId()!=user.getId()) {
				listuser.add(us);
				count++;
			}
		}
		model.addAttribute("count", count);
		model.addAttribute("user",listuser);
		return "index/indexguanliyuan/selectusersetting";

	}
	//封号
	@RequestMapping("/fenghao.action")
	@ResponseBody
	public User fenghao(HttpSession session,int id){
		User user=userService.findUserById(id);
		if(user.getZhuangtai()==0) {
			user.setZhuangtai(1);	
		}else {
			user.setZhuangtai(0);
		}
		userService.updateUserByZhuangtai(id, user);
		return user;
	}
	
	//条件查询功能
	@RequestMapping("/selectuserbyemail.action")
	public String selectuserbyemail(HttpSession session,Model model,String email){
		User user = (User) session.getAttribute("user");
		List<User> userlist=new ArrayList<User>();
		if(email.equals(null)||email.equals("")) {
			List<User> users=userService.findAllUser();
			for(User us:users) {
				if(us.getId()!=user.getId()) {
					userlist.add(us);
				}
			}
		}else {
			userlist=userService.selectUserByEmail(email);
		}
		model.addAttribute("user",userlist);
		return "index/indexguanliyuan/selectusersetting";
	}
	
	//显示所有可报名的比赛
	@RequestMapping("/selkebaomingall.action")
	public String selkebaoming(HttpSession session,Model model) {
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
		return "index/indexguanliyuan/selectkebaomingall";
	}
	
}
