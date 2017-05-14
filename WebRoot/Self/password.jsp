<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="Css/style.css" />
    <script type="text/javascript" src="Js/jquery.js"></script>
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>
</head>
<body>
<form class="form-inline definewidth m20" action="changePassword" method="post">    
   <table>
		<tr>
			<td align="right">原密码:</td><td><input type="password" name="oldPassword"/></td>
		</tr>
		<tr>
			<td align="right">新密码:</td><td><input type="password" name="newPassword"/></td>
		</tr>
		<tr>
			<td align="right">确认密码:</td><td><input type="password" name="rePassword"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><br/>
				<input type="submit" value="保存" class="btn btn-primary"/>
			</td>
		</tr>
   </table>
</form>
</body>
</html>