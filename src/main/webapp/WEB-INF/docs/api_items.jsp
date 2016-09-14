<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>${record.title }</title>
    <link href="${pageContext.request.contextPath}/docs/css/index.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/docs/css/line.css" rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/docs/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath}/docs/js/linetextarea.js"></script>
<script src="${pageContext.request.contextPath}/docs/js/jsformat.js"></script>
<script src="${pageContext.request.contextPath}/docs/js/jsparse.js"></script>
<script src="${pageContext.request.contextPath}/docs/js/jsoninit.js"></script>
</head>
 
<body>
<div id="content">
      <div >
    <div id="wstitle">
        <h1 class="header"><a href="#">${record.title }</a></h1>
    </div>
    <div class="wsdescription">
        相关说明:${record.note }    </div>
    <h2>请求示例</h2>
        <p class="sampleurl">
        [ 
        	<c:if test="${record.type==1 }">GET</c:if>
        	<c:if test="${record.type==2}">POST</c:if>
        	<c:if test="${record.type==3 }">PUT</c:if>
        	<c:if test="${record.type==4 }">DELETE</c:if>
            ]
            
            <a target="_blank" href= "#">
               ${record.content } ${record.url } </a>
            <br/>
            <br/>
            
            请求参数:  
             <textarea style="width: 100%; outline:none;" rows="20"   spellcheck="false" >${record.request }</textarea>
        </p>
 		
                       
        <input type="hidden" name="api_method" value="GET"/>
 
        <table id="desc_zmk">
            <tr>
                <th width="15%">参数名</th>
                <th>类型</th>
                <th>说明</th>
            </tr>
            <c:forEach items="${columns }" var="record">
            <c:if test="${record.type==0 }">
                            <tr>
                    <td> ${record.coTitle }</td> <td> ${record.coType }</td><td> ${record.coNote }</td>   
                </tr>
                </c:if>
              </c:forEach>
                    </table>
    
    <h2>返回示例</h2>
 		  <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <span>返回结果json</span>
                        </div>
                        <div class="panel-body" style="position: relative;">
 
                            <div class="row">
                                <div class="col-lg-12">
                                    <textarea style="width: 100%; outline:none;" rows="20" id="json_input" spellcheck="false" placeholder='请输入需要格式化的json字符串'>${record.response}</textarea>
                                </div>
                            </div>

                            <div style="height: 10px;"></div>
                            
                            <div class="row">
                                <div class="col-lg-12">
                                    <button type="button" class="btn btn-outline btn-primary variable">格式化</button>
                                    <button type="reset" class="btn btn-outline btn-danger clear">清空</button>
                                </div>
                            </div>
         			   </div>
       			 </div>
			</div>
        <table id="desc_zmk">
            <tr>
                <th width="15%">参数名</th>
                <th>类型</th>
                <th>说明</th>
            </tr>
                      <c:forEach items="${columns }" var="record">
            <c:if test="${record.type==1 }">
                            <tr>
                    <td> ${record.coTitle }</td> <td> ${record.coType }</td><td> ${record.coNote }</td>   
                </tr>
                </c:if>
              </c:forEach>
                    </table>
          
</div>
</div>
</body>
</html>