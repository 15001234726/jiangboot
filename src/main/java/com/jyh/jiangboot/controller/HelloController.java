package com.jyh.jiangboot.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class HelloController {


	@RequestMapping("/")
	public String hello() {
		return "Hello";
	}


	@RequestMapping("/zip")
	public void helloTemp(HttpServletResponse res) throws IOException {

		/**
		 * 传压缩包回前端
		 */
//		FileInputStream inputStream = new FileInputStream("/Users/luv/Desktop/合同demo.zip");
//		int i = inputStream.available();
//		byte[] buff = new byte[i];
//		inputStream.read(buff);
//		inputStream.close();
//		//设置发送到客户端的响应内容类型
//		res.setContentType("application/zip");
//		OutputStream out = res.getOutputStream();
//		out.write(buff);
//		//关闭响应输出流
//		out.close();

//
//		FileInputStream inputStream = new FileInputStream("/Users/luv/Desktop/整理大体技术 (1).pdf");
//		int i = inputStream.available();
//		byte[] buff = new byte[i];
//		inputStream.read(buff);
//		inputStream.close();
//		//设置发送到客户端的响应内容类型
//		res.setContentType("application/pdf");
//		OutputStream out = res.getOutputStream();
//		out.write(buff);
//		//关闭响应输出流
//		out.close();


//		ZipFile zipFile = new ZipFile("/Users/luv/Desktop/合同demo.zip", Charset.forName("gbk"));


		final String OUTPUT_FOLDER = "/Users/luv/Desktop/test";
		String FILE_PATH = "/Users/luv/Desktop/合同demo.zip";

		// 判断文件夹是否存在
		File folder = new File(OUTPUT_FOLDER);
		if (!folder.exists()) {
			folder.mkdir();
		}

		// 创建buffer
		byte[] buffer = new byte[1024];
		ZipInputStream zipls = null;

		try {
			zipls = new ZipInputStream(new FileInputStream(FILE_PATH), Charset.forName("GBK"));
			ZipEntry entry = null;
			while ((entry = zipls.getNextEntry()) != null) {
				String entryName = entry.getName();
				String outFileName = OUTPUT_FOLDER + File.separator + entryName;
				System.out.println("Unzip: " + outFileName);

				if (entry.isDirectory()) {
					new File(outFileName).mkdirs();
				} else {
					FileOutputStream fos = new FileOutputStream(outFileName);
					int len;
					while ((len = zipls.read(buffer)) > 0) {
						fos.write(buffer, 0, len);
					}
					fos.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				zipls.close();
			} catch (IOException e) {
				e.printStackTrace();
			}


//        ZipInputStream zin = null;
//        InputStream inputStream = null;
//        ServletOutputStream out = null;
//        int byteread;
//        byte data[] = new byte[1024];
//        try {
//            zin = new ZipInputStream(new FileInputStream("/Users/luv/Desktop/合同demo.zip"));
//
//            if (zin.getNextEntry() != null) inputStream = new BufferedInputStream(zin);
//            out = res.getOutputStream();
//            while ((byteread = inputStream.read(data)) != -1) {
//                out.write(data, 0, byteread);
//                out.flush();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (inputStream != null) {
//                try {
//                    inputStream.close();
//                } catch (Exception e1) {
//                    e1.printStackTrace();
//                }
//            }
//
//            if (zin != null) {
//                try {
//                    zin.close();
//                } catch (Exception e1) {
//                    e1.printStackTrace();
//                }
//            }
//            if (out != null) {
//                try {
//                    out.flush();
//                } catch (Exception e1) {
//                    e1.printStackTrace();
//                }
//            }
//            if (out != null) {
//                try {
//                    out.close();
//                } catch (Exception e1) {
//                    e1.printStackTrace();
//                }
//            }
//
//        }
		}
	}


//	public static void main(String[] args) {
//
//		for (ContractStatus value : ContractStatus.values()) {
//			System.out.println(value);
//			System.out.println(value.getValue());
//
//
//
//		}
//
//
//
//
//	}
//

}





