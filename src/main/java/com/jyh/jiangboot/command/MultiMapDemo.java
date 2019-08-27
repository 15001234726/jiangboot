package com.jyh.jiangboot.command;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class MultiMapDemo {

    public static void main(String[] args) {
        MultiValueMap<String, String> form = new LinkedMultiValueMap();
//        form.add("1","1");
//        form.add("2","2");
//        form.add("3","3");
//        form.add("1","4");
//        form.add("1","5");
//
//        System.out.println(form);
//
//
//        List<String> a = form.get("1");

//        LocalDateTime date = LocalDateTime.now();
//        System.out.println(date);
//        System.out.println(date.withHour(0));
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse("2019-08-06 00:00:00",df);


        System.out.println(date.toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(date.toInstant(ZoneOffset.of("+0")).toEpochMilli());
        System.out.println(date.toInstant(ZoneOffset.of("-8")).toEpochMilli());


    }




}
