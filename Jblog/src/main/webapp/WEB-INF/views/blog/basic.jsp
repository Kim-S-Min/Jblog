<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/blogheader.jsp" />
	<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />	
	
	<h1>블로그 제목</h1>
	<h2>${vo.getBlogTitle()}</h2>
	<h1>로고 이미지</h1>
	<form method="post" >		
		<label for="blogTitle">블로그제목</label> 
		<input id="blogTitle" name="blogTitle" type="text" value="${vo.getBlogTitle()}">
		<input id="userNo" name="userNo" type="hidden" value="${vo.getUserNo() }">
		<input type="submit" value="등록">
		<label>로고이미지</label>			
			<img src="${pageContext.request.contextPath}/${vo.getLogoFile()}">
			<input type="file" id = "file" name="file" >		
			<input class = "btn btn-secondary" value="기본설정변경">
	</form>
</body>
</html>