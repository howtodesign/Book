<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset=UTF-8">
<title></title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
	<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>

		<h1 class="gradient">Book Review</h1>

		<h5>dreamING of breaking away from the routine of daily life</h5>

	</header>



	<section>

		<article class="col_9">

			<div>

				<form action="deleteMember.do">

					<label>PASSWORD : </label><input type="password" name="password"><br>

					<label>PASSWORD CHECK : </label><input type="password" name="passwordre" onkeyup="pwCheck()"><br>

					<div id="pwCheckResult"></div>

					<input type="submit" value="get out">

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