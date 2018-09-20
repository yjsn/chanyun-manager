package com.chanyun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chanyun.common.BaseResult;
import com.chanyun.common.Constants;
import com.chanyun.common.PageInfo;
import com.chanyun.common.QueryParams;
import com.chanyun.entity.MerchantAccount;
import com.chanyun.entity.News;
import com.chanyun.service.NewsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="寺庙通告信息接口")
@RestController
@RequestMapping("/api/templeNews")
public class TempleNewsController extends BaseController<Object> {
	@Autowired
	private NewsService newsService;
	
	@SuppressWarnings("unchecked")
	@ApiOperation("查询资讯信息")
	@PostMapping("/newsInfo")
	@ResponseBody
	public BaseResult<News> newsInfoById(@RequestBody int newsId){
		News result = newsService.queryNewsById(newsId);
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("添加资讯信息")
	@PostMapping("/addNewsInfo")
	@ResponseBody
	public BaseResult<News> addNewsInfo(@RequestBody News news,HttpServletRequest request){
		HttpSession session = request.getSession();
		MerchantAccount account = (MerchantAccount) session.getAttribute("merchantAccount");
		news.setNewsTempleid(account.getTempleId());
		News result = newsService.add(news);
		if(result!=null) return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "信息添加成功", result);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "信息添加失败", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("修改资讯信息")
	@PostMapping("/editNewsInfo")
	@ResponseBody
	public BaseResult<News> editNewsInfo(@RequestBody News news,HttpServletRequest request){
		HttpSession session = request.getSession();
		MerchantAccount account = (MerchantAccount) session.getAttribute("merchantAccount");
		if(account.getTempleId().compareTo(news.getNewsTempleid())!=0){
			return returnBaseResult(Constants.RESULT_CODE_CHECK_FAIL, "此账户无权限修信息", null);
		}
		boolean result = newsService.edit(news);
		if(result) return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "信息修改成功", news);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "信息修改失败", null);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("分页查询资讯列表")
	@PostMapping("/newsList")
	@ResponseBody
	public BaseResult<PageInfo<News>> queryNewsList(@RequestBody QueryParams<News> request,HttpServletRequest httpRequest){
		HttpSession session = httpRequest.getSession();
		MerchantAccount account = (MerchantAccount) session.getAttribute("merchantAccount");
		News news = request.getBean();
		news.setNewsTempleid(account.getTempleId());
		PageInfo<News> result = newsService.queryNewsList(request.getPageNum(), request.getPageSize(),news);
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
}
