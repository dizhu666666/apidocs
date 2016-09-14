// JavaScript Document
$(function(){
	/***********批量操作***********/
	 $('.plcz').hover(function(){
	$(this).find('.dropdown-menu').show();
	},function(){
	$(this).find('.dropdown-menu').hide();
	})
	
	/***********搭配套餐上传照片、短信服务***********/
	$('.pic-allul li').click(function(){ $(this).addClass("pic-sel").siblings().removeClass(); $(".upload-cont > div").hide().eq($('.pic-allul li').index(this)).show() 
}); 
/***********站内信***********/
	 $('.message-list .message-content').hover(function(){
	$(this).find('.remove').show();
	},function(){
	$(this).find('.remove').hide();
	})
	
		/***********销售额总览  统计说明***********/		
		 $('.tjsm-all ').hover(function(){
	$(this).find('.tip-body').show();
	},function(){
	$(this).find('.tip-body').hide();
	})	
	})