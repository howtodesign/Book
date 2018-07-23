<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="resource/member_info.js"></script>
<title>member info</title>
<link type="text/css" rel="stylesheet" href="resource/style.css">
</head>
<body>
	<header>
		<h1 class="gradient">Book Review</h1>
		<h5>dreamING of breaking away from the routine of daily life</h5>
	</header>

	<section>
		<article class="col_9">
			<div>
				<form action="updateMember.do" method="post">
					<fieldset>
						<legend>member info</legend>
						<label>ID : </label>${sessionScope.loginId }
						<input type="hidden" name="id" value="${sessionScope.loginId }">
						<label>NAME : </label><input readonly="readonly" type="text" name="name" value="${member.name }"><br>
						<label>NICKNAME : </label>
						<input readonly="readonly" type="text" name="nickname" value="${member.nickname }" onkeyup="nickDuplicate()">
						<div id="nickCheckResult"></div><br>
						<c:set var="phones" value="${member.phone }"/>
						<label>phone</label><input readonly="readonly" type="tel" name="phone1" value="${fn:substring(phones, 0, 3) }" maxlength="3" onkeyup="phCheck()">-
						<input readonly="readonly" type="tel" name="phone2" value="${fn:substring(phones, 4, 8) }" maxlength="4" onkeyup="phCheck()">-
						<input readonly="readonly" type="tel" name="phone3" value="${fn:substring(phones, 9, 13) }" maxlength="4" onkeyup="phCheck()">
						<input type="hidden" name="phone">
						<br>
						<label>email</label><input readonly="readonly" type="email" name="email" value="${member.email }"><br>
						<button id="updatebtn">수정하기</button>  
					</fieldset>
					<a href="updatePassword.do"><button>비밀번호 변경</button></a>
				</form>
			</div>
		</article>
	</section>

	<footer>
		<p>Footer</p>
	</footer>
</body>
</html>