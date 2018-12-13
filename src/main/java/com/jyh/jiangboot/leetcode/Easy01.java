package com.jyh.jiangboot.leetcode;


import java.util.HashMap;
import java.util.Map;

public class Easy01 {

    public static int[] twoSum(int[] nums, int target) {
        /*
        给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
        你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
         */
        //1  时间复杂度O(n^2)
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(i);
//            for (int a = 1 + i; a < nums.length; a++) {
//                System.out.println(a);
//                if (nums[i] + nums[a] == target) {
//                    int[] x={i,a};
//                    return x;
//                }
//            }
//        }
//        return null;

        //2  时间复杂度O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //判断差值 差值为key 位置为value
            int complement = target - nums[i];
            //如果存在差值的key  取位置
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        /*
//        给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//        */
//
//            ListNode dummyHead = new ListNode();
//            ListNode p = l1, q = l2, curr = dummyHead;
//            int carry = 0;
//            while (p != null || q != null) {
//                int x = (p != null) ? p.val : 0;
//                int y = (q != null) ? q.val : 0;
//                int sum = carry + x + y;
//                carry = sum / 10;
//                curr.next = new ListNode(sum % 10);
//                curr = curr.next;
//                if (p != null) p = p.next;
//                if (q != null) q = q.next;
//            }
//            if (carry > 0) {
//                curr.next = new ListNode(carry);
//            }
//            return dummyHead.next;
//        }




    public static void main(String[] args) {
        //1
//        int[] a = {1,2,3,4,5,6,7,8,9,10};
//        Easy01.twoSum(a, 19);


    }




}
