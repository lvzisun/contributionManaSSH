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
<title>内部通讯录</title>
<link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="Css/style.css" />
<script type="text/javascript" src="Js/jquery.js"></script>
<script type="text/javascript" src="Js/jquery.sorted.js"></script>
<script type="text/javascript" src="Js/bootstrap.js"></script>
<script type="text/javascript" src="Js/ckform.js"></script>
<script type="text/javascript" src="Js/common.js"></script>

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
		$('#newNav').click(function() {
			window.location.href = "add.html";
		});
	});

	function checkall() {
		var alls = document.getElementsByName("check");
		var ch = document.getElementById("checkall");
		if (ch.checked) {
			for (var i = 0; i < alls.length; i++) {
				alls[i].checked = true;
			}
		} else {
			for (var i = 0; i < alls.length; i++) {
				alls[i].checked = false;
			}
		}
	}
	function delAll() {
		var alls = document.getElementsByName("check");
		var ids = new Array();
		for (var i = 0; i < alls.length; i++) {
			if (alls[i].checked) {
				ids.push(alls[i].value);
			}
		}
		if (ids.length > 0) {
			if (confirm("确认操作?")) {
				alert("成功!");
			}
		} else {
			alert("请选中要操作的项");
		}
	}
	function changePage(page){
		$("#currentPage").val(page);
		$("#userBox").submit();
	}
</script>
</head>
<body>
	<c:if test="${empty result.userAddresses }">
		<c:redirect url="../loadUserAddress"></c:redirect>
	</c:if>
	<form action="queryUserAddress" method="post" class="definewidth m20" id="userBox">
		<input type="hidden" name="condition.currentPage"  id="currentPage" value="">
		<table class="table table-bordered table-hover definewidth m10">
			<tr>
				<td width="10%" class="tableleft">姓名：</td>
				<td><input type="text" name="condition.realname" value="${result.condition.realname}" /></td>
				<td width="10%" class="tableleft">电话号码：</td>
				<td><input type="text" name="condition.phone" value="${result.condition.phone }" /></td>
			</tr>
			<tr>
				<td colspan="6"><center>
						<button type="submit" class="btn btn-primary" type="button">查询</button>
						<button type="reset" class="btn btn-primary" type="button">清空</button>
					</center></td>
			</tr>
		</table>
	</form>
	<c:choose>
		<c:when test="${!empty result.addressMessage }">
			<h3 style="color:red;margin:10px 100px;">${result.addressMessage }</h3>
		</c:when>
	</c:choose>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th><input type="checkbox" id="checkall" onChange="checkall();"></th>
				<th>姓名</th>
				<th>性别</th>
				<th>出生日期</th>
				<th>电话</th>
				<th>地址</th>
				<th>Email</th>
				<th>操作</th>
			</tr>
		</thead>
		<c:forEach items="${result.userAddresses }" var="u" varStatus="s">
			<tr>
				<td style="vertical-align:middle;"><input type="checkbox"
					name="check" value="${u.id}"></td>
				<td style="vertical-align:middle;">${u.realname }</td>
				<td style="vertical-align:middle;">${u.sex}</td>
				<td style="vertical-align:middle;">${u.birthday }</td>
				<td style="vertical-align:middle;">${u.phone }</td>
				<td style="vertical-align:middle;">${u.address }</td>
				<td style="vertical-align:middle;">${u.email }</td>
				<td style="vertical-align:middle;"><a href="loadUserAddressInfo?user.id=${u.id }">查看</a></td>
			</tr>
		</c:forEach>
	</table>
	<table class="table table-bordered table-hover definewidth m10">
		<tr>
			<th colspan="5">
						<div class="inline pull-right page">
					<c:if test="${result.condition.currentPage>1 }">
						<a href='javascript:void(0)' onclick="changePage(1)">首页</a>
						<a href='javascript:void(0)'
							onclick="changePage(${result.condition.currentPage-1 })">上一页</a>
					</c:if>
					当前第<span class="current">${result.condition.currentPage }</span>页
					<c:if
						test="${result.condition.currentPage<result.condition.totalPage }">
						<a href='javascript:void(0)'
							onclick="changePage(${result.condition.currentPage+1 })">下一页</a>
						<a href='javascript:void(0)'
							onclick="changePage(${result.condition.totalPage })">尾页</a>
					</c:if>
					&nbsp;&nbsp;&nbsp;共<span class='current'>${result.condition.totalCount }</span>条记录<span
						class='current'>${result.condition.currentPage }/${result.condition.totalPage }</span>页
				</div>
				<div>
					<button type="button" class="btn btn-success" id="delPro">导出Excel</button>
				</div>
			</th>
		</tr>
	</table>

</body>
</html>
