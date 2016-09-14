package com.doc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.doc.entity.DocsFunction;
import com.doc.entity.DocsFunctionExample;

public interface DocsFunctionMapper {
    int countByExample(DocsFunctionExample example);

    int deleteByExample(DocsFunctionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DocsFunction record);

    int insertSelective(DocsFunction record);

    List<DocsFunction> selectByExampleWithBLOBs(DocsFunctionExample example);

    List<DocsFunction> selectByExample(DocsFunctionExample example);

    DocsFunction selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DocsFunction record, @Param("example") DocsFunctionExample example);

    int updateByExampleWithBLOBs(@Param("record") DocsFunction record, @Param("example") DocsFunctionExample example);

    int updateByExample(@Param("record") DocsFunction record, @Param("example") DocsFunctionExample example);

    int updateByPrimaryKeySelective(DocsFunction record);

    int updateByPrimaryKeyWithBLOBs(DocsFunction record);

    int updateByPrimaryKey(DocsFunction record);
}