<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<title>This is mainpage</title>
<link type="text/css" rel="stylesheet" href="resource/style.css">
</head>
<body>
	<header>
		<h1 class="gradient">Book Review</h1>
		<h5>dreamING of breaking away from the routine of daily life</h5>
	</header>

	<section>
		<div class="col_3 sidebar">
			<div class="loginStation">
				<c:choose>
				 <c:when test="${empty sessionScope.loginId }">
				 	<form action="login.do" method="post">
				 		<table>
				 			<tr>
				 				<td><input type="text" name="userId" placeholder="ID"></td>
				 			</tr>
				 			<tr>
				 				<td><input type="password" name="userPw" placeholder="Password" >
				 				<td rowspan="2"><input type="submit" value="login"><td>
				 			</tr>
				 		</table>
				 		<a href="joinForm.do">join</a>  <a>search id/pass</a>
					</form>
				 </c:when>
				 <c:otherwise>
				 	${sessionScope.loginNick } welcome  <a href="checkPassword.do">memberinfo</a><br>
				 	<a href="logout.do">logout</a>
				 </c:otherwise>	
				</c:choose>
			</div>

			<ul>
				<li>HORROR</li>
				<li>ROMANCE</li>
				<li>COOK</li>
				<li>TRAVEL</li>

			</ul>
		</div>
		<article class="col_9">
			<h1>London</h1>
			<p>London is the capital city of England. It is the most populous
				city in the United Kingdom, with a metropolitan area of over 13
				million inhabitants.</p>
			<p>Standing on the River Thames, London has been a major
				settlement for two millennia, its history going back to its founding
				by the Romans, who named it Londinium.</p>
		</article>
	</section>

	<footer>
		<p>Footer</p>
	</footer>
</body>
</html>