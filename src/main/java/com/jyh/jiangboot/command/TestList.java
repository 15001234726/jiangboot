package com.jyh.jiangboot.command;

import java.util.ArrayList;
import java.util.List;

public class TestList {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(1);
        list2.add(4);
        list2.add(7);
        list2.add(10);
//        List<Integer> listAll = new ArrayList<Integer>();
//        listAll.addAll(list1);
//        listAll.addAll(list2);
//        listAll = new ArrayList<Integer>(new LinkedHashSet<>(listAll));
//        System.out.println(listAll);
//        list1.retainAll(list2);
//        System.out.println(list1);
//
//        list2.removeAll(list1);
//        System.out.println(list2);

        list1.removeAll(list2);
        System.out.println(list1);


    }

}
