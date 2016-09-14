package com.doc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doc.entity.DocsFunction;
import com.doc.entity.DocsMenu;
import com.doc.mapper.DocsFunctionMapper;
import com.doc.mapper.DocsMenuMapper;
import com.doc.po.ParamPo;
import com.doc.service.FunctionService;
import com.doc.util.TimeManager;

@Service
public class FunctionServiceImpl implements FunctionService{
	@Autowired
	DocsMenuMapper menuMapper;
	@Autowired
	DocsFunctionMapper funcMapper;
	
	@Override
	public int insertSelective(DocsFunction object,ParamPo paramPo) {
		funcMapper.insertSelective(object);
		DocsMenu menu=new DocsMenu();
		menu.setAddTime(TimeManager.currentTime());
		menu.setApiFuncId(object.getId());
		menu.setType(1);
		menu.setNote(object.getNote());
		menu.setTitle(object.getTitle());
		return menuMapper.insertSelective(menu);
	}

	@Override
	public DocsFunction selectByPKey(Long id) {
		DocsMenu menu=menuMapper.selectByPrimaryKey(id);
		return funcMapper.selectByPrimaryKey(menu.getApiFuncId());
	}

	@Override
	public int updateSelective(DocsFunction object,ParamPo paramPo) {
		 deleteById(paramPo.getMenuId());
		 return insertSelective(object, paramPo);
	}

	@Override
	public int deleteById(Long id) {
		DocsMenu menu=menuMapper.selectByPrimaryKey(id);
		if(menu.getType()!=1){
			return 0;
		}
		menuMapper.deleteByPrimaryKey(id);
		return funcMapper.deleteByPrimaryKey(menu.getApiFuncId());
	}

	 

}
