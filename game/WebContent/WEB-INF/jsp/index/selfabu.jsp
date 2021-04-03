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
        <link rel="stylesheet" href="${root}admin/css/x-admin.css" media="all">
    </head>
    <body>
        <div class="x-nav">
            <span class="layui-breadcrumb">
              <a><cite>首页</cite></a>
              <a><cite>专业管理</cite></a>
              <a><cite>专业信息列表</cite></a>
            </span>
            <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
        </div>
        <div class="x-body">
        	<form class="layui-form x-center" action="${root}/majors/allByCollege.action"  method="post" style="width:30%">
                <div class="layui-form-pane" style="margin-top: 15px;">
                  <div class="layui-form-item">
                    <div class="layui-input-inline">
                      <input type="text" name="college"  placeholder="请输入查询的学院关键字"  class="layui-input">
                    </div>
                    <div class="layui-input-inline" style="width:80px">
                        <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                    </div>
                  </div>
                </div> 
            </form>
        
            <c:forEach items="${colleges}" var="colleges">
            <input type="hidden" id="cid" name="cid" value="${colleges.cid}" >	
            <xblock>
            	学院名称  : ${colleges.college}
            <button class="layui-btn" onclick="role_add('添加用户','${root}majors/toinsertmajors.action?id=${colleges.cid}','900','500')">
            <i class="layui-icon">&#xe608;</i>
            添加专业
            </button>
            <span class="x-right" style="line-height:40px">共有专业：${colleges.count} 个</span>
            </xblock>
            
            <table class="layui-table">
            
                <thead>
                    <tr>
                        <th>
                            
                        </th>
                        <th>
                            专业名称
                        </th>
                        <th>
                            操作
                        </th>
                    </tr>
                </thead>    
                <tbody>     
                    
                    
                    <c:forEach items="${majors}" var="majors">
                    <c:if test="${majors.cid==colleges.cid }">
					<tr>
						<td>
                           
                        </td>
						<td>${majors.major}</td>
						
                        <td class="td-manage">
                            <a title="编辑" href="javascript:;" onclick="role_edit('编辑','${root}majors/toupdate.action?id=${majors.mid}','4','','510')"
                            class="ml-5" style="text-decoration:none">
                                <i class="layui-icon">&#xe642;</i>
                            </a>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                           <a title="删除" href="${root}majors/delete.action?id=${majors.mid}" onclick="return confirm('是否真的删除？')"
                            style="text-decoration:none">
                                <i class="layui-icon">&#xe640;</i>
                            </a>
                        </td> 
                        </tr>
                        </c:if>
                        </c:forEach>
                    
                    
                </tbody>
            </table>
            </c:forEach>
            </div>
        <div id="page"></div>
        <script src="${root}admin/lib/layui/layui.js" charset="utf-8"></script>
        <script src="${root}admin/js/x-layui.js" charset="utf-8"></script>
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
            
            //批量删除提交
             function delAll () {
                layer.confirm('确认要删除吗？',function(index){
                    //捉到所有被选中的，发异步进行删除
                    layer.msg('删除成功', {icon: 1});
                });
             }
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
            
<!-- <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script type="text/javascript">
	$("#insert").submit(function(){
		var cid=$("#cid").val();
		var params="cid="+cid; 
		console.log(params);
		$.ajax({
			   type: "POST",
			   url: "${root}majors/count.action",
			   data: params,
			   success: function(msg){
				   if(msg.code==1){
					   //alert(msg.message);
					   //window.location.href="${root}colleges/all.action";
					   }
				   else{
					   //alert(msg.message);
					   }
			   }
			}); 		
		
		return false;
		});
</script> -->
            
    </body>
</html>