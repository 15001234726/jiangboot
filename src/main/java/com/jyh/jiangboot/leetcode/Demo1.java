package com.jyh.jiangboot.leetcode;

public class Demo1 {


    /**
     *  无序数列0到n  n个数 每个数只出现一次 找到缺少的那个数
     *
     * @param demo
     * @return
     */

    public static int test(int[] demo) {

        int result = 0;
        for (int i = 0; i < demo.length; i ++) {
            result = result ^ demo[i] ^ i;
        }
        result = result ^ (demo.length);
        return result;
    }


    public static void main(String[] args) {
        int[] demo = new int[] {8,9,10,11,12,13,14,0,1,2,3,4,5,6,7};

        int result = test(demo);
        System.out.println(result);

    }


}
