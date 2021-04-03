package cn.qziedu.game.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.qziedu.game.api.Game;
import cn.qziedu.game.pojo.Fabuinfo;
import cn.qziedu.game.utils.Msg;

@Controller
@RequestMapping("/tupian")
public class Images extends HttpServlet{

	@RequestMapping("/a.action")
	public void a(HttpServletResponse resp) throws IOException {
		BufferedImage image=new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
		ServletOutputStream outputStream=resp.getOutputStream();
		ImageIO.write(image, "jpg", outputStream);
	}
	@RequestMapping("/b.action")
	public void b(HttpServletResponse resp) throws IOException {
		System.out.println("小游戏开始了");
        Game game=new Game();
        game.laFram();
	}
	


	
}
