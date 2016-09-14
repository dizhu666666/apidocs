<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>菜单项</title>
<link href="${pageContext.request.contextPath}/docs/css/common.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/docs/js/jQuery.js"></script>
<script language="javascript">
$(function(){
$('.lfmenu li h3').toggle(function(){
$(this).next().fadeOut(400);
	},function(){
	$(this).next().fadeIn(400);	
		})
	//左侧菜单点击效果
$('.lfmenu li ul a').click(function () {
$('.lfmenu li ul li').removeClass("current");
$(this).parent("li").addClass("current");
});
 })
</script>
</head>

<body>
<div id="leftmenu">
<div class="sidenav-wrapper">
<ul class="lfmenu">
<li>

<h3>接口文档</h3>
<ul style="display: block;">
<li class="current"><a target="mainFrame" href="${pageContext.request.contextPath}/menu/list?way=1">首页列表</a></li>
<c:forEach items="${pageList }" var="record">
<c:if test="${record.status==0 }">
<li><a target="mainFrame" href="${pageContext.request.contextPath}/api/item?id=${record.id }">${record.title }</a></li>
</c:if>
</c:forEach>
</ul>
</li>
</ul>
 

</div>


</div>

</body>
</html>

