<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../mall/main_top.jsp" %>
registerForm.jsp<br>

<%-- <%=request.getContextPath()%> /ex 까지 나오지만 webapp까지 포함한 의미 --%>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script type="text/javascript">

/* 아이디 중복버튼 */ /* jquery 사용 */
$(document).ready(function(){
	//alert(1);
	isCheck=0;
	
	$('#idchk').click(function(){
		//alert('idchk')
		isCheck=1;
		
		$.ajax({
			url : "id_check_proc.mem",
			data : ({
				inputid : $("input[name='id']").val()
			}),
			success : function(data){
				//alert(data);
				if(data=="cannot"){
					alert("이미 사용중인 아이디입니다.")
					isCheck=0;
				}else{
					alert("사용 가능한 아이디입니다.")
				}
			}//success
		})//ajax
		
	});//$('#idchk').click
	
	$('input[name="id"]').keydown(function(){
		//alert('keydown');
		isCheck=0;
	});
	
	$('#btnSubmit').click(function(){
		//alert('#btnSubmit');
		if(isCheck==0){
			alert("아이디 중복 확인을 해주세요.")
			return false;
		}else if($('input[name="password"]').val()==''){
			//alert('비밀번호가 누락되었습니다.');
			//return false;
		}else if($('input[name="password"]').val() != $('input[name="passwordchk"]').val()){
			alert('비밀번호가 일치하지 않습니다.');
			return false;
		}else{
			alert('회원가입이 완료되었습니다.');
		}
	});//$('#btnSubmit').click
	
	
	
});//ready

</script>

<style>
.err{
		font-size: 9pt;
		color : red;
		font-weight: bold;
}
</style>

<center>
<h2>회원 가입</h2>

<form:form commandName="memberBean" name="f" action="register.mem" method="post">
<!-- commandName : 컨트롤러에서 설정한 command 객체(Bean 클래스 객체)의 첫글자 소문자 (X참조변수)-->
<!-- commandName="커맨드객체"(별칭 or memberBean(커맨드 객체 저절로 앞글자 소문자됨)) -->
<!-- input 태그 value 속성에 el문에 커맨드객체를 사용 => 새로고침시 누락이외에 입력한 데이터들 다시 나옴 -->
	<table border="1" width="50%">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="taylor">
			<input type="button" id="idchk" value="중복확인" onclick="idChk()"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="테일러">
			<form:errors cssClass="err" path="name"></form:errors></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="password" value="${ memberBean.password }">
			<form:errors cssClass="err" path="password"></form:errors></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td><input type="text" name="passwordchk" value=""></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" value="taylor@gmail.com"></td>
		</tr>
		<tr>
			<td>주민번호</td>
			<td><input type="text" name="rrn1" value="891213">-
			<input type="text" name="rrn2" value="2222222"></td>
		</tr>
		<tr>
			<td>핸드폰</td>
			<td><input type="text" name="hp1" value="010" size="4">-
			<input type="text" name="hp2" value="1313" size="4">-
			<input type="text" name="hp3" value="1234" size="4"></td>
		</tr>
		<tr>
			<td>주소</td>  
			<td><input type="text" name="zipcode1" value="서울시"><br>
			<input type="text" name="zipcode2" value="용산구"><br>
			<input type="text" name="zipcode3" value="경리단길"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" id="btnSubmit" value="회원가입">
			</td>
		</tr>
	</table>
</form:form>

</center>