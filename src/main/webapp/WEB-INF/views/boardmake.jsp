<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<meta charset="EUC-KR">
<title>게시물 작성</title>
</head>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
function boardData(){
	console.log("실행확인");
	console.log($("#name"));
	$.ajax({
		type : 'POST',           
	    url : '/boarddatain',       
	    dataType : 'text',       
	    async: true,
	    data :{
	    	"TITLE" : $("#TITLE").val(),
	    	"CONTENT" : $("#CONTENT").val()
	    	"WRITER" : $("#WRITER").val()
	    } ,
	    success : function(data) {
	    	console.log("data:"+ data);
	    	alert("성공");
	    	location.href="/boardlist"
	    },
	    error : function(request,status,error) {
	    	alert("실패 ");    	
	    }
	    	
	})
}
</script>
<body>
	<button onclick="location.href='/member'">관리자홈</button>
	<form id="alldata" method="post">
		<table>
			<tr>
				<td>제목</td>
				<td><textarea name="TITLE" id="TITLE"></textarea></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="CONTENT" id="CONTENT"></textarea></td>
			</tr>
			<tr>
				<td><input type="hidden" name="WRITER" id="WRITER"
					value="${WRITER}"></input></td>
			</tr>
			<tr>
				<td><input type="button" id="add" value="작성"
					onclick="boardData()"></td>
			</tr>
		</table>
	</form>

</body>
</html>