package com.yr.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("bb");
		list.add("cc");
		list.add("dd");
		list.add("ee");
		
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("a.jsp").forward(req, resp);
	}
	
	
	
}
