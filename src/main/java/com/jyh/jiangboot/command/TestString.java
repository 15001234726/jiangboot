package com.jyh.jiangboot.command;

public class TestString {


    public static void main(String[] args) {

        String aaa = "淘鲜达啦啦啦啦略略略略";
        String bbb = "淘鲜达";

        if(aaa.indexOf(bbb)!=-1){
            System.out.println("包含");
        }else{
            System.out.println("不包含");
        }

        int total = 1820;
        int group = 70;
        int a = total / group ;
        int b = total % group;
        System.out.println(a);
        System.out.println(b);
        if (total % group != 0) {
            System.out.println("1");
        }


//        SingleDemo.getIntstance();
//        SingleDemo.show();



    }



}
