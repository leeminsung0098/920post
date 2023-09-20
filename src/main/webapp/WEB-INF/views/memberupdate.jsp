<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta charset="EUC-KR">
<title>member update</title>
</head>
<body>
	<div class="container">
		<form action="/memberupdatesucess" method="post">
			<div class="form-group">
				<label for="id">아이디</label> <input type="text" id="id"
					name="id" value="${memberdetail.ID}">
			</div>
			<div>
				<label for="password">비밀번호</label>
				<textarea id="password" name="password">
                ${memberdetail.PASSWORD}</textarea>
			</div>
			<div>
				<label for="name">이름</label>
				<textarea id="name" name="name">
                ${memberdetail.NAME}</textarea>
			</div>
			<div>
				<label for="email">이메일</label>
				<textarea id="email" name="email">
                ${memberdetail.EMAIL}</textarea>
			</div>
			<div>
				<label for="phonenum">휴대전화</label>
				<textarea id="phonenum" name="phonenum">
                ${memberdetail.PHONENUM}</textarea>
			</div>
			<div>
				<label for="burth">생년월일</label>
				<textarea id="burth" name="burth">
                ${memberdetail.BURTH}</textarea>
			</div>
			<div>
				<label for="delete_yn">삭제여부 Y , N 으로 작성</label>
				<textarea id="delete_yn" name="delete_yn">
                ${memberdetail.DELETE_YN}</textarea>
			</div>
			<div>
				<label for="admin">등급 (nom 일반유저 , adm 관리자)</label>
				<textarea id="admin" name="admin">
                ${memberdetail.ADMIN}</textarea>
			</div>
			<input type="hidden" name="user_id" value="${USER_ID}" />
			<button type="submit">수정완료</button>
		</form>
	</div>
</body>
</html>