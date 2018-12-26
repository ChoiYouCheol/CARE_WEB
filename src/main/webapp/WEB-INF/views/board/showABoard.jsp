<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 사항</title>

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
					<form action="${pageContext.request.contextPath }/modifyboard"
						method="post">
						<table class="table table-bordered" style="width: 60%;">
							<tr style="display: none;">
								<td><input type="text" name="bid" value="${board.bid }"></td>
							</tr>
							<tr>
								<th width="20%">작성자</th>
								<td width="30%">${board.mid }님</td>
								<th width="20%">조회수</th>
								<td>${board.hit }</td>
							</tr>
							<c:choose>
								<c:when test="${sessionScope.loginUser==board.mid }">
									<tr>
										<th>제 목</th>
										<td colspan="3"><input type="text" name="title"
											class="form-control" value="${board.title }"></td>
									</tr>
									<tr>
										<th>내 용</th>
										<td colspan="3"><textarea rows="10" cols="30"
												class="form-control" name="content">${board.content }</textarea>
										</td>
									</tr>
								</c:when>
								<c:otherwise>
									<tr>
										<th>제 목</th>
										<td colspan="3"><input type="text" name="title"
											class="form-control" value="${board.title }" disabled="disabled"></td>
									</tr>
									<tr>
										<th>내 용</th>
										<td colspan="3"><textarea rows="10" cols="30"
												class="form-control" name="content" disabled="disabled">${board.content }</textarea>
										</td>
									</tr>
								</c:otherwise>
							</c:choose>

							<tr>
								<td colspan="4" align="center"><c:choose>
										<c:when test="${sessionScope.loginUser==board.mid }">
											<button type="submit" class="btn btn-info">수 정</button>
										</c:when>
										<c:otherwise>
											<button type="submit" class="btn btn-info"
												disabled="disabled">수 정</button>
										</c:otherwise>
									</c:choose>
									<button type="button"
										onclick="location.href='${pageContext.request.contextPath}/boardview'"
										class="btn btn-info">목 록</button></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>

		<c:import url="../default/footer.jsp" />
	</div>

</body>
</html>