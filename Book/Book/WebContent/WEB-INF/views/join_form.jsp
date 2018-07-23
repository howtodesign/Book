<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="resource/joinCheck.js"></script>
<title>joinForm</title>
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
				<form action="join.do" method="post">
					<fieldset>
						<legend>join form</legend>
						<label>ID : </label><input type="text" name="memberId" onkeyup="idDuplicate()">
						<button id="idCheck">id check</button>
						<div id="idCheckResult"></div>
						<label>PASSWORD : </label><input type="password" name="memberPw"><br>
						<label>PASSWORD CHECK : </label><input type="password" name="memberPwre" onkeyup="pwCheck()"><br>
						<div id="pwCheckResult"></div>
						<label>NAME : </label><input type="text" name="memberName"><br>
						<label>NICKNAME : </label><input type="text" name="memberNick" onkeyup="nickDuplicate()">
						<button id="nickCheck">nickname check</button>
						<div id="nickCheckResult"></div><br>
						<label>phone</label><input type="tel" name="memberPhone"><br>
						<label>email</label><input type="email" name="memberEmail"><br>
						<input type="submit" value="회원가입">
					</fieldset>
				</form>
			</div>
		</article>
	</section>

	<footer>
		<p>Footer</p>
	</footer>
	
</body>
</html>