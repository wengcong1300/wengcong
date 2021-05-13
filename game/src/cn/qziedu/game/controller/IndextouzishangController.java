package cn.qziedu.game.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.qziedu.game.pojo.Dpinfo;
import cn.qziedu.game.pojo.User;
import cn.qziedu.game.pojo.Userinfo;
import cn.qziedu.game.service.DpinfoService;
import cn.qziedu.game.service.UserinfoService;

@Controller
@RequestMapping("/tzs")
public class IndextouzishangController {
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
			List<Dpinfo> list=dpinfoService.selDpinfoByEid(user.getId());
			if(list.size()>0&&list.get(0)!=null) {
				session.setAttribute("dpinfo", list.get(0));
			}
			return "index/indextouzishang/indextouzishang";
		}
	}
}
