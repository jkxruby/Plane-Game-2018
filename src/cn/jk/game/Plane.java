package cn.jk.game;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by jkx on 2018/9/22.
 */
public class Plane extends GameObject {

    boolean left,up,right,down;
    boolean live = true;


    public void drawSelf(Graphics g){

        if(live) {

            g.drawImage(img, (int) x, (int) y, null);
            if (left) {
                x -= speed;
            }
            if (right) {
                x += speed;
            }
            if (up) {
                y -= speed;
            }
            if (down) {
                y += speed;
            }
        } else{

        }

    }

    public Plane(Image img, double x, double y){
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = 5;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }

    // 释放键盘
    public void minusDirection(KeyEvent e){
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
        }
    }

        // 按下键盘，增加放向
    public void addDirection(KeyEvent e){
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
        }

    }

}
