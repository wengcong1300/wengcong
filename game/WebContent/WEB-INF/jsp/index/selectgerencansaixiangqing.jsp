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
       
        <div class="x-body">
            
            <xblock>
            <span class="x-right" style="line-height:40px">共有数据：${count} 条</span>
            <a class="layui-btn"   href="javascript:location.replace(location.href);">
            <i class="layui-icon" >ဂ</i>
            刷新
            </a>
            </xblock>
            
            <table class="layui-table">
                <thead>
                    <tr>
                        <th>
                            排行
                        </th>
                        <th>
                            比赛名称
                        </th>
                        <th>
                            姓名
                        </th>
                        <th>
                           获胜次数
                        </th>
                        
                    </tr>
                </thead>    
                <tbody id="tbody-data">     
                    <c:forEach items="${baominginfo}" var="baominginfo" varStatus="stauts">
					<tr>
						<td>
							第${stauts.count}名
                        </td>
						<td>
							<c:forEach items="${fabuinfo}" var="fabuinfo">
		                    	<c:if test="${baominginfo.fabuinfoid==fabuinfo.id }">
		                    		 ${fabuinfo.gamename}
		                    	</c:if>
	                        </c:forEach>
	                    </td>
						<td>
							<c:forEach items="${userinfo}" var="userinfo">
		                    	<c:if test="${userinfo.emailid==baominginfo.emailid }">
		                    		 ${userinfo.name}
		                    	</c:if>
	                        </c:forEach>
	                        </td>
						<td>${baominginfo.numwin}</td>
                        
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

              //以上模块根据需要引入
              /* laypage({
                  cont: 'page'
                  ,pages: 10
                  ,first: 1
                  ,last: 100
                  ,prev: '<em><</em>'
                  ,next: '<em>></em>'
                
            	}); */
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

             
            //编辑
            function role_edit (title,url,id,w,h) {
                x_admin_show(title,url,w,h);   
            }
            /*删除*/
            function role_del(obj,id){
			  layer.confirm('确认要删除吗？',function(index){
	                   //发异步删除数据
	                   $(obj).parents("tr").remove();
	                   layer.msg('已删除!',{icon:1,time:1000});
	               });
            }
            </script>
       <!--  <script type="text/javascript">
			//全选
			var oall=document.getElementById("all");
			var oid=document.getElementsByName("id");
			oall.onclick=function(){//勾选全选时
				for(var i=0;i<oid.length;i++){
					//所有的选择框和全选一致
					oid[i].checked=oall.checked;		
				}
			};
		</script> -->
    </body>
</html>