<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />	
				
	<h2>"감사합니다. 회원 가입 및 블로그가 성공적으로 만들어 졌습니다."</h2>
	<p><a href="<c:url value="/users/login"/>">로그인하기</a></p>

</body>
</html>