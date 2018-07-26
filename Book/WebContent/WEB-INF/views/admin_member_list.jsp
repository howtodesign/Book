<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
				<li id="bookmember" value="bookmember" class="manage">BOOKmember</li>
				<li id="notice" value="notice" class="manage">NOTICE</li>
				<li id="etc" value="etc" class="manage">ETC</li>
			</ul>
		</div>
		<article class="col_9">
			<div align="center">
			<table border="1">
				<tr>
					<th width="10%">NO</th>
					<th width="20%">ID</th>
					<th width="20%">NAME</th>
					<th width="10%">GRADE</th>
					<th width="30%">REGIST_DATE</th>
					<th width="10%">INFO</th>
				</tr>
				
				<c:if test="${empty memberPage.memberList }">
				<tr>
					<td colspan="5">no lists</td>
				</tr>
				</c:if>
				
				<c:if test="${not empty memberPage.memberList }">
					<c:set var="number" value="${memberPage.number }"/>
					<c:forEach items="${memberPage.memberList }" var="m" varStatus="i">
						<tr height="30">
							<td>${number+i.index }</td>
							<td>${m.id }</td>
							<td>${m.name }</td>
							<c:if test="${m.flag_admin eq 'm'}">
							<td>member</td>	
							</c:if>
							<c:if test="${m.flag_admin eq 'admin13'}">
							<td>admin</td>	
							</c:if>
							<c:if test="${member.flag_admin eq 'b'}">
							<td>ban</td>	
							</c:if>
							<td>${m.regist_date }</td>
							<td>
								<form action="adminMemberInfo.do" method="post">
									<input type="hidden" name="id" value="${m.id }">
									<input type="submit" value="Info">
								</form>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
			</div>
			<div align="center">
				<c:if test="${memberPage.startPage gt 1 }">
					<a href="adminMemberList.do?p=${memberPage.startPage-1 }">[PRE]</a>
				</c:if>
				<c:forEach begin="${memberPage.startPage }" end="${memberPage.endPage }" var="i">
					<a href="adminMemberList.do?p=${i }">[${i }]</a>
				</c:forEach>
				<c:if test="${memberPage.endPage lt memberPage.totalPageCount }">
					<a href="adminMemberList.do?p=${memberPage.endPage+1 }">[NEXT]</a>
				</c:if>
			</div>
			<a href="adminMain.do"><button>ADMINMAIN</button></a> 
		</article>
	</section>

	<footer>
		<p>Footer</p>
	</footer>
</body>
</html>