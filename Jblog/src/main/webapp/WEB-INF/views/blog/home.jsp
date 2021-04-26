<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jblog blog home</title>
</head>
<script src = "<c:url value="/assets/javascript/jquery/jquery-3.6.0.js"/>"></script>
<body>
	<jsp:include page="/WEB-INF/views/includes/blogheader.jsp" />

	<div id="recentpost">
		<c:choose>
			<c:when test="${empty postList }">
					<h1>등록된 글이 없습니다</h1>
				</c:when>
				<c:otherwise>
					<h2>${postList[0].getPostTitle()}</h2> 
					<p>${postList[0].getPostContent()}</p>
					<p>${postList[0].getPostNo()}</p>
					<p>${userblogId.getUserNo()}</p>
					<h3>comments</h3>
					<c:choose>
						<c:when test = "${not empty authUser }">
							<form method = "POST" action = "${userblogId.getId()}/insertcomments">
								<input type="hidden" name = "postNo" id = "postNo" value = "${postList[0].getPostNo()}">
								<input type="hidden" name = "userNo" id = "userNo" value = "${authUser.getUserNo() }">
								<label>${authUser.getUserName() }</label>
								<input type="text" name = "commentsContent" id ="commentsContent">
								<input type="submit" value = "코멘트작성">
							</form>	
						</c:when>
					</c:choose>
					<c:forEach items="${commenstList}" var="commentsList">
						<p>${commentsList.getUserName() }</p>
						<p>${commentsList.getCmtContent() }</p>
						<p>${commentsList.getRegDate() }</p>
						<P>
						<c:choose>
							<c:when test = "${commentsList.getUserNo() == authUser.getUserNo() }">
							<form method="post" action="<c:url value="${userblogId.getId()}/deletecomments"/>">
							<input type='hidden' id = "no" name="no" value="${commentsList.getCmtNo()}">
							<input class ="btn btn-danger" type="submit" value="삭제">
							</form>
							</c:when>
						</c:choose>
						</p>
					</c:forEach>	
				</c:otherwise>
		</c:choose>
	</div>
	
	<div id = "category">
		<a href="${userBlogId.getId()}">카테고리</a>
		<c:forEach items="${cateList}" var="cate">
				<form method = "POST">
					<input type="hidden" name = "cateNo" id = "cateNo" value = "${cate.getCateNo() }">
					<input type="submit" id= "but" value = "${cate.getCateName() }">
				</form>	
		</c:forEach>
	</div>
	
	<div id="postbycategory">
		<c:forEach items="${postList}" var="catePost">
			<p>${catePost.getPostTitle()}</p>
			<p>${catePost.getRegDate()}</p>
		</c:forEach>
	</div>

	<jsp:include page="/WEB-INF/views/includes/footer.jsp" />


</body>
</html>