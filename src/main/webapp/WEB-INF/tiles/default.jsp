<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사이트 제목</title>
    
<style>

    .contents {
        background-color : green;
        height : 500px;
    }
    

</style>
</head>
<body>
<!--     Page Header -->
<%--     <tiles:insertAttribute name="header" /> --%>
    
    <!-- Page Contents -->
    <tiles:insertAttribute name="body" />
    
<!--     Page Footer -->
<%--     <tiles:insertAttribute name="footer" /> --%>
    
</body>
</html>

<!-- // footer.jsp -->
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> --%>
<!-- <div class="footer">Footer</div> -->

<!-- // header.jsp -->
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> --%>
<!-- <div class="header">Header</div> -->