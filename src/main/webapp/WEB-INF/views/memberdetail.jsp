<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<meta charset="EUC-KR">
<title>유저 정보 디테일</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
function deletechk(){
	 if (!confirm("삭제 하시겠습니까.")) {
         alert("취소");
     } else {
         alert("삭제합니다");
         $.ajax({
 		    type : 'POST',         
 		    url : '/membersoftdelete',   
 		    dataType : 'JSON',     
 		    async: true,
 		    data : {
 		    	"USER_ID" : $("#USER_ID").val()
 		    },
 		    success : function(data) {
 		    	console.log(data.result_code);
 		    		alert("삭제성공");
 					location.href="/member";
 		    },
 		    error : function(request,status,error) {
 		    	alert("삭제실패");
 		    	console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
 		    	console.log(BNO);
 		    }
 		});
         
     }
 }

</script>
</head>
<body>
	<input type="hidden" id="USER_ID" value="${memberdetail.USER_ID}" />
	<div>
		<form>
			<div>
				<label>유저번호</label>
				<p>${memberdetail.USER_ID}</p>
			</div>
			<hr>
			<div>
				<label>아이디</label>
				<p>${memberdetail.ID}</p>
			</div>
			<hr>
			<div>
				<label>비밀번호</label>
				<p>${memberdetail.PASSWORD}</p>
			</div>
			<hr>
			<div>
				<label>이름</label>
				<p>${memberdetail.NAME}</p>
			</div>
			<hr>
			<div>
				<label>이메일</label>
				<p>${memberdetail.EMAIL}</p>
			</div>
			<hr>
			<div>
				<label>휴대전화</label>
				<p>${memberdetail.PHONENUM}</p>
			</div>
			<hr>
			<div>
				<label>삭제 (Y= 삭제함 N = 삭제하지 않음)</label>
				<p>${memberdetail.DELETE_YN}</p>
			</div>
			<hr>
			<div>
				<label>업데이트</label>
				<p>${memberdetail.UPDAYE_YN}</p>
			</div>
			<hr>
			<div>
				<label>삭제 날짜</label>
				<p>${memberdetail.DELETE_DATE}</p>
			</div>
			<hr>
			<div>
				<label>가입 날짜</label>
				<p>${memberdetail.UPDATE_DATE}</p>
			</div>
			<hr>
			<div>
				<label>등급</label>
				<p>${memberdetail.ADMIN}</p>
			</div>

		</form>
		<button
			onclick="location.href='/memberupdate/${memberdetail.USER_ID}'">수정</button>
		<input type=button onclick="deletechk()" value="삭제" />
		<button onclick="location.href='/member'">리스트</button>
	</div>

</body>
</html>