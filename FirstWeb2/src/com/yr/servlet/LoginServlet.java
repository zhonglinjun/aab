package com.yr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yr.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	/**
	 *
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String code = req.getParameter("code");
//		
//		Integer code1 = (Integer) req.getSession().getAttribute("mobile_code");
//		String code2 = String.valueOf(code1);
//		
//		if(code.equals(code2))
//		{
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			UserService userService = new UserService();
			int c  = userService.login(username, password);
			if(c == 1)
			{
				resp.sendRedirect("userList");
			}
			else
			{
				resp.sendRedirect("login.jsp");
			}
//		}
//		else
//		{
//			resp.sendRedirect("login.jsp");
//		}
	}
}

