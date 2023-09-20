<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
function userData(){
	console.log("실행확인");
	console.log($("#name"));
	$.ajax({
		type : 'POST',           
	    url : '/datain',       
	    dataType : 'text',       
	    async: true,
	    data :{
	    	"ID" : $("#ID").val(),
	    	"PASSWORD" : $("#PASSWORD").val(),
	    	"NAME" : $("#NAME").val(),
	    	"EMAIL" : $("#EMAIL").val(),
	    	"PHONENUM" : $("#PHONENUM").val(),
	    	"BURTH" : $("#BURTH").val()
	    } ,
	    success : function(data) {
	    	console.log("data:"+ data);
	    	alert("성공");
	    	location.href="/inner"
	    },
	    error : function(request,status,error) {
	    	alert("실패 ");
	    	console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	    	console.log($("#name").val())
	    	
	    }
	    	
	})
}
</script>
</head>
<body>
<p> 정보 작성 </p>
<%-- <input type="hidden" id="member_in" value="${member_in} }"/> --%>
<!-- <div> -->
<!-- <p> 아이디  <input type="text" id="id" name="id" value="20자리 이하 "></p> -->
<!-- <p> 비밀번호 <input type="text" id="password" name="password" value="20자리 이하"></p> -->
<!-- <p> 이름 <input type="text" id="name" name="name" value="이름"></p> -->
<!-- <p> 이메일 <input type="text" id="email" name="email" value=" @포함"></p> -->
<!-- <p> 휴대폰 번호 <input type="text" id="phonenum" name="phonenum" value="010 포함 11자리"></p> -->
<!-- <p> 생년월일 <input type="text" id="burth" name="burth" value="ex:980430"></p> -->
<!-- <input type="button" value="확인" onclick="userData()"> -->
<!-- </div> -->

<button onclick="location.href='/member'">관리자홈</button>
	<form id="alldata" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name ="ID" id="ID"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name ="PASSWORD" id="PASSWORD"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name ="NAME" id="NAME"></td>
			</tr>
			<tr>
				<td>메일</td>
				<td><input type="text" name ="EMAIL" id="EMAIL"></td>
			</tr>
			<tr>
				<td>휴대폰 번호</td>
				<td><input type="text" name ="PHONENUM" id="PHONENUM"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name ="BURTH" id="BURTH"></td>
			</tr>
			<tr>
			<td colspan="2">
			<input type="button" id="add" value="추가하기" onclick="userData()">
			</td>
			</tr>
		</table>
	</form>

</body>
</html>