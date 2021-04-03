package cn.qziedu.game.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.qziedu.game.pojo.Buildinfo;
import cn.qziedu.game.pojo.Fabuinfo;
import cn.qziedu.game.pojo.User;
import cn.qziedu.game.pojo.Userinfo;
import cn.qziedu.game.service.BuildinfoService;
import cn.qziedu.game.service.FabuinfoService;
import cn.qziedu.game.service.UserService;
import cn.qziedu.game.service.UserinfoService;
import cn.qziedu.game.utils.Msg;

@Controller
@RequestMapping("/ht")
public class IndexController {
	@Autowired
	private UserinfoService userinfoService;
	@Autowired
	private UserService userService;
	@Autowired
	private BuildinfoService buildinfoService;
	@Autowired
	private FabuinfoService fabuinfoService;

	// 显示欢迎界面
	@RequestMapping("/welcome.action")
	public String welcome() {
		return "index/welcome";
	}

	// 显示用户的信息（可操作）
	@RequestMapping("/toxinxi.action")
	public String toxinxi(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		// 获取user的id
		int emailid = user.getId();
		List<Userinfo> userinfo = userinfoService.selUserinfoByEid(emailid);
		if (userinfo.size() > 0) {
			model.addAttribute("userinfo", userinfo.get(0));
			return "index/insertxinxi";
		} else {
			return "index/insertxinxi";
		}

	}

	// 显示用户的信息
	@RequestMapping("/selxinxi.action")
	public String selxinxi(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		// 获取user的id
		int emailid = user.getId();
		List<Userinfo> userinfo = userinfoService.selUserinfoByEid(emailid);
		if (userinfo.size() > 0) {
			model.addAttribute("userinfo", userinfo.get(0));
			return "index/userinfoxinxi";
		} else {
			return "index/insertxinxi";
		}
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

	// 添加或修改用户信息
	@RequestMapping("/xiugaixinxi.action")
	@ResponseBody
	public Msg xiugaixinxi(HttpServletRequest request,MultipartFile file, HttpSession session, int age, String name, String phone, String jieshao)
			throws Exception, IOException {
		Msg msg = null;
		String sqlPath = null;

		 /**
         * 上传图片
         */
        String filePath = "E:\\upload";//保存图片的路径
        //获取原始图片的拓展名
        String originalFilename = file.getOriginalFilename();
        //新的文件名字
        String filename = UUID.randomUUID()+originalFilename;
        //封装上传文件位置的全路径
        File targetFile = new File(filePath,filename); 
        //把本地文件上传到封装上传文件位置的全路径
        file.transferTo(targetFile);

		// 根据user的id判断userinfo是否存在
		User user = (User) session.getAttribute("user");
		// 获取user的id
		int emailid = user.getId();
		// 查询userinfo
		List<Userinfo> list = userinfoService.selUserinfoByEid(emailid);
		Userinfo userinfo = new Userinfo();
		userinfo.setAge(age);
		userinfo.setName(name);
		userinfo.setPhone(phone);
		userinfo.setJieshao(jieshao);
		userinfo.setEmailid(emailid);
		// 判断userinfo是否存在
		if (list.size() > 0) {
			//判断有么有选择图片
			if(originalFilename!="") {
				// 把图片的相对路径保存至数据库
				sqlPath = "/imgs/" + filename;
				userinfo.setTouxiang(sqlPath);
			}
			//更新
			userinfoService.updUserinfo(userinfo, emailid);
			msg = new Msg();
			msg.setCode(1);
			msg.setMessage("修改成功");
			session.setAttribute("userinfo", userinfo);
		}
		else {
			if(originalFilename=="") {
				msg = new Msg();
				msg.setCode(-1);
				msg.setMessage("添加失败,未选择头像");
			}
			else {
				// 把图片的相对路径保存至数据库
				sqlPath = "/imgs/" + filename;
				userinfo.setTouxiang(sqlPath);
				// 添加
				userinfoService.insUserinfo(userinfo);
				msg = new Msg();
				msg.setCode(0);
				msg.setMessage("添加成功");
				session.setAttribute("userinfo", userinfo);
			}
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
	
	
	//显示所有可报名的比赛
	@RequestMapping("/selkebaoming.action")
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
		List<User> users=userService.findAllUser();
		model.addAttribute("users", users);
		model.addAttribute("fabuinfo", list);
		if(user.getQuanxian().equals("普通用户")) {
			return "index/selectkebaoming";
		}
		else {
			return "index/selectkebaomingall";
		}
	}
	//查看已经结束的比赛
	@RequestMapping("/selectgameover.action")
	public String selectgameover(HttpSession session,Model model) {
		User user=(User) session.getAttribute("user");
		Date datetime=new Date();
		List<Fabuinfo> list=new ArrayList<Fabuinfo>();
		List<Fabuinfo> fabuinfos=fabuinfoService.selectFabuinfo();
		for(Fabuinfo fabuinfo:fabuinfos) {
			if(fabuinfo.getTime4().before(datetime)) {
				list.add(fabuinfo);
			}
		}
		List<User> users=userService.findAllUser();
		model.addAttribute("users", users);
		model.addAttribute("fabuinfo", list);
		return "index/selectyiwancheng";
	}
}
