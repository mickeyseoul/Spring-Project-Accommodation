<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../mall/main_top.jsp" %>
login.jsp<br>

<script type="text/javascript">
	function logincheck(){
		//alert(1);
		if(f.logincheck.value==-1){
			alert('가입된 아이디가 없습니다.')
		}else if(f.logincheck.value==-2){
			alert('아이디와 비밀번호가 일치하지 않습니다.')
		}
	}
</script>

<body onload="logincheck()">
<center>
<h2>로그인</h2>

<form name="f" action="login.mem" method="post">
	<input type="hidden" name="logincheck" value="${ loginCheck }">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="admin"></td>
		</tr>
		<tr>
			<td>비번</td>
			<td><input type="password" name="password" value=""></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="로그인"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<a href="findid.mem">아이디 찾기</a> | <a href="">비밀번호 찾기</a>
			</td>
		</tr>
		<tr>
	</table>
</form>

</center>
</body>