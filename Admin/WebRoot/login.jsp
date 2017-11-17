<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="/Admin/LoginServlet" method="post">
    	<table>
    		<tr>
    			<th>用户名：</th>
    			<td><input type="text" name="userName" value="${erro }"></td>
    		</tr>
    		<tr>
    			<th>密码：</th>
    			<td><input type="password" name="password"></td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center"><input type="submit" value="登陆">&nbsp;<a href="/Admin/register.jsp">注册</a></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
