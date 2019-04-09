package com.jyh.jiangboot.command;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class NewExcel {

    public void createExcel() throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        workbook.createSheet("sheet1");

        HSSFRow row = workbook.getSheetAt(0).createRow(0);
        HSSFCell cell0 = row.createCell(0);
        cell0.setCellValue("名称");

        FileOutputStream fos = new FileOutputStream("/Users/luv/Desktop/test01.xls");
        workbook.write(fos);
        fos.close();

    }

    public static void main(String[] args) throws IOException {
        NewExcel excel = new NewExcel();
        excel.createExcel();



    }




}
