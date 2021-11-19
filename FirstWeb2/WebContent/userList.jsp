<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.yr.entity.User"%>
<%@ page import="com.yr.entity.Page"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

</script>
</head>
<body>
	<table border="1">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>head</th>
			<th>addr</th>
			<th>age</th>
		</tr>
		<% 
		Page<User> pg = (Page<User>)request.getAttribute("page");
		
		List<User> list = pg.getList();
		for(int i = 0;i<list.size();i++){
			User user = list.get(i);
		%>
			<tr>
				<td><%=user.getId() %></td>
				<td><%=user.getName()%></td>
				<td>
					 <img height="50px" width="50px" alt="" src="download?downUrl=<%= URLEncoder.encode(user.getHead()) %>" /> 
				</td>
				<td><%=user.getAddr() %></td>
				<td><%=user.getAge() %></td>
			</tr>
		<%}%>
		
	</table>
	
	
		总共<font color="red"><%=pg.getSum() %></font> 条数据&nbsp;&nbsp;&nbsp;
		总共<font color="red"><%=pg.getPageCount() %></font> 页&nbsp;&nbsp;&nbsp;
		当前<font color="red"><%=pg.getPageNo() %></font> 页
		
		<br>
		<a href="userList?pageNo=1" >首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
		
		<!-- 不是第一页,才能显示上页 -->
		<% if(pg.getPageNo()  != 1){ %>
		<a href="userList?pageNo=<%=pg.getPageNo() -1 %>" >上页</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<%} %>
		
		<!-- 不是最后一页,才能显示下页 -->
		<% if(pg.getPageNo()  != pg.getPageCount()){ %>
		<a href="userList?pageNo=${page.pageNo +1 }" >下页</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<%} %>
		
		<a href="userList?pageNo=${page.pageCount}" >尾页</a>
		
		
		<br><br>
		<a href="userAdd.jsp">新增</a>
		
		
		<!-- 超连接在下载 
		<a href="download?downUrl=<%= URLEncoder.encode("C:\\Users\\Administrator\\Desktop\\b\\1628594299800a.jpg") %>">下载</a>-->
</body>
</html>