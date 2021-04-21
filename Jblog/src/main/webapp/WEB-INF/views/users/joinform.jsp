<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>          
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<div id="wapper">
			<div id="content">
				<div id="site-introduction">
				
	<h1>회원 가입</h1>
	
	<form
		id="join-form"
		name="registerForm" 
		action="<c:url value="/users/join"/>"
		method="POST"
		>
		<input type="hidden" name="check" value="f">
		<input type="hidden" name="a" value="join">
		
		<label for="userName">이름</label>
		<input name="userName" type="text" placeholder="이름을 입력하십시오"><br>
		<!-- 이름 필드의 에러메시지 확인 후 출력 -->
		<spring:hasBindErrors name="userVo">
			<!-- name 필드에 검증 오류가 있다면 -->
			<c:if test="${ errors.hasFieldErrors('userName') }">
				<strong style="color:red">
				<spring:message code="${errors.getFieldError('userName').codes[0] }"
					text="${errors.getFieldError('userName').defaultMessage }" />
				</strong><br/>
			</c:if>
			
		<label for="id">id</label>
		<input type="text" name="id" placeholder="id을 입력하십시오.">
		
		<!-- 이메일 체크 버튼 -->
		<input type="button" 
			value="id 중복체크" 
			onclick="checkid(this.form.id, '<c:url value="/users/idcheck" />')" /><br>
	
		
		</spring:hasBindErrors>
		<label for="password">비밀번호</label>
		<input name="password" type="password" placeholder="비밀번호를 입력하십시오"><br>
	
		
	
		
		<label for="agree">약관동의</label><br>
		<input type="radio" name="agree" value="Yes" >서비스 약관에 동의합니다</radio><br>
		<input type="submit" value="회원가입">	
	</form>
		
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>
