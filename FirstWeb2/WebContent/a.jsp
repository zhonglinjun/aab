<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="a" value="2015-10-20" />

<fmt:parseDate value="${a}" var="p"  pattern="yyyy-MM-dd" />

<%=new java.util.Date() %>
            
</body>
</html>