package cn.qziedu.game.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qziedu.game.pojo.Buildinfo;
import cn.qziedu.game.pojo.Fabuinfo;
import cn.qziedu.game.pojo.User;
import cn.qziedu.game.service.FabuinfoService;

@Controller
public class Test {
		@Autowired
		private FabuinfoService fabuinfoService;
		
		@RequestMapping("/totest.action")
		public String totest(HttpSession session,Model model) {
			
			return "index/test";
		}
		
//		@RequestMapping("/test.action")
//		@ResponseBody
//		public List<Integer> test(HttpSession session,Model model) {
//			List<Integer> list=new ArrayList<Integer>();
//			List<Fabuinfo> fabuinfos=fabuinfoService.selectFabuinfo();
//			for(Fabuinfo f:fabuinfos) {
//				list.add(f.getNumber());
//			}
//			return list;
//		}
		@RequestMapping("/test.action")
		@ResponseBody
		public Map<String, Integer> test(HttpSession session,Model model) {
			Map<String, Integer> map = new HashMap<String,Integer>(); 
			List<Fabuinfo> fabuinfos=fabuinfoService.selectFabuinfo();
			for(Fabuinfo f:fabuinfos) {
				map.put(f.getGamename(), f.getNumber());
			}
			return map;
		}

}
