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
  <title>后台管理系统</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <!-- <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"> -->
  <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="format-detection" content="telephone=no">
  <!--<script type="text/javascript" src="/static/xiyuan/lib/loading/okLoading.js"></script>-->
  <link rel="stylesheet" href="${root}static/css/x-admin.css" media="all">
</head>

<body>
<div class="layui-layout layui-layout-admin">
  <div class="layui-header header header-demo">
    <div class="layui-main">
      <div class="admin-logo-box">
        <a class="logo" href="" title="logo">电子竞技管理系统</a>
        <div class="larry-side-menu">
          <i class=" layui-icon iconfont" aria-hidden="true">&#xe661;</i>
        </div>
      </div>


      <ul class="layui-nav" lay-filter="" >
        <!-- <li class="layui-nav-item" id="time" style="margin-right:30px;font-size: 20px;color: #2fb9d4;font-family: 'yjsz'"></li> -->
        <li class="layui-nav-item">
          <a href="" title="首页">
            <i class="iconfont" style="top: 1px;">&#xe657;首页</i>
          </a>
        </li>
        <li class="layui-nav-item" id="tou"><img src="${userinfo.touxiang}" class="layui-circle" style="border: 2px solid #A9B7B7;" width="35px" height="35px" alt=""></li>
        <li class="layui-nav-item"> <a href="javascript:;">${user.email}</a>
          <dl class="layui-nav-child">
            <!-- 二级菜单 --> 
            <dd><a href="javascript:;"  onclick="geren()">个人信息</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
         <a href="${root}qt/logout.action" onclick="tologout()">退出</a>
        </li>
      </ul>
    </div>
  </div>

  <!--左侧导航区域-->
  <div class="layui-side layui-bg-black x-side show_list" style="left:0px;" id="table1">
    
    <div class="layui-side-scroll">
      <ul class="layui-nav layui-nav-tree site-demo-nav" lay-filter="side">
        <li class="layui-nav-item"> <a class="javascript:;" > <i class="layui-icon iconfont" style="top: 3px;">&#xe66b;</i><cite>用户信息</cite> </a>
          <dl class="layui-nav-child">
            <dd class="">
            <dd class=""> <a href="javascript:;" _href="${root}ht/selxinxi.action"> <cite>个人信息</cite> </a> </dd>
            </dd>
            <dd class="">
            <dd class=""> <a href="javascript:;" _href="${root}ht/toxiugaimima.action"> <cite>修改密码</cite> </a> </dd>
            </dd>
          </dl>
        </li>
        <li class="layui-nav-item"> <a class="javascript:;" href="javascript:;"> <i class="layui-icon iconfont" style="top: 3px;">&#xe64c;</i><cite>竞赛信息管理</cite> </a>
          <dl class="layui-nav-child">
            <dd class="">
            <dd class=""> <a href="javascript:;" _href="${root}ht/selkebaoming.action"> <cite>可报名竞赛</cite> </a> </dd>
            </dd>
            <dd class="">
            <dd class=""> <a href="javascript:;" _href="${root}ht/seldaikaishiall.action"> <cite>即将开始竞赛</cite> </a> </dd>
            </dd>
             <dd class="">
            <dd class=""> <a href="javascript:;" _href="${root}ht/selectgameover.action"> <cite>已结束竞赛</cite> </a> </dd>
            </dd>
          </dl>
        </li>
        <li class="layui-nav-item"> <a class="javascript:;" href="javascript:;"> <i class="layui-icon iconfont" style="top: 3px;">&#xe67d;</i><cite>个人竞赛管理</cite> </a>
          <dl class="layui-nav-child">
          	<dd class="">
            <dd class=""> <a href="javascript:;" _href="${root}ptyh/xianshibaoming.action"> <cite>个人报名记录</cite> </a> </dd>
            </dd>
            <dd class="">
            <dd class=""> <a href="javascript:;" _href="${root}ptyh/gerencansai.action"> <cite>个人参赛记录</cite> </a> </dd>
            </dd>
            <dd class="">
            <dd class=""> <a href="javascript:;" _href="${root}ptyh/selectgerenhuojiang.action"> <cite>个人获奖记录</cite> </a> </dd>
            </dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>


  <div class="layui-tab layui-tab-card site-demo-title x-main" lay-filter="x-tab" lay-allowclose="true" style="left: 220px;border-left: solid 2px #2299ee;">
    <ul class="layui-tab-title">
      <li class="layui-this"> 主页 <i class="layui-icon layui-unselect layui-tab-close">ဆ</i> </li>
    </ul>
    <div class="layui-tab-content site-demo site-demo-body">
      <div class="layui-tab-item layui-show">
        <iframe name="content"  frameborder="0" src="${root}ht/welcome.action" class="x-iframe"></iframe>
      </div>
    </div>
  </div>
  <div class="site-mobile-shade"> </div>

</div>

<script src="${root}static/lib/layui/layui.js" charset="utf-8"></script>
<script src="${root}static/js/x-admin.js"></script>
<script src="${root}static/js/jquery.min.js"></script>
<script src="${root}static/js/x-layui.js" charset="utf-8"></script>
<script type="text/javascript">
	$(window).load(function(){  
		//var cid=${colleges.cid};
		//var email=$("#email").val();
		var email="${user.email}";
		if(email==""){
			alert("还没有登录，请返回登录");
			window.location.href="${root}qt/tologin.action";
			}
		else{
			$.ajax({
				   type: "POST",
				   url: "${root}ht/userifo.action",
				   data: "",
				   success: function(msg){
					   if(msg.code==1){
						   }
					   else{
						   alert(msg.message);
						   x_admin_show('用户信息','${root}ht/toxinxi.action','400','450');
						   }
				   }
				}); 	
				return false;
			}
	});
</script>		

<script>
		function geren(){
			$.ajax({
		 		   type: "POST",
		 		   url: "${root}ht/userifo.action",
		 		   data: "",
		 		   success: function(msg){
		 			   if(msg.code==1){
		 				  x_admin_show('用户信息','${root}ht/selxinxi.action','400','450');
		 				   }
		 			   else{
		 				   alert(msg.message);
		 				   x_admin_show('用户信息','${root}ht/toxinxi.action','400','450');
		 				   x_admin_close();
		 				   //window.location.href="${root}ht/toxinxi.action";
		 				   }
		 		   }
		 		}); 	
		 		return false;
		  }
    	
</script>
<script>
    layui.use(['laydate','element','laypage','layer'], function(){
        $ = layui.jquery;//jquery
        laydate = layui.laydate;//日期插件
        lement = layui.element();//面包导航
        laypage = layui.laypage;//分页
        layer = layui.layer;//弹出层
        //以上模块根据需要引入

    });

    function member_show(title,url,id,w,h){
      x_admin_show(title,url,w,h);
    }
    function memberset_show(title,url,id,w,h){
        x_admin_show(title,url,w,h);
      }
</script>
<script>
    //顶部时间
    function getTime(){
        var myDate = new Date();
        var myYear = myDate.getFullYear(); //获取完整的年份(4位,1970-????)
        var myMonth = myDate.getMonth()+1; //获取当前月份(0-11,0代表1月)
        var myToday = myDate.getDate(); //获取当前日(1-31)
        var myDay = myDate.getDay(); //获取当前星期X(0-6,0代表星期天)
        var myHour = myDate.getHours(); //获取当前小时数(0-23)
        var myMinute = myDate.getMinutes(); //获取当前分钟数(0-59)
        var mySecond = myDate.getSeconds(); //获取当前秒数(0-59)
        var week = ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'];
        var nowTime;

        nowTime = myYear+'-'+fillZero(myMonth)+'-'+fillZero(myToday)+'&nbsp;&nbsp;'+fillZero(myHour)+':'+fillZero(myMinute)+':'+fillZero(mySecond)+'&nbsp;&nbsp;'+week[myDay]+'&nbsp;&nbsp;';
        //console.log(nowTime);
        $('#time').html(nowTime);
    };
    function fillZero(str){
        var realNum;
        if(str<10){
            realNum	= '0'+str;
        }else{
            realNum	= str;
        }
        return realNum;
    }
    setInterval(getTime,1000);
</script>

</body>
</html>