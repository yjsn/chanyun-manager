package com.chanyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanyun.common.PageInfo;
import com.chanyun.dao.MeritsProductMapper;
import com.chanyun.entity.MeritsProduct;
import com.chanyun.service.MeritsProductService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class MeritsProductServiceImpl implements MeritsProductService {
	@Autowired
	private MeritsProductMapper mapper;
	
	@Override
	public List<MeritsProduct> queryMeritsByTempleIdAndType(int meritsType,
			int templeId) {
		MeritsProduct params = new MeritsProduct();
		params.setMeritsType(meritsType);
		params.setTempleId(templeId);
		List<MeritsProduct> result = mapper.queryByParams(params);
		return result;
	}

	@Override
	public MeritsProduct queryById(int id) {
		MeritsProduct result = mapper.selectByPrimaryKey(id);
		return result;
	}

	@Override
	public PageInfo<MeritsProduct> queryByPage(int pageNum, int pageSize,
			MeritsProduct meritsProduct) {
		PageHelper.startPage(pageNum, pageSize);
		PageHelper.orderBy("create_time desc");
		Page<MeritsProduct> sqlResult = mapper.queryByPage(meritsProduct);
		PageInfo<MeritsProduct> result = new PageInfo<MeritsProduct>(sqlResult);
		return result;
	}

	@Override
	public MeritsProduct addMeritsProduct(MeritsProduct meritsProduct) {
		int i = mapper.insertSelective(meritsProduct);
		if(i > 0) return meritsProduct;
		return null;
	}

	@Override
	public boolean editMeritsProduct(MeritsProduct meritsProduct) {
		int i = mapper.updateByPrimaryKeySelective(meritsProduct);
		if(i > 0) return true;
		return false;
	}
	
	

}
