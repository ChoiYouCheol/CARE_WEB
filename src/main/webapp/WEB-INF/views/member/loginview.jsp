<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="total">
		<c:import url="../default/header.jsp" />

		<div class="body">
			<div class="loginInfo" style="width: 40%; float: right;">
				<img alt="ryan" src="${pageContext.request.contextPath }/resources/img/ryan.png"
					style="width: 50%; height: 50%;"
				>
			</div>
			<div class="loginForm" style="width: 60%; margin-top: 20px;" align="right">
				<form action="${pageContext.request.contextPath }/login" method="post">
					<div class="summitForm" style="float: right; width: 25%;" align="left">
						<button type="submit" style="height: 60px; font-size: 18px" class="btn">로그인</button>
					</div>
					<div class="inputForm" style="width: 50%;" align="right">
						<table>
							<tr><td><input type="text" name="id" style="height: 30px;"></td></tr>
							<tr><td><input type="password" name="pwd" style="height: 30px;"></td></tr>
							<tr><td><a href="${pageContext.request.contextPath }/signin_view">회원가입</a></td></tr>
						</table>
					</div>
				</form>
			</div>
		</div>

		<c:import url="../default/footer.jsp" />
	</div>

</body>
</html>