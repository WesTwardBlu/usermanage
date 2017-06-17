package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Userinfo;
import com.service.UserinfoService;
import com.service.impl.UserinfoServiceImpl;

public class UserinfoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method= req.getParameter("method");
		if (method!=null && "finduserinfos".equals(method)) {
			findUserinfos(req, resp);
		} else if (method!=null && "findbyid".equals(method)) {
			findById(req, resp);
			
		} else if (method!=null && "preupdate".equals(method)) {
			preUpdate(req, resp);
		} else if (method!=null && "delete".equals(method)) {
			delete(req, resp);
		}
		
		
	}
	


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method= req.getParameter("method");
		if (method!=null && "add".equals(method)) {
			add(req, resp);
		} else if (method!=null && "update".equals(method)) {
			update(req, resp);
			
		} 
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String uid= req.getParameter("uid");
		UserinfoService userinfoService= new UserinfoServiceImpl();
		userinfoService.delete(uid);
		resp.sendRedirect("userinfoServlet?method=finduserinfos");
	}
	
	public void preUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("UserInfoServlet.preUpdate");
		String uid= req.getParameter("uid");
		UserinfoService userinfoService= new UserinfoServiceImpl();
		Userinfo userinfo= userinfoService.findById(uid);
		req.setAttribute("userinfo", userinfo);
		req.getRequestDispatcher("updateuserinfo.jsp").forward(req, resp);
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uid= request.getParameter("uid");
		String userinfoname= request.getParameter("userinfoname");
		String sex= request.getParameter("sex");
		String age= request.getParameter("age");
		String phone= request.getParameter("phone");
		String school= request.getParameter("school");
		Userinfo userinfo= new Userinfo();
		userinfo.setUid(Integer.parseInt(uid));
		userinfo.setUserinfoname(userinfoname);
		userinfo.setSex(sex);
		userinfo.setAge(Integer.parseInt(age));
		userinfo.setPhone(phone);
		userinfo.setSchool(school);
		
		UserinfoService userinfoService= new UserinfoServiceImpl();
		userinfoService.update(userinfo);
		response.sendRedirect("userinfoServlet?method=finduserinfos");
		
	}

	public void findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("UserInfoServlet.findbyid");
		String uid= req.getParameter("uid");
		UserinfoService userinfoService= new UserinfoServiceImpl();
		Userinfo userinfo= userinfoService.findById(uid);
		req.setAttribute("userinfo", userinfo);
		req.getRequestDispatcher("userinfodetail.jsp").forward(req, resp);
		
	}

	public void findUserinfos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("UserInfoServlet.findUserinfos");
		UserinfoService userinfoService= new UserinfoServiceImpl();
		List<Userinfo> userinfos= userinfoService.findUserinfos();
		req.setAttribute("userinfos", userinfos);
		req.getRequestDispatcher("userinfo.jsp").forward(req, resp);
	}

	
	
	public void add(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String uid= request.getParameter("uid");
		String userinfoname= request.getParameter("userinfoname");
		String sex= request.getParameter("sex");
		String age= request.getParameter("age");
		String phone= request.getParameter("phone");
		String school= request.getParameter("school");
		Userinfo userinfo= new Userinfo();
		userinfo.setUid(Integer.parseInt(uid));
		userinfo.setUserinfoname(userinfoname);
		userinfo.setSex(sex);
		userinfo.setAge(Integer.parseInt(age));
		userinfo.setPhone(phone);
		userinfo.setSchool(school);
		
		UserinfoService userinfoService= new UserinfoServiceImpl();
		userinfoService.addUserinfo(userinfo);
		response.sendRedirect("userinfoServlet");
		
	}
	
}
