<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
	$(function() {
		$("#aaa").click(function() {
			var phone = $("#phone").val();

			$.ajax({
				url : "code",
				type: "get",
				data:{"phone":phone},
				success : function(result) {
					alert(result);
				}
			});
		});
	});
</script>

</head>
<body>
	<form action="login" method="post">
		用户名:<input type="text" name="username"><br> 密码:<input
			type="text" name="password"><br> 
			<!-- 手机	<input type="text"	name="phone" id="phone"> 
			<input type="button" value="获取验证码"	id="aaa"> <br> 
			验证码：<input type="text" name="code"	id="code"><br>  -->
			<input type="submit" value="登陆">
	</form>
</body>
</html>
