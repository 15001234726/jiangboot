package com.jyh.jiangboot.command;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.*;

public class TestSort {

    /**
     * 使用 Map按key进行排序
     * @param map
     * @return
     */
    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<String, String> sortMap = new TreeMap<String, String>(
                new MapKeyComparator());

        sortMap.putAll(map);

        return sortMap;
    }

    static class MapKeyComparator implements Comparator<String>{

        @Override
        public int compare(String str1, String str2) {

            return str1.compareTo(str2);
        }
    }



    public static void main(String[] args) {

        String a = "client_id";
        String b = "client_secret";
        String c = "grant_type";
        String d = "phone";
        String e = "timestamp";
        String f = "sign_key";


        List<String> list = new ArrayList();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
        list.sort(String::compareTo);

        for (String s : list) {
            System.out.println(s);
        }

        Map map = new TreeMap();
        map.put(a, 1);
        map.put(b, 2);
        map.put(c, 3);
        map.put(d, 4);
        map.put(e, 5);
        map.put(f, 6);

        Map resultMap = sortMapByKey(map);
        System.out.println(resultMap);

        String qqq = resultMap.toString();
        String ccc = qqq.replaceAll(", ", "&").replaceAll("[\\\\{\\\\}]", "");
        System.out.println(ccc);

        System.out.println(DigestUtils.sha1Hex(ccc));

    }


}
