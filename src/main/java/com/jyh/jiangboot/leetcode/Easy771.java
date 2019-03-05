package com.jyh.jiangboot.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Easy771 {

    /*
     给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
     S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     */


    public static int numJewelsInStones(String J, String S) {

        int total = 0;
        char[] a = J.toCharArray();

        Map<Character, Character> map = new HashMap<>();
        for (char s : a) {
            map.put(s, s);
        }

        char[] b = S.toCharArray();
        for (Character s : b) {
            Character result = map.get(s);
            if (result != null) {
                total = total + 1;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        int result = numJewelsInStones("aAcdeC", "aAAbbbbcc");
        System.out.println(result);

    }



}
