<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset=UTF-8">
<title></title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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

				<form action="join.do" method="post">

					<fieldset>

						<legend>join form</legend>

						<label>ID : </label><input type="text" name="id" onkeyup="idDuplicate()">

						<div id="idCheckResult"></div>

						<label>PASSWORD : </label><input type="password" name="password"><br>

						<label>PASSWORD CHECK : </label><input type="password" name="passwordre" onkeyup="pwCheck()"><br>

						<div id="pwCheckResult"></div>

						<label>NAME : </label><input type="text" name="name"><br>

						<label>NICKNAME : </label><input type="text" name="nickname" onkeyup="nickDuplicate()">

						<div id="nickCheckResult"></div><br>

						<label>phone</label><input type="tel" name="phone1" maxlength="3" onkeyup="phCheck()">-

						<input type="tel" name="phone2" maxlength="4" onkeyup="phCheck()">-

						<input type="tel" name="phone3" maxlength="4" onkeyup="phCheck()">

						<input type="hidden" name="phone">

						<br>

						<label>email</label><input type="email" name="email"><br>

						<input type="submit" value="join">

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