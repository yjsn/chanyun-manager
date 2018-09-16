package com.chanyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanyun.common.PageInfo;
import com.chanyun.dao.NewsMapper;
import com.chanyun.entity.News;
import com.chanyun.service.NewsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsMapper mapper;
	
	@Override
	public List<News> queryIndexNewsList() {
		List<News> result = mapper.selectIndexNews();
		return result;
	}

	@Override
	public PageInfo<News> queryNewsList(int pageNum,int pageSize,News news) {
		PageHelper.startPage(pageNum, pageSize);
		PageHelper.orderBy("create_time desc");
		Page<News> sqlResult = mapper.selectNewsByPage(news);
		PageInfo<News> result = new PageInfo<News>(sqlResult);
		return result;
	}

	@Override
	public boolean add(News news) {
		int i=mapper.insertSelective(news);
		if(i>0) return true;
		return false;
	}

	@Override
	public boolean edit(News news) {
		int i = mapper.updateByPrimaryKey(news);
		if(i>0) return true;
		return false;
	}

	@Override
	public News queryNewsById(int newsId) {;
		News news = mapper.selectByPrimaryKey(newsId);
		return news;
	}

}
