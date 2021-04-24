<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>    
<div id="navigation">
	<ul>
		<li> <a href = "<c:url value="/${authUser.getId()}" />">블로그</a></li>
		<li> <a href = "<c:url value="basic" />">기본 설정</a></li>
		<li> <a href = "<c:url value="category" />">카테고리</a></li>
		<li> <a href = "<c:url value="write" />">글 작성</a></li>
	</ul>
</div>