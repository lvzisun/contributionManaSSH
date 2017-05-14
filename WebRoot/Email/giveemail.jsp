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
<title>发件箱</title>
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
	/**
	*加载有特殊条件的Email
	*/
	function loadWithCondition() {
		var key = $("#paramName").val();
		var order=$("#orderParam").val();
		var value=$("#paramValue").val();
		var url="loadGiveemail";
		if(!isEmpty(key) && !isEmpty(value) && !isEmpty(order)){
			url=url+"?"+key+"="+value+"&"+"condition.emailParams.order="+order;
		}
		if(!isEmpty(key) && !isEmpty(value) && isEmpty(order)){
			url=url+"?"+key+"="+value;	
		}
		if((isEmpty(key) || isEmpty(value)) && !isEmpty(order)){
			url=url+"?"+"condition.emailParams.order="+order;		
		}
		$("addCondition").attr("action",url);
		$("addCondition").submit();
		return;
	}
	/**
	*判读一个字符串是否为空
	*@params:str--要判空的字符串
	*/
	function isEmpty(str){
		if(str==null || str.eq("")){
			return false;
		}else{
			return true;
		}
	}
	/**
	*清除查询条件
	*/
	function clearParam() {
		$("#paramValue").val("");
		$("#emailParam option:first").prop("selected", true);
		$("#orderParam option:first").prop("selected", true);
	}
	/**
	*翻页
	*@Params:page————要显示的页码数
	*/
	function changePage(page) {
		if (page == null || page == 0) {
			page = 1;
		}
		location = "loadGiveemail?condition.currentPage=" + page;
	}
</script>
</head>
<body>
	<c:if test="${empty result.sendemail }">
		<c:redirect url="../loadGiveemail"></c:redirect>
	</c:if>
	<form  action="" method="post" id="addCondition">
		<table class="table table-bordered table-hover definewidth m10">
		<tr>
			<td width="10%" class="tableleft">搜索条件：</td>
			<td><select name="" id="paramName">
					<option></option>
					<option value="condition.emailParams.title">标题</option>
					<option value="condition.emailParams.content">内容</option>
					<option value="condition.emailParams.receiveName">收件人</option>
			</select></td>
			<td width="10%" class="tableleft">关键字：</td>
			<td><input type="text" id="paramValue" name="" value="" /></td>
			<td width="10%" class="tableleft">排序：</td>
			<td><select name="condition.emailParams.maketime" id="orderParam">
					<option></option>
					<option value="desc">发送时间降序</option>
					<option value="asc">发送时间升序</option>
			</select></td>
		</tr>
		<tr>
			<td colspan="6"><center>
					<button type="submit" class="btn btn-primary" type="button"
						onclick="loadWithCondition()">查询</button>
					<button type="button" class="btn btn-primary" type="button"
						onclick="clearParam()">清空</button>
				</center></td>
		</tr>
	</table>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th><input type="checkbox" id="checkall" onChange="checkall();"></th>
				<th>序号</th>
				<th>标题</th>
				<th>内容</th>
				<th>收件人</th>
				<th>发送时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<c:choose>
			<c:when test="${result.sendemail=='您的发件箱是空的' }">
				<tr>
					<td colspan="7" style="text-align: center;color:red">找不到任何邮件</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${result.sendemail }" var="e" varStatus="s">
					<tr>
						<td style="vertical-align:middle;"><input type="checkbox"
							name="check" value="${e.id }"></td>
						<td style="vertical-align:middle;">${s.index+1 }</td>
						<td style="vertical-align:middle;">${e.title }</td>
						<td style="vertical-align:middle;">${e.content }</td>
						<td style="vertical-align:middle;">${e.receivename }</td>
						<td style="vertical-align:middle;">${e.maketime }</td>
						<td style="vertical-align:middle;"><a href="look.html">详情...</a>&nbsp;&nbsp;&nbsp;<a
							href="">删除</a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
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
					<button type="button" class="btn btn-success" id="newNav">删除</button>
					<button type="button" class="btn btn-success" id="delPro">导出Excel</button>
				</div>

			</th>
		</tr>
	</table>

</body>
</html>
