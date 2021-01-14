package com.jyh.jiangboot.command;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.codec.digest.DigestUtils;

public class TestSort {

    /**
     * 使用 Map按key进行排序
     * @param map
     * @return
     */
    public static Map<LocalDateTime, String> sortMapByKey(Map<LocalDateTime, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<LocalDateTime, String> sortMap = new TreeMap<LocalDateTime, String>(
                new MapKeyComparator());

        sortMap.putAll(map);

        return sortMap;
    }

    static class MapKeyComparator implements Comparator<LocalDateTime>{

        @Override
        public int compare(LocalDateTime str1, LocalDateTime str2) {

            return str1.compareTo(str2);
        }
    }

    public static JSONObject getEffectOffer(JSONArray offers) {
        TreeMap<LocalDateTime, JSONObject> map = new TreeMap();
        for (Object offer : offers) {
            JSONObject data = (JSONObject) offer;
            LocalDateTime time = DateTimeUtil.string2DateTime3(data.getString("OfferSubmitTime"));
            map.put(time, data);
        }

        return map.lastEntry().getValue();
    }


    public static void main(String[] args) throws InterruptedException {
        JSONObject data1 = new JSONObject();
        data1.put("OfferSubmitTime", "2020/3/19 17:41:26");

         JSONObject data2 = new JSONObject();
        data2.put("OfferSubmitTime", "2018/3/19 17:41:26");

         JSONObject data3 = new JSONObject();
        data3.put("OfferSubmitTime", "2019/3/19 17:41:26");

        JSONArray array = new JSONArray();
        array.add(data1);
        array.add(data2);
        array.add(data3);

        JSONObject a = TestSort.getEffectOffer(array);

        System.out.println(1);







//        String a = "client_id";
//        String b = "client_secret";
//        String c = "grant_type";
//        String d = "phone";
//        String e = "timestamp";
//        String f = "sign_key";
//
//
//        List<String> list = new ArrayList();
//        list.add(a);
//        list.add(b);
//        list.add(c);
//        list.add(d);
//        list.add(e);
//        list.add(f);
//        list.sort(String::compareTo);
//
//        for (String s : list) {
//            System.out.println(s);
//        }
//
//        Map map = new TreeMap();
//        map.put(a, 1);
//        map.put(b, 2);
//        map.put(c, 3);
//        map.put(d, 4);
//        map.put(e, 5);
//        map.put(f, 6);

        TreeMap map = new TreeMap();
        map.put(DateTimeUtil.string2DateTime3("2018/3/19 17:41:26"), 1);
        map.put(DateTimeUtil.string2DateTime3("2020/3/17 17:41:26"), 2);
        map.put(DateTimeUtil.string2DateTime3("2019/3/17 17:41:26"), 3);

        Map map2 = new HashMap();
        map2.put(DateTimeUtil.string2DateTime3("2018/3/19 17:41:26"), 1);
        map2.put(DateTimeUtil.string2DateTime3("2020/3/17 17:41:26"), 2);
        map2.put(DateTimeUtil.string2DateTime3("2019/3/17 17:41:26"), 3);

//        map.put(DateTimeUtil.string2DateTime3("2018/3/20 17:41:26"), 3);
//        map.put(DateTimeUtil.string2DateTime3("2018/4/17 17:41:26"), 4);
//        map.put(DateTimeUtil.string2DateTime3("2018/5/17 17:41:26"), 5);
//        map.put(DateTimeUtil.string2DateTime3("2018/6/17 17:41:26"), 6);


        Map resultMap = sortMapByKey(map);
        System.out.println(resultMap);


         Map resultMap2 = sortMapByKey(map2);
        System.out.println(resultMap2);




        String qqq = resultMap.toString();
        String ccc = qqq.replaceAll(", ", "&").replaceAll("[\\\\{\\\\}]", "");
        System.out.println(ccc);

        System.out.println(DigestUtils.sha1Hex(ccc));

    }


}
