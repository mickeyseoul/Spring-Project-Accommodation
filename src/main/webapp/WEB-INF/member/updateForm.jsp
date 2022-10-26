<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../mall/main_top.jsp" %>
updateForm.jsp<br>

<script type="text/javascript">
function goUpdate(){
	//alert(f.password.value);
	if(f.password.value != f.passwordchk.value){
		alert('비밀번호가 다릅니다.');
		return false;
	}
}
</script>

<center>
<h2>회원 수정</h2>

<form name="f" action="update.mem" method="post">
	<input type="hidden" name="num" value="${ member.num }">
	<table border="1" width="80%">
		<tr>
			<td>아이디</td>
			<td>${ member.id }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${ member.name }"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="password" value=""></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td><input type="text" name="passwordchk"  value=""></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" value="${ member.email }"></td>
		</tr>
		<%-- <tr>
			<td>주민번호</td>
			<td><input type="text" value="${ member.name }"></td>
		</tr> --%>
		<tr>
			<td>핸드폰</td>
			<td><input type="text" name="hp1" value="${ member.hp1 }" size="4">-
			<input type="text" name="hp2" value="${ member.hp2 }" size="4">-
			<input type="text" name="hp3" value="${ member.hp3 }" size="4"></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="zipcode1" value="${ member.zipcode1 }"><br>
			<input type="text" name="zipcode2" value="${ member.zipcode2 }"><br>
			<input type="text" name="zipcode3" value="${ member.zipcode3 }"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="변경" onclick="return goUpdate()">
			</td>
		</tr>
		
	</table>
</form>

</center>