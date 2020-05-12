package com.jyh.jiangboot.command;

/**
 * 自定义异常：rest请求结果转换异常
 */
public class RestResultConvertExcepction extends RuntimeException{
    public RestResultConvertExcepction(){
    }
    public RestResultConvertExcepction(String message) {
        super(message);
    }

    public RestResultConvertExcepction(Throwable cause) {
        super(cause);
    }

    public RestResultConvertExcepction(String message, Throwable cause) {
        super(message, cause);
    }
}
