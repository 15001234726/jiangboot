package com.jyh.jiangboot.command;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CreateExcel {


    public void testExcel(String urlStr) throws IOException {


        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3*1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //得到输入流
        InputStream inputStream = conn.getInputStream();

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);


//        导入
        System.out.println(to111(hssfWorkbook));


    }

    public String to111(HSSFWorkbook hssfWorkbook) {

        //读数据
        HSSFSheet sheet0 = hssfWorkbook.getSheetAt(2);
        HSSFRow hssfRow = sheet0.getRow(2);
        HSSFCell cell = hssfRow.getCell(6);


        return cell.toString();

    }




    public static void main(String[] args) throws IOException {
        CreateExcel createExcel = new CreateExcel();
        createExcel.testExcel(
                "https://shadowpriest.oss-cn-beijing.aliyuncs.com/work/%E4%B8%93%E9%A1%B9%E9%99%84%E5%8A%A0%E6%89%A3%E9%99%A4%E4%BF%A1%E6%81%AF.xls");




    }




}
