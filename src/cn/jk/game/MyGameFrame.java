package cn.jk.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/** 飞机游戏的窗口
 * Created by jkx on 2018/9/22.
 */
public class MyGameFrame extends JFrame {

    Image plane = GameUtil.getImage("images/plane.png");
    Image bg = GameUtil.getImage("images/bg.jpg");
    int planeX=250, planeY=250;

    @Override
    public void paint(Graphics g){  //自动调用，g相当于画笔
        g.drawImage(bg, 0,0,null);
        g.drawImage(plane, planeX,planeY,null);
        planeX ++;


    }

    //多线程
    class PaintThread extends Thread{
        @Override
        public void run(){
            while(true){
                System.out.println("窗口重画一次");
                repaint();   //重画窗口

                try{
                    Thread.sleep(40);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }


    // 初始化窗口
    public void launchFrame(){
        this.setTitle("2018新版飞机大战");
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocation(300,300);

        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }

        });
        new PaintThread().start(); //启动重画窗口线程
    }

    public static void main(String[] args){
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }


}
