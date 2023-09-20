<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%--     <%@ MemberVO m = new MemberVO --%>
<%--     m.setName("test"); --%>
<%--     pageContext.setAttribute("mem" , m)%> --%>

<html>
<head>
<!-- <script src="/WEB-INF/js/jquery_3.3.1_jquery.min.js"></script> -->
<script>
function insertMember(){
	location.href="/inner"
}

function board(){
	location.href="/boardlist"
}
function trash(){
	location.href="/trash"
}
</script>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<link href = "resources/css/point.css" rel="stylesheet" type="text/css">
<form>
<input type="hidden" id="test" value="1"/>
</form>
<body>
	<div class="container">
		<h2 class="noe">MemberList</h2>
		<p class="noe">${id} 님</p>
		<table class="table table-membered table">
		<thead>
			<tr><th>번호</th>
				<th>비밀번호  </th>
				<th>이름  </th>
				<th>이메일  </th>
				<th>전화번호  </th>
				<th>생년월일  </th>
				<th>가입날짜  </th>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="listVo" items="${listVo}" >
					<tr class="my-div" onclick="location.href='/memberdetail/${listVo.USER_ID}'">
						<td>${listVo.USER_ID}</td>
						<td>${listVo.PASSWORD}</td>
						<td>${listVo.NAME}</td>
						<td>${listVo.EMAIL}</td>
						<td>${listVo.PHONENUM}</td>
						<td>${listVo.BURTH}</td>
						<td>${listVo.UPDATE_DATE}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5" class="text-center">
						<button onclick="insertMember()">신규 등록</button>
						<button onclick="board()">보드 이동</button>				
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>

</html>