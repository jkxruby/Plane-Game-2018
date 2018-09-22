package cn.jk.game;

import java.awt.*;

/**
 * Created by jkx on 2018/9/22.
 */
public class Plane extends GameObject {
    public void drawSelf(Graphics g){
        g.drawImage(img, (int)x, (int)y, null);
        x++;
    }

    public Plane(Image img, double x, double y){
        this.img = img;
        this.x = x;
        this.y = y;
    }

}
