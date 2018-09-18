package com.chanyun.utils;
 
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

/**
* <p>Title: OSSUtil.java</p>  

* <p>Description:图片上传至阿里OSS云库工具类 </p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年9月17日 

* @version 1.0
 */
public class OSSUtil {
  private  String endpoint ;//oss服务配置参数
  private  String accessKeyId;//这里是你的授权KeyId
  private  String accessKeySecret;//这里是你的授权秘钥
  private  String bucketName;
  /**
   * OSS的文件夹名
   */
  private  String objectName;//这里是你存放图片的文件夹名
  
 /**
  * 
  * @param endpoint oss服务配置参数
  * @param accessKeyId 这里是你的授权KeyId
  * @param accessKeySecret 这里是你的授权秘钥
  * @param bucketName 请求url头
  * @param path 文件存储路径
  * @param url 请求url
  */
  public OSSUtil(String endpoint, String accessKeyId, String accessKeySecret,
		String bucketName, String objectName) {
	super();
	this.endpoint = endpoint;
	this.accessKeyId = accessKeyId;
	this.accessKeySecret = accessKeySecret;
	this.bucketName = bucketName;
	this.objectName = objectName;
}


/**
   * 上传图片
   * @param fileName 文件名
   * @param inputStream 流
   */
  @SuppressWarnings("deprecation")
public String uploadImageToOSS(MultipartFile file) {
    /**
     * 创建OSS客户端
     */
    OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    try {
      //根据时间生成文件名称
      String fileName = file.getOriginalFilename();
      String name = UploadUtil.getFileNameByTime(fileName);
     PutObjectResult result= ossClient.putObject(new PutObjectRequest(bucketName, objectName+name, file.getInputStream()));
     if("".equals(result.getETag()))
      return null;
     return "https://"+bucketName+"."+endpoint+"/"+objectName+name;
    } catch (Exception e) {
      e.printStackTrace();
      System.err.println(e.getMessage());
    } finally {
      ossClient.shutdown();
    }
    return null;
  }
 
 
  /**
   * 多图上传
   */
  @SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
public String[] uploadImageToOSS(String[] fileNames, InputStream[] inputStreams) {
    /**
     * 创建OSS客户端
     */
    OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    try {
      ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue(
          Arrays.asList(fileNames));
      ConcurrentLinkedQueue<InputStream> streamConcurrentLinkedQueue = new ConcurrentLinkedQueue<InputStream>(
          Arrays.asList(inputStreams));
      Iterator<InputStream> inputStreamss = streamConcurrentLinkedQueue.iterator();
      ConcurrentLinkedQueue c = new ConcurrentLinkedQueue();
      for (Iterator<String> iterator = concurrentLinkedQueue.iterator();
          iterator.hasNext() && inputStreamss.hasNext(); ) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String[] names = iterator.next().split("[.]");
        String name = uuid + "." + names[names.length - 1];
        ossClient.putObject(new PutObjectRequest(bucketName, objectName + name, inputStreamss.next()));
        c.add(bucketName + objectName + name);
      }
      return (String[]) c.toArray(new String[0]);
    } catch (Exception e) {
      e.printStackTrace();
      System.err.println(e.getMessage());
    } finally {
      ossClient.shutdown();
    }
    return null;
  }
 
 
  /**
   * 删除图片 警告：在没有调用其他方法的情况下，请调用closeClient方法
   *
   * @param url URL全路径
   */
  public void deleteImg(String url) {
    OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    if (url == null || "".equals(url)) {
      return;
    }
    String[] paths = url.split("[.]");
    /**
     * 文件夹是否存在
     */
    if (!ossClient.doesObjectExist(bucketName, objectName)) {
      ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(new byte[0]));
    }
    String[] name = paths[paths.length - 2].split("[/]");
    /**
     * 对象是否存在
     */
    if (ossClient
        .doesObjectExist(bucketName,
        		objectName + name[name.length - 1] + "." + paths[paths.length - 1])) {
      /**
       * 删除存在对象
       */
      ossClient
          .deleteObject(bucketName, objectName + name[name.length - 1] + "." + paths[paths.length - 1]);
    }
    ossClient.shutdown();
  }
  
}
