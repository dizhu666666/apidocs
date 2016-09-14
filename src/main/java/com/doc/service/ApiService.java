package com.doc.service;

import java.util.List;

import com.doc.entity.DocsApi;
import com.doc.entity.DocsApiColumn;
import com.doc.entity.DocsApiWithBLOBs;

public interface ApiService extends BaseService<DocsApiWithBLOBs>{

	List<DocsApi> selectAllByCondition(String apiUrl, String apiName);

	List<DocsApiColumn> selectAllByApiId(Long id);
}
