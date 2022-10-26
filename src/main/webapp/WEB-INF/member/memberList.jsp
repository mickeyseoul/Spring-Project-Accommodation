<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../admin/main_top.jsp" %>
memberList.jsp<br>

<center>
<h2>회원 리스트</h2>

<table border="1" width="80%">
	<tr>
		<td colspan="9">총 ${ fn:length(lists) } 개</td>
	</tr>

	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th>
		<th>주민번호</th>
		<th>핸드폰</th>
		<th>주소</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	
	<c:if test="${ fn:length(lists) eq 0 }">
		<tr>
			<td colspan="9" align="center">등록된 회원이 없습니다.</td>
		</tr>
	</c:if>
	
	<c:if test="${ fn:length(lists) ne 0 }">
		<c:forEach var="member" items="${ lists }" varStatus="i">
			<tr>
				<td>${ i.count }</td>
				<td>${ member.id }</td>
				<td>${ member.name }</td>
				<td>${ member.email }</td>
				<td>${ member.rrn1 }-${ member.rrn2 }</td>
				<td>${ member.hp1 }-${ member.hp2 }-${ member.hp3 }</td>
				<td>${ member.zipcode1 } ${ member.zipcode2 } ${ member.zipcode3 }</td>
				<td><a href="update.mem?num=${ member.num }">수정</a></td>
				<td><a href="delete.mem?num=${ member.num }">삭제</a></td>
			</tr>
		</c:forEach>
	</c:if>
	
	
</table>


</center>