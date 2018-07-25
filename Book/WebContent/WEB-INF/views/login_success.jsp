<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title></title>
<link type="text/css" rel="stylesheet" href="resource/style.css">
</head>
<body>
	<c:choose>
	<c:when test="${not empty sessionScope.flagAdmin}">
		<script type="text/javascript">
			location.href='adminMain.do';
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			location.href='${pageContext.request.contextPath}';
		</script>
	</c:otherwise>
	</c:choose>
</body>
</html>