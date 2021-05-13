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

import cn.qziedu.game.pojo.China;
import cn.qziedu.game.pojo.Dpinfo;
import cn.qziedu.game.pojo.User;
import cn.qziedu.game.service.ChinaService;
import cn.qziedu.game.service.DpinfoService;
import cn.qziedu.game.utils.Msg;

@Controller
@RequestMapping("/tzs/sjxx")
public class SshangjiaxinxiController {
	
	@Autowired
	private DpinfoService dpinfoService;
	@Autowired
	private ChinaService chinaService;
	
	// 显示店铺的信息
	@RequestMapping("/seldpxinxi.action")
	public String selxinxi(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		// 获取user的id
		int emailid = user.getId();
		List<Dpinfo> dpinfo = dpinfoService.selDpinfoByEid(emailid);
		if (dpinfo.size() > 0) {
			model.addAttribute("dpinfo", dpinfo.get(0));
			return "index/indextouzishang/shangjiaxinxi/dpinfoxinxi";
		} else {
			return "index/indextouzishang/shangjiaxinxi/insertxinxi";
		}
	}
	
	// 显示店铺的信息（可操作）
	@RequestMapping("/todpxinxi.action")
	public String toxinxi(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		// 获取user的id
		int emailid = user.getId();
		List<Dpinfo> dpinfo = dpinfoService.selDpinfoByEid(emailid);
		if (dpinfo.size() > 0) {
			model.addAttribute("dpinfo", dpinfo.get(0));
			return "index/indextouzishang/shangjiaxinxi/insertxinxi";
		} else {
			return "index/indextouzishang/shangjiaxinxi/insertxinxi";
		}
	}
	
	// 添加或修改店铺信息
	@RequestMapping("/xiugaidpxinxi.action")
	@ResponseBody
	public Msg xiugaixinxi(HttpServletRequest request,MultipartFile file, HttpSession session, String dpdizhi1,String dpdizhi2,String dpdizhi3, String dpname, String phone, String jieshao)
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

		// 根据user的id判断dpinfo是否存在
		User user = (User) session.getAttribute("user");
		// 获取user的id
		int emailid = user.getId();
		// 查询dpinfo
		List<Dpinfo> list = dpinfoService.selDpinfoByEid(emailid);
		Dpinfo dpinfo = new Dpinfo();
		if(dpdizhi1.equals("")==false||dpdizhi2.equals("")==false||dpdizhi3.equals("")==false) {
			dpinfo.setDizhi(dpdizhi1+dpdizhi2+dpdizhi3);
		}
		dpinfo.setDpname(dpname);
		dpinfo.setPhone(phone);
		dpinfo.setJieshao(jieshao);
		dpinfo.setEmailid(emailid);
		// 判断dpinfo是否存在
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
				dpinfo.setTouxiang(sqlPath);
			}
			//更新
			dpinfoService.updDpinfo(dpinfo, emailid);
			msg = new Msg();
			msg.setCode(1);
			msg.setMessage("修改成功");
			session.setAttribute("dpinfo", dpinfo);
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
				dpinfo.setTouxiang(sqlPath);
				// 添加
				dpinfoService.insDpinfo(dpinfo);
				msg = new Msg();
				msg.setCode(0);
				msg.setMessage("添加成功");
				session.setAttribute("dpinfo", dpinfo);
			}
		}
		return msg;
	}
	
	//查询地址1
	@RequestMapping("/todizhi1.action")
	@ResponseBody
	public List<China> todizhi1() {
		List<China> china=chinaService.selectsheng();
		return china;
	}
	
	//查询地址2
	@RequestMapping("/todizhi2.action")
	@ResponseBody
	public List<China> todizhi2(String d1) {
		China c=chinaService.selectChinaByName(d1);
		List<China> china=chinaService.selectshi(c.getId());
		return china;
	}
	//查询地址3
	@RequestMapping("/todizhi3.action")
	@ResponseBody
	public List<China> todizhi3(String d2) {
		China c=chinaService.selectChinaByName(d2);
		List<China> china=chinaService.selectqu(c.getId());
		return china;
	}

}
