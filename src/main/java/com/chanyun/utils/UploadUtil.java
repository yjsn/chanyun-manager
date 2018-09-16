package com.chanyun.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.chanyun.common.BaseResult;
import com.chanyun.common.Constants;

/**
* <p>Title: UploadUtil.java</p>  

* <p>Description: 文件上传</p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月11日 

* @version 1.0
 */
@Slf4j
public class UploadUtil {
	/**
	 * 单文件上传
	 * @param file
	 * @param savePath
	 * @return
	 */
	public static BaseResult<String> singleUpload(MultipartFile file,String savePath){
		if(file.isEmpty()){
			return new BaseResult<String>(Constants.RESULT_CODE_CHECK_FAIL,"文件上传失败，文件内容为空","");
		}
		String saveFileName = getFileNameByTime(file.getOriginalFilename());
		File saveFile = new File(new File(savePath) , saveFileName);
		//检测上传路径是否存在，不存在创建路径
		if(!saveFile.getParentFile().exists()){
			saveFile.getParentFile().mkdirs();
		}
		BufferedOutputStream out;
		try {
			out = new BufferedOutputStream(new FileOutputStream(saveFile));
			out.write(file.getBytes());
	        out.flush();
	        out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.error("文件上传失败,"+e.getMessage());
			return new BaseResult<String>(Constants.RESULT_CODE_CHECK_EXCEPTION,"文件上传失败,"+e.getMessage(),"");
		} catch (IOException e) {
			e.printStackTrace();
			log.error("文件上传失败,"+e.getMessage());
			return new BaseResult<String>(Constants.RESULT_CODE_CHECK_EXCEPTION,"文件上传失败,"+e.getMessage(),"");
		}
		
		return new BaseResult<String>(Constants.RESULT_CODE_SUCCESS,"文件上传成功",saveFile.getPath());
	}
	
	/**
	 * 多文件上传
	 * @param files  文件流
	 * @param savePath  上传路径
	 * @return
	 */
	public static BaseResult<String> uploadFiles(HttpServletRequest request,String savePath){
		File savePathFile = new File(savePath);
		if(!savePathFile.exists()){
			savePathFile.mkdirs();
		}
		//获取上传文件流
		List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
		MultipartFile file = null;
		BufferedOutputStream stream = null;
		for (int i = 0; i < files.size(); i++) {
			file = files.get(i);
			if(file.isEmpty()){
				return new BaseResult<String>(Constants.RESULT_CODE_CHECK_FAIL,"文件上传失败，第"+i+"文件内容为空","");
			}
			try {
                byte[] bytes = file.getBytes();
                File saveFile = new File(savePathFile, getFileNameByTime(file.getOriginalFilename()));
                stream = new BufferedOutputStream(new FileOutputStream(saveFile));
                stream.write(bytes);
                stream.close();
            } catch (Exception e) {
                if (stream != null) {
                    try {
						stream.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						log.warn("文件流关闭失败");
					}
                    stream = null;
                }
                return new BaseResult<String>(Constants.RESULT_CODE_CHECK_EXCEPTION,"文件上传失败,第 " + i + " 个文件上传有错误" + e.getMessage(),"");
            }

			
		}
		return new BaseResult<String>(Constants.RESULT_CODE_SUCCESS,"文件上传成功","");
	}
	
	/**
	 * 
	 * @Title: getFileNameByTime   
	 * @Description: TODO(根据时间生成文件名称)   
	 * @param: @param fileName 原有文件名
	 * @param: @return      
	 * @return: String    返回新生成文件名  
	 * @throws
	 */
	public static String getFileNameByTime(String fileName){
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		return DateUtil.getCurrentTimeMillis()+suffix;
	}
	
}
