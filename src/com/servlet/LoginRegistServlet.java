package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.Users;
import com.service.UsersService;
import com.service.impl.UsersServiceImpl;

public class LoginRegistServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method= req.getParameter("method");
		if (method!=null && "regist".equals(method) ) {
			regist(req, resp);
		} else if (method!=null && "login".equals(method) ) {
			login(req, resp);
		}
		
	}
	
	public void regist(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		System.out.println("LoginRegistServlet.regist");
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		
		UsersService usersService= new UsersServiceImpl();
		if (username!=null && !"".equals(username.trim()) && password!=null && !"".equals(password) ) {
			Users users= new Users();
			users.setUsername(username);
			users.setPassword(password);
			usersService.insertUsers(users);
		}else{
			HttpSession session= request.getSession();
			session.setAttribute("errormsg", "Regist username or password invalid! please input ");
			response.sendRedirect("regist.jsp");
			return;
		}
		response.sendRedirect("login.jsp");
		return;
	}
	
	public void login(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("LoginRegistServlet.login");
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		
		UsersService usersService= new UsersServiceImpl();
		Users users = usersService.findUsersByNameAndPass(username, password);
		if (null!=users) {
			
			response.sendRedirect("userinfoServlet?method=finduserinfos");
			return ;
		}
		response.sendRedirect("login.jsp");
		return ;
		
	}
	
	
	
}
