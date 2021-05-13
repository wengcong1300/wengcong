<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	pageContext.setAttribute("root", basePath);
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>荣耀电子竞技管理系统</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="${root }static/lib/layui/css/layui.css"  media="all">
  <style type="text/css">
  .layui-form{
  width: 90%;
  }
  </style>
</head>
<body>
 
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
  <legend>建立赛事</legend>
</fieldset>
 
<form class="layui-form" action="" lay-filter="example">
  <div class="layui-form-item">
    <label class="layui-form-label">比赛名称</label>
    <div class="layui-input-block">
      <input type="text" id="gamename" name="gamename"  required="required" lay-verify="title" autocomplete="off" placeholder="请输入比赛名称" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">比赛描述</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入比赛描述" id="miaoshu"  required="required"  class="layui-textarea" name="miaoshu"></textarea>
    </div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">比赛规则</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入比赛规则" id="guize" required="required" class="layui-textarea" name="guize"></textarea>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">建赛用户</label>
    <div class="layui-input-block">
      <input type="text" name="" readonly="readonly"  value="${user.email}" autocomplete="off" class="layui-input">
    </div>
  </div>

  <div class="layui-form-item">
    <div class="layui-input-block">
      <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
    </div>
  </div>
</form>

          
<script src="${root }static/lib/layui/layui.js" charset="utf-8"></script>
<script src="${root}static/js/x-layui.js" charset="utf-8"></script>
<script src="${root}static/js/jquery.min.js"></script>
<script type="text/javascript">
	$(".layui-form").submit(function(){
		var gamename=$("#gamename").val();
		var miaoshu=$("#miaoshu").val();
		var guize=$("#guize").val();
		var params="gamename="+gamename+"&"+"miaoshu="+miaoshu+"&"+"guize="+guize; 
		console.log(params);
		$.ajax({
			   type: "POST",
			   url: "${root}tzs/sjjs/insertBuildinfo.action",
			   data: params,
			   success: function(msg){
				   if(msg.code==1){
					   alert(msg.message);
					   x_admin_close();
					   parent.location.href=parent.location.href;
					   }
				   else{
					   alert(msg.message);
					   //parent.location.href=parent.location.href;
					   }
			   }
			}); 		
		return false;
		});
</script>
</body>
</html>