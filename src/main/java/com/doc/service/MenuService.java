package com.doc.service;

import java.util.List;

import com.doc.entity.DocsMenu;

public interface MenuService extends BaseService<DocsMenu>{

	List<DocsMenu> selectAllByType(int type,String apiUrl,String apiName);

}
