package cn.jk.game;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/** 飞机游戏的窗口
 * Created by jkx on 2018/9/22.
 */
public class MyGameFrame extends JFrame {
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
    }

    public static void main(String[] args){
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }


}
