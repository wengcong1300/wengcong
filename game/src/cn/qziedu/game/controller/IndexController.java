package cn.qziedu.game.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qziedu.game.pojo.Dpinfo;
import cn.qziedu.game.pojo.User;
import cn.qziedu.game.pojo.Userinfo;
import cn.qziedu.game.service.DpinfoService;
import cn.qziedu.game.service.UserService;
import cn.qziedu.game.service.UserinfoService;
import cn.qziedu.game.utils.Msg;

@Controller
@RequestMapping("/ht")
public class IndexController {
	@Autowired
	private UserinfoService userinfoService;
	@Autowired
	private DpinfoService dpinfoService;
	@Autowired
	private UserService userService;

	// 显示欢迎界面
	@RequestMapping("/welcome.action")
	public String welcome() {
		return "index/welcome";
	}

	// 判断userinfo是否存在
	@RequestMapping("/userifo.action")
	@ResponseBody
	public Msg userifo(HttpSession session) {
		Msg msg = null;
		// 根据user的id判断userinfo是否存在
		User user = (User) session.getAttribute("user");
		// 获取user的id
		int emailid = user.getId();
		List<Userinfo> userinfo = userinfoService.selUserinfoByEid(emailid);
		if (userinfo.size() > 0) {
			msg = new Msg();
			msg.setCode(1);
		} else {
			msg = new Msg();
			msg.setCode(0);
			msg.setMessage("请完善个人信息");
		}
		return msg;
	}
	
	// 判断dpinfo是否存在
	@RequestMapping("/dpinfo.action")
	@ResponseBody
	public Msg dpinfo(HttpSession session) {
		Msg msg = null;
		// 根据user的id判断dpinfo是否存在
		User user = (User) session.getAttribute("user");
		// 获取user的id
		int emailid = user.getId();
		List<Dpinfo> dpinfo = dpinfoService.selDpinfoByEid(emailid);
		if (dpinfo.size() > 0) {
			msg = new Msg();
			msg.setCode(1);
		} else {
			msg = new Msg();
			msg.setCode(0);
			msg.setMessage("请完善个人信息");
		}
		return msg;
	}


	// 显示修改密码页面
	@RequestMapping("/toxiugaimima.action")
	public String toxiugaimima() {
		return "index/xiugaimima";
	}

	// 修改密码
	@RequestMapping("/xiugaimima.action")
	@ResponseBody
	public Msg xiugaimima(HttpSession session, String password, String rpassword) {
		Msg msg = null;
		User user = (User) session.getAttribute("user");
		int id = user.getId();
		String pwd = user.getPassword();
		if (pwd.equals(password)) {
			userService.updUserPassword(id, rpassword);
			user.setPassword(rpassword);
			msg = new Msg();
			msg.setCode(1);
			msg.setMessage("修改密码成功");
		} else {
			msg = new Msg();
			msg.setCode(0);
			msg.setMessage("修改密码失败");
		}
		return msg;
	}
}
