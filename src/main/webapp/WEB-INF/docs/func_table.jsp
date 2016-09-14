<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>出售中的商品</title>
<link href="${pageContext.request.contextPath}/docs/css/common.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/docs/css/shangpin.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/docs/js/jQuery.js"></script>
<script>
$(function(){
if($("#controller").val()==1){
	$("div[name=oprationapi]").show();
}
var cookies = document.cookie ? document.cookie.split('; ') : [];
var i = 0;
for (; i < cookies.length; i++) {
	if(cookies[i].split("=")[0]=="iwangto"){
		$("div[name=oprationapi]").show();
	}else{
		
	}
}
});
function  change(){
	if($.trim($("input[name=apiUrl]").val())=="iwanttooperationapidocument"){
		document.cookie="iwangto=iwangto";
		$("div[name=oprationapi]").show();
	}	
}
</script>
</head>

<body>
<input value="${iwanttooperationapidocument }" type="hidden" name="iwanttooperationapidocument" id="controller"/>
<div class="right-ct">
<form action="${pageContext.request.contextPath}/menu/list?type=1&way=2" method="post">
<div class="search-form clearfix">
<ul class="search-ul fl clearfix">
<li><div class="input-prepend">
<span class="add-on" >功能名称</span>
<span><input class="un-input wd3" type="text" placeholder="功能名称" value="${apiName }" name="apiName"/>
</span>
</div></li>
</ul>
<div class="fl"><input type="submit" name="button" class="mini-btn" id="button" value="搜索" /></div>

</div>
</form>
<div class="table-toolbar clearfix" name="oprationapi" style="display:none;">
<a class="btn-group" href="${pageContext.request.contextPath}/func/add" >
<i class="icon icon-plus"></i>新增</a> 
</div>
<div class="sp-list">
<table  class="table table-bordered table-striped centered dataTable">
<thead>
<tr role="row">
 
<th width="35%">功能名称</th>
<th width="35%">简要描述</th>
<th width="5%">状态</th>
<th width="10%">操作</th>
</tr>
</thead>

<tbody >
<c:forEach items="${pageList }" var="record" varStatus="count">
<tr id="tr${record.id }" <c:if test="${count.count%2==1 }">class="odd"</c:if><c:if test="${count.count%2==0 }">class="even"</c:if>>
 
<td class="">
${record.title }
</td>
<td class="">${record.note }
</td>
<td class=""><c:if test="${record.status==1 }">废弃</c:if>
<c:if test="${record.status==0 }">正常</c:if>
</td>
 
<td class="">
<div class="ccbtn-group ">
<a class="btn-group" href="${pageContext.request.contextPath}/func/item?id=${record.id }"><i class="icon icon-pencil"></i>查看</a>
<div name="oprationapi" style="display:none;">
<a class="btn-group" href="${pageContext.request.contextPath}/func/edit?id=${record.id }"><i class="icon icon-pencil"></i>编辑</a>
<a class="btn-group" href="javascript:removeFuncItem('${record.id }')"><i class="icon icon-pencil"></i>删除</a>
</div>
</div>
</td>
</tr>
</c:forEach>
 </tbody ></table>
<script>
function  removeFuncItem(id){
	$.ajax({
		   type: "POST",
		   url: "${pageContext.request.contextPath}/func/del",
		   data: {"id":id},
		   dataType:"json",
		   success: function(data){
		     if(data.result>0){
		    	  $("#tr"+id).remove();
		     } 
		   }
	});
}
</script>

</div>
</div>
</body>
</html>