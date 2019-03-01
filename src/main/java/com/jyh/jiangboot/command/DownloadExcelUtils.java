package com.jyh.jiangboot.command;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadExcelUtils {


    public void testExcel(String urlStr) throws IOException {
        //按照固定模板导出
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3*1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //得到输入流
        InputStream inputStream = conn.getInputStream();
//        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);

//        BufferedInputStream bufferedInputStream = new BufferedInputStream(
//                inputStream);
//        POIFSFileSystem fileSystem = new POIFSFileSystem(
//                bufferedInputStream);
//        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileSystem);

        //写数据
//        HSSFSheet sheet1 = hssfWorkbook.getSheetAt(4);
//        HSSFCell cell119 = sheet1.getRow(4).getCell(7);
//        cell119.setCellValue("110103199410281513");
//
        //写文件
//        FileOutputStream fos = new FileOutputStream("/Users/luv/Desktop/test01.xls");
//        hssfWorkbook.write(fos);

        //byte存储
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        hssfWorkbook.write(os);
//        byte[] getData = os.toByteArray();
//
        //file存储
//        File saveDir = new File("/Users/luv/Desktop");
//        if(!saveDir.exists()){
//            saveDir.mkdir();
//        }
//        File file = new File(saveDir+File.separator+"test01.xls");
//        FileOutputStream fos = new FileOutputStream(file);
//        fos.write(getData);
//        if(fos!=null){
//            fos.close();
//        }
//        fos.close();
//        inputStream.close();

    }


    public static void main(String[] args) throws IOException {
        DownloadExcelUtils downloadExcelUtils = new DownloadExcelUtils();
        downloadExcelUtils.testExcel("https://shadowpriest.oss-cn-beijing.aliyuncs.com/work/%E4%B8%93%E9%A1%B9%E9%99%84%E5%8A%A0%E6%89%A3%E9%99%A4%E4%BF%A1%E6%81%AF.xls");
    }


}
