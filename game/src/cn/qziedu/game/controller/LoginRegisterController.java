package cn.qziedu.game.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qziedu.game.pojo.User;
import cn.qziedu.game.service.UserService;
import cn.qziedu.game.utils.MailUtil;
import cn.qziedu.game.utils.Msg;
import cn.qziedu.game.utils.RandomUtil;

/**
 * 登录注册
 * @author 翁聪
 *
 */
@Controller
@RequestMapping("/qt")
public class LoginRegisterController {
	@Autowired
	private UserService userService;
	//显示登录界面
	@RequestMapping("/tologin.action")
	public String tologin() {
		return "login";
	}
	
	//登录
	@RequestMapping("/login.action")
	@ResponseBody
	public Msg login(HttpSession session,String quanxian,String email,String password) {
		Msg msg=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		session.setAttribute("shijian", sdf.format(new Date()));
		List<User> user=userService.findUser(quanxian,email, password);
		if(user.size()>0&&user.get(0)!=null) {
			msg=new Msg();
			if(quanxian.equals("管理员")) {
				msg.setCode(1);
				//msg.setMessage("登录成功");
				session.setAttribute("user", user.get(0));
			}
			if(quanxian.equals("普通用户")) {
				if(user.get(0).getZhuangtai()==0) {
					msg.setCode(2);
					//msg.setMessage("登录成功");
					session.setAttribute("user", user.get(0));
				}
				else {
					msg.setCode(-1);
					msg.setMessage("该用户多次违规已被封号");
				}
			}
			if(quanxian.equals("投资商")) {
				if(user.get(0).getZhuangtai()==0) {
					msg.setCode(3);
					//msg.setMessage("登录成功");
					session.setAttribute("user", user.get(0));
				}
				else {
					msg.setCode(-1);
					msg.setMessage("该用户多次违规已被封号");
				}
			}
		}
		else {
			msg=new Msg();
			msg.setCode(0);
			msg.setMessage("用户名密码错误");
		}
		return msg;
	}
	
	
	
	//退出
	@RequestMapping("/logout.action")
	public String logout(HttpSession session) {
		//session.setAttribute("isLogin", null);
		session.setAttribute("shijian", null);
		session.setAttribute("user", null);
		session.setAttribute("userinfo", null);
		return "login";
	}
	
	//显示注册界面
	@RequestMapping("/toregister.action")
	public String toregister() {
		return "register";
	}
	
	//注册邮箱验证
	@RequestMapping("/email.action")
	@ResponseBody
	public Msg sendMailVerifyCode(HttpSession session,String quanxian,String email) {
		Msg msg=null;
		String verifyCode=String.valueOf(RandomUtil.getRandNum());
		String content="邮箱验证码:"+verifyCode;
		List<User> list=userService.findUserByEmail(quanxian, email);
		if(list.size()>0) {
			msg=new Msg();
			msg.setCode(-1);
			msg.setMessage("该权限邮箱用户已存在，请重新注册或返回登录");
		}
		else {
			try {
				MailUtil.sendMailText("荣耀电子竞技系统注册验证码：",content, email);
				msg=new Msg();
				msg.setCode(1);
				msg.setMessage("验证码发送成功");
				session.setAttribute("verifyCode", verifyCode);
				session.setAttribute("email", email);
				System.err.println(verifyCode);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				msg=new Msg();
				msg.setCode(0);
				msg.setMessage("验证码发送失败,请重新发送");
			}
		}
		return msg;
	}
	
	//注册
	@RequestMapping("/register.action")
	@ResponseBody
	public Msg register(User user,HttpSession session,Model model,String quanxian,String email,String password,String coifirmpassword,String verifycode) throws Exception {
		//验证邮箱验证码
		Object verifyCode=session.getAttribute("verifyCode");
		Object emai=session.getAttribute("email");
		Msg msg=null;
		System.err.println(verifyCode);
		if(verifycode.equals(verifyCode)&&email.equals(emai)) {
			msg=new Msg();
			msg.setCode(1);
			msg.setMessage("注册成功");
			user.setQuanxian(quanxian);
			user.setEmail(email);
			user.setPassword(password);
			user.setZhuangtai(0);
			userService.insertUser(user);
			session.setAttribute("verifyCode", null);
			session.setAttribute("email", null);
		}
		else {
			msg=new Msg();
			msg.setCode(0);
			msg.setMessage("验证码错误");
		}
		return msg;
	}
	
	//显示找回密码页面
	@RequestMapping("/toupdate.action")
	public String toupdate() {
		return "update";
	}
	
	//找回密码邮箱验证
	@RequestMapping("/upemail.action")
	@ResponseBody
	public Msg upsendMailVerifyCode(HttpSession session,String quanxian,String email) {
		Msg msg=null;
		String verifyCode=String.valueOf(RandomUtil.getRandNum());
		String content="邮箱验证码:"+verifyCode;
		List<User> list=userService.findUserByEmail(quanxian, email);
		if(list.size()>0) {
			try {
				MailUtil.sendMailText("荣耀电子竞技系统注册验证码：",content, email);
				msg=new Msg();
				msg.setCode(1);
				msg.setMessage("验证码发送成功");
				session.setAttribute("verifyCode", verifyCode);
				session.setAttribute("email", email);
				System.err.println(verifyCode);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				msg=new Msg();
				msg.setCode(0);
				msg.setMessage("验证码发送失败,请重新发送");
			}	
		}
		else {
			msg=new Msg();
			msg.setCode(-1);
			msg.setMessage("该权限邮箱用户还未注册");
		}
		return msg;
	}
	
	//找回密码
	@RequestMapping("/update.action")
	@ResponseBody
	public Msg update(User user,HttpSession session,Model model,String quanxian,String email,String password,String verifycode) throws Exception {
		//验证邮箱验证码
		Object verifyCode=session.getAttribute("verifyCode");
		Object emai=session.getAttribute("email");
		Msg msg=null;
		System.err.println(verifyCode);
		if(verifycode.equals(verifyCode)&&email.equals(emai)) {
			msg=new Msg();
			msg.setCode(1);
			msg.setMessage("找回密码成功");
			user.setZhuangtai(0);
			User users=userService.findUserByEmail(quanxian, email).get(0);
			userService.updUserPassword(users.getId(), password);
			session.setAttribute("verifyCode", null);
			session.setAttribute("email", null);
		}
		else {
			msg=new Msg();
			msg.setCode(0);
			msg.setMessage("验证码错误");
		}
		return msg;
	}
}
