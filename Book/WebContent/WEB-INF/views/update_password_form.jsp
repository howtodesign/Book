<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	function pwCheck() {
		if($("input[name='password']").val() == $("input[name='passwordre']").val()){
			$("#pwCheckResult").text("비밀번호가 일치합니다.");
			$("#pwCheckResult").css("color", "green");
		}else{
			$("#pwCheckResult").text("비밀번호 불일치");
			$("#pwCheckResult").css("color", "red");
			joinCheck["pwCheck"]=false;
			$("input[name='passwordre']").focus();
		}
	}
</script>
<title></title>
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
				<form action="updatePassword.do">
					<label>CURRENT PASSWORD : </label><input type="password" name="beforepassword"><br>
					<label>MODIFY PASSWORD : </label><input type="password" name="password"><br>
					<label>PASSWORD CHECK : </label><input type="password" name="passwordre" onkeyup="pwCheck()"><br>
					<div id="pwCheckResult"></div>
					<input type="submit" value="modify">
				</form>
				<a href="${pageContext.request.contextPath}">main</a>
			</div>
		</article>
	</section>

	<footer>
		<p>Footer</p>
	</footer>
</body>
</html>