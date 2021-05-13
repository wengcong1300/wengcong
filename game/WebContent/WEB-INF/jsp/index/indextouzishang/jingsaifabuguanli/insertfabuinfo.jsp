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
  <legend>发布赛事</legend>
</fieldset>

<div style="text-align: center">
	<h1>发布规则</h1>
	<p>1.报名时长与竞赛时长至少要大于2天，报名结束阶段与竞赛开始阶段至少多于3天</p>
	<p>2.报名开始时间 小于 报名结束时间 小于 竞赛开始时间 小于 竞赛结束时间</p>
	<p>3.报名开始时间或结束时间与已发布的时间冲突，两阶段至少相差5小时</p>
</div>
 
<form class="layui-form" action="" lay-filter="example">
  <div class="layui-form-item">
    <label class="layui-form-label">比赛名称</label>
    <div class="layui-input-block">
      <input type="text" id="gamename" name="gamename" readonly="readonly" value="${buildinfo.gamename}" lay-verify="title"   class="layui-input">
    </div>
  </div>
  
 <div class="layui-form-item">
    <label class="layui-form-label">报名开始时间</label>
    <div class="layui-input-block">
      <input type="datetime-local" id="time1"  name="time1" required="required"  class="layui-input">
    </div>
  </div>
   
  <div class="layui-form-item">
    <label class="layui-form-label">报名结束时间</label>
    <div class="layui-input-block">
    	<input type="datetime-local" id="time2"  name="time2"  required="required"  class="layui-input"/>
  	</div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">比赛开始时间</label>
    <div class="layui-input-block">
      <input type="datetime-local" id="time3"  name="time3" required="required"  class="layui-input">
    </div>
  </div>
   
  <div class="layui-form-item">
    <label class="layui-form-label">比赛结束时间</label>
    <div class="layui-input-block">
    	<input type="datetime-local" id="time4"  name="time4"  required="required"  class="layui-input"/>
  	</div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">参赛名额</label>
    <div class="layui-input-block">
      <input type="text" id="number" name="number" required="required"  lay-verify="title"   class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">奖金</label>
    <div class="layui-input-block">
      <input type="text" id="money" name="money" required="required"  lay-verify="title"   class="layui-input">
    </div>
  </div>
    <input type="hidden" name="buildinfo" id="buildinfo" value="${buildinfo}" autocomplete="off" class="layui-input">
	<input type="hidden" name="userid" id="userid" value="${user.id}" autocomplete="off" class="layui-input">
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
<script src="${root}static/js/jquery.js" charset="utf-8"></script>
<script src="${root}static/js/date.format.js" charset="utf-8"></script>
<script src="${root}static/js/jquery.min.js"></script>
<script type="text/javascript">
	$(".layui-form").submit(function(){
		var buildid=${buildinfo.buildid}
		var time11=$("#time1").val();
		var time12=$("#time2").val();
		var time13=$("#time3").val();
		var time14=$("#time4").val();
		var userid=$("#userid").val();
		var number=$("#number").val();
		var money=$("#money").val();
/* 		var timeStamp = new Date(oTimer.value).getTime(); */
		var time1 = new Date(time11).format("Y-m-d H:i:s");
		var time2 = new Date(time12).format("Y-m-d H:i:s");
		var time3 = new Date(time13).format("Y-m-d H:i:s");
		var time4 = new Date(time14).format("Y-m-d H:i:s");
		var params="buildid="+buildid+"&"+"time1="+time1+"&"+"time2="+time2
		+"&"+"time3="+time3+"&"+"time4="+time4+"&"+"userid="+userid+"&"+"number="+number+"&"+"money="+money;  
		console.log(params);
		$.ajax({
			   type: "POST",
			   url: "${root}tzs/jsfb/insertfabuinfo.action",
			   data: params,
			   success: function(msg){
				   if(msg.code==1){
					   alert(msg.message);
					   x_admin_close();
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