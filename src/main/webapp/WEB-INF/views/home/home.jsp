<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>

	<div class="total">
		<c:import url="../default/header.jsp" />

		<div class="body">
			<div class="timeInfo" align="center" style="width: 40%; margin: 10px;">
				<h1>Home 화면입니다.!</h1>
				<P>현재 시간은  : ${serverTime}.</P>
			</div>
		</div>

		<c:import url="../default/footer.jsp" />
	</div>
</body>
</html>
