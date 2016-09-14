package com.doc.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.doc.entity.DocsFunction;
import com.doc.service.FunctionService;
import com.doc.util.TimeManager;

/**
 * 业务功能文档
 * @author tmp123
 *
 */
@Controller
@RequestMapping(value = "func", produces = "application/json;charset=UTF-8")
public class FunctionController extends BaseController<DocsFunction>{
	
	private FunctionService funcService;
	
	public FunctionService getFuncService() {
		return funcService;
	}
	@Autowired
	public void setFuncService(FunctionService funcService) {
		this.funcService = funcService;
		super.baseService=funcService;
	}
	public FunctionController() {
		add="func_add";
		doAdd="redirect:/menu/list?way=2&type=1";
		edit="func_add";
		doEdit="redirect:/menu/list?way=2&type=1";
	}
	@RequestMapping(value = "item")
	public String item(Model model,long id){
		model.addAttribute("record", funcService.selectByPKey(id));
		return "func_item";
	}
	 @RequestMapping("upload")
	 @ResponseBody
	public Map<String, Object> uploadcom(HttpServletResponse response ,HttpServletRequest request,MultipartFile imgFile){
		 Map<String, Object> map=new HashMap<>();
		 try {
			String msg=ajaximag("upload",imgFile,request);
			if(msg.startsWith("http:")){
				map.put("error", 0);
				map.put("url",msg);
			}else{
				map.put("error", 1);
				map.put("message",msg);
			}
			 return map;
		} catch (Exception e) {
		}
		 return map;
	}
		 
		
		private String ajaximag(String foldname,MultipartFile imgfile,HttpServletRequest request){
			try {
				//原始名称
				String originalFilename = imgfile.getOriginalFilename();
				//上传图片
				if(imgfile!=null && originalFilename!=null && originalFilename.length()>0){
					String msg="";
					String imgtype=originalFilename.substring(originalFilename.lastIndexOf("."));
					if(imgfile.getSize()>1024*1024*2){
						msg="图片大小超过规定数值!";
					}else if(".jpg".equals(imgtype)
							|| ".peg".equals(imgtype)
							|| ".png".equals(imgtype)
							|| ".jpng".equals(imgtype)
							|| ".jpeg".equals(imgtype)
							|| ".pjpeg".equals(imgtype)
							|| ".x-png".equals(imgtype)
							|| ".gif".equals(imgtype)){
						String spe="/";
						String foldstr="i"+spe+TimeManager.getInstance().getYear() + spe
								+ TimeManager.getInstance().getMonth() ;
						String filename=UUID.randomUUID().toString().replaceAll("-","")+imgtype;
						String nativeStr=request.getSession().getServletContext().getRealPath("")+"../"; 
						
						File fold=new File(nativeStr+foldstr);
						if(!fold.exists()){
							fold.mkdirs();
						}
						File newFile = new File(fold,filename);
						imgfile.transferTo(newFile);
						msg=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"+foldstr+"/"+filename;
					}else{
						msg="图片格式错误";
					}
					return msg;
				}
			} catch (IllegalStateException e) {
			} catch (IOException e) {
			}
					return "";
		 }
}
