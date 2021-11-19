package com.yr.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.yirong.EncryptUtils;
import com.yr.entity.User;
import com.yr.qq.MailTest;
import com.yr.service.UserService;

@WebServlet("/userAdd")
@MultipartConfig
public class UserAddServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("name");
		String email = req.getParameter("email");
		String addr = req.getParameter("addr");
		String age = req.getParameter("age");

		Part head = req.getPart("head");

		// 得到文件名
		String fileName = head.getSubmittedFileName();

		// 文件都是用流操作的
		InputStream inputStream = head.getInputStream();// 输入流

		long a = System.currentTimeMillis();
		String path = "C:\\Users\\Administrator\\Desktop\\b\\" + a + fileName;
		OutputStream outputStream = new FileOutputStream(path);

		byte[] b = new byte[1024];
		int length = 0;
		while ((length = inputStream.read(b)) != -1) {
			outputStream.write(b, 0, length);
			outputStream.flush();
		}

		outputStream.close();
		inputStream.close();

		User user = new User();
		user.setName(name);
		user.setAddr(addr);
		user.setAge(Integer.valueOf(age));
		user.setHead(path);
		
		//
		EncryptUtils eu = new EncryptUtils();
		password = eu.encryptToMD5(password);
		
		user.setPassword(password);
		user.setEmail(email);

		UserService userService = new UserService();
		userService.addUser(user);

		// 新增成功，就需要发送邮箱给指定邮箱
		sendMail(name,email);

		resp.sendRedirect("userList");
	}

	public void sendMail(String name,String email) {
		MailTest mail = new MailTest();
		mail.setSubject("账号激活");

		String content = "<a href='http://192.168.1.73:8080/FirstWeb/active?username="+name+"'>点击激活</a>";
		mail.setContent(content);
		mail.setTo(new String[] { email });
		try {
			mail.sendMessage();
			System.out.println("发送邮件成功！");
		} catch (Exception e) {
			System.out.println("发送邮件失败！");
			e.printStackTrace();
		}
	}
}
