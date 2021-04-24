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
	<form method="post">
	    <label for="postTitle">제목</label>
	    <input type="text" name="postTitle" value="">
	
	    <select id="cateNo" name="cateNo">
	        <c:forEach items="${list}" var="cateVo">
	            <option value="${cateVo.getCateNo() }">${cateVo.getCateName() }</option>
	        </c:forEach>
	    </select>
	
	    <br>
	    <label for="postContent">내용</label>
	    <textarea name="postContent"></textarea>
	    <br>
	    <input class="btn btn-secondary" type="submit" value="등록">
	</form>
</body>
</html>