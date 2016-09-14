 
var editor;
KindEditor.ready(function(K) {
	editor = K.create('textarea[name="content"]', {
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
		
	 