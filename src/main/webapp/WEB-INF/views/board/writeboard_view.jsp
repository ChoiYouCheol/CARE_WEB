<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>

	<c:if test="${sessionScope.loginUser=='' || sessionScope.loginUser==null}">
		<c:redirect url="${pageContext.request.contextPath }/home"/>
	</c:if>

</head>
<body>

	<div class="total">
		<c:import url="../default/header.jsp" />

		<div class="body">
			<div class="bwriteForm">
				<div class="container" align="center">
					<form action="${pageContext.request.contextPath }/writeboard" method="post">
						<table class="table table-bordered" style="width: 50%;">
							<tr style="display: none;"><td><input type="text" name="mid" value="${sessionScope.loginUser }"></td></tr>
							<tr>
								<th width="20%">작성자</th>
								<td>${sessionScope.loginUser }님</td>
							</tr>
							<tr>
								<th>제   목</th>
								<td><input type="text" name="title" class="form-control"></td>
							</tr>
							<tr>
								<th>내   용</th>
								<td>
									<textarea rows="10" cols="30" class="form-control" name="content"></textarea>
								</td>
							</tr>
							<tr><td colspan="2" align="center">
								<button type="submit" class="btn btn-info">작 성</button>
								<button type="button" onclick="location.href='${pageContext.request.contextPath}/boardview'" 
									class="btn btn-info">취소</button>
							</td></tr>
						</table>
					</form>
				</div>
			</div>
		</div>

		<c:import url="../default/footer.jsp" />
	</div>

</body>
</html>