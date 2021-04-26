<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>        
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
</head>
<script src="<c:url value="/assets/javascript/jquery/jquery-3.6.0.js"/>"></script>
<script src="<c:url value="/assets/javascript/users.js"/>"></script>
<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		
	<form
		id="join-form"
		name="registerForm" 
		action="<c:url value="/users/join"/>"
		method="POST"
		onsubmit="return joinForm(this)"
		>
		<input type="hidden" name="check" value="f">
		<input type="hidden" name="a" value="join">
		
		<label for="userName">이름</label>
		<input name="userName" type="text" placeholder="이름을 입력해주세요"><br>
		
		<label for="id">아이디</label>
		<input type="text" name="id" placeholder="아이디를 입력해주세요">
		
		<input type="button" class="btn btn-secondary" value="중복체크" onclick="checkId(this.form.id,'<c:url value="/users/idcheck"/>')">
		<div id = "msg_id"></div>
	
		<label for="password">비밀번호</label>
		<input name="password" type="password" placeholder="비밀번호를 입력해주세요"><br>
		
		<label for="agree">약관동의</label><br>
		<input type="checkbox" name="agree">서비스 약관에 동의합니다</radio><br>
		<input class = "btn btn-secondary" type="submit" value="회원가입">
	</form>

		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />

</body>
</html>