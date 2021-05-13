package cn.qziedu.game.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qziedu.game.pojo.Buildinfo;
import cn.qziedu.game.pojo.User;
import cn.qziedu.game.service.BuildinfoService;
import cn.qziedu.game.utils.Msg;

@Controller
@RequestMapping("/tzs/sjjs")
public class SshangjiajiansaiController {
	
	@Autowired
	private BuildinfoService buildinfoService;
	
	//显示查询个人创建的竞赛信息
	@RequestMapping("/selBuildinfo.action")
	public String selBuildinfo(HttpSession session,Model model) {
		User user=(User) session.getAttribute("user");
		
		List<Buildinfo> buildinfo=buildinfoService.selBuildinfoByUserid(user.getId());
		long count=buildinfoService.countBuildinfo(user.getId());
		model.addAttribute("buildinfo", buildinfo);
		model.addAttribute("count", count);
		return "index/indextouzishang/shangjiajiansaiguanli/selectbuildinfo";
	}
	
	//显示建立赛事页面
	@RequestMapping("/toinsertBuildinfo.action")
	public String toinsertBuildinfo(HttpSession session,Model model) {
		//显示添加页面
		return "index/indextouzishang/shangjiajiansaiguanli/insertbuildinfo";
	}
	
	//建立赛事
	@RequestMapping("/insertBuildinfo.action")
	@ResponseBody
	public Msg insertBuildinfo(HttpSession session,Model model,String gamename,String miaoshu,String guize) {
		Msg msg=null;
		User user=(User) session.getAttribute("user");
		//添加
		Buildinfo buildinfo=new Buildinfo();
		buildinfo.setGamename(gamename);
		buildinfo.setMiaoshu(miaoshu);
		buildinfo.setGuize(guize);
		buildinfo.setUserid(user.getId());
		int n=buildinfoService.insBuildinfo(buildinfo);
		if(n==1) {
			msg=new Msg();
			msg.setCode(1);
			msg.setMessage("建立成功");
		}
		else {
			msg=new Msg();
			msg.setCode(0);
			msg.setMessage("建立失败");
		}
		return msg;
	}
	
	//显示修改赛事页面
	@RequestMapping("/toupdateBuildinfo.action")
	public String toupdateBuildinfo(HttpSession session,Model model,int buildid) {
		//显示修改页面
		Buildinfo buildinfo=buildinfoService.selBuildinfoByBuildid(buildid);
		model.addAttribute("buildinfo", buildinfo);
		return "index/indextouzishang/shangjiajiansaiguanli/updatebuildinfo";
	}
	
	//修改赛事
	@RequestMapping("/updateBuildinfo.action")
	@ResponseBody
	public Msg updateBuildinfo(HttpSession session,Model model,int buildid,String gamename,String miaoshu,String guize) {
		Msg msg=null;
		User user=(User) session.getAttribute("user");
		//修改
		Buildinfo buildinfo=new Buildinfo();
		buildinfo.setGamename(gamename);
		buildinfo.setMiaoshu(miaoshu);
		buildinfo.setGuize(guize);
		buildinfo.setUserid(user.getId());
		int n=buildinfoService.updBuildinfo(buildid, buildinfo);
		if(n==1) {
			msg=new Msg();
			msg.setCode(1);
			msg.setMessage("修改成功");
		}
		else {
			msg=new Msg();
			msg.setCode(1);
			msg.setMessage("修改失败");
		}
		return msg;
	}
	
	//删除
	@RequestMapping("/deletebuildinfo.action")
	public String deletebuildinfo(int buildid) {
		//显示修改页面
		buildinfoService.deletebuildinfo(buildid);
		return "redirect:selBuildinfo.action";
	}
	
	//批量删除
	@RequestMapping("/deleteBuildinfoByIds.action")
	@ResponseBody
	public Msg deleteBuildinfoByIds(String ids) {
		Msg msg=null;
		String[] idss=ids.split(",");
		for(int i=0;i<idss.length;i++) {
			buildinfoService.deletebuildinfo(Integer.parseInt(idss[i]));
			msg=new Msg();
			msg.setCode(1);
			msg.setMessage("删除成功");
		}
		return msg;
	}
}
