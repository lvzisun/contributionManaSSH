<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>中软高科信息采编系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="header">
    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>
    <div class="dl-log">欢迎您，<span class="dl-lossg-user">${user.username }</span><a href="/chinapost/index.php?m=Public&a=logout" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">信息采编系统</div></li>

		</ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">
    </ul>
</div>
<script type="text/javascript" src="assets/js/jquery-1.6.js"></script>
<script type="text/javascript" src="assets/js/bui.js"></script>
<script type="text/javascript" src="assets/js/common/main-min.js"></script>
<script type="text/javascript" src="assets/js/config-min.js"></script>
<script>
BUI.use("common/main",function(){
	var config=[{id:"1",menu:[
	     <c:forEach items="${result.firstpower}" var="f" varStatus="status">
	     	{text:"${f.firstpowername}",items:[
	     	       <c:forEach items="${f.secondpower}" var="s" varStatus="status2">
	     	       		{id:"${s.id}",text:"${s.secondpowername}",href:"${s.href}"}
	     	       	<c:if test="${status2.index<f.secondpower.size()-1}">
						,		     	
		     		</c:if>
	     	       </c:forEach>
	     	                                   ]}
	     	<c:if test="${status.index<result.firstpower.size()-1}">
				,		     	
	     	</c:if>
	     </c:forEach>
	                          ]}];
	
new PageUtil.MainPage({
    modulesConfig : config
});
})
</script>
</body>
</html>