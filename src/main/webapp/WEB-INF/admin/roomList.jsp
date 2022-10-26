<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
roomList.jsp<br>

<script type="text/javascript">
	function refresh(){
		alert("룸이 등록되었습니다.")
		window.parent.location.reload(); //부모창 새로고침
	}
	function goPage(num){
		location.href='roomInsert.ad?refresh=0&num='+num;
	}
</script>

<center>
<h2>룸 리스트</h2>

<c:if test="${ refresh eq 1 }">
<body onload="refresh()"></body>
</c:if>

<c:if test="${ number eq 0 }">
	<table border="1" width="90%">
		<tr>
			<td align="center">조회할 호텔을 선택해 주세요.</td>
		</tr>
	</table>	
</c:if>
	
<c:if test="${ number > 0 }">
	<table border="1" width="90%">
		<tr>
			<td><img src="<%=request.getContextPath()%>/resources/${ hotel.image }" width="50" height="50"></td>
			<td>${ hotel.num }</td>
			<td>${ hotel.name }</td>
			<td>${ hotel.area1 }</td>
			<td>${ hotel.area2 }</td>
		</tr>
		<tr>
			<!-- <td><input type="button" value="룸등록" onclick="javascript:location.href='roomInsert.ad'"></td> -->
			<td><input type="button" value="룸등록" onclick="goPage('${ hotel.num }')"></td>
		</tr>
	</table>
	

	<!-- 룸 리스트 -->
	<table width="90%">
	
		<tr>
			<td></td>
			<td>번호</td> <!-- 편의상 번호 -->
			<td>이름</td>
			<td>가격</td>
			<td>수량</td>
			<td>인원</td>
			<td>흡연</td>
			<td></td>
			<td></td>
		</tr>
		
		<c:if test="${ fn:length(lists) eq 0 }">
			<tr>
				<td>등록된 룸이 없습니다.</td>
			</tr>
		</c:if>
		
		<c:if test="${ fn:length(lists) ne 0 }">
			<c:forEach var="room" items="${ lists }" varStatus="i">
				<tr>
					<td><img src="<%= request.getContextPath() %>/resources/${ room.image }" width="50" height="50"></td>
					<td>${ i.count }</td>
					<td>${ room.name }</td>
					<td>${ room.price }</td>
					<td>${ room.qty }</td>
					<td>${ room.people }</td>
					<td>${ room.smoke }</td>
					<td><a href="">수정</a></td>
					<td><a href="deleteRoom.ad?num=${ room.num }&hotelnum=${ room.hotelnum }">삭제</a></td>
				</tr>
			</c:forEach>
		</c:if>
	
	</table>

</c:if>
</center>
