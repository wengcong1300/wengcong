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
        <form  id="insert">
           <input type="hidden"  name="id" value="${user.id}" class="id">
            <div class="pd-20">
              <table  class="layui-table" lay-skin="line">
                <tbody>
                  <tr>
                    <th>用户名：</th>
                    <td><input type="text" readonly="readonly" required="required"  name="email" value="${user.email}" id="address" class="layui-input"></td>
                  </tr>
                  <tr>
                    <th  width="80">密码：</th>
                    <td><input type="password"  name="password" required="required"  id="password" class="layui-input" ></td>
                  </tr>
                  <tr>
                    <th>新密码：</th>
                    <td><input type="password"  name="rpassword" required="required"  id="rpassword" class="layui-input" ></td>
                  </tr>
                </tbody>
              </table>
              <div class="layui-form-item">
                  <button class="layui-btn" type="submit" >
                      修改
                  </button>
              </div>
              
            </div>
            </form>
        </div>
        <script src="${root}static/lib/layui/layui.js" charset="utf-8">
        </script>
        <script src="${root}static/js/x-layui.js" charset="utf-8">
        </script>
        <script src="${root}static/js/jquery.min.js"></script>
		<script type="text/javascript">
			$("#insert").submit(function(){
				var password=$("#password").val();
				var rpassword=$("#rpassword").val();
				var params="password="+password+"&"+"rpassword="+rpassword; 
				console.log(params);
				$.ajax({
					   type: "POST",
					   url: "${root}ht/xiugaimima.action",
					   data: params,
					   success: function(msg){
						   if(msg.code==1){
							   alert(msg.message);
							   $("#password").val("");
        					   $("#rpassword").val("");
							   }
						   else{
							   alert(msg.message);
							   $("#password").val("");
        					   $("#rpassword").val("");
							   //parent.location.href=parent.location.href;
							   }
					   }
					}); 		
				return false;
				});
		</script>
        <script>
            layui.use(['form','layer'], function(){
                $ = layui.jquery;
              var form = layui.form()
              ,layer = layui.layer;
            
              //自定义验证规则
              form.verify({
                nikename: function(value){
                  if(value.length < 5){
                    return '昵称至少得5个字符啊';
                  }
                }
                ,pass: [/(.+){6,12}$/, '密码必须6到12位']
                ,repass: function(value){
                    if($('#L_pass').val()!=$('#L_repass').val()){
                        return '两次密码不一致';
                    }
                }
              });

              console.log(parent);
              //监听提交
              form.on('submit(add)', function(data){
                console.log(data);
                //发异步，把数据提交给php
                layer.alert("增加成功", {icon: 6},function () {
                    // 获得frame索引
                    var index = parent.layer.getFrameIndex(window.name);
                    //关闭当前frame
                    parent.layer.close(index);
                });
                return false;
              });
              
              
            });
        </script>
        
    </body>

</html>