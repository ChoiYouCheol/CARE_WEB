<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
</head>
<body>

	<div class="total">
		<c:import url="../default/header.jsp" />

		<div class="body">
			<div class="timeInfo" align="center" style="width: 40%; margin: 10px;">
				<h1>Hello world!</h1>
				<P>The time on the server is ${serverTime}.</P>
			</div>
		</div>

		<c:import url="../default/footer.jsp" />
	</div>
</body>
</html>
