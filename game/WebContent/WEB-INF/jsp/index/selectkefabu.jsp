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
        <title>
            竞赛管理系统
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="${root}static/css/x-admin.css" media="all">
    </head>
    <body>
        <%-- <div class="x-nav">
            <span class="layui-breadcrumb">
              <a><cite>首页</cite></a>
              <a><cite>竞赛管理</cite></a>
              <a><cite>个人建赛列表</cite></a>
            </span>
            <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
        </div> --%>
        <div class="x-body">
            
            <xblock>
            <a class="layui-btn"   href="javascript:location.replace(location.href);">
            <i class="layui-icon" >ဂ</i>
            刷新
            </a>
            <span class="x-right" style="line-height:40px">共有数据：${count} 条</span>
            </xblock>
            
            <table class="layui-table">
                <thead>
                    <tr>
                        <th>
                            比赛名称
                        </th>
                        <th>
                            比赛描述
                        </th>
                        <th>
                            比赛规则
                        </th>
                        <th>
                             建赛用户
                        </th>
                        <th>
                            操作
                        </th>
                    </tr>
                </thead>    
                <tbody>     
                    <c:forEach items="${buildinfo}" var="buildinfo">
					<tr>
						<td>${buildinfo.gamename}</td>
						<td>${buildinfo.miaoshu}</td>
						<td>${buildinfo.guize}</td>
						<td>${buildinfo.userid}</td>
                        <td class="td-manage">
                            <button class="layui-btn" onclick="role_add('发布窗口','${root}ht/toinsertfabuinfo.action?buildid=${buildinfo.buildid}','900','500')">
				           	 	发布
				            </button>
                        </td> 
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            </div>
        <div id="page"></div>
        <script src="${root}static/lib/layui/layui.js" charset="utf-8"></script>
        <script src="${root}static/js/x-layui.js" charset="utf-8"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
        <script>
            layui.use(['laydate','element','laypage','layer'], function(){
                $ = layui.jquery;//jquery
              laydate = layui.laydate;//日期插件
              lement = layui.element();//面包导航
              laypage = layui.laypage;//分页
              layer = layui.layer;//弹出层


              laypage({
                  cont: 'page'
                  ,pages: 10
                  ,first: 1
                  ,last: 100
                  ,prev: '<em><</em>'
                  ,next: '<em>></em>'
                
            	});
            });
             /*添加*/
            function role_add(title,url,w,h){
                x_admin_show(title,url,w,h);
            }

             

            </script>         
    </body>
</html>