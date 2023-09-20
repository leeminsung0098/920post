<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta charset="EUC-KR">
<title>update</title>
</head>
<body>
	<div class="container">
		<form action="/updatesucess" method="post">
			<div class="form-group">
				<label for="title">제목</label> <input type="text" id="title"
					name="title" value="${detail.TITLE}">
			</div>
			<div>
				<label for="content">내용</label>
				<textarea id="content" name="content">
                ${detail.CONTENT}</textarea>
			</div>
			<input type="hidden" name="BNO" value="${BNO}" />
			<button type="submit">수정완료</button>
		</form>
	</div>
</body>
</html>