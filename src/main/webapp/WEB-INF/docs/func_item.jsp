<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>docs管理系统</title>
<link href="${pageContext.request.contextPath}/docs/css/common.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/docs/css/shangpin.css" rel="stylesheet" type="text/css" />
<script charset="utf-8" src="${pageContext.request.contextPath}/docs/js/jQuery.js"></script>
</head>
<body>
<div class="right-ct">
<div class="search-form">
<div class="t-name1">
  <h3>文档信息</h3>
</div>
<div class="form-content mt-10"><table class="form" border="0">
  <tr>
 <td class="label-td">
<label> 功能文档名称：</label>
</td>
    <td><input type="text" name="title"  value="${record.title }" id="textfield" class="input1 wd2" /> </td>
  </tr>
    
  <tr>
   <td class="label-td"><label><span class="red">*</span>详细介绍：</label></td>
    <td> ${record.content }</td>
  </tr><tbody ></table>
  </div>
  </div>
<div class="fb-btn"><input type="submit" name="button2" id="button2" value="返回列表"  onclick="location.href='${pageContext.request.contextPath}/menu/list?way=2&type=1'" class="fb-button"  /></div>
</div>
</body> 
</html>