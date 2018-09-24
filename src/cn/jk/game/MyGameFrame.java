package cn.jk.game;

import com.sun.tools.internal.jxc.ap.Const;
import sun.awt.image.OffScreenImage;

//import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JFrame;

/** 飞机游戏的窗口
 * Created by jkx on 2018/9/22.
 */
public class MyGameFrame extends JFrame {

    Image planeImg = GameUtil.getImage("images/plane.png");
    Image bg = GameUtil.getImage("images/bg.jpg");
    //int planeX=250, planeY=250;
    Plane plane = new Plane(planeImg,250,250);
    Shell shell = new Shell();
    Shell[] shells = new Shell[50];
    Explode bao;  //这里没有new对象，这里只是声明bao 是一个爆炸对象
    Date startTime = new Date();
    Date endTime;
    int period; //游戏持续的时间


    @Override
    public void paint(Graphics g){  //自动调用，g相当于画笔
        Color c = g.getColor();
        g.drawImage(bg,0,0,null);

        plane.drawSelf(g);  //画飞机


        //shell.draw(g);   //画一个炮弹
        for(int i=0; i<shells.length; i++){
            shells[i].draw(g);


            // 飞机和炮弹发生碰撞检测
            boolean peng = shells[i].getRect().intersects(plane.getRect());
            if(peng){
                plane.live = false;
                if(bao == null) {
                    bao = new Explode(plane.x, plane.y);
                    endTime = new Date();
                    period = (int) ((endTime.getTime() - startTime.getTime()) / 1000);
                }

                g.setColor(Color.white);
                g.drawString("时间：" + period + "秒", (int)plane.x, (int)plane.y);
                bao.draw(g);

            }
            // 死亡倒计时
            if(!plane.live) {

                g.setColor(Color.white);
                Font f = new Font("宋体", Font.BOLD, 50);
                g.setFont(f);
                g.drawString("时间：" + period + "秒", (int) plane.x, (int) plane.y);
            }
        }



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
            plane.addDirection(e);
        }

        @Override
        public void keyReleased( KeyEvent e){   // 释放键盘
            plane.minusDirection(e);
        }
    }


    // 初始化窗口
    public void launchFrame(){
        this.setTitle("2018新版飞机大战");
        this.setVisible(true);
        this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        this.setLocation(300,300);

        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }

        });


        new PaintThread().start(); //启动重画窗口线程
        addKeyListener(new KeyMonitor());  //给窗口增加键盘的监听

        //初始化50个炮弹
        for(int i=0; i<shells.length; i++){
            shells[i] = new Shell();
        }

    }

    public static void main(String[] args){
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }

    //避免游戏出现闪烁的问题,实际就是增加一个缓存
    private Image offScreenImage = null;

    public void update(Graphics g){
        if(offScreenImage == null)
            offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_WIDTH); //这是游戏的高度和宽度
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage,0,0,null);
    }





}
