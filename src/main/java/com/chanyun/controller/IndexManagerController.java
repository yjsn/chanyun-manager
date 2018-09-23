package com.chanyun.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.chanyun.entity.IndexBanner;
import com.chanyun.entity.MerchantAccount;
import com.chanyun.entity.News;
import com.chanyun.service.IndexBannerService;
import com.chanyun.service.NewsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="首页管理接口",tags="首页管理接口")
@RestController
@RequestMapping("/api/indexManager")
public class IndexManagerController extends BaseController<Object>{
	@Autowired
	private IndexBannerService bannerService;
	@Autowired
	private NewsService newsService;
	
	@SuppressWarnings("unchecked")
	@ApiOperation("首页banner列表查询")
	@PostMapping("/indexBannerList")
	@ResponseBody
	public BaseResult<List<IndexBanner>> indexBannerList(){
		List<IndexBanner> result = bannerService.queryIndexBannerList();
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	
	@SuppressWarnings("unchecked")
	@ApiOperation("首页资讯列表查询")
	@PostMapping("indexNewsList")
	@ResponseBody
	public BaseResult<List<News>> indexNewsList(){
		List<News> result = newsService.queryIndexNewsList();
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("首页法会信息查询")
	@PostMapping("/religiousCeremonies")
	@ResponseBody
	public BaseResult<News> religiousCeremoniesList(){
		News news = new News();
		news.setNewsType(3);//法会类型资讯
		news.setNewsStatus(Constants.STATUS_ABLE);
		PageInfo<News> list = newsService.queryNewsList(1, 1, news);
		News result = new News();;
		if(list.getList().size()>0) result = list.getList().get(0);
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("banner列表查询")
	@PostMapping("/bannerList")
	@ResponseBody
	public BaseResult<PageInfo<IndexBanner>> bannerList(@RequestBody QueryParams<IndexBanner> request){
		PageInfo<IndexBanner> result = bannerService.queryIndexBannerByPage(request.getPageNum(),request.getPageSize(),request.getBean());
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("banner信息查询")
	@PostMapping("/bannerInfo")
	@ResponseBody
	public BaseResult<IndexBanner> bannerInfo(@RequestBody int bannerId){
		IndexBanner result = bannerService.queryIndexBannerById(bannerId);
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("banner信息添加")
	@PostMapping("/addBannerInfo")
	@ResponseBody
	public BaseResult<IndexBanner> addBannerInfo(@RequestBody IndexBanner request){
		request.setStatus(Constants.STATUS_ABLE);
		request.setCreateTime(new Date());
		IndexBanner result = bannerService.add(request);
		if(null==result) return returnBaseResult(Constants.RESULT_CODE_FAIL, "信息添加失败", result);
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "信息添加成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("banner信息修改")
	@PostMapping("/editBannerInfo")
	@ResponseBody
	public BaseResult<IndexBanner> editBannerInfo(@RequestBody IndexBanner request){
		boolean result = bannerService.edit(request);
		if(result) return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "信息修改成功", request);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "信息修改失败", null);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("banner信息启用接口")
	@PostMapping("/ableBannerInfo")
	@ResponseBody
	public BaseResult<IndexBanner> ableBannerInfo(@RequestBody int bannerId){
		IndexBanner indexBanner =  new IndexBanner();
		indexBanner.setId(bannerId);
		indexBanner.setStatus(Constants.STATUS_ABLE);
		boolean result = bannerService.edit(indexBanner);
		indexBanner=bannerService.queryIndexBannerById(bannerId);
		if(result) return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "信息修改成功", indexBanner);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "信息修改失败", null);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("banner信息禁用接口")
	@PostMapping("/disableBannerInfo")
	@ResponseBody
	public BaseResult<IndexBanner> disableBannerInfo(@RequestBody int bannerId){
		IndexBanner indexBanner =  new IndexBanner();
		indexBanner.setId(bannerId);
		indexBanner.setStatus(Constants.STATUS_DISABLE);
		boolean result = bannerService.edit(indexBanner);
		indexBanner=bannerService.queryIndexBannerById(bannerId);
		if(result) return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "信息修改成功", indexBanner);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "信息修改失败", null);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("banner信息删除接口")
	@PostMapping("/deleteBannerInfo")
	@ResponseBody
	public BaseResult<IndexBanner> deleteBannerInfo(@RequestBody int bannerId){
		IndexBanner indexBanner =  new IndexBanner();
		indexBanner.setId(bannerId);
		indexBanner.setStatus(Constants.STATUS_DELETE);
		boolean result = bannerService.edit(indexBanner);
		indexBanner=bannerService.queryIndexBannerById(bannerId);
		if(result) return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "信息删除成功", null);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "信息删除失败", null);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("分页查询资讯列表")
	@PostMapping("/newsList")
	@ResponseBody
	public BaseResult<PageInfo<News>> queryNewsList(@RequestBody QueryParams<News> request){
		PageInfo<News> result = newsService.queryNewsList(request.getPageNum(), request.getPageSize(), request.getBean());
		return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "查询成功", result);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("查询资讯信息")
	@PostMapping("/newsInfo")
	@ResponseBody
	public BaseResult<News> newsInfo(@RequestBody int newsId){
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
	public BaseResult<News> editNewsInfo(@RequestBody News news){
		boolean result = newsService.edit(news);
		if(result) return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "信息修改成功", news);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "信息修改失败", null);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("禁用资讯信息")
	@PostMapping("/disableNewsInfo")
	@ResponseBody
	public BaseResult<News> disableNewsInfo(@RequestBody News news){
		News updateNews = new News();
		updateNews.setId(news.getId());
		updateNews.setNewsStatus(Constants.STATUS_DISABLE);
		boolean result = newsService.edit(updateNews);
		news = newsService.queryNewsById(news.getId());
		if(result) return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "信息禁用成功", news);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "信息禁用失败", null);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("启用资讯信息")
	@PostMapping("/ableNewsInfo")
	@ResponseBody
	public BaseResult<News> ableNewsInfo(@RequestBody News request){
		News  news = new News();
		news.setId(request.getId());
		news.setNewsStatus(Constants.STATUS_ABLE);
		boolean result = newsService.edit(news);
		news = newsService.queryNewsById(request.getId());
		if(result) return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "信息启用成功", news);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "信息用户失败", null);
	}
	
	@SuppressWarnings("unchecked")
	@ApiOperation("删除资讯信息")
	@PostMapping("/deleteNewsInfo")
	@ResponseBody
	public BaseResult<News> deleteNewsInfo(@RequestBody News request){
		News  news = new News();
		news.setId(request.getId());
		news.setNewsStatus(Constants.STATUS_DELETE);
		boolean result = newsService.edit(news);
		news = newsService.queryNewsById(request.getId());
		if(result) return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "信息禁用成功", null);
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "信息禁用失败", null);
	}
}


