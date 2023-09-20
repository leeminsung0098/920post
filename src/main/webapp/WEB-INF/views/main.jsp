<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>

<title>메인 화면</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
	function sendData() {
		if($("#ID").val() == ""){
			alert("아이디를 입력하세요");
			return false;
		}
		if($("#PASSWORD").val() == ""){
			alert("패스워드를 입력하세요");
			return false;
		}
		//ajax 호출
		$.ajax({
		    type : 'POST',           // 타입 (get, post, put 등등)
		    url : '/loginChk',           // 요청할 서버url
		    dataType : 'JSON',       // 데이터 타입 (html, xml, json, text 등등)
		    async: true,
		    data : {
		    	"ID" : $("#ID").val(),
		    	"PASSWORD" : $("#PASSWORD").val()
		    },
		    success : function(data) { // 결과 성공 콜백함수
		    	cbSuccess(data);
		    },
		    error : function(request,status,error) { // 결과 에러 콜백함수
		    	alert("로그인 실패 / 데이터 미전송");
		    }
		});
	}
	
	function cbSuccess(data){
		var result_code = data.result_code;
		var group_code = data.group_code;
		
		if(result_code == "del"){
			alert("회원이 삭제되었습니다. 관리자에게 문의하시기 바랍니다.");
			return;
		}
		
    	if(result_code == 1004){
    		alert("로그인 성공");
    		if(group_code == "adm"){
    			location.href="/boardlist";
    		}else{
    			location.href="/boardlist";
    		}
		}else{
			alert("계정이없거나 비밀번호 틀림");
			return;
		}
	}
		
		
</script>
</head>
<body>
<input type="hidden" id="code" value="${code}"/>
<p>로그인</p>
	<div>
		<input type="text" id="ID" name="ID" placeholder="아이디">
		<input type="text" id="PASSWORD" name="PASSWORD"  placeholder="비밀번호">
		<input type="button" value="확인" onclick="sendData()">
	</div>
</body>
</html>