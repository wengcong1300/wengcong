package cn.qziedu.game.controller;

import java.io.File;
import java.io.IOException;
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

import cn.qziedu.game.pojo.User;
import cn.qziedu.game.pojo.Userinfo;
import cn.qziedu.game.service.UserinfoService;
import cn.qziedu.game.utils.Msg;

@Controller
@RequestMapping("/ptyh/yhxx")
public class PyonhuxinxiController {
	
	@Autowired
	private UserinfoService userinfoService;
	
	// 显示用户的信息
	@RequestMapping("/selxinxi.action")
	public String selxinxi(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		// 获取user的id
		int emailid = user.getId();
		List<Userinfo> userinfo = userinfoService.selUserinfoByEid(emailid);
		if (userinfo.size() > 0) {
			model.addAttribute("userinfo", userinfo.get(0));
			return "index/indexputonuser/yonhuxinxi/userinfoxinxi";
		} else {
			return "index/indexputonuser/yonhuxinxi/insertxinxi";
		}
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
			return "index/indexputonuser/yonhuxinxi/insertxinxi";
		} else {
			return "index/indexputonuser/yonhuxinxi/insertxinxi";
		}
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
		File files=new File(request.getSession().getServletContext().getRealPath("upload"));
		if(!files.exists()) {
			files.mkdirs();
		}
        String filePath = files.getAbsolutePath();//保存图片的路径
        //获取原始图片的拓展名
        String originalFilename = file.getOriginalFilename();
        //新的文件名字
        String filename = UUID.randomUUID()+originalFilename;
        

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
				//封装上传文件位置的全路径
		        File targetFile = new File(filePath,filename); 
		        //把本地文件上传到封装上传文件位置的全路径
		        file.transferTo(targetFile);
				String a=list.get(0).getTouxiang();
				a="upload"+a.substring(5);
				File filess=new File(request.getSession().getServletContext().getRealPath(a));
				filess.delete();
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
				//封装上传文件位置的全路径
		        File targetFile = new File(filePath,filename); 
		        //把本地文件上传到封装上传文件位置的全路径
		        file.transferTo(targetFile);
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

}
