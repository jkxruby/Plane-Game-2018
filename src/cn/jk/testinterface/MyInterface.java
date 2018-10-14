package cn.jk.testinterface;

/**
 * Created by jkx on 2018/10/3.
 */
public interface MyInterface {  // 除了把 class 换成 interface外，其他没多大区别
    // 接口中只有常量和 抽象方法
    String MAX_GREAD = "BOSS";
    int MAX_SPEED = 120;

    public void test01();

    public void test02(int a, int b);






}

