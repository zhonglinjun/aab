package com.yr.servlet;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class DownLoadServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getParameter("downUrl");
		System.out.println(path);
		
        FileInputStream fis = new FileInputStream(path);
        
        
        resp.setCharacterEncoding("utf-8");//解决乱码
        resp.setHeader("Content-Disposition", "attachment; filename=a1.jpg");//让浏览器跳出下载框
        
        ServletOutputStream out = resp.getOutputStream();
        byte[] bt = new byte[1024];
        int length = 0;
        while((length=fis.read(bt))!=-1){
            out.write(bt,0,length);
        }
        out.close();
        
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
}

