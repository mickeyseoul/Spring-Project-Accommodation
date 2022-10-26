<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<!-- roomInsertForm.jsp<br> -->


<center>
<h2>룸 등록</h2>

	<table border="1" width="90%">
		<tr>
			<td><img src="<%=request.getContextPath()%>/resources/${ hotel.image }" width="50" height="50"></td>
			<td>${ hotel.num }</td>
			<td>${ hotel.name }</td>
			<td>${ hotel.area1 }</td>
			<td>${ hotel.area2 }</td>
		</tr>
	</table>
	
	<form action="roomInsert.ad" method="post" enctype="multipart/form-data">
		<input type="hidden" name="hotelnum" value="${ hotel.num }">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>포인트</td>
				<td><input type="text" name="point"></td>
			</tr>
			<tr>
				<td>갯수</td>
				<td><input type="text" name="qty"></td>
			</tr>
			<tr>
				<td>인원</td>
				<td><input type="text" name="people"></td>
			</tr>
			<tr>
				<td>흡연</td>
				<td><input type="radio" name="smoke" value="0" checked>금연
				<input type="radio" name="smoke" value="1">흡연</td>
			</tr>
			<tr>
				<td>브리핑</td>
				<td><textarea name="brief" rows="3" cols="50" ></textarea></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" rows="5" cols="50"></textarea></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td><input type="file" name="upload"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="등록"></td>
			</tr>
		</table>
	</form>

</body>
</center>
