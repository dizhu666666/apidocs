package com.doc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.doc.entity.DocsApi;
import com.doc.entity.DocsApiExample;
import com.doc.entity.DocsApiWithBLOBs;

public interface DocsApiMapper {
    int countByExample(DocsApiExample example);

    int deleteByExample(DocsApiExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DocsApiWithBLOBs record);

    int insertSelective(DocsApiWithBLOBs record);

    List<DocsApiWithBLOBs> selectByExampleWithBLOBs(DocsApiExample example);

    List<DocsApi> selectByExample(DocsApiExample example);

    DocsApiWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DocsApiWithBLOBs record, @Param("example") DocsApiExample example);

    int updateByExampleWithBLOBs(@Param("record") DocsApiWithBLOBs record, @Param("example") DocsApiExample example);

    int updateByExample(@Param("record") DocsApi record, @Param("example") DocsApiExample example);

    int updateByPrimaryKeySelective(DocsApiWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DocsApiWithBLOBs record);

    int updateByPrimaryKey(DocsApi record);
}