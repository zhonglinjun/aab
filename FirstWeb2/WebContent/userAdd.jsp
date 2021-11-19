<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="userAdd" method="post" enctype="multipart/form-data">
		姓名：<input type="text" name="name" id="name"><br>
		密码：<input type="text" name="password" id="password"><br> 
		邮箱：<input type="text" name="email" id="email"><br> 
		地址：<input type="text" name="addr" id="addr"><br>
		年龄：<input type="text" name="age" id="age"><br>
		头像：<input type="file" name="head" id="head"><br> 
		<input type="submit" value="提交">
	</form>
</body>
</html>