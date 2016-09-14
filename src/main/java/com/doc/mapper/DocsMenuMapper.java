package com.doc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.doc.entity.DocsMenu;
import com.doc.entity.DocsMenuExample;

public interface DocsMenuMapper {
    int countByExample(DocsMenuExample example);

    int deleteByExample(DocsMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DocsMenu record);

    int insertSelective(DocsMenu record);

    List<DocsMenu> selectByExample(DocsMenuExample example);

    DocsMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DocsMenu record, @Param("example") DocsMenuExample example);

    int updateByExample(@Param("record") DocsMenu record, @Param("example") DocsMenuExample example);

    int updateByPrimaryKeySelective(DocsMenu record);

    int updateByPrimaryKey(DocsMenu record);
}