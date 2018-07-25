<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
<meta charset=UTF-8">
<title></title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
	 $(function() {
	
		 $(".genre").click(function(){
			 var selectedGenre = $(this).attr('value'); 
			
			 if(selectedGenre=="horror"){
				 var bb_code =$(this).attr('id');
			
			 location.href = "${pageContext.request.contextPath}/horror.do?bb_code="+bb_code;
			 }
			 
			 return false;
			 });	 
	 })
	
	</script>
	
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