<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 화면</title>

	<c:if test="${sessionScope.loginUser=='' || sessionScope.loginUser==null}">
		<c:redirect url="${pageContext.request.contextPath }/home"/>
	</c:if>

</head>
<body>

	<div class="total">
		<c:import url="../default/header.jsp" />

		<div class="body">
			<div class="blistForm">
				<div class="container" align="center">
					<table class="table table-hover" style="width: 65%;">
						<tr style="font-size: 18px; font-family: 굴림;">
							<th width="60%" style="text-align: center;">제목</th>
							<th width="25%" style="text-align: center;">작성자</th>
							<th width="15%" style="text-align: center;">조회수</th>
						</tr>
						<c:choose>
							<c:when test="${boardlist.size()==0 || boardlist==null }">
								<tr>
									<td colspan="4" align="center">게시글이 없습니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="b" items="${boardlist }">
									<tr align="center"
										onclick="location.href='${pageContext.request.contextPath}/showABoard?bid=${b.bid }'">
										<td>${b.title }</td>
										<td>${b.mid }</td>
										<td>${b.hit }</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
						<tr>
							<td colspan="4" align="center"><button type="button"
							 onclick="location.href='${pageContext.request.contextPath}/writeboard_view'" class="btn btn-info">게시글 작성</button>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<c:import url="../default/footer.jsp" />
	</div>

</body>
</html>