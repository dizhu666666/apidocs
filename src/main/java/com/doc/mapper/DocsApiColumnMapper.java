package com.doc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.doc.entity.DocsApiColumn;
import com.doc.entity.DocsApiColumnExample;

public interface DocsApiColumnMapper {
    int countByExample(DocsApiColumnExample example);

    int deleteByExample(DocsApiColumnExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DocsApiColumn record);

    int insertSelective(DocsApiColumn record);

    List<DocsApiColumn> selectByExample(DocsApiColumnExample example);

    DocsApiColumn selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DocsApiColumn record, @Param("example") DocsApiColumnExample example);

    int updateByExample(@Param("record") DocsApiColumn record, @Param("example") DocsApiColumnExample example);

    int updateByPrimaryKeySelective(DocsApiColumn record);

    int updateByPrimaryKey(DocsApiColumn record);

	int deleteBYApidId(Long apiFuncId);
}