package com.jyh.jiangboot.leetcode;

import java.util.Arrays;

public class Easy977 {

    /*
    给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
    示例 1：
    输入：[-4,-1,0,3,10]
    输出：[0,1,9,16,100]
     */

    public static int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i ++) {
            result[i] = A[i] * A[i];
        }
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{-7,-3,2,3,11};
        for (int i : sortedSquares(a)) {
            System.out.println(i);
        }
    }


}
