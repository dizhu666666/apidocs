package com.doc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doc.entity.DocsApiColumn;
import com.doc.entity.DocsApiWithBLOBs;
import com.doc.service.ApiService;

/**
 * 接口文档api
 * @author tmp123
 *
 */

@Controller
@RequestMapping(value = "api", produces = "application/json;charset=UTF-8")
public class ApiController extends BaseController<DocsApiWithBLOBs>{
	private ApiService apiService;
	public ApiService getApiService() {
		return apiService;
	}
	@Autowired
	public void setApiService(ApiService apiService) {
		super.baseService=apiService;
		this.apiService = apiService;
	}
	public ApiController(){
		add="api_add";
		doAdd="redirect:/menu/list?way=1";
		edit="api_edit";
		doEdit="redirect:/menu/list?way=1";
	}
	
	@RequestMapping(value = "list",method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
	public String list(Model model,HttpServletRequest request,
			String apiUrl,String apiName){
		model.addAttribute("pageList", apiService.selectAllByCondition(apiUrl,apiName));
		return "apiDocs";
	}
	
 
	
	@RequestMapping(value = "item")
	public String item(Model model,Long id){
		if(id==null){
			id=0L;
		}
		DocsApiWithBLOBs api= apiService.selectByPKey(id);
		
		model.addAttribute("columns",api.getColumns());
		model.addAttribute("record",api);
		return "api_item";
	}
	
	
}
