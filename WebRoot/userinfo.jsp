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
    
    <title>Userinfo</title>
    
	

  </head>
  
  <body>
  	<br>
  	<br>
  	<br>
  	<div align="center">
	  	<h1>userinfo</h1>
	  	<a href="adduserinfo.jsp">增加用户</a>
  		<table>
  			
  			<tr>
  				<td>ID</td>
  				<td>姓名</td>
  				<td>性别</td>
  				<td>年龄</td>
  				<td>电话</td>
  				<td>学校</td>
  				<td>删除</td>
  				<td>修改</td>
  			</tr>
  			
  			<%
  				List<Userinfo> userinfos= (List<Userinfo>)request.getAttribute("userinfos");
  				if(userinfos!=null){
  				  for(Userinfo userinfo:userinfos){
  			%>
  					<tr>
		  				<td><a href="userinfoServlet?method=findbyid&uid=<%=userinfo.getUid()%>"><%=userinfo.getUid() %></a></td>
		  				<td><%=userinfo.getUserinfoname() %></td>
		  				<td><%=userinfo.getSex() %></td>
		  				<td><%=userinfo.getAge() %></td>
		  				<td><%=userinfo.getPhone() %></td>
		  				<td><%=userinfo.getSchool() %></td>
		  				<td><a href="userinfoServlet?method=delete&uid=<%=userinfo.getUid()%>">删除</a></td>
		  				<td><a href="userinfoServlet?method=preupdate&uid=<%=userinfo.getUid()%>">修改</a></td>
	  				</tr>
  			<%		
  				  }
  				}  
  			%>
  			
  		</table>
  	</div>
  
  </body>
</html>
