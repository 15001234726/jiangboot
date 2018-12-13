package com.jyh.jiangboot.leetcode;

public class Easy07 {

    public static int reverse(int x) {

        //给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
        /*
        但是，这种方法很危险，因为当 \text{temp} = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 时会导致溢出。
        幸运的是，事先检查这个语句是否会导致溢出很容易。
        为了便于解释，我们假设 \text{rev}rev 是正数。
        如果 temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 导致溢出，那么一定有 \text{rev} \geq \frac{INTMAX}{10}rev≥ 10
        INTMAX。
        如果 \text{rev} > \frac{INTMAX}{10}rev>10INTMAX
        ，那么 temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 一定会溢出。
        如果 \text{rev} == \frac{INTMAX}{10}rev==10INTMAX
        ，那么只要 \text{pop} > 7pop>7，temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 就会溢出。
         */

        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;

    }

    public static void main(String[] args) {
        System.out.println(Easy07.reverse(-1234));

    }

}
