package com.chanyun.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import springfox.documentation.annotations.ApiIgnore;

import com.chanyun.common.BaseResult;
import com.chanyun.common.Constants;
import com.chanyun.utils.OSSUtil;
import com.chanyun.utils.UploadUtil;

@Controller
@RequestMapping("/api/upload")
@Api(value="上传文件接口",tags="上传文件接口")
public class UploadController extends BaseController<Object>{
	@Autowired
	private Environment en;
	
	private String endpoint;
	private String accessKeyId;
	private String accessKeySecret;
	private String bucketName;
	private String objectName;
	
	@RequestMapping("/upload")
	@ResponseBody
	@ApiIgnore
    public BaseResult<String> upload(HttpServletResponse resp,	
                         @RequestParam("file")MultipartFile file) throws IOException {

        BaseResult<String> result = UploadUtil.singleUpload(file, "G:\\新建文件夹\\uploadTest");
        return result;
      }
	
	@SuppressWarnings("unchecked")
	@ApiOperation("上传文件")
	@PostMapping("/oss")
	@ResponseBody
	public BaseResult<String> uploadOss(
			@ApiParam(value="上传文件类型：img 图片，excel,word,img") @RequestParam("type")String type,
			@ApiParam(value="文件目录 indexBanner 首页banner图片，news 资讯封面图，temple 寺庙主页图片") @RequestParam("folder")String folder,
			@ApiParam(value="寺庙id,非寺庙类图片上传，此参数可为空值") @RequestParam("templeId")int templeId,
			@ApiParam(value="上传文件") @RequestParam("file") MultipartFile file){
		endpoint=en.getProperty("oss.endpoint");
		accessKeyId=en.getProperty("oss.accessKeyId");
		accessKeySecret=en.getProperty("oss.accessKeySecret");
		bucketName=en.getProperty("oss.bucketName");
		if("img".equals(type)){//图片上传
			if("indexBanner".equals(folder)){//首页轮播图
				objectName=en.getProperty("oss.img.indexBanner");
			}else if("news".equals(folder)){//资讯封面图
				objectName=en.getProperty("oss.img.indexBanner");
			}else if("temple".equals(folder)){//寺庙主页图片
				objectName=en.getProperty("oss.img.indexBanner")+templeId+"/";
			}else{
				return returnBaseResult(Constants.RESULT_CODE_CHECK_FAIL, "参数验证失败", "");
			}
		}else{
			return returnBaseResult(Constants.RESULT_CODE_CHECK_FAIL, "上传失败，目前只支付图片上传", "");
		}
		//上传图片
		OSSUtil ossUtil = new OSSUtil(endpoint, accessKeyId, accessKeySecret, bucketName, objectName);
		String result =ossUtil.uploadImageToOSS(file);
		if(null == result) return returnBaseResult(Constants.RESULT_CODE_FAIL, "上传失败", result);
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "上传成功", result);
	}
}
