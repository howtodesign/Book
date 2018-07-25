<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title></title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

	<header>
		<h1 class="gradient">Book Review</h1>
		<h5>dreamING of breaking away from the routine of daily life</h5>
	</header>

	<section>
		<div class="col_3 sidebar">
			<div class="loginStation"></div>

			<ul>
				<li id="bb101" value="horror" class="genre">HORROR</li>
				<li id="romance" value="romance" class="genre">ROMANCE</li>
				<li id="cook" value="cook" class="genre">COOK</li>
				<li id="travel" value="travel" class="genre">TRAVEL</li>

			</ul>
		</div>
		<article class="col_9">
			<h1>Horror Review Write Page</h1>


			<form action="write.do" method="post" enctype="multipart/form-data">
				
				<table border="1">
					<tr>
						<td>title:</td>
						<td><input type="text" name="title" size="50"></td>
					</tr>
					<tr>
						<td>writer:</td>
						<td>null</td>
					</tr>
					<tr>
						<td>file:</td>
						<td><input type="file" name="uploadFiles">
							<button id="btnAdd">+</button>
							<button id="btnMinus">-</button></td>
					</tr>
					<tr>
						<td>content:</td>
						<td><textarea rows="10" cols="100%" name="content"></textarea>

						</td>
					</tr>

					<tr>
						<td><input type="submit" value="submit">
						<a href="bookPage.do"><button id="bookAPI" name="bookAPI" value="bookAPI">bookAPI</button></a></td>
					</tr>
				</table>

			</form>







		</article>
	</section>

	<footer>
		<p>Footer</p>
	</footer>

</body>
</html>



