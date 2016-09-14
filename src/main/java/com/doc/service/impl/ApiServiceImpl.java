package com.doc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.doc.entity.DocsApi;
import com.doc.entity.DocsApiColumn;
import com.doc.entity.DocsApiColumnExample;
import com.doc.entity.DocsApiExample;
import com.doc.entity.DocsApiWithBLOBs;
import com.doc.entity.DocsMenu;
import com.doc.mapper.DocsApiColumnMapper;
import com.doc.mapper.DocsApiMapper;
import com.doc.mapper.DocsMenuMapper;
import com.doc.po.ParamPo;
import com.doc.service.ApiService;
import com.doc.util.TimeManager;
@Service
public class ApiServiceImpl implements ApiService{
	@Autowired
	DocsApiMapper apiMapper;
	@Autowired
	DocsApiColumnMapper apiColumnMapper;
	@Autowired
	DocsMenuMapper docMenuMapper;

	@Override
	public List<DocsApi> selectAllByCondition(String apiUrl, String apiName) {
		DocsApiExample example=new DocsApiExample();
		DocsApiExample.Criteria criteria=example.createCriteria();
		if(!StringUtils.isEmpty(apiName)){
			criteria.andTitleLike("%"+apiName+"%");
		}
		if(!StringUtils.isEmpty(apiUrl)){
			criteria.andUrlLike("%"+apiUrl+"%");
		}
		example.setDistinct(true);
		example.setOrderByClause("status,id");
		return apiMapper.selectByExample(example);
	}

	@Override
	public int updateSelective(DocsApiWithBLOBs object,ParamPo paramPo) {
		deleteById(paramPo.getMenuId());
		return  insertSelective(object, paramPo);
	}
	@Override
	public int deleteById(Long id) {
		DocsMenu menu=docMenuMapper.selectByPrimaryKey(id);
		int a=docMenuMapper.deleteByPrimaryKey(id);
		int b=apiColumnMapper.deleteBYApidId(menu.getApiFuncId());
		return apiMapper.deleteByPrimaryKey(menu.getApiFuncId());
	}


	@Override
	public int insertSelective(DocsApiWithBLOBs object,ParamPo paramPo) {
		apiMapper.insertSelective(object);
		int time=TimeManager.currentTime();
		
		DocsMenu menu=new DocsMenu();
		menu.setAddTime(time);
		menu.setType(0);
		menu.setTitle(object.getTitle());
		menu.setUrl(object.getContent()+object.getUrl());
		menu.setApiFuncId(object.getId());
		docMenuMapper.insertSelective(menu);
		
		if(!StringUtils.isEmpty(paramPo.getReqColumn())){
			List<DocsApiColumn> columns=JSON.parseArray(paramPo.getReqColumn(), DocsApiColumn.class);
			for(DocsApiColumn column:columns){
				column.setAddTime(time);
				column.setApiId(object.getId());
				column.setType(0);
				apiColumnMapper.insertSelective(column);
			}
			
		}
		if(!StringUtils.isEmpty(paramPo.getResColumn())){
			List<DocsApiColumn> columns=JSON.parseArray(paramPo.getResColumn(), DocsApiColumn.class);
			for(DocsApiColumn column:columns){
				column.setAddTime(time);
				column.setApiId(object.getId());
				column.setType(1);
				apiColumnMapper.insertSelective(column);
			}
		}
		return 1;
	}


	@Override
	public DocsApiWithBLOBs selectByPKey(Long id) {
		DocsMenu menu=docMenuMapper.selectByPrimaryKey(id);
		DocsApiWithBLOBs blobs=apiMapper.selectByPrimaryKey(menu.getApiFuncId());
		blobs.setColumns(selectAllByApiId(menu.getApiFuncId()));
		return blobs;
	}

	@Override
	public List<DocsApiColumn> selectAllByApiId(Long id) {
		DocsApiColumnExample example=new DocsApiColumnExample();
		example.createCriteria().andApiIdEquesl(id);
		return apiColumnMapper.selectByExample(example);
	}
 

}
