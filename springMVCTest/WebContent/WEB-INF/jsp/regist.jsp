<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <!--  <body>
  <c:if test="${ allErrors!=null}">
  <c:forEach items="${allErrors }" var="error">
  ${error.defaultMessage}
  </c:forEach>
      </c:if>
<form method="post">
	用户名:<input type="text" name="username" value=${user.username }/><br/>
	用户密码:<input type="password" name="password" /><br/>
	邮箱:<input type="text" name="email"/><br/>
	绰号:<input type="text" name="nickname"/><br/>
	<input type="submit" value="用户注册"/>
	</form>-->
	<body>
	<h1 style="text-align:center">用户注册</h1>
	<sf:form method="post" modelAttribute="user">
    <table width="700" align="center" border="1">
	<tr>
	<td>用户名:</td><td><sf:input path="username"/><sf:errors path="username"/></td>
	</tr>
	<tr>
	<td>用户密码:</td><td><sf:password path="password"/><sf:errors path="password"/></td>
	</tr>
	<tr>
	<td>用户昵称:</td><td><sf:input path="nickname"/></td>
	</tr>
	<tr>
	<td>用户邮箱:</td><td><sf:input path="email"/><sf:errors path="email"/></td>
	</tr>
	<tr>
	<td colspan="2" style="text-align:center" >
		<input type="submit" value="注册"/>
	</td>
	</tr>
</table>
</sf:form>
  </body>
</html>
