<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	pageContext.setAttribute("root", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>荣耀电子竞技管理系统</title>
<link type="text/css" rel="stylesheet"
	href="${root}static/css/style.css" />
<%-- <script type="text/javascript" src="${root}static/js/jquery-1.8.2.min.js"></script> --%>
</head>

<body>
	<div class="loginBox">
		<h1>注册</h1>
		<form id="registerForm">
			<div class="item">
				<div class="icon">
					<img src="${root}static/images/icon4.png" />
				</div>
				<select id="quanxian" name="quanxian" class="sel">
					<option value="普通用户"><span>普通用户</span></option>
					<option value="投资商"><span>投资商</span></option>
				</select>
			</div>
			<div class="item">
				<div class="icon">
					<img src="${root}static/images/icon1.png" />
				</div>
				<div class="txt">
					<input id="email" name="email" required=""  type="text" placeholder="请输入您的邮箱" />
				</div>
			</div>
			<div class="item">
				<div class="icon">
					<img src="${root}static/images/icon2.png" />
				</div>
				<div class="txt">
					<input id="password" name="password" type="password" required=""
						placeholder="请输入您的密码" />
				</div>
			</div>
			<div class="item">
				<div class="icon">
					<img src="${root}static/images/icon3.png" />
				</div>
				<div class="txt">
					<input id="verifycode" name="verifycode" type="text"
						placeholder="请输入验证码" />
				</div>
				<div class="yzm">
					<button class="btn warning" id="sendVerifyCode" type="button"
						style="display: block; width: 100px; height: 45px;">发送验证码</button>
				</div>
			</div>
			<div class="item_3">
				<input name="" type="submit" value="注册" class="btn" />
			</div>
			<div class="item_4">
				已注册<a href="${root}qt/tologin.action">我要登录</a>
			</div>
		</form>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
	<script type="text/javascript">
		$(function() {

			//发送验证码

			$("#sendVerifyCode").click(function() {
				var email = $('#email').val()
				var password = $('#password').val();
				var quanxian = $('#quanxian').val();
				var params = "quanxian=" + quanxian + "&"
				+ "email=" + email
				console.log(params);
				if(email==""){
					alert("邮箱不能为空");
				}
				else{
					$.ajax({
						type : "POST",
						url : "${root}qt/email.action",
						data : params,
						success : function(msg) {
							if (msg.code == 1) {
								alert(msg.message);
								//window.location.href="${root}tologin";
							}
							else if (msg.code == -1) {
								$("#verifycode").val("");
								$("#email").val("");
								$("#password").val("");
								alert(msg.message);
								//window.location.href="${root}tologin";
							}
							else {
								$("#verifycode").val("");
								$("#email").val("");
								$("#password").val("");
								alert(msg.message);
							}
						}
					});
				}
			});
			//验证验证码       
			$("#registerForm")
					.submit(
							function() {
								console.log("ok");
								var quanxian = $('#quanxian').val();
								var email = $('#email').val();
								var password = $('#password').val();
								var verifycode = $('#verifycode').val();
								var params = "quanxian=" + quanxian + "&"
										+ "email=" + email + "&"
										+ "password=" + password + "&"
										+ "verifycode=" + verifycode;
								console.log(params);
								$
										.ajax({
											type : "POST",
											url : "${root}qt/register.action",
											data : params,
											success : function(msg) {
												if (msg.code == 1) {
													alert(msg.message);
													window.location.href = "${root}qt/tologin.action";
												} else {
													alert(msg.message);
												}
											}
										});

								return false;
							});
		})
	</script>

</body>
</html>
