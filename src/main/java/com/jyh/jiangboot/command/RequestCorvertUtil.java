package com.jyh.jiangboot.command;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


/**
 * 请求响应转换工具
 */
public class RequestCorvertUtil {



    /***
     *
     * @param url 请求的url
     * @param s  需转换的请求结果response.body
     * @return
     * @throws RestResultConvertExcepction  转换失败抛出异常，异常信息中携带上转换信息
     */
    public static JSONArray getJSONArrayFromStr(String url,String s) throws RestResultConvertExcepction {
        try{
            JSONArray jsonArray= JSON.parseArray(s);
            return jsonArray;
        }catch (Exception e){
            throw new RestResultConvertExcepction("getJSONArrayFromStr调用外部接口结果转换失败\n接口"+url+"返回结果："+htmlEncode(s)+"\n无法转换为JSONArray",e);
        }

    }



    /***
     *
     * @param url 请求的url
     * @param s  需转换的请求结果response.body
     * @return
     * @throws RestResultConvertExcepction  转换失败抛出异常，异常信息中携带上转换信息
     */
    public static JSONObject getJSONObjectFromStr(String url,String s) throws RestResultConvertExcepction {
        try{
            JSONObject jsonArray= JSON.parseObject(s);
            return jsonArray;
        }catch (Exception e){
            throw new RestResultConvertExcepction("getJSONArrayFromStr调用外部接口结果转换失败\n接口"+url+"返回结果："+htmlEncode(s)+"\n无法转换为JSONObject",e);
        }
    }



    /**
     * 给字符转加上xmp标签，防止job中心显示日志隐藏html标签的问题
     * @param source
     * @return
     */
    public static String htmlEncode(String source){
        if (source.length()>1000)
            source=source.substring(0,999)+"...";

        return "<xmp>"+source+"</xmp>";
    }
}
