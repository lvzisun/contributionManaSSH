<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
    </style>
</head>
<body>
<form action="changeInfo" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <tr>
            <td width="10%" class="tableleft">用户名</td>
            <td>${user.username }</td>
        </tr>
        <tr>
            <td class="tableleft">真实姓名</td>
            <td><input type="text" name="user.realname" value="${user.realname }"/></td>
        </tr>
        <tr>
            <td class="tableleft">性别</td>
            <td><c:choose>
						<c:when test="${user.sex=='男' }">
							<input type="radio" name="user.sex" value="${user.sex }"
								checked />男&nbsp;&nbsp;&nbsp;
        			<input type="radio" name="user.sex" value="女" />女
        		</c:when>
						<c:otherwise>
							<input type="radio" name="user.sex" value="${user.sex }"
								checked />女&nbsp;&nbsp;&nbsp;
        			<input type="radio" name="user.sex" value="男" />男
        		</c:otherwise></c:choose></td>
        </tr>
        <tr>
            <td class="tableleft">年龄</td>
       	     <td><input type="text" name="user.age" value="${user.age }"/></td>
        </tr>
        <tr>
            <td class="tableleft">联系电话</td>
            <td>
                <input type="text" name="user.phone" value="${user.phone }"/>
        </tr>
        <tr>
            <td class="tableleft">邮箱</td>
            <td>
                <input type="text" name="user.email" value="${user.email }"/>
        </tr>
        <tr>
            <td class="tableleft">地址</td>
            <td>
                <input type="text" name="user.address" value="${user.address }"/>
        </tr>
        <tr>
            <td class="tableleft">出生年月</td>
            <td>
                <input type="text" name="birthdayStr" value="${user.birthday }"/>
        </tr>
        <tr>
            <td class="tableleft">状态</td>
            <td><c:choose>
						<c:when test="${user.status==1 }">
							<input type="radio" name="user.status" value="${user.status }"
								checked />正常&nbsp;&nbsp;&nbsp;
        			<input type="radio" name="user.status" value="0" />禁用
        		</c:when>
						<c:otherwise>
							<input type="radio" name="user.status" value="${user.status }"
								checked />禁用&nbsp;&nbsp;&nbsp;
        			<input type="radio" name="user.status" value="1" />正常
        		</c:otherwise>
					</c:choose>
        	</td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button">更新</button>&nbsp;&nbsp;<button type="reset" class="btn btn-success" name="backid" id="backid">重置</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>