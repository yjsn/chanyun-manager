package com.chanyun.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.web.multipart.MultipartFile;

@ApiModel("文件上传请求参数")
public class UploadParams {
	@ApiModelProperty(value="上传文件类型：img 图片，excel,word,img,pdf")
	private String type;
	@ApiModelProperty(value="文件流")
	private MultipartFile file;
	@ApiModelProperty(value="文件目录 indexBanner 首页banner图片，news 资讯封面图，temple 寺庙主页图片")
	private String folder;
	@ApiModelProperty(value="寺庙id,非寺庙类图片上传，不需要传此参数")
	private int templeId;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getTempleId() {
		return templeId;
	}

	public void setTempleId(int templeId) {
		this.templeId = templeId;
	}
	
	
}
