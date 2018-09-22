package cn.jk.game;

import sun.awt.image.OffScreenImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/** 飞机游戏的窗口
 * Created by jkx on 2018/9/22.
 */
public class MyGameFrame extends JFrame {

    Image planeImg = GameUtil.getImage("images/plane.png");
    Image bg = GameUtil.getImage("images/bg.jpg");
    //int planeX=250, planeY=250;
    Plane plane = new Plane(planeImg,250,250);

    @Override
    public void paint(Graphics g){  //自动调用，g相当于画笔
        g.drawImage(bg,0,0,null);

        plane.drawSelf(g);  //画飞机


    }

    //多线程,帮助我们反复画窗口
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

    // 定义键盘监听内部类
    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){  //KeyEvent 按压键盘的捕捉
            System.out.println("按下" + e.getKeyCode());
        }

        @Override
        public void keyReleased( KeyEvent e){   // 释放键盘
            System.out.println("抬起" + e.getKeyCode());
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
        addKeyListener(new KeyMonitor());  //给窗口增加键盘的监听
    }

    public static void main(String[] args){
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }





}
