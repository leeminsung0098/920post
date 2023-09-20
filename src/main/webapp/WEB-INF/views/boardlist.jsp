<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>

$(function(){
	alert(1);
	pageList(1);
});

function pageList(cur_page){
	console.log("실행");
	console.log(cur_page);
	$.ajax({
		type : "POST",
		url : "/boardlistdata",
		dataType : "JSON",
		async: true,
		data : {
			"cur_page" : cur_page,
			"row" : 10
		},
		success : function(data){
			alert(data);
		},
		error : function(request,status,error) {
 		    
 		    	console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
 		    
 		    }
	});
}

function insertBoard(){
	location.href="/make"
}

</script>
</head>
<link href = "resources/css/point.css" rel="stylesheet" type="text/css">
<body>
<input type="hidden" id="cur_page" value="1"/>
	<div class="text-center-id">
		<h2 class="noe">boardList </h2>
				<p class="noe">
				${setid }님
				</p>

		<table class="table table-board table">
		<thead>
			<tr>
				<th> 번호 </th>
				<th> 제목 </th>
				<th> 글쓴이 </th>
				<th> 작성일 </th>
			</tr>
			</thead>
			<tbody id="pageList1">
				<c:if test="${code eq 'adm'}">
					<button onclick="location.href='/member'">관리자홈</button>
				</c:if>
				<tr>
					<td colspan="5" class="text-center">
						<button onclick="insertBoard()">게시물 작성</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>

</body>
</html>