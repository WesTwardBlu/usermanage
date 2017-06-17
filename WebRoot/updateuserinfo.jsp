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
    
    <title>updateuserinfo</title>
    
	

  </head>
  
  <body>
  	<div align="center">
  		<h3>修改用户信息</h3>
  		
  		<form action="userinfoServlet" method="post">
  			<%
				Userinfo userinfo= (Userinfo)request.getAttribute("userinfo");
				if(null!= userinfo){
			%>
	  			ID:<input type="text" name="uid" value="<%=userinfo.getUid() %>" readonly="readonly"/><br>
	  			姓名:<input type="text" name="userinfoname" value="<%=userinfo.getUserinfoname() %>"><br>
	  			性别:<select name="sex" >
	  				<%
	  				if("male".equals(userinfo.getSex())){
	  				%>
		  				<option value="male" selected="selected">male</option>
		  				<option value="fmal">fmale</option>
	  				<%	
	  				} else{
	  				%>	
		  				<option value="male">male</option>
		  				<option value="fmal" selected="selected">fmale</option>
	  				<%
	  				}
	  				%>
	  			</select><br>
	  			年龄:<input type="text" name="age" value="<%=userinfo.getAge() %>"><br>
	  			电话:<input type="text" name="phone" value="<%=userinfo.getPhone() %>"><br>
	  			学校:<input type="text" name="school" value="<%=userinfo.getSchool() %>"><br>
	  			<input type="hidden" name="method" value="update">
	  			<input type="submit" value="修改">
	  		<%		
				}
			%>	
  		</form>
  	</div>
  </body>
</html>
