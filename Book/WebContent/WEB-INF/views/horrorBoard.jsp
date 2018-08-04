<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
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
			${sessionScope.loginNick} welcome <a href="checkPassword.do">memberinfo</a><br>
				 	<a href="logout.do">logout</a>
			</div>

			<ul>
				<li id="bb101" value="horror" class="genre">HORROR</li>
				<li id="bb102" value="romance" class="genre">ROMANCE</li>
				<li id="bb103" value="cook" class="genre">COOK</li>
				<li id="bb104" value="travel" class="genre">TRAVEL</li>

			</ul>
		</div>
		
		
		<article class="col_9">
			<h1>${bb_name } Board</h1>
		
			<table border="1">
				<tr>
					<th width="10%">bookb_num</th>
					<th width="15%">writer</th>
					<th width="30%">title</th>
					<th width="15%">book_name</th>
					<th width="25%">write_date</th>
					<th width="5%">read_count</th>
					
				</tr>

				<c:if test="${empty horrorBoardPage.bookBoardList}">
					<tr>
						<td colspan="6" align="center">no lists</td>
					</tr>
				</c:if>


				<c:if test="${not empty horrorBoardPage.bookBoardList}">
				<c:set var="number" value="${horrorBoardPage.number}"/>
					<c:forEach items="${horrorBoardPage.bookBoardList}" var="horrorBoard" varStatus="i">
						<tr>
							<td>${number-i.index}</td>
							<td>${horrorBoard.writer}</td>
							<td><a
								href="read.do?bookb_num=${horrorBoard.bookb_num}&p=${horrorBoardPage.currentPage}&n=${number-i.index}">
									${horrorBoard.title}</a></td>
							<td>${horrorBoard.book_name}</td>
							<td>${horrorBoard.write_date}</td>
						<td>${horrorBoard.readcount}</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>

<div id="paging" align="center">

		<c:if test="${horrorBoardPage.startPage gt 1}">
			<a href="horror.do?p=${horrorBoardPage.startPage-1}&bb_code=${horrorBoardPage.bb_code}">[pre]</a>
		</c:if>

		<c:forEach begin="${horrorBoardPage.startPage}" end="${horrorBoardPage.endPage}" var="i">
			<a href="horror.do?p=${i}&bb_code=${horrorBoardPage.bb_code}">[${i}]</a>
		</c:forEach>

		<c:if test="${horrorBoardPage.endPage lt horrorBoardPage.totalPage}">
			<a href="horror.do?p=${horrorBoardPage.endPage+1}&bb_code=${horrorBoardPage.bb_code}">[next]</a>
		</c:if>
		
		 		<a href="writeForm.do?bb_code=${horrorBoardPage.bb_code }"><button>WRITE</button></a> 
				<a href="main.do"><button>MAIN</button></a> 
		
	</div>

		
	
	
		</article>
		
		
		
		
		
	</section>

	<footer>
		<p>Footer</p>
	</footer>

</body>
</html>