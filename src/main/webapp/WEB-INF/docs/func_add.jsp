<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>功能文档</title>
<link href="${pageContext.request.contextPath}/docs/css/common.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/docs/css/shangpin.css" rel="stylesheet" type="text/css" />
<script charset="utf-8" src="${pageContext.request.contextPath}/docs/js/jQuery.js"></script>
<!--文本编辑器  开始-->
	<style>
			form {
				margin: 0;
			}
			textarea {
				display: block;
			}
		</style>
		<script charset="utf-8" src="${pageContext.request.contextPath}/docs/kindeditor-4.1.7/kindeditor-min.js"></script>
		<script charset="utf-8" src="${pageContext.request.contextPath}/docs/kindeditor-4.1.7/lang/zh_CN.js"></script>
		<script>
var editor;
KindEditor.ready(function(K) {
	editor = K.create('textarea[name="content"]', {
		resizeType : 2,
		urlType: 'domain',
		shadowMode : false,
		allowPreviewEmoticons : false,
		allowImageUpload : true,
		allowFlashUpload : false,
		uploadJson : '${pageContext.request.contextPath}/func/upload',
		indentChar : '',
		afterCreate : function(){
			K.ctrl(this.edit.iframe.get(0).contentWindow.document, 13, function() {
				$("wmd-input").parent().submit();
			});
		},
		afterChange : function() {
			this.sync();
		},
		
		items : ['bold', 'italic', 'underline', 'strikethrough', 'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'formatblock', 'insertorderedlist', 'insertunorderedlist', '|','forecolor',
				 'hilitecolor', 'fontname', 'fontsize', '|','link', 'unlink', 'emoticons', 'shcode', 'image', 'flash', 'table', 'quote', '|', 'fullscreen', 'source', 'about'],
		
		htmlTags:
		{
			script : ['src'],
            font : ['color', 'size', 'face', '.background-color'],
            span : [
                    '.color', '.background-color', '.font-size', '.font-family', '.background',
                    '.font-weight', '.font-style', '.text-decoration', '.vertical-align', '.line-height'
            ],
            div : [
                    'align', '.border', '.margin', '.padding', '.text-align', '.color',
                    '.background-color', '.font-size', '.font-family', '.font-weight', '.background',
                    '.font-style', '.text-decoration', '.vertical-align', '.margin-left'
            ],
            table: [
                    'border', 'cellspacing', 'cellpadding', 'width', 'height', 'align', 'bordercolor',
                    '.padding', '.margin', '.border', 'bgcolor', '.text-align', '.color', '.background-color',
                    '.font-size', '.font-family', '.font-weight', '.font-style', '.text-decoration', '.background',
                    '.width', '.height', '.border-collapse'
            ],
            'td,th': [
                    'align', 'valign', 'width', 'height', 'colspan', 'rowspan', 'bgcolor',
                    '.text-align', '.color', '.background-color', '.font-size', '.font-family', '.font-weight',
                    '.font-style', '.text-decoration', '.vertical-align', '.background', '.border'
            ],
            a : ['href', 'target', 'name'],
            embed : ['src', 'width', 'height', 'type', 'loop', 'autostart', 'quality', '.width', '.height', 'align', 'allowscriptaccess'],
            img : ['src', 'width', 'height', 'border', 'alt', 'title', 'align', '.width', '.height', '.border'],
            'p,ol,ul,li,blockquote,h1,h2,h3,h4,h5,h6' : [
                    'align', '.text-align', '.color', '.background-color', '.font-size', '.font-family', '.background',
                    '.font-weight', '.font-style', '.text-decoration', '.vertical-align', '.text-indent', '.margin-left'
            ],
            pre : ['class'],
            hr : ['class', '.page-break-after'],
            'br,tbody,tr,strong,b,sub,sup,em,i,u,strike,s,del' : []
		}
    });
});
		
		</script>
		<!--文本编辑器  结束-->



</head>

<body>
<div class="right-ct">
 <form action="${pageContext.request.contextPath}/func/${action}" method="post">
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
   <td class="label-td"><label>额外说明：</label></td>
    <td> <textarea name="note" style="  width:840px; height:380px;"class="textarea-t">${record.note }</textarea></td>
  </tr>
  <tr>
   <td class="label-td"><label><span class="red">*</span>详细介绍：</label></td>
    <td> <textarea name="content" style="visibility:hidden; width:840px; height:380px;"class="textarea-t">${record.content }</textarea></td>
  </tr><tbody ></table>
  </div>
  </div>
 <input type="hidden" name="id" value="${record.id }"/>
 <input type="hidden" name="menuId" value="${id }"/>
<div class="fb-btn"><input type="submit" name="button2" id="button2" value="确定提交"  class="fb-button"  /></div>
</form>
</div>
</body>
</html>

