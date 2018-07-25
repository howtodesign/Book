<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		 $(".manage").click(function(){
			 var selectedmanage = $(this).attr('value'); 
			
			 if(selectedmanage=="memberList"){
			
			 location.href = "adminMemberList.do";
			 }
			 
			 return false;
			 });	 
	})
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
		<div class="col_3 sidebar">
			<div class="loginStation">
				 	${sessionScope.loginNick } welcome admin <a href="checkPassword.do">memberinfo</a><br>
				 	<a href="logout.do">logout</a>
			</div>

			<ul>
				<li value="memberList" class="manage">MEMBER</li>
				<li id="bookBoard" value="bookBoard" class="manage">BOOKBOARD</li>
				<li id="notice" value="notice" class="manage">NOTICE</li>
				<li id="etc" value="etc" class="manage">ETC</li>
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