<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>头部 - 文档管理系统</title>
<link href="${pageContext.request.contextPath}/docs/css/common.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/docs/js/jQuery.js"></script>
<script language="javascript">
$(function(){
$('.nav li').click(function(){
$(this).addClass("nav-slect").siblings().removeClass("nav-slect");
	})
 })
</script>
</head>

<body>
<div id="header">
    <div class="top clearfix">
     <div class="logo fl">文档管理系统</div>
     <div class="shezhi fr"> </div>
</div>
<div class="top-menu clearfix">
    <ul class="nav fl clearfix">
            <li class="nav-slect" ><a href="${pageContext.request.contextPath}/menu/list" target="leftFrame">接口文档</a></li>
            <li><a href="${pageContext.request.contextPath}/menu/list?type=1" target="leftFrame">功能文档</a></li>
        </ul>
 
        </div>
    </div>
    
</body>
</html>
