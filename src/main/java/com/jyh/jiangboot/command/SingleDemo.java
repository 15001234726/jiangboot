package com.jyh.jiangboot.command;

public class SingleDemo {

    private SingleDemo() {
        System.out.println("创建单例对象");
    }

    private static SingleDemo sd = new SingleDemo();

    public static SingleDemo getIntstance() {
        return sd;
    }

    public static void show() {
        System.out.println("单例中的静态函数");
    }


}
