<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>中软高科信息采编系统</title>
<script src="Js/jquery.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="Css/register.css" />
<script type="text/javascript">
	$(function() {
		$('.rem').click(function() {
			$(this).toggleClass('selected');
		});

		$('#signup_select').click(function() {
			$('.form_row ul').show();
			event.cancelBubble = true;
		});

		$('#d').click(function() {
			$('.form_row ul').toggle();
			event.cancelBubble = true;
		});

		$('body').click(function() {
			$('.form_row ul').hide();
		});

		$('.form_row li').click(function() {
			var v = $(this).text();
			$('#signup_select').val(v);
			$('.form_row ul').hide();
		});

	});
</script>
<script type="text/javascript">
	function login() {
		document.getElementById("signup_form").submit();
	}
</script>
</head>
<body>
	<div class='signup_container'>
		<h1 class='signup_title'>用户登陆</h1>
		<img src='images/people.png' id='admin' />
		<div id="signup_forms" class="signup_forms clearfix">
			<form class="signup_form_form" id="signup_form" method="post"
				action="loginAction">
				<div class="form_row first_row">
					<label for="signup_email">请输入用户名</label>
					<div class='tip ok'></div>
					<input type="text" name="user.username" placeholder="请输入用户名"
						id="signup_name" data-required="required">
				</div>
				<div class="form_row">
					<label for="signup_password">请输入密码</label>
					<div class='tip error'></div>
					<input type="password" name="user.password" placeholder="请输入密码"
						id="signup_password" data-required="required">
				</div>
			</form>
		</div>
		<div class="login-btn-set">
			<div class='rem'>记住我</div>
			<a href='javascript:void(0)' onclick="login()" class='login-btn' style="border:solid 1px blue;width: 120px;height:30px;text-align:center;padding-top: 10px">登录</a>
		</div>
		<div id="message" class="tip error">
			<s:property/>${fileErrors}<s:property/>
		</div>
		<p class='copyright'>版权所有 zzy1989527</p>
	</div>
</body>
</html>
