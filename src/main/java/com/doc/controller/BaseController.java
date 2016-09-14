package com.doc.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doc.po.ParamPo;
import com.doc.service.BaseService;
import com.doc.util.HttpMethodUtil;
import com.doc.util.HttpRequestUtil;

/**
 * 接口文档api
 * @author tmp123
 *
 */

@Controller
public class BaseController<T> {
private Logger logger=LoggerFactory.getLogger(this.getClass());
	BaseService<T> baseService;
	
	String add="";
	String doAdd="";
	String edit="";
	String doEdit="";
	
	@RequestMapping(value = "/", produces = "application/json;charset=UTF-8")
	public String index(){
		return "index";
	}
	@RequestMapping(value = "top", produces = "application/json;charset=UTF-8")
	public String top(){
		return "top";
	}
	@RequestMapping(value = "welcome", produces = "application/json;charset=UTF-8")
	public String menu(){
		return "welcome";
	}
	
	
	@RequestMapping(value = "add", produces = "application/json;charset=UTF-8")
	public String add(Model model){
		model.addAttribute("action", "doAdd");
		return add;
	}
	@RequestMapping(value = "doAdd", produces = "application/json;charset=UTF-8")
	public String doAdd(Model model,T object,ParamPo paramPo){
		baseService.insertSelective(object,paramPo);
		return doAdd;
	}
	@RequestMapping(value = "edit", produces = "application/json;charset=UTF-8")
	public String edit(Model model,Long id){
		model.addAttribute("id", id);
		model.addAttribute("action", "doEdit");
		model.addAttribute("record",baseService.selectByPKey(id));
		return edit;
	}
	@RequestMapping(value = "doEdit", produces = "application/json;charset=UTF-8")
	public String doEdit(Model model,T object,ParamPo paramPo){
		baseService.updateSelective(object,paramPo);
		return doEdit;
	}
	@RequestMapping(value = "del", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, Object> del(Model model,Long id){
		Map<String, Object> map=new HashMap<>();
		map.put("result", baseService.deleteById(id));
		return map;
	}
	@RequestMapping(value = "getJson", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, Object> getJson(Model model,String url,int type,String reqbody){
		logger.debug(url+"-----"+HttpMethodUtil.codeToMethod(type)+"-----"+reqbody);
		Map<String, Object> map=new HashMap<>();
		map.put("success",1);
		String data="";
		switch (type) {
		case 1:
			if(reqbody.startsWith("?")){
				url+=reqbody;
			}else{
				url+="?"+reqbody;
			}
			data=HttpRequestUtil.doGet(url);
			break;
		case 2:
			data=HttpRequestUtil.doPost(url,reqbody,null);
			break;
		case 3:
			data=HttpRequestUtil.doPut(url,reqbody,null);
			break;
		case 4:
			data=HttpRequestUtil.doDelete(url,reqbody,null);
			break;
		default:
			break;
		}
		map.put("data", data);
		return map;
	}
}
