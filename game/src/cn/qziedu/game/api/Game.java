package cn.qziedu.game.api;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
//DrawChessBoard.class.getClassLoader().getResource("images/ball.png")
    Image ball=Toolkit.getDefaultToolkit().getImage(Game.class.getClassLoader().getResource("ball.png"));
    Image desk=Toolkit.getDefaultToolkit().getImage(Game.class.getClassLoader().getResource("desk.png"));

    double x=200;
    double y=200;
    boolean right=true; //控制小球的水平位移

    //绘制窗口
    public void paint(Graphics g){
        System.out.println("窗口被画一次");
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int)x,(int)y,null);
        if(right==true){
            x=x+10;
        }
        else{
            x=x-10;
        }
        if(x>800){
            right=false;
        }
        if(x<0){
            right=true;
        }
    }

    public void laFram(){
        setSize(856,450);
        setLocation(100,100);
        setVisible(true);

        //BufferedImage image=new BufferedImage(200,100,BufferedImage.TYPE_INT_RGB);

        //实现动画每秒绘制25次
        while (true){
            repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
