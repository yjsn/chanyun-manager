package com.chanyun.controller;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chanyun.common.BaseResult;
import com.chanyun.utils.UploadUtil;

import springfox.documentation.annotations.ApiIgnore;


@Controller
@RequestMapping("/")
@ApiIgnore
public class AppController {

	@RequestMapping("/upload")
	@ResponseBody
    public BaseResult<String> upload(HttpServletResponse resp,	
                         @RequestParam("file")MultipartFile file) throws IOException {

        BaseResult<String> result = UploadUtil.singleUpload(file, "G:\\新建文件夹\\uploadTest");
        return result;
      }	
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
}
