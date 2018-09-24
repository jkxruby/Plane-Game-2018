package cn.jk.game;

import java.awt.*;

/** 游戏中物体的父类
 * Created by jkx on 2018/9/22.
 */
public class GameObject {
    Image img;
    double x,y;
    int speed = 3;
    int width, height;

    public void drawSelf(Graphics g){
        g.drawImage(img,(int)x,(int)y,null);

    }

    public GameObject(Image img, double x, double y, int speed, int width, int height){
        super();
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;

    }

    public GameObject(Image img, double x, double y){  //就叫重载构造器，名字相同，但输入参数不同
        super();
        this.img = img;
        this.x = x;
        this.y = y;
    }

    public GameObject(){   //空构造器，又称无参构造器

    }
 // 返回物体所在矩形，便于后续的碰撞检测
    public Rectangle getRect(){
        return new Rectangle((int)x, (int)y, width,height);
    }


}
