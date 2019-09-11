package com.jyh.jiangboot.command;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author jiangyuhong
 * @date 2019/8/27 18:47
 */
public class ReadFile {

    public void readFile() throws IOException {

        FileOutputStream fos = new FileOutputStream("/Users/luv/Desktop/屏幕快照 2019-08-27 18.48.27.png");



        byte[] bytes = new byte[1024];




//        File saveDir = new File("/Users/luv/Desktop/");
//        if(!saveDir.exists()){
//            saveDir.mkdir();
//        }
//
//        File newFile = new File(saveDir+File.separator+"1111.png");
//        FileOutputStream fos2 = new FileOutputStream(newFile);
//        fos2.write(fos);
//
//        if(fos!=null){
//            fos.close();
//        }
//
//        if(fos2!=null){
//            fos2.close();
//        }


    }

    public static void main(String[] args) throws IOException {
        ReadFile readFile = new ReadFile();
        readFile.readFile();
    }


}
