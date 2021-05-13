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
            <button class="layui-btn" onclick="delAll()">
            <i class="layui-icon">&#xe640;</i>
            批量删除
            </button>
            <button class="layui-btn" onclick="role_add('建立赛事窗口','${root}tzs/sjjs/toinsertBuildinfo.action','900','500')">
            <i class="layui-icon">&#xe608;</i>
            添加
            </button>
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
                            <input type="checkbox" name="ids" id="all" >
                        </th>
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
						<td>
                            <input type="checkbox" value="${buildinfo.buildid }" name="id">
                        </td>
						<td>${buildinfo.gamename}</td>
						<td>${buildinfo.miaoshu}</td>
						<td>${buildinfo.guize}</td>
						<td>${user.email}</td>
                        <td class="td-manage">
                            <a title="编辑" href="javascript:;" onclick="role_edit('编辑','${root}tzs/sjjs/toupdateBuildinfo.action?buildid=${buildinfo.buildid}','4','','510')"
                            class="ml-5" style="text-decoration:none">
                                <i class="layui-icon">&#xe642;</i>
                            </a>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                           <a title="删除" href="${root}tzs/sjjs/deletebuildinfo.action?buildid=${buildinfo.buildid}" onclick="return confirm('是否真的删除？')"
                            style="text-decoration:none">
                                <i class="layui-icon">&#xe640;</i>
                            </a>
                        </td> 
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
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
                var ids = [];
                // 获取选中的id
                $('tbody input').each(function(index, el) {
                    if($(this).prop('checked')){
                        ids.push($(this).val())
                    }
                });
                if(ids.length==0){
                    	layer.confirm('请选择删除的信息')
                    }
                else{
                	layer.confirm('确认要删除吗？'/* +ids.toString() */,function(index){
                        //捉到所有被选中的，发异步进行删除
                        $.ajax({
                			   type: "post",
                			   url: "${root }tzs/sjjs/deleteBuildinfoByIds.action?ids="+ids,
                			   success: function(msg){
                		            if(msg.code==1){
                		            	 alert(msg.message);
                		            	 layer.close(layer.index);
                		            	 window.location.href="${root}tzs/sjjs/selBuildinfo.action";
                		            }
                			   }
                			});
                		//阻止form表单的默认行为，比如刷新了下
                		return false;
                    });
                    }
                
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
        <script type="text/javascript">
			//全选
			var oall=document.getElementById("all");
			var oid=document.getElementsByName("id");
			oall.onclick=function(){//勾选全选时
				for(var i=0;i<oid.length;i++){
					//所有的选择框和全选一致
					oid[i].checked=oall.checked;		
				}
			};
		</script>
    </body>
</html>