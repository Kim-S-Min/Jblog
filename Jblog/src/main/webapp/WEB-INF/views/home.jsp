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
	
	<form>
		<input type = "txet">
		<input class="btn btn-secondary" type = "submit" value = "검색"> <br>
		<input type = "radio" name = "searchcate" value="blogName"> 블로그제목
		<input type = "radio" name = "searchcate" value="bloger"> 블로거
	</form>
</body>
</html>