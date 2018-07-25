<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#reset_btn").click(function() {
			var flag = confirm('Do you want to reset password?');
			var targetId = '${member.id}';
			
			if(flag){
				$.ajax({
					url : "adminResetPassword.do",
					method : "post",
					data : {id : targetId}, 
					datatype : "html",
					success : function(result) {
						if(result=="true"){
							alert("reset password");
							location.href="adminMain.do";
						}else{
							alert("fail");
						}
					},
					error : function(ex) {
						alert(ex);
					}
				})	
				return false;
			}else{
				return false;
			}
		})
		
		$("#grant_btn").click(function() {
			var flag = confirm('Do you want to grant admin?');
			var targetId = '${member.id}';
			
			if(flag){
				$.ajax({
					url : "adminGrant.do",
					method : "post",
					data : {id : targetId}, 
					datatype : "html",
					success : function(result) {
						if(result=="true"){
							alert("grant admin");
							location.href="adminMain.do";
						}else{
							alert("fail");
						}
					},
					error : function(ex) {
						alert(ex);
					}
				})	
				return false;
			}else{
				return false;
			}
		})
		
		$("#revoke_btn").click(function() {
			var flag = confirm('Do you want to revoke admin?');
			var targetId = '${member.id}';
			
			if(flag){
				$.ajax({
					url : "adminRevoke.do",
					method : "post",
					data : {id : targetId}, 
					datatype : "html",
					success : function(result) {
						if(result=="true"){
							alert("revoke admin");
							location.href="adminMain.do";
						}else{
							alert("fail");
						}
					},
					error : function(ex) {
						alert(ex);
					}
				})	
				return false;
			}else{
				return false;
			}
		})
		
		$("#ban_btn").click(function() {
			var flag = confirm('Do you want to ban user?');
			var targetId = '${member.id}';
			
			if(flag){
				$.ajax({
					url : "adminBan.do",
					method : "post",
					data : {id : targetId}, 
					datatype : "html",
					success : function(result) {
						if(result=="true"){
							alert("ban user");
							location.href="adminMain.do";
						}else{
							alert("fail");
						}
					},
					error : function(ex) {
						alert(ex);
					}
				})	
				return false;
			}else{
				return false;
			}
		})
		
		$("#unban_btn").click(function() {
			var flag = confirm('Do you want to unban user?');
			var targetId = '${member.id}';
			
			if(flag){
				$.ajax({
					url : "adminUnban.do",
					method : "post",
					data : {id : targetId}, 
					datatype : "html",
					success : function(result) {
						if(result=="true"){
							alert("unban user");
							location.href="adminMain.do";
						}else{
							alert("fail");
						}
					},
					error : function(ex) {
						alert(ex);
					}
				})	
				return false;
			}else{
				return false;
			}
		})
		
		$("#kick_btn").click(function() {
			var flag = confirm('Do you want to kick user?');
			var targetId = '${member.id}';
			
			if(flag){
				$.ajax({
					url : "adminKick.do",
					method : "post",
					data : {id : targetId}, 
					datatype : "html",
					success : function(result) {
						if(result=="true"){
							alert("kick user");
							location.href="adminMain.do";
						}else{
							alert("fail");
						}
					},
					error : function(ex) {
						alert(ex);
					}
				})	
				return false;
			}else{
				return false;
			}
		})
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
				<li id="bookmember" value="bookmember" class="manage">BOOKmember</li>
				<li id="notice" value="notice" class="manage">NOTICE</li>
				<li id="etc" value="etc" class="manage">ETC</li>
			</ul>
		</div>
		<article class="col_9">
			<div align="center">
			<table border="1">
				<tr height="30">
					<th width="30%">ID</th>
					<td width="70%">${member.id }</td>
				</tr>
				<tr>
					<th>NAME</th>
					<td>${member.name }</td>
				</tr>
				<tr>
					<th>NICKNAME</th>
					<td>${member.nickname }</td>
				</tr>
				<tr>
					<th>PHONE</th>
					<td>${member.phone }</td>
				</tr>
				<tr>
					<th>EMAIL</th>
					<td>${member.email }</td>
				</tr>
				<tr>
					<th>GRADE</th>
					<td>
					<c:if test="${member.flag_admin eq 'm'}">
						<c:out value="member"/>
					</c:if>
					<c:if test="${member.flag_admin eq 'admin13'}">
						<c:out value="admin"/>
					</c:if>
					<c:if test="${member.flag_admin eq 'b'}">
						<c:out value="ban"/>
					</c:if>
					</td>	
				</tr>
				<tr>
					<th>REGIST_DATE</th>	
					<td>${member.regist_date }</td>
				</tr>	
			</table>
			<c:choose>
				<c:when test="${member.flag_admin eq 'b'}">
				<button id="unban_btn">UNBAN</button>
				</c:when>
			<c:otherwise>
				<button id="reset_btn">RESET PASSWORD</button>
				<c:if test="${member.flag_admin eq 'm'}">
				<button id="ban_btn">BAN</button>
				<button id="kick_btn">KICK</button>
				<button id="grant_btn">GRANT ADMIN</button>
				</c:if>
				<c:if test="${member.flag_admin eq 'admin13'}">
				<button id="revoke_btn">REVOKE ADMIN</button>
				</c:if>
			</c:otherwise>
			</c:choose>
			</div>
			<a href="adminMain.do"><button>ADMINMAIN</button></a> 
		</article>
	</section>

	<footer>
		<p>Footer</p>
	</footer>
</body>
</html>