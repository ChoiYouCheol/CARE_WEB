<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css">
	<style type="text/css">
		header {
			font-size: 75px; font-family: times; margin: 15px;
		}
		.menu{
			height: 45px;
		}
		.total{
			width: 1200px;
			height: auto;
			position: absolute;
			left: 50%;
			margin-left: -600px;
		}
		footer{
			font-size: 20pt; font-family: Gabriola;
			color: deeppink;
		}
		.body{
			height: 800px;
			overflow: auto;
			padding: 5px;
		}
	</style>

</head>
<body>

	<header>
		<div align="center"><b>단무지</b></div>
	</header>
	<div class="menu">
		<div class="btn-group btn-group-justified">
				<a href="${pageContext.request.contextPath }/home" class="btn btn-primary">Home</a>
			<c:choose>
				<c:when test="${sessionScope.loginUser==null || sessionScope.loginUser=='' }">
					<a href="${pageContext.request.contextPath }/home" class="btn btn-primary">게시판</a>
					<a href="${pageContext.request.contextPath }/loginview" class="btn btn-primary">로그인</a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath }/home" class="btn btn-primary">게시판</a>
					<a href="${pageContext.request.contextPath }/logout" class="btn btn-primary">로그아웃</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

</body>
</html>