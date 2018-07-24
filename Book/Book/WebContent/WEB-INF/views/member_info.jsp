<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="resource/member_update.js"></script>
<script type="text/javascript">
//닉네임 중복체크
function nickDuplicate() {
	
	var inputNick = $("input[name='nickname']").val();
	var userNick = "${sessionScope['loginNick']}";
	$.ajax({
		url : "nickCheck.do",
		method : "post",
		data : {nick : inputNick}, 
		datatype : "html",
		success : function(result) {
			if(result=="true" || inputNick==userNick){
				$("#nickCheckResult").text("사용 가능한 닉네임 입니다.");
				$("#nickCheckResult").css("color", "green");
				joinCheck["nickCheck"] = true;
			}else{
				$("#nickCheckResult").text("이미 존재하는 닉네임 입니다.");
				$("#nickCheckResult").css("color", "red");
				$("input[name='nickname']").focus();
				joinCheck["nickCheck"] = false;
			}
		},
		error : function(ex) {
			alert(ex);
		}
	})
	
};	

	$(function() {
		var userId = "${sessionScope['loginId']}";
		$.ajax({
			url : "getMember.do",
			method : "post",
			data : {id : userId}, 
			datatype : "text",
			success : function(result) {
				if(result != "null"){
				var member = JSON.parse(result);
				$("input[name='name']").attr("value", member.name);
				$("input[name='nickname']").attr("value", member.nickname);
				$("input[name='email']").attr("value", member.email);
				$("input[name='phone']").attr("value", member.phone);
				$("input[name='phone1']").attr("value", member.phone.substring(0, 3));
				$("input[name='phone2']").attr("value", member.phone.substring(4, 8));
				$("input[name='phone3']").attr("value", member.phone.substring(9, 13));
				}else{
					alert("정보가 없습니다.");
				}
			},
			error : function(ex) {
				alert(ex);
			}
			
		})
		
		$("#updatebtn").click(function() {
			$("input[readonly='readonly']").prop("readonly", false);
			$("#updatebtn").hide();
			$("input[type='submit']").show();
			return false;
		})
	})
</script>
<title>member info</title>
<link type="text/css" rel="stylesheet" href="resource/style.css">
</head>
<body>
	<c:if test="${checkpw eq 'getout' }">
		<script type="text/javascript">
			alert("dismatched password");
			history.go(-2);
		</script>
	</c:if>
	<header>
		<h1 class="gradient">Book Review</h1>
		<h5>dreamING of breaking away from the routine of daily life</h5>
	</header>

	<section>
		<article class="col_9">
			<div>
				<form action="updateMember.do" method="post">
					<fieldset>
						<legend>member info</legend>
						<label>ID : </label>${sessionScope.loginId }<br>
						<input type="hidden" name="id" value="${sessionScope.loginId }">
						<label>NAME : </label><input readonly="readonly" type="text" name="name"><br>
						<label>NICKNAME : </label>
						<input readonly="readonly" type="text" name="nickname"onkeyup="nickDuplicate()">
						<div id="nickCheckResult"></div><br>
						<c:set var="phones"/>
						<label>phone</label><input readonly="readonly" type="tel" name="phone1" maxlength="3" onkeyup="phCheck()">-
						<input readonly="readonly" type="tel" name="phone2" maxlength="4" onkeyup="phCheck()">-
						<input readonly="readonly" type="tel" name="phone3" maxlength="4" onkeyup="phCheck()">
						<input type="hidden" name="phone">
						<br>
						<label>email</label><input readonly="readonly" type="email" name="email" ><br>
						<input type="submit" value="modify" hidden="">
					</fieldset>
				</form>
				<button id="updatebtn">modify</button>  
				<a href="updatePassword.do"><button>update password</button></a>
				<a href="${pageContext.request.contextPath}">main</a>
			</div>
		</article>
	</section>

	<footer>
		<p>Footer</p>
	</footer>
</body>
</html>