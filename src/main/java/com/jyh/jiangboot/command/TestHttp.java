package com.jyh.jiangboot.command;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

/**
 * @author jiangyuhong
 * @date 2019/9/26 10:56
 */
public class TestHttp {

    @Autowired
    private RestTemplate restTemplate;

    private boolean getInfo() {
        LocalDateTime now = LocalDateTime.now();
        String sign = DigestUtils.md5Hex("fec880f9634e271a" + now);


        JSONObject data = new JSONObject();
        data.put("sign", sign);
        data.put("timestamp", now);

        HttpEntity<String> requestEntity = new HttpEntity<String>(data.toJSONString(), null);
//        JSONObject newResult = RequestCorvertUtil.getJSONObjectFromStr("127.0.0.1:8089/api/V2/userInfo/asset",restTemplate.exchange
//                ("127.0.0.1:8089/api/V2/userInfo/asset", HttpMethod.GET, requestEntity, String.class).getBody());

        restTemplate.exchange("127.0.0.1:8089/api/V2/userInfo/asset", HttpMethod.GET, requestEntity, JSONObject.class);
        System.out.println(1);
        return true;


    }

    public static void main(String[] args) {

        TestHttp testHttp = new TestHttp();
        testHttp.getInfo();


    }


}
