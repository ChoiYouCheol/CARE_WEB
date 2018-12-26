<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

	<c:if test="${sessionScope.loginUser!=null}">
		<c:redirect url="${pageContext.request.contextPath }/home"/>
	</c:if>

	<script type="text/javascript">
		var regNumber = /^[0-9]*$/;
		var idOk = false;
		var pwdOk = false;
		var nameOK = false;
		function equalPwd(){
			var pwd = document.getElementById("pwd").value;
			var repwd = document.getElementById("repwd").value;
			
			if(pwd==repwd){
				document.getElementById("pwdText").innerHTML="비밀번호 일치";
				pwdOk = true;
			}else{
				document.getElementById("pwdText").innerHTML="비밀번호 불일치";
				pwdOk = false;
			}
		}
		function checkId(){
			var id = document.getElementById("id").value;
			console.log(id);
			if(id == ''){
				document.getElementById("idText").innerHTML="아이디를 입력하세요.";
				idOk = false;
				return;
			}
			if(regNumber.test(id.charAt(0))){
				document.getElementById("idText").innerHTML="숫자 시작 안됩니다.";
				idOk = false;
			} else{
				document.getElementById("idText").innerHTML="";
				idOk = true;
			}
		}
		function checkRegister(){
			if(!idOk){
				alert("아이디를 확인해주세요.");
			}else if(!pwdOk){
				alert("비밀번호를 확인해주세요.");
			}else if(!nameOK)
				alert("이름을 확인해주세요.");
			else
				document.getElementById("doRegister").submit();
		}
		function checkName(){
			var name = document.getElementById("name").value;
			console.log(name);
			if(name == ''){
				document.getElementById("nameText").innerHTML="이름을 입력해주세요.";
				nameOK = false;
				return;
			} else{
				document.getElementById("nameText").innerHTML="";
				nameOK = true;
			}
				
		}
	</script>

</head>
<body>

	<div class="total">
		<c:import url="../default/header.jsp" />

		<div class="body">
			<div class="signinInfo" style="margin-left: 28%;">
				<div class="form-group">
					<form action="${pageContext.request.contextPath }/signin" method="post" id="doRegister">
						<table style="width: 80%;">
							<tr>
								<td width="17%">아이디</td><td width="50%"><input type="text" class="form-control" name="id" id="id" size="44.75" onkeyup="checkId()"></td><td><a id="idText"></a></td>  
							</tr>
							<tr>
								<td>비밀번호</td><td><input type="password" name="pwd" id="pwd" size="44.75" class="form-control"></td>
							</tr>
							<tr>
								<td>비밀번호 재입력</td><td><input type="password" class="form-control" name="repwd" id="repwd" size="44.75" onkeyup="equalPwd()"></td><td><a id="pwdText"></a></td>
							</tr>
							<tr>
								<td>이   름</td><td><input type="text" name="name" class="form-control" id="name" size="44.75" onkeyup="checkName()"></td><td><a id="nameText"></a></td>
							</tr>
							<tr>
								<td>도   시</td>
								<td>
									<select name="city" class="form-control">
										<option value="서울특별시">서울특별시</option>
										<option value="인천광역시">인천광역시</option>
										<option value="수원시">수원시</option>
										<option value="부천시">부천시</option>
										<option value="용인시">용인시</option>
										<option value="화성시">화성시</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>주   소</td>
								<td>
									<input type="text" name="place" size="44.75" class="form-control">
								</td>
							</tr>
							<tr>
								<td>자기소개</td>
								<td>
									<textarea rows="5" cols="46" name="introduce" class="form-control"></textarea>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<button type="button" onclick="checkRegister()" class="btn btn-primary">가입</button>
									<button type="button" onclick="location.href='${pageContext.request.contextPath}/loginview'" class="btn btn-primary">취소</button>
								</td>
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