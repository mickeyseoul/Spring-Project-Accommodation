<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../mall/main_top.jsp" %>
findIdResult.jsp<br>

<center>

<table>

	<c:if test="${ result eq 0 }">
		<tr>
			<td>일치하는 회원정보가 없습니다.</td>
		</tr>
	</c:if>
	
	<c:if test="${ result eq 1 }">
		<tr>
			<td>${ memberBean.id } 
			가입일자 : 
			<fmt:parseDate var="reg_date" pattern="yyyy-MM-dd" value="${ memberBean.reg_date }"/>
			<fmt:formatDate value="${ reg_date }" pattern="yyyy-MM-dd"/>
			</td>
		</tr>
	</c:if>
	
</table>

</center>