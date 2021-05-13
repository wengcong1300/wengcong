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
            荣耀电子竞技管理系统
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
                             参赛用户名字
                        </th>
                        <th>
                             参赛用户年龄
                        </th>
                        <th>
                             参赛用户手机号码
                        </th>
                    </tr>
                </thead>    
                <tbody>   
	                <c:forEach items="${baominginfo}" var="baominginfo">
	                <input type="hidden" value="${baominginfo.fabuinfoid}" id="fabuinfoid">
	                <tr>
		                <c:forEach items="${fabuinfo}" var="fabuinfo">
			                <c:if test="${fabuinfo.id==baominginfo.fabuinfoid}">
									<td>${fabuinfo.gamename}</td>
									<td>${fabuinfo.miaoshu}</td>
									<td>${fabuinfo.guize}</td>
							</c:if>
		                </c:forEach>
		                <c:forEach items="${userinfo}" var="userinfo" >
			                <c:if test="${userinfo.emailid==baominginfo.emailid}">
			                	<input type="hidden" value="${userinfo.emailid}" name="emailid">
			                	<td>${userinfo.name}</td>
			                	<td>${userinfo.age}</td>
			                	<td>${userinfo.phone}</td>
			                </c:if>
			            </c:forEach>	
						</tr>
                   	</c:forEach>
                </tbody>
            </table>

	          <!--   <button class="layui-btn" onclick="suiji()">
	           	 	随机分组
	            </button> -->

            </div>
        <div id="page"></div>
        <script src="${root}static/lib/layui/layui.js" charset="utf-8"></script>
        <script src="${root}static/js/x-layui.js" charset="utf-8"></script>
        <script src="${root}static/js/jquery.min.js"></script>
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


            /* function suiji(){
                //获取全部报名用户名字
                var ids = [];
                var fabuinfoid=$("#fabuinfoid").val();
                var quanxuan=document.getElementsByName("emailid");
                for(var i=0;i<quanxuan.length;i++){
                	ids.push(quanxuan[i].value);
				}
				$.ajax({
					type:"post",
					url:"${root}ptyh/suijifenzu.action?ids="+ids+"&fabuinfoid="+fabuinfoid,
					dataType : 'json',
					success:function(data){
						//alert(JSON.stringify(data));
						window.location.href="${root}ptyh/tosuijifenzu.action?fabuinfoid="+fabuinfoid;
					}
				});
				
           } */

            </script>   
    
    </body>
</html>