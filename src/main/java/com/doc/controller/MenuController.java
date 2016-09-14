package com.doc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.doc.service.MenuService;

/**
 * 接口文档api
 * @author tmp123
 *
 */

@Controller
@RequestMapping(value = "menu", produces = "application/json;charset=UTF-8")
public class MenuController extends BaseController{
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "list")
	public String list(Model model,@RequestParam(defaultValue="0")int type,@RequestParam(defaultValue="0")int way,String apiUrl,String apiName
			,String iwanttooperationapidocument){
		model.addAttribute("pageList",menuService.selectAllByType(type,apiUrl,apiName));
		model.addAttribute("apiUrl", apiUrl);
		model.addAttribute("apiName", apiName);
		model.addAttribute("iwanttooperationapidocument", iwanttooperationapidocument);
		if(way==1){
			return "api_table";
		}
		if(way==2){
			return "func_table";
		}
		if(type==1){
			return "funcDoc";
		}
		return "apiDocs";
	}
}
