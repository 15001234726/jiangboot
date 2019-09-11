package com.jyh.jiangboot.command;

import org.apache.commons.codec.digest.DigestUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author jiangyuhong
 * @date 2019/8/28 15:16
 */
public class Auth {

    public static void main(String[] args) {

        long time = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(time);

        String result = DigestUtils.md5Hex("0b18f9a2ed584e00" + time);

        System.out.println(result);


    }


}
