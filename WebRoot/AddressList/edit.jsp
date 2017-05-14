<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>修改通讯录</title>
<link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="Css/style.css" />
<script type="text/javascript" src="Js/jquery.js"></script>
<script type="text/javascript" src="Js/jquery.sorted.js"></script>
<script type="text/javascript" src="Js/bootstrap.js"></script>
<script type="text/javascript" src="Js/ckform.js"></script>
<script type="text/javascript" src="Js/common.js"></script>
<script type="text/javascript" src="Js/ckeditor/ckeditor.js"></script>


<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
<script type="text/javascript">
	$(function() {
		$('#backid').click(function() {
			window.location.href = "AddressList/index2.jsp";
		});
	});
</script>
</head>
<body>
	<form action="updateFriend" method="post" class="definewidth m20">
		<input type="hidden" name="friend.id" value="${result.addressInfo.id}" }/>
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">姓名</td>
				<td><input type="text" name="friend.realname"
					value="${result.addressInfo.realname }" /></td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">性别</td>
				<td><c:choose>
						<c:when test="${result.addressInfo.sex=='男' }">
							<input type="radio" name="friend.sex" value="${result.addressInfo.sex }"
								checked />男&nbsp;&nbsp;&nbsp;
        			<input type="radio" name="friend.sex" value="女" />女
        		</c:when>
						<c:otherwise>
							<input type="radio" name="friend.sex" value="${result.addressInfo.sex }"
								checked />女&nbsp;&nbsp;&nbsp;
        			<input type="radio" name="friend.sex" value="男" />男
        		</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">生日</td>
				<td><input type="text" name="birthdayStr"
					value="${result.addressInfo.birthday }" /></td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">电话</td>
				<td><input type="text" name="friend.phone"
					value="${result.addressInfo.phone }" /></td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">地址</td>
				<td><input type="text" name="friend.address"
					value="${result.addressInfo.address }" /></td>
			</tr>
			<tr>
				<td width="10%" class="tableleft">邮箱</td>
				<td><input type="text" name="friend.email"
					value="${result.addressInfo.email }" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<center>
						<button type="submit" class="btn btn-primary" type="button">保存</button>
						&nbsp;&nbsp;
						<button type="reset" class="btn btn-success" name="backid"
							id="backid">返回列表</button>
					</center>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>