<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>${record.title }</title>
    <link href="${pageContext.request.contextPath}/docs/css/common.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/docs/css/shangpin.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/docs/css/index.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/docs/css/line.css" rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/docs/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath}/docs/js/linetextarea.js"></script>
<script src="${pageContext.request.contextPath}/docs/js/jsformat.js"></script>
<script src="${pageContext.request.contextPath}/docs/js/jsparse.js"></script>
<script src="${pageContext.request.contextPath}/docs/js/jsoninit.js"></script>
<script charset="utf-8" src="${pageContext.request.contextPath}/docs/kindeditor-4.1.2/kindeditor-min.js"></script>
		<script charset="utf-8" src="${pageContext.request.contextPath}/docs/kindeditor-4.1.2/lang/zh_CN.js"></script>
<script  >
var editor;
KindEditor.ready(function(K) {
	editor = K.create('textarea[name="request"]', {
		themeType : 'oschina',
		resizeType : 2,
		urlType: 'domain',
		shadowMode : false,
		allowPreviewEmoticons : false,
		allowImageUpload : true,
		allowFlashUpload : false,
		uploadJson : '/assistant/manage/photoupload.jhtml?act=website&upfrom=editor',
		indentChar : '',
		afterCreate : function(){
			K.ctrl(this.edit.iframe.get(0).contentWindow.document, 13, function() {
				$("wmd-input").parent().submit();
			});
		},
		afterChange : function() {
			this.sync();
		},
		items : [],
    });
});
</script>
</head>
 
<body>
<form action="${pageContext.request.contextPath}/api/doAdd" method="post">
<div class="right-ct">


<div class="search-form">
<div class="t-name1">
  <h3>其他</h3>
</div>
<div class="form-content mt-10"><table   class="form" border="0">
  <tr>
	 <td class="label-td">
	<label>接口名称：</label>
	</td>
	    <td><input type="text" name="title"  class="input1 wd2" /><span class="gray_9"></span></td><td></td>
  </tr>
  <tr>
   <td class="label-td"><label>额外说明：</label></td>
    <td> <textarea name="note" style="  width:840px; height:380px;"class="textarea-t"></textarea></td>
  </tr>
</table></div></div>

<div class="search-form">
<div class="t-name1">
  <h3>请求信息</h3>
</div>
<div class="form-content mt-10"><table class="form" border="0" id="reqtab">
  <tr>
 <td class="label-td">
<label>prefix：</label>
</td>
    <td><input type="text" name="content"  class="input1 wd2" /><span class="gray_9">http://www.baidu.com</span></td>
  </tr>
  <tr>
   <td class="label-td">
<label>路径url：</label>
</td>
    <td><input type="text" name="url" id="textfield" class="input1 wd2" /><span class="gray_9">/live/living</span></td>
  </tr>
  <tr>
  <td class="label-td">
<label>访问方式：</label>
</td>
   <td  >
 	 <select name="type" id="select" class="select1 wd4">
             <option value="1">GET</option>
             <option value="2">POST</option>
             <option value="3">PUT</option>
             <option value="4">DELETE</option>
        </select>
 	</td>
  </tr>
  <tr>
   <td class="label-td"><label>请求数据：</label></td>
    <td> <textarea name="request" style="visibility:hidden; width:840px; height:380px;"class="textarea-t">如:a=1&b=2</textarea></td>
  </tr>
   <tr>
   <td class="label-td"><label>字段说明：</label></td>
    <td><span class="input1 wd2" style="border:0px;">字段名称</span><span class="input1 wd4" style="border:0px;">类型</span><span class="input1 wd2" style="border:0px;">注释</span><input type="button" name="reqtab" class="fb-button"  value="添加字段"/></td>
  </tr>
   <tr class="column">
   <td class="label-td"> </td>
    <td> <input type="text" name="co_title" id="textfield" class="input1 wd2" />
      <select name="co_type" id="select" class="select1 wd4">
             <option value="int">int</option>
             <option value="float">float</option>
             <option value="double">double</option>
             <option value="long">long</option>
             <option value="string">string</option>
        </select>
    <input type="text" name="co_note" id="textfield" class="input1 wd2" /><input type="button" onclick="rmline(this)"  class="btn btn-outline btn-primary variable" value="删除" /> </td>
  </tr>
  
</table></div></div>
<script>
$(function(){
	$("input[type=button]").bind("click",function(){
		var tr=$(this).parents("tr").next().clone();
		tr.appendTo("#"+$(this).attr("name"));
	});
	$("#submit").bind("click",function(){
		var reqjson="[";
		var resjson="[";
		$("#reqtab").find("tr.column").each(function(){
			var title=$(this).find("input[name=co_title]").val();
			var note=$(this).find("input[name=co_note]").val();
			var type=$(this).find("select  option:selected").val();
			reqjson+='{"coTitle":"'+title+'","coType":"'+type+'","coNote":"'+note+'"}';
		});
		reqjson+="]";
		$("#restab").find("tr.column").each(function(){
			var title=$(this).find("input[name=co_title]").val();
			var note=$(this).find("input[name=co_note]").val();
			var type=$(this).find("select  option:selected").val();
			resjson+='{"coTitle":"'+title+'","coType":"'+type+'","coNote":"'+note+'"}';
		});
		resjson+="]";
		 $("input[name=reqColumn]").val(reqjson);
		 $("input[name=resColumn]").val(resjson);
	});
}) 
function rmline(obj){
	
	if($(obj).parents("table").find("tr.column").length==1){
		alert("不允许全部删除");
		return ;
	}
	$(obj).parents("tr").remove();
}
function sendhttp(){
	var url=$.trim($("input[name=content]").val())+$.trim($("input[name=url]").val());
	var type=$("#select option:selected").val();
	var reqbody=$.trim($("textarea[name=request]").html());
	if(url==""){
		alert("请输入路径");
		return ;
	}
	$.ajax({
		   type: "POST",
		   url: "${pageContext.request.contextPath}/getJson",
		   data: {"url":url,"type":type,"reqbody":reqbody},
		   dataType:"json",
		   success: function(data){
		     if(data.success==1){
		    	  $("textarea[name=response]").html(data.data);
		     } 
		   }
	});
}

</script>
<div class="search-form">
<div class="t-name1">
  <h3>响应信息</h3>
</div>
<div class="form-content mt-10"><table id="restab"  class="form" border="0">
  
  <tr>
   <td class="label-td"><label>请求接口：</label></td>
    <td><input type="button"  value="发送请求"  class="fb-button" onclick="javascript:sendhttp();"  />  
     </td>
  </tr>
  <tr>
   <td class="label-td"><label>返回数据：</label></td>
    <td><textarea name="response" style="width: 100%; outline:none;" rows="20" id="json_input" spellcheck="false" placeholder='请输入需要校验的json字符串'></textarea>
                                    <button type="button" class="btn btn-outline btn-primary variable">校验</button>
                             </td>
  </tr>
  					
   <tr>
   <td class="label-td"><label>字段说明：</label></td>
    <td><span class="input1 wd2" style="border:0px;">字段名称</span><span class="input1 wd4" style="border:0px;">类型</span><span class="input1 wd2" style="border:0px;">注释</span><input type="button" name="restab" class="fb-button"  value="添加字段"/></td>
  </tr>
   <tr class="column">
   <td class="label-td"> </td>
    <td> <input type="text" name="co_title" id="textfield" class="input1 wd2" />
      <select name="co_type" id="select" class="select1 wd4">
             <option value="int">int</option>
             <option value="float">float</option>
             <option value="double">double</option>
             <option value="long">long</option>
             <option value="string">string</option>
        </select>
    <input type="text" name="co_note" id="textfield" class="input1 wd2" /><input type="button" onclick="rmline(this)"  class="btn btn-outline btn-primary variable" value="删除" /> </td>
  </tr>
  
</table></div></div>

<input type="hidden" name="reqColumn" value=""/>
<input type="hidden" name="resColumn" value=""/>

</div>
<div class="fb-btn"><input type="submit" id="submit"  value="确定提交"  class="fb-button"  /></div>
</form>
</body>
</html>