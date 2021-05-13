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
            <form class="layui-form x-center" action="selectuserbyemail.action" method="get" style="width:80%">
                <div class="layui-form-pane" style="margin-top: 15px;">
                  <div class="layui-form-item">
                    <div class="layui-input-inline">
                      <input type="text" id="email" name="email"  placeholder="请输入邮箱号" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-input-inline" style="width:80px">
                        <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                    </div>
                  </div>
                </div> 
            </form>
            <xblock>
            	<a class="layui-btn"   href="javascript:location.replace(location.href);">
	            <i class="layui-icon" >ဂ</i>
	            刷新
	            </a>
            	<span class="x-right" style="line-height:40px">共有数据：<span class="layui-badge">${count }</span> 条</span>
            </xblock>
            <table class="layui-table" id="test">
                <thead>
                    <tr>
                        <th>
                            邮箱
                        </th>
                        <th>
                            密码
                        </th>
                        <th>
                            权限
                        </th>
                        <th>
                            状态
                        </th>
                        <th>
                            操作
                        </th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${user}" var="user">
                	<tr>
                        <td>
                            ${user.email}
                        </td>
                        <td>
                            ${user.password}
                        </td>
                        <td >
                            ${user.quanxian}
                        </td>
                        <c:if test="${user.zhuangtai==0}">
	                        <td class="td-status">
	                            <span class="layui-btn layui-btn-normal ">
	                                已启用
	                            </span>
	                        </td>
	                        <td class="td-manage">
	                            <a style="text-decoration:none" onclick="admin_stop(this,${user.id})" href="javascript:;" title="停用">
	                                <i class="layui-icon">&#xe601;</i>
	                            </a>
	                        </td>
                        </c:if>
                        <c:if test="${user.zhuangtai==1}">
	                        <td class="td-status">
	                            <span class="layui-btn layui-btn-disabled layui-btn-mini">已停用</span>
	                        </td>
	                        <td class="td-manage">
	                            <a style="text-decoration:none" onclick="admin_start(this,${user.id})" href="javascript:;" title="停用">
	                                <i class="layui-icon">&#xe62f;</i>
	                            </a>
	                        </td>
                        </c:if>
                    </tr>
                    </c:forEach>
                </tbody> 
            </table>

            <div id="page"></div>
        </div>
        <script src="${root}static/lib/layui/layui.js" charset="utf-8"></script>
        <script src="${root}static/js/x-layui.js" charset="utf-8"></script>
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
                ,pages: 100
                ,first: 1
                ,last: 100
                ,prev: '<em><</em>'
                ,next: '<em>></em>'
              });  */     
              
              var start = {
                min: laydate.now()
                ,max: '2099-06-16 23:59:59'
                ,istoday: false
                ,choose: function(datas){
                  end.min = datas; //开始日选好后，重置结束日的最小日期
                  end.start = datas //将结束日的初始值设定为开始日
                }
              };
              
              var end = {
                min: laydate.now()
                ,max: '2099-06-16 23:59:59'
                ,istoday: false
                ,choose: function(datas){
                  start.max = datas; //结束日选好后，重置开始日的最大日期
                }
              };
            });

            //批量删除提交
             function delAll () {
                layer.confirm('确认要删除吗？',{icon:3,title:'提示信息'},function(index){
                    //捉到所有被选中的，发异步进行删除
                    layer.msg('删除成功', {icon: 1});
                });
             }
             /*添加*/
            function admin_add(title,url,w,h){
                x_admin_show(title,url,w,h);
            }

            

             /*停用*/
            function admin_stop(obj,id){
                layer.confirm('确认要停用吗？',function(index){
                    //发异步把用户状态进行更改
                    var params="id="+id;
                	$.ajax({
          			   type: "POST",
          			   url: "${root}gly/fenghao.action",
          			   data: params,
          			   success: function(data){
              			   console.log(data.id);
							$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="admin_start(this,'+data.id+')" href="javascript:;" title="启用"><i class="layui-icon">&#xe62f;</i></a>');
							$(obj).parents("tr").find(".td-status").html('<span class="layui-btn layui-btn-disabled layui-btn-mini">已停用</span>');
							$(obj).remove();
							layer.msg('已停用!',{icon: 5,time:1000});
	          			   }
	          			}); 		
	          		return false;
	          		});
                    
                }

            /*启用*/
            function admin_start(obj,id){
                layer.confirm('确认要启用吗？',function(index){
                    //发异步把用户状态进行更改
                    var params="id="+id;
                	$.ajax({
         			   type: "POST",
         			   url: "${root}gly/fenghao.action",
         			   data: params,
         			   success: function(data){
         				  console.log(data.id);
         				  $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="admin_stop(this,'+data.id+')" href="javascript:;" title="停用"><i class="layui-icon">&#xe601;</i></a>');
                          $(obj).parents("tr").find(".td-status").html('<span class="layui-btn layui-btn-normal layui-btn-mini">已启用</span>');
                          $(obj).remove();
                          layer.msg('已启用!',{icon: 6,time:1000});
         			   }
         			}); 		
         		return false;
         		});
            }
            //编辑
            function admin_edit (title,url,id,w,h) {
                x_admin_show(title,url,w,h); 
            }
            /*删除*/
            function admin_del(obj,id){
                layer.confirm('确认要删除吗？',{icon:3,title:'提示信息'},function(index){
                    //发异步删除数据
                    $(obj).parents("tr").remove();
                    layer.msg('已删除!',{icon:1,time:1000});
                });
            }
            
            </script>
            
            
    </body>
</html>