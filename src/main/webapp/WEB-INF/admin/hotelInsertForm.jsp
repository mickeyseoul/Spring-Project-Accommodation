<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="main_top.jsp" %>
<!-- hotelInsertForm.jsp<br> -->


<style>
#hotel{
	float: left;
	margin-left: 80;
	margin-right: -50;
}

</style>

<center>

<form action="insert.ad" method="post" enctype="multipart/form-data">
<table id="hotel" border="1">
	<!-- 호텔 등록 -->
	<tr>
		<td>호텔 등록</td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="name" value="페어필드 바이 메리어트 서울" size="30"></td>
	</tr>
	<tr>
		<td>지역</td>
		<td><input type="text" name="area1" value="서울시">
		<input type="text" name="area2" value="여의도"></td>
	</tr>
	<tr>
		<td>이미지</td>
		<td><input type="file" name="upload"></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="등록"></td>
	</tr>
	
	<!-- 호텔 리스트 -->
	<tr height="40"></tr>
	<tr><td>호텔 리스트</td></tr>
	<tr>
		<th>등록번호</th>
		<th>이름</th>
		<th>지역1</th>
		<th>지역2</th>
		<th>룸</th>
		<th>삭제</th>
	</tr>	
	<c:if test="${ lists eq null }">	
		<tr align="center">
			<td>
				등록된 상품이 없습니다.
			</td>
		</tr>
	</c:if>
	
	<c:if test="${ lists ne null }">	
	<c:forEach var="hotel" items="${ lists }">
		<tr align="center">
			<td>
				${ hotel.num }
			</td>
			<td>
				<a href="roomList.ad?refresh=0&num=${ hotel.num }" target="listframe">${ hotel.name }</a>
			</td>
			<td>
				${ hotel.area1 }
			</td>
			<td>
				${ hotel.area2 }
			</td>
			<td>
				${ hotel.roomkind }
			</td>
			<td><a href="deleteHotel.ad?num=${ hotel.num }">삭제</a></td>
		</tr>
	</c:forEach>
	</c:if>
	
</table>
</form>

<iframe width="45%" height="500" src="roomList.ad?refresh=0&num=0" name="listframe"></iframe>


</center>