<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title></title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$('#btnAdd').click(function() {
		var addElement = '<br><input type="file" name="uploadFiles">';
		$('button[id="btnMinus"]').after(addElement);
		return false;
	
		
	 })
	 
	 $(".genre").click(function(){
		 var selectedGenre = $(this).attr('value'); 
		
		 if(selectedGenre=="horror"){
			 var bb_code =$(this).attr('id');
		 location.href = "horror.do?bb_code="+bb_code;
		 }
		 if(selectedGenre=="romance"){
			 var bb_code =$(this).attr('id');
		 location.href = "horror.do?bb_code="+bb_code;
		 }
		 if(selectedGenre=="cook"){
			 var bb_code =$(this).attr('id');
		 location.href = "horror.do?bb_code="+bb_code;
		 }
		 if(selectedGenre=="travel"){
			 var bb_code =$(this).attr('id');
		 location.href = "horror.do?bb_code="+bb_code;
		 }
		 return false;
		 });	 
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
			<div class="loginStation">${sessionScope.loginNick} welcome <a href="checkPassword.do">memberinfo</a><br>
				 	<a href="logout.do">logout</a></div>

			<ul>
				<li id="bb101" value="horror" class="genre">HORROR</li>
				<li id="bb102" value="romance" class="genre">ROMANCE</li>
				<li id="bb103" value="cook" class="genre">COOK</li>
				<li id="bb104" value="travel" class="genre">TRAVEL</li>

			</ul>
		</div>
		<article class="col_9">
			<h1>Horror Review Write Page</h1>


			<form action="write.do" method="post" enctype="multipart/form-data">
				<input type="hidden" name="bb_code" value="${bb_code }">
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
						<td colspan="2" align="center"><input type="submit" value="submit"> </td>
					</tr>
				</table>

			</form>
<!-- <a	 href="bookPage.do"><button id="bookAPI" name="bookAPI" -->
<!-- 									value="bookAPI">bookAPI</button></a> -->






		</article>
	</section>

	<footer>
		<p>Footer</p>
	</footer>

</body>
</html>



