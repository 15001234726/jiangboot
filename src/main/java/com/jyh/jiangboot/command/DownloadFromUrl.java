package com.jyh.jiangboot.command;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadFromUrl {

    public static File downloadFromUrl(String urlStr, String fileName) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3*1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //获取自己数组
        byte[] getData = readInputStream(inputStream);

        //文件保存位置
        /**
         * 读取文件地址
         */
//        File saveDir = new File("");
        File saveDir = new File("/Users/luv/Desktop/专项附加扣除信息(2).xls");
        if(!saveDir.exists()){
            saveDir.mkdir();
        }
        File file = new File(saveDir+File.separator+fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if(fos!=null){
            fos.close();
        }
        if(inputStream!=null){
            inputStream.close();
        }
        return file;
    }






    /**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

    public static void main(String[] args) {
        try {
            downloadFromUrl("https://shadowpriest.oss-cn-beijing.aliyuncs.com/work/%E4%B8%93%E9%A1%B9%E9%99%84%E5%8A%A0%E6%89%A3%E9%99%A4%E4%BF%A1%E6%81%AF%282%29.xls", "123.xls");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
