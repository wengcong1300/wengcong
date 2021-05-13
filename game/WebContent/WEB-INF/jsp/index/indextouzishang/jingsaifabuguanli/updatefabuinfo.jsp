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
  <legend>修改已发布赛事</legend>
</fieldset>
 
<form class="layui-form" action="" lay-filter="example">
  <div class="layui-form-item">
    <label class="layui-form-label">比赛名称</label>
    <div class="layui-input-block">
      <input type="text" id="gamename" name="gamename" value="${fabuinfo.gamename}" readonly="readonly" required="required" lay-verify="title" autocomplete="off" placeholder="请输入比赛名称" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">比赛描述</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入比赛描述" id="miaoshu"   required="required" class="layui-textarea" name="miaoshu">${fabuinfo.miaoshu}</textarea>
    </div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">比赛规则</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入比赛规则" id="guize"  required="required" class="layui-textarea" name="guize">${fabuinfo.guize}</textarea>
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">建赛用户</label>
    <div class="layui-input-block">
      <input type="text" name="email" readonly="readonly"  value="${user.email}" autocomplete="off" class="layui-input">
    </div>
  </div>
  
 <div class="layui-form-item">
    <label class="layui-form-label">报名开始时间</label>
    <div class="layui-input-block">
      <input type="datetime-local" id="time1"    name="time1" value="<fmt:formatDate value="${fabuinfo.time1}" pattern="yyyy-MM-dd'T'hh:mm"/>"  required="required"  class="layui-input">
    </div>
  </div>
   
  <div class="layui-form-item">
    <label class="layui-form-label">报名结束时间</label>
    <div class="layui-input-block">
    	<input type="datetime-local" id="time2"   name="time2" value="<fmt:formatDate value="${fabuinfo.time2}" pattern="yyyy-MM-dd'T'hh:mm"/>" required="required"  class="layui-input"/>
  	</div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">比赛开始时间</label>
    <div class="layui-input-block">
      <input type="datetime-local" id="time3"    name="time3" value="<fmt:formatDate value="${fabuinfo.time3}" pattern="yyyy-MM-dd'T'hh:mm"/>" required="required"  class="layui-input">
    </div>
  </div>
   
  <div class="layui-form-item">
    <label class="layui-form-label">比赛结束时间</label>
    <div class="layui-input-block">
    	<input type="datetime-local" id="time4"    name="time4" value="<fmt:formatDate value="${fabuinfo.time4}" pattern="yyyy-MM-dd'T'hh:mm"/>"  required="required"  class="layui-input"/>
  	</div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">参赛名额</label>
    <div class="layui-input-block">
      <input type="text" id="number" name="number" value="${fabuinfo.number}" required="required"  lay-verify="title"   class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">参赛名额</label>
    <div class="layui-input-block">
      <input type="text" id="money" name="money" value="${fabuinfo.money}" required="required"  lay-verify="title"   class="layui-input">
    </div>
  </div>
	<input type="hidden" name="userid" id="userid" value="${user.id}" autocomplete="off" class="layui-input">
	<input type="hidden" name="id" id="id" value="${fabuinfo.id}" autocomplete="off" class="layui-input">
	<input type="hidden" name="buildid" id="buildid" value="${fabuinfo.buildid}" autocomplete="off" class="layui-input">
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
		var id=$("#id").val();
		var gamename=$("#gamename").val();
		var miaoshu=$("#miaoshu").val();
		var guize=$("#guize").val();
		var email=$("#email").val();
		var time11=$("#time1").val();
		var time12=$("#time2").val();
		var time13=$("#time3").val();
		var time14=$("#time4").val();
		var userid=$("#userid").val();
		var buildid=$("#buildid").val();
		var number=$("#number").val();
		var money=$("#money").val();
/* 		var timeStamp = new Date(oTimer.value).getTime(); */
		var time1 = new Date(time11).format("Y-m-d H:i:s");
		var time2 = new Date(time12).format("Y-m-d H:i:s");
		var time3 = new Date(time13).format("Y-m-d H:i:s");
		var time4 = new Date(time14).format("Y-m-d H:i:s");
		var params="id="+id+"&"+"buildid="+buildid+"&"+"gamename="+gamename+"&"+"miaoshu="+miaoshu
		+"&"+"guize="+guize+"&"+"email="+email
		+"&"+"time1="+time1+"&"+"time2="+time2
		+"&"+"time3="+time3+"&"+"time4="+time4
		+"&"+"userid="+userid+"&"+"number="+number+"&"+"money="+money; 
		console.log(params);
		$.ajax({
			   type: "POST",
			   url: "${root}tzs/jsfb/fabuxiugai.action",
			   data: params,
			   success: function(msg){
				   if(msg.code==1){
					   alert(msg.message);
					   x_admin_close();
					   parent.location.href=parent.location.href;
					   }
				   else if(msg.code==-1){
					   alert(msg.message);
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