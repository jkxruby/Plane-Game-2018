package cn.jk.game;

/** 临时学习继承使用，与游戏代码无关
 * Created by jkx on 2018/9/22.
 */
public class OtherTest01 {
    public static void main(String[] args){
        Base base = new Child();
        base.method();
    }
}

class Base{
    protected void method(){
        System.out.println("Base method");
    }
}

class Child extends Base{
    protected void methodB(){
        System.out.println("Child methodB");
    }
}
