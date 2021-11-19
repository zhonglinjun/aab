package com.yr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yr.entity.Page;
import com.yr.entity.User;
import com.yr.service.UserService;

@WebServlet("/userList")
public class UserListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageNo = req.getParameter("pageNo");
		String pageSize = req.getParameter("pageSize");
		
		
		Page<User> page= new Page<User>();
		
		//获取与设置第几页
		if(pageNo == null || pageNo.equals(""))//第一次表示没有取到第几页,显示第1页
		{
			page.setPageNo(1);
		}
		else
		{
			page.setPageNo(Integer.valueOf(pageNo));
		}
		
		//获取与设置每页显示多少条数据
		if(pageSize == null || pageSize.equals(""))//每页显示多少条数据,默认每页显示3条数据
		{
			page.setPageSize(5);
		}
		else
		{
			page.setPageSize(Integer.valueOf(pageSize));
		}
		
		//java 如果传入参数是一个对象.就算在方法里面修改,外面也会一起修改.
		
		UserService userService = new UserService();
		userService.getUserAll(page);
		
		//返回到界面上的类型有修改.因为除了LIST还有很多分页的数据
		req.setAttribute("page", page);
		
		req.getRequestDispatcher("userList.jsp").forward(req, resp);
	}
}
