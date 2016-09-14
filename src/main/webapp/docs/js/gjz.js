// JavaScript Document
//查找关键字
function s_focus(){ 
//捕获触发事件的对象，并设置为以下语句的默认对象 
with(event.srcElement) 
     //如果当前值为默认值，则清空 
if(value==defaultValue) {value="" ;event.srcElement.style.color = '#333333';}
else{event.srcElement.style.color = '#333333';}
} 
function s_blur(){ 
//捕获触发事件的对象，并设置为以下语句的默认对象 
with(event.srcElement) 
//如果当前值为空，则重置为默认值
if(value=="") {value=defaultValue ;event.srcElement.style.color = '#999999';}
else{event.srcElement.style.color = '#333333';}
}