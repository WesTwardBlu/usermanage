<%@page import="com.domain.Userinfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>userdetail</title>
  </head>
  
  <body>
  	<br>
  	<br>
  	<br>
  	<div align="center">
		<h3>userdetail</h3>  
		<%
			Userinfo userinfo= (Userinfo)request.getAttribute("userinfo");
			if(null!= userinfo){
		%>
		
			ID:<input type="text" value="<%=userinfo.getUid() %>" readonly="readonly"><br>
			姓名:<input type="text" value="<%=userinfo.getUserinfoname() %>" readonly="readonly"><br>
			性别:<input type="text" value="<%=userinfo.getSex() %>" readonly="readonly"><br>
			年龄:<input type="text" value="<%=userinfo.getAge() %>" readonly="readonly"><br>
			电话:<input type="text" value="<%=userinfo.getPhone() %>" readonly="readonly"><br>
			学校:<input type="text" value="<%=userinfo.getSchool() %>" readonly="readonly"><br>
		
		<%		
			}
		%>	
  	</div>
  </body>
</html>
