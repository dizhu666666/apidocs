package com.doc.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doc.entity.DocsMenu;
import com.doc.entity.DocsMenuExample;
import com.doc.mapper.DocsMenuMapper;
import com.doc.po.ParamPo;
import com.doc.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService{
	 
	@Autowired
	DocsMenuMapper menuApiMapper;
	
	@Override
	public List<DocsMenu> selectAllByType(int type,String apiUrl,String apiName) {
		DocsMenuExample example=new DocsMenuExample();
		DocsMenuExample.Criteria criteria= example.createCriteria().andTypeEqualTo(type);
		if(!StringUtils.isEmpty(apiUrl)){
			criteria.andUrlLike("%"+apiUrl+"%");
		}
		if(!StringUtils.isEmpty(apiName)){
			criteria.andTitleLike("%"+apiName+"%");
		}
		return menuApiMapper.selectByExample(example);
	}

	@Override
	public int insertSelective(DocsMenu object, ParamPo paramPo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DocsMenu selectByPKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateSelective(DocsMenu object,ParamPo paramPo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	 

}
