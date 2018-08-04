<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<style type="text/css">
.title{
color: white;
letter-spacing: .20em;
text-shadow: 1px -1px 0 #767676, -1px 2px 1px #737272, -2px 4px 1px #767474, -3px 6px 1px #787777, -4px 8px 1px #7b7a7a, -5px 10px 1px #7f7d7d, -6px 12px 1px #828181, -7px 14px 1px #868585, -8px 16px 1px #8b8a89, -9px 18px 1px #8f8e8d;
}
.genre {
font: 25px/25px Georgia,serif; padding: 10px; border-radius: 10px; border: 2px solid rgb(28, 110, 164); border-image: none; background-image: radial-gradient(at center, rgb(28, 110, 164) 0%, rgb(35, 136, 203) 14%, rgb(20, 78, 117) 100%); color: rgb(223, 255, 164); text-transform: none; text-decoration: none; box-shadow: 5px 5px 15px 5px #000000; display: inline-block;}
.genre:hover {
background: #1C6EA4; }
.genre:active {
background: #144E75; }

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
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
<title>This is mainpage</title>
<link type="text/css" rel="stylesheet" href="resource/style.css">
</head>
<body>
	<c:if test="${not empty sessionScope.flagAdmin}">
		<script type="text/javascript">
			location.href='adminMain.do';
		</script>
	</c:if>
	<header>
		<h1 class="gradient">Book Review</h1>
		<h5 class="gradient">dreamING of breaking away from the routine of daily life</h5>
	</header>

	<section>
		<div class="col_3 sidebar">
			<div class="loginStation">
				<c:choose>
				 <c:when test="${empty sessionScope.loginId}">
				 	<form action="login.do" method="post">
				 		<table>
				 			<tr>
				 				<td><input type="text" name="userId" placeholder="ID"></td>
				 				<td rowspan="2"><input type="submit" value="login"><td>
				 			</tr>
				 			<tr>
				 				<td><input type="password" name="userPw" placeholder="Password" >
				 				<td rowspan="2"><input type="submit" value="login"><td>
				 			</tr>
				 		</table>
					</form>
					<a href="joinForm.do"><button>join</button></a>
				 	<a><button>search id/pass</button></a>
				 </c:when>
				 <c:otherwise>
				 	${sessionScope.loginNick} welcome  <a href="checkPassword.do">memberinfo</a><br>
				 	<a href="logout.do">logout</a>
				 </c:otherwise>	
				</c:choose>
			</div>

			<ul>
				<li id="bb101" value="horror" class="genre">HORROR</li>
				<li id="bb102" value="romance" class="genre">ROMANCE</li>
				<li id="bb103" value="cook" class="genre">COOK</li>
				<li id="bb104" value="travel" class="genre">TRAVEL</li>
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