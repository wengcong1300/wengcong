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
    <form id="xiugai"></form>
        <div class="x-body">
            <blockquote class="layui-elem-quote">
                <img src="${userinfo.touxiang}" class="layui-circle" style="border: 2px solid #A9B7B7;width:40px;height:40px;float:left">
                <dl style="margin-left:80px; color:#019688">
                <dd>个性签名：</dd>
                <dd style="margin-left:0">${userinfo.jieshao}</dd>
              </dl>
            </blockquote>
            <div class="pd-20">
              <table  class="layui-table" lay-skin="line">
                <tbody>
                  <tr>
                    <th  width="80">用户名：</th>
                    <td>${user.email }</td>
                  </tr>
                  <tr>
                    <th>姓名：</th>
                    <td>${userinfo.name}</td>
                  </tr>
                  <tr>
                    <th>年龄：</th>
                    <td>${userinfo.age}</td>
                  </tr>
                  <tr>
                    <th>手机号：</th>
                    <td>${userinfo.phone}</td>
                  </tr>
                  
                </tbody>
              </table>
            </div>
            <div class="layui-form-item">
                  <button class="layui-btn" type="submit" >
                      修改
                  </button>
              </div>
        </div>
        
        <script src="${root}static/js/jquery.min.js"></script>
		<script type="text/javascript">
		$(function() {
			$(".layui-btn").click(function() {
				window.location.href="${root}ptyh/yhxx/toxinxi.action";
			});
		})
		</script>
    </body>

</html>