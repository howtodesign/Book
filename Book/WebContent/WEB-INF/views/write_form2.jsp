<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title></title>
<style type="text/css">
.title {
	color: white;
	letter-spacing: .20em;
	text-shadow: 1px -1px 0 #767676, -1px 2px 1px #737272, -2px 4px 1px
		#767474, -3px 6px 1px #787777, -4px 8px 1px #7b7a7a, -5px 10px 1px
		#7f7d7d, -6px 12px 1px #828181, -7px 14px 1px #868585, -8px 16px 1px
		#8b8a89, -9px 18px 1px #8f8e8d;
}

.genre {
	font: 25px/25px Georgia, serif;
	padding: 10px;
	border-radius: 10px;
	border: 2px solid rgb(28, 110, 164);
	border-image: none;
	background-image: radial-gradient(at center, rgb(28, 110, 164) 0%,
		rgb(35, 136, 203) 14%, rgb(20, 78, 117) 100%);
	color: rgb(223, 255, 164);
	text-transform: none;
	text-decoration: none;
	box-shadow: 5px 5px 15px 5px #000000;
	display: inline-block;
}

.genre:hover {
	background: #1C6EA4;
}

.genre:active {
	background: #144E75;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<script type="text/javascript">
$(function() {
	$('#btnAdd').click(function() {
		var addElement = '<br><input type="file" name="uploadFiles">';
		$('button[id="btnMinus"]').after(addElement);
		return false;
	
	 })
	 
	


})
</script>
<link type="text/css" rel="stylesheet" href="resource/style.css">
</head>
<body>

	<header>
		<h1 class="gradient">Book Review</h1>
		<h5>dreamING of breaking away from the routine of daily life</h5>
	</header>

	<section>
		<div class="col_3 sidebar">
			<div class="loginStation">${sessionScope.loginNick}
				welcome <a href="checkPassword.do">memberinfo</a><br> <a
					href="logout.do">logout</a>
			</div>

			<ul>
				<li id="bb101" value="horror" class="genre">HORROR</li>
				<li id="bb102" value="romance" class="genre">ROMANCE</li>
				<li id="cook" value="cook" class="genre">COOK</li>
				<li id="travel" value="travel" class="genre">TRAVEL</li>

			</ul>
		</div>
		<article class="col_9">
			<div id="scroller"
				style="overflow: auto; width: 100%; height: 400px;">
				<h1 class="title">Romance Review Write Page</h1>


				<%-- <form action="write.do" method="post" enctype="multipart/form-data">
				<input type="hidden" name="bb_code" value="bb102">
				<table border="1">
					<tr>
					<td>book_name:</td>
					<td><input type="text" name="book_name" size="50"></td>
					</tr>
					<tr>
						<td>title:</td>
						<td><input type="text" name="title" size="50"></td>
					</tr>
					<tr>
						<td>writer:</td>
						<td>${sessionScope.loginNick}</td>
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
						<td><input type="submit" value="submit"> <a
							href="bookPage.do"><button id="bookAPI" name="bookAPI"
									value="bookAPI">bookAPI</button></a></td>
					</tr>
				</table>

			</form> --%>

				<!-- <form action="write.do" method="get"> -->
					<input type="hidden" name="bb_code" value="bb102"> <input
						type="hidden" name="bookb_num" value="bb102">
					<table border="1" style="width: 100%">
						<%-- <tr>
							<td>book_name:</td>
							<td><input type="text" name="book_name" size="50"></td>
						</tr>
						<tr>
							<td>title:</td>
							<td><input type="text" name="title" size="50"></td>
						</tr>
						<tr>
							<td>writer:</td>
							<td>${sessionScope.loginNick}</td>
						</tr>
						<tr>
							<td>file:</td>
							<td><input type="file" name="uploadFiles">
								<button id="btnAdd">+</button>
								<button id="btnMinus">-</button></td>
						</tr> --%>
						<tr>
							<td colspan="2">
							</td>
						</tr>
						
						<tr>
							<td><button id="submit">submit</button>
								<a href="bookPage.do" target="_blank"><button id="bookAPI"
										value="bookAPI">bookAPI</button></a></td>
						</tr>
					</table>
				<!-- </form> -->


			</div>



		</article>
	</section>
	
	<footer>
		<p>Footer</p>
	</footer>

</body>
</html>



