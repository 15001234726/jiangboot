package com.jyh.jiangboot.command;

import java.io.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author jiangyuhong
 * @date 2020/1/14 18:25
 */
public class WriteExcel {

    public static void main(String[] args) {
        WriteExcel a = new WriteExcel();
        a.testExcel();
    }


    public void testExcel() {


        File newFile = createNewFile("/Users/luv/Desktop/旷视 HR FEED 模板.xlsx", "/Users/luv/Desktop");
        InputStream is = null;
        XSSFWorkbook workbook = null;
        XSSFSheet sheet = null;
        try {
            is = new FileInputStream(newFile);// 将excel文件转为输入流
            workbook = new XSSFWorkbook(is);// 创建个workbook，
            // 获取第一个sheet
            sheet = workbook.getSheetAt(0);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        if (sheet != null) {
            try {

                System.out.println(1);

                XSSFRow row = sheet.createRow(1);

                XSSFCell cell = row.createCell(0);


                cell.setCellValue("11111");


//                sheet.getRow(1).getCell(1).setCellValue("2222222");

                // 写数据
                FileOutputStream fos = new FileOutputStream(newFile);

                workbook.write(fos);
                fos.flush();
                fos.close();


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != is) {
                        is.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }



        System.out.println(1);
    }




    /**
     * 读取excel模板，并复制到新文件中供写入和下载
     *
     * @return
     */
    public File createNewFile(String tempPath, String rPath) {
        // 读取模板，并赋值到新文件************************************************************
        // 文件模板路径
        String path = (tempPath);
        File file = new File(path);
        // 保存文件的路径
        String realPath = rPath;
        // 新的文件名
        String newFileName = System.currentTimeMillis() + ".xlsx";
        // 判断路径是否存在
        File dir = new File(realPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // 写入到新的excel
        File newFile = new File(realPath, newFileName);
        try {
            newFile.createNewFile();
            // 复制模板到新文件
            fileChannelCopy(file, newFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newFile;
    }



    /**
     * 复制文件
     *
     * @param s
     *            源文件
     * @param t
     *            复制到的新文件
     */

    public void fileChannelCopy(File s, File t) {
        try {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = new BufferedInputStream(new FileInputStream(s), 1024);
                out = new BufferedOutputStream(new FileOutputStream(t), 1024);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = in.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }
            } finally {
                if (null != in) {
                    in.close();
                }
                if (null != out) {
                    out.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
