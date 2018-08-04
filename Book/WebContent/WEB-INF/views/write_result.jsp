<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#horrorList").click(function(){
			var bb_code = $(this).val();
	
			location.href = "${pageContext.request.contextPath}/horror.do?bb_code="+bb_code;	
		})
	})
	
	</script>
	<link type="text/css" rel="stylesheet" href="resource/style.css">
<title></title>
</head>
<body>
	<header>
		<h1 class="gradient">Book Review</h1>
		<h5>dreamING of breaking away from the routine of daily life</h5>
	</header>

	<section>
		<div class="col_3 sidebar">
			<div class="loginStation">
			${sessionScope.loginNick} welcome <a href="checkPassword.do">memberinfo</a><br>
				 	<a href="logout.do">logout</a>
			</div>

			<ul>
				<li id="bb101" value="horror" class="genre">HORROR</li>
				<li id="romance" value="romance" class="genre">ROMANCE</li>
				<li id="cook" value="cook" class="genre">COOK</li>
				<li id="travel" value="travel" class="genre">TRAVEL</li>
			</ul>
		</div>
		<article class="col_9">
			<h1>write result</h1>
		<form action="write.do">
			<table border="1">
				<tr>
					<td width="10%">num:</td>
					<td width="90%">${insertedBoard.bookb_num}</td>
				</tr>

				<tr>
				<td width="10%">book_name</td>
				<td width="90%">${insertedBoard.book_name}</td>
				</tr>
			

				<tr>
					<td width="10%">title:</td>
					<td width="90%">${insertedBoard.title}</td>
				</tr>
				
					<c:forEach items="${fileList}" var="fileList">
					<tr>
						<td>file:</td>
						<td>${fileList.original_name}</td>
					</tr>
				</c:forEach>
				
				<tr>
					<td width="10%">writer:</td>
					<td width="90%">${insertedBoard.writer}</td>
				</tr>
				<tr>
					<td width="10%">content:</td>
					<td width="90%">${insertedBoard.content}</td>
				</tr>

			</table>
		</form>
		<button id="horrorList" value="bb101">horrorList</button>
		<a href="bookPage.do" target="_blank"><button>bookAPI</button></a>
		<input type="hidden" name="bookb_num" value="${insertedBoard.bookb_num}">
		<input type="hidden" name="p" value="${page}">
			</article>
	</section>

	<footer>
		<p>Footer</p>
	</footer>
</body>
</html>




