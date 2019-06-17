package com.jyh.jiangboot.command;

import org.apache.commons.codec.digest.DigestUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DateTime {


    public static void main(String[] args) {
//        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String a = LocalDateTime.now().format(formatter);
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        try {
//            Date date = simpleDateFormat.parse(a);
//            long ts = date.getTime() * 1000;
//            System.out.println(ts);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        Date date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
//        System.out.println(date);


        Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(milliSecond);

        Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(second);

        String b = milliSecond.toString();

        String sign = DigestUtils.shaHex(b);
        String sign2 = DigestUtils.sha1Hex(b);
        System.out.println(sign);
        System.out.println(sign2);





    }




}
