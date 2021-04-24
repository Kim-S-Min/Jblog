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
	
	<table>
	
	<tr>
		<th>번호</th>
		<th>카테고리명</th>
		<th>포스트수</th>
		<th>설명</th>
		<th>등록일</th>
		<th>삭제</th>
	</tr>
	<c:forEach items="${list }" var="vo">
		<tr>
			<td>${vo.getCateNo() }</td>
			<td>${vo.getCateName() }</td>
			<td>${vo.getPostCount() }</td>
			<td>${vo.getDescription() }</td>
			<td>${vo.getRegDate() }</td>
			<td> 
				<c:choose>
					<c:when test = "${vo.getPostCount() == 0 }">
					<form method="post" action="<c:url value="delete"/>">
					<input type='hidden' id = "no" name="no" value="${vo.getCateNo()}">
						<div><input class ="btn btn-danger" type="submit" value="삭제"></div>
					</form>
					</c:when>
					<c:otherwise>
						<div> <button class ="btn btn-warning" onclick="alert('삭제할 수 없습니다.')">X</button></div>
					</c:otherwise>
				</c:choose>
			
			</td>
		</tr>
	</c:forEach>	
	</table>
	<h3>카테고리 추가</h3>
	<div>
		<form method="POST">
			<label for="cateName">카테고리명</label>
		<input id="cateName" name="cateName" type="text">
		<br>
		<label for="description">설명</label>
		<input id="description" name="description" type="text">
		<br>
		<input id="userNo" name="userNo" type="hidden" value="${authUser.getUserNo() }">
			<input class="btn btn-secondary" type="submit" value="카테고리 추가">
		</form>
	</div>
	
</body>
</html>