package com.jyh.jiangboot.command;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.text.SimpleDateFormat;

@Component
public class ExcelUtils {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



    //声明一个该工具类的静态的内部对象
    private static ExcelUtils excelUtils;

    //工具类中需要注入service，dao等需要
    //使用注解@PostConstruct把需要使用的service，dao等加载到上面定义的静态内部对象中
    @PostConstruct
    public void init() {
        excelUtils = this;

    }

    public void testExcel() {
        File newFile = createNewFile("/Users/luv/Desktop/专项附加扣除信息(2).xls", "/Users/luv/Desktop");
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
        // 删除创建的新文件
        this.deleteFile(newFile);


    }



    /**
     *tempPath 模板文件路径
     *path 文件路径
     *list 集合数据
     */
//    public void exportExcel(String tempPath, String path, HttpServletResponse response, List<OrderVO> list) {
//        File newFile = createNewFile(tempPath, path);
//        InputStream is = null;
//        XSSFWorkbook workbook = null;
//        XSSFSheet sheet = null;
//        try {
//            is = new FileInputStream(newFile);// 将excel文件转为输入流
//            workbook = new XSSFWorkbook(is);// 创建个workbook，
//            // 获取第一个sheet
//            sheet = workbook.getSheetAt(0);
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }
//
//        if (sheet != null) {
//            try {
//                // 写数据
//                FileOutputStream fos = new FileOutputStream(newFile);
//                XSSFRow row = sheet.getRow(0);
//                if (row == null) {
//                    row = sheet.createRow(0);
//                }
//                XSSFCell cell = row.getCell(0);
//                if (cell == null) {
//                    cell = row.createCell(0);
//                }
//                cell.setCellValue("我是标题");
//
//                for (int i = 0; i < list.size(); i++) {
//                    OrderVO vo = list.get(i);
//                    row = sheet.createRow(i+2); //从第三行开始
//
//                    //这里就可以使用sysUserMapper，做相应的操作
//                    //User user = excelUtils.sysUserMapper.selectByPrimaryKey(vo.getId());
//
//                    //根据excel模板格式写入数据....
//                    createRowAndCell(vo.getTaobaoOrderId(), row, cell, 0);
//                    createRowAndCell(vo.getOrderInfo(), row, cell, 1);
//                    createRowAndCell(vo.getLy(), row, cell, 2);
//                    createRowAndCell(format.format(DateFormat.getDateInstance().parse(vo.getCreateTime())), row, cell, 3);
//                    createRowAndCell(vo.getTotal(), row, cell, 4);
//                    createRowAndCell(getOrderSource(vo.getSourceId()), row, cell, 5);
//                    //.....
//                }
//                workbook.write(fos);
//                fos.flush();
//                fos.close();
//
//                // 下载
//                InputStream fis = new BufferedInputStream(new FileInputStream(
//                        newFile));
//                byte[] buffer = new byte[fis.available()];
//                fis.read(buffer);
//                fis.close();
//                response.reset();
//                response.setContentType("text/html;charset=UTF-8");
//                OutputStream toClient = new BufferedOutputStream(
//                        response.getOutputStream());
//                response.setContentType("application/x-msdownload");
//                String newName = URLEncoder.encode(
//                        "订单" + System.currentTimeMillis() + ".xlsx",
//                        "UTF-8");
//                response.addHeader("Content-Disposition",
//                        "attachment;filename=\"" + newName + "\"");
//                response.addHeader("Content-Length", "" + newFile.length());
//                toClient.write(buffer);
//                toClient.flush();
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    if (null != is) {
//                        is.close();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        // 删除创建的新文件
//        this.deleteFile(newFile);
//    }

    /**
     *根据当前row行，来创建index标记的列数,并赋值数据
     */
    private void createRowAndCell(Object obj, XSSFRow row, XSSFCell cell, int index) {
        cell = row.getCell(index);
        if (cell == null) {
            cell = row.createCell(index);
        }

        if (obj != null)
            cell.setCellValue(obj.toString());
        else
            cell.setCellValue("");
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
     * 下载成功后删除
     *
     * @param files
     */
    private void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void main(String[] args) {
        ExcelUtils excelUtils = new ExcelUtils();
        excelUtils.testExcel();

    }

}

