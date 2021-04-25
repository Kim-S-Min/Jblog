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
<script src = "<c:url value="/assets/javascript/jquery/jquery-3.6.0.js"/>"></script>
<script src = "<c:url value="/assets/javascript/users.js"/>"></script>
<body>

	<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>

				
				
	<form id="login-form" 
		name="loginform" 
		method="POST" 
		action="<c:url value="/users/login"/>">
		
		<label class="block-label" for="id">아이디</label> 
		<input id="id" name="id" type="text" value=""><br>

		<label class="block-label">패스워드</label> 
		<input name="password" type="password" value=""><br>


		<div>${message1}</div>
		<div>${message2}</div>
		<input class = "btn btn-secondary" 
			type="submit" 
			value="로그인" 
			onclick="okay(this.form.id, this.form.password, 
			'<c:url value="/users/logincheck"/>')">
	</form> 
	

		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />

</body>
</html>