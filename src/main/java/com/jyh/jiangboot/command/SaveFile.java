package com.jyh.jiangboot.command;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * @author jiangyuhong
 * @date 2019/8/26 20:03
 */
public class SaveFile {

    class ImageFile{
        String fileName;
        byte[] fileBytes;
    }

    /**
     * 将base64字符串解析为字节数组
     * @param s
     * @return
     */
    private ImageFile getByteFromBase64(String s){
        if (s==null||"".equals(s)){
            return null;
        }
        String fimleName="/jiang."+s.substring(s.indexOf("/")+1,s.indexOf(";"));
        s=s.replaceFirst("data:image/.*?;base64,","");
        ImageFile imageFile=new ImageFile();
        imageFile.fileBytes=Base64.getDecoder().decode(s);
        imageFile.fileName=fimleName;
        return imageFile;

    }

    public boolean saveFile() throws IOException {
        ImageFile photoCertFile=getByteFromBase64("文件地址");

        byte[] getData = photoCertFile.fileBytes;

        File saveDir = new File("/Users/luv/Desktop/");
        if(!saveDir.exists()){
            saveDir.mkdir();
        }

        File file = new File(saveDir+File.separator+photoCertFile.fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if(fos!=null){
            fos.close();
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        boolean result = new SaveFile().saveFile();
    }





}
