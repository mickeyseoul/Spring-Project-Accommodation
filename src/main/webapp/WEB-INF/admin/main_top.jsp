<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<!-- admin.main_top.jsp<br> -->

<!-- bootstrap src -->
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	
	
<!-- bootstrap -->
<nav class="navbar bg-light">
  <div class="container-fluid">
    <table style="width: 100%;">
		<tr>
			<td><a href="main.mall">
			<img src="<%=request.getContextPath()%>/resources/images/goMain.png" width="80" height="80">
			</a></td>
			<td align="right">${ loginInfo.id }님|<a href="logout.mem">로그아웃</a></td>
		</tr>
    </table>
    
    <!-- <form class="d-flex" role="search">
      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success" type="submit">Search</button>
    </form> -->
  </div>
</nav>
	

<center>

<table border="1" width="90%">
	<tr>
		<td>
			<a href="main.ad">관리자 메인 페이지</a><br>
			<a href="insert.ad">상품 등록</a><br>
			<a href="list.ad">상품 리스트</a><br>
			<a href="list.mem">회원리스트</a><br>
			<a href="">주문내역</a><br>
		</td>
	</tr>
	
</table>


</center>
