<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<meta charset="EUC-KR">
<title>상세보기</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
function deletechk(){
	 if (!confirm("삭제 하시겠습니까.")) {
         alert("취소");
     } else {
         alert("삭제합니다");
         $.ajax({
 		    type : 'POST',         
 		    url : '/softdelete',   
 		    dataType : 'JSON',     
 		    async: true,
 		    data : {
 		    	"BNO" : $("#bno").val()
 		    },
 		    success : function(data) {
 		    	console.log(data.result_code);
 		    		alert("삭제성공");
 					location.href="/boardlist";
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
<input type="hidden" id="bno" value="${detail.BNO}"/>
	<div>
		<form>
			<div>
				<label>제목</label>
				<p>${detail.TITLE}</p>
			</div>
			<div>
				<label>작성자</label>
				<p>${detail.WRITER}</p>
			</div>
			<div>
				<label>작성날짜</label>
				<p>
				${detail.REGDATE}
				</p>
			</div>
			<hr>
			<div>
				<label>내용</label>
				<p>${detail.CONTENT}</p>
			</div>
		</form>
		<button
			onclick="location.href='/update/${detail.BNO}'">수정</button>
		<input
		type=button onclick="deletechk()"  value="삭제"/>
		<button
			onclick="location.href='/boardlist/${board.BNO}'">리스트</button>
	</div>



</body>
</html>