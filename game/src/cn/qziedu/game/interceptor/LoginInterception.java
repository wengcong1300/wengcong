package cn.qziedu.game.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.qziedu.game.pojo.User;


public class LoginInterception implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.err.println("preHandle");
		System.err.println(request.getRequestURI());
		String uri=request.getRequestURI();
//		if(uri.indexOf("/tologin.action")>=0||uri.indexOf("/tologin")>=0||uri.indexOf("/toreg")>=0||
//				uri.indexOf("/index")>=0||uri.indexOf("/person")>=0||uri.indexOf("/ftl")>=0||
//				uri.indexOf("/login")>=0||uri.indexOf("/logout")>=0||uri.indexOf("/user")>=0||uri.indexOf("/userinfo")>=0) {
//			return true;
//		}
		if(uri.indexOf("/qt")>=0||uri.indexOf("/keshihua")>=0) {
			return true;
		}
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		if(user!=null) {
			String quanxian=user.getQuanxian();
			if(quanxian.equals("普通用户")) {
				if(uri.indexOf("/ptyh")>=0||uri.indexOf("/ht")>=0) {
					return true;
				}
			}
			if(quanxian.equals("投资商")) {
				if(uri.indexOf("/tzs")>=0||uri.indexOf("/ht")>=0) {
					return true;
				}
			}
			if(quanxian.equals("管理员")) {
				if(uri.indexOf("/gly")>=0||uri.indexOf("/ht")>=0) {
					return true;
				}
			}
		}
		
		String contextPath = request.getContextPath();
	    String basePath = request.getScheme()+"://"+request.getServerName()+":"+
	    request.getServerPort()+contextPath+"/";
	    System.err.println(basePath+"qt/tologin.action");//http://localhost:8080/game/qt/tologin.action
	    response.sendRedirect(basePath+"qt/tologin.action");
		//request.getRequestDispatcher(basePath+"qt/tologin.action").forward(request, response);
		return false;
		//return true;
	}
	

}
