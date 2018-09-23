package cn.jk.game;

import java.awt.*;

/**  炮弹类
 * Created by jkx on 2018/9/23.
 */
public class  Shell extends GameObject {
    double degree;

    public Shell(){   // 同名方法，这是方法
        x = 200;
        y = 200;
        width = 10;
        height = 10;
        speed = 3;

        degree = Math.random()* Math.PI *2;  //0-2PI的随机数

    }

    public void draw(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.YELLOW);

        g.fillOval((int)x, (int)y,width, height);
        //炮弹沿着任意角度去飞
        x += speed * Math.cos(degree);
        y += speed * Math.sin(degree);

        if(x<0 || x> Constant.GAME_WIDTH -width ){
            degree = Math.PI - degree;   //碰到墙壁翻转
        }

        if(y<30 || y> Constant.GAME_HEIGHT -height){
            degree = - degree;
        }

        g.setColor(c);

    }

}
