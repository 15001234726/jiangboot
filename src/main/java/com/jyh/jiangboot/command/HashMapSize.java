package com.jyh.jiangboot.command;

/**
 * @author jiangyuhong
 * @date 2019/9/11 16:15
 */
public class HashMapSize {

    private static Integer getMapSize(int size) {
        Double length = Math.ceil(size / 0.75);
        int a = length.intValue();

        for (int i = 1; i > 0; i ++) {
            Double c = Math.pow(2, i);
            if (a > c) {
                continue;
            } else {
                return c.intValue();
            }
        }
       return null;
    }

    public static void main(String[] args) {
        int a = HashMapSize.getMapSize(200);
        System.out.println(a);

    }

}
