package com.jyh.jiangboot.com.hashmap;

public class TestMyHashMap {

    public static void main(String[] args) {
        MyMap<String, String> map = new MyHashMap<>();
//        Map<String, String> hashmap = new HashMap<>();
        for (int i = 0; i < 21; i++) {
            map.put("key" + i, "value" + i);
//            hashmap.put("key" + i, "value" + i);
        }
        for (int i = 0; i < 21; i++) {
            System.out.println("mymap:key = " + i + ", value = " + map.get("key" + i));
//            System.out.println("hashmap:key = " + i + ", value = " + hashmap.get("key" + i));
        }






    }

}
