<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../mall/main_top.jsp" %>
findIdForm.jsp<br>

<center>
<h2>아이디 찾기</h2>

<form action="findid.mem" method="post">
<table border="1">
	<tr>
		<td>이메일</td>
		<td><input type="text" name="email" value="mickey@gmail.com"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="name" value="미키"></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="아이디 찾기"></td>
	</tr>
</table>
</form>

</center>





