package com.doc.service;

import com.doc.po.ParamPo;

public interface BaseService<T> {

	int insertSelective(T object,ParamPo paramPo);

	T selectByPKey(Long id);

	int updateSelective(T object,ParamPo paramPo);

	int deleteById(Long id);

}
