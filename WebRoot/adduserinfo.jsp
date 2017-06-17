<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>adduserinfo</title>
    
	

  </head>
  
  <body>
  	<div align="center">
  		<h3>添加用户信息</h3>
  		
  		<form action="userinfoServlet" method="post">
  			ID:<input type="text" name="uid"><br>
  			姓名:<input type="text" name="userinfoname"><br>
  			性别:<select name="sex" >
  				<option value="male">male</option>
  				<option value="fmal">fmale</option>
  			</select><br>
  			年龄:<input type="text" name="age"><br>
  			电话:<input type="text" name="phone"><br>
  			学校:<input type="text" name="school"><br>
  			<input type="hidden" name="method" value="add">
  			<input type="submit" value="添加">
  		</form>
  	</div>
  </body>
</html>
