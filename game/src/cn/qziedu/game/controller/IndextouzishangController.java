package cn.qziedu.game.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.qziedu.game.pojo.User;
import cn.qziedu.game.pojo.Userinfo;
import cn.qziedu.game.service.UserService;
import cn.qziedu.game.service.UserinfoService;
import cn.qziedu.game.utils.Msg;

@Controller
@RequestMapping("/touzishang")
public class IndextouzishangController {
	@Autowired
	private UserinfoService userinfoService;
	@Autowired
	private UserService userService;

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
			return "index/indextouzishang";
		}
	}
}
