	var joinCheck = {
			"idCheck" : false,
			"pwCheck" : false,
			"nameCheck" : false,
			"nickCheck" : false,
			"phoneCheck" : false,
			"emailCheck" : false
		}

//아이디 중복체크
	function idDuplicate() {	
		
		var inputId = $("input[name='memberId']").val();
		
		$.ajax({
			url : "idCheck.do",
			method : "post",
			data : {id : inputId}, 
			datatype : "html",
			success : function(result) {
				if(result=="true"){
					$("#idCheckResult").text("사용 가능한 아이디 입니다.");
					$("#idCheckResult").css("color", "green");
					joinCheck["idCheck"] = true;
				}else{
					$("#idCheckResult").text("이미 존재하는 아이디 입니다.");
					$("#idCheckResult").css("color", "red");
					$("input[name='memberId']").focus();
					joinCheck["idCheck"] = false;
				}
			},
			error : function(ex) {
				alert(ex);
			}
		})
		
	};
	
	//닉네임 중복체크
	function nickDuplicate() {
		
		var inputNick = $("input[name='memberNick']").val();
		
		$.ajax({
			url : "nickCheck.do",
			method : "post",
			data : {nick : inputNick}, 
			datatype : "html",
			success : function(result) {
				if(result=="true"){
					$("#nickCheckResult").text("사용 가능한 닉네임 입니다.");
					$("#nickCheckResult").css("color", "green");
					joinCheck["nickCheck"] = true;
				}else{
					$("#nickCheckResult").text("이미 존재하는 닉네임 입니다.");
					$("#nickCheckResult").css("color", "red");
					$("input[name='memberNick']").focus();
					joinCheck["nickCheck"] = false;
				}
			},
			error : function(ex) {
				alert(ex);
			}
		})
		
	};

	//비밀번호 재확인
	function pwCheck() {
		if($("input[name='memberPw']").val() == $("input[name='memberPwre']").val()){
			$("#pwCheckResult").text("비밀번호가 일치합니다.");
			$("#pwCheckResult").css("color", "green");
		}else{
			$("#pwCheckResult").text("비밀번호 불일치");
			$("#pwCheckResult").css("color", "red");
			joinCheck["pwCheck"]=false;
			$("input[name='memberPwre']").focus();
		}
	}
	
$(function() {
	
	$("#idCheck").click(function() {
		idDuplicate();
	})
	
	$("#nickCheck").click(function() {
		nickDuplicate();
	})
	
	$("form").submit(function() {
		
			if($("input[name='memberId']").val() == ""){
				alert("ID를 입력하세요.");
				$("input[name='memberId']").focus();
				return false; 
			}else{
					idDuplicate();
			}
			if(joinCheck["idCheck"]==false){
				$("input[name='memberId']").focus();
				return false;
			}
			if($("input[name='memberPw']").val() == ""){
				alert("비밀번호를 입력하세요.");
				$("input[name='memberPw']").focus();
				return false;
			}
			if($("input[name='memberPw']").val().length<4){
				alert("비밀번호가 너무 짧습니다.");
				$("input[name='memberPw']").focus();
				return false;
			}else{
				joinCheck["pwCheck"]=true;
			}
			if($("input[name='memberName']").val()==""){
				alert("이름 입력");
				$("input[name='memberName']").focus();
				return false;
			}else{
				joinCheck["nameCheck"]=true;
			}
			if($("input[name='memberNick']").val()==""){
				alert("닉네임 입력");
				$("input[name='memberNick']").focus();
				return false;
			}else{
					nickDuplicate();
			}
			if(joinCheck["nickCheck"]==false){
				$("input[name='memberNick']").focus();
				return false;
			}
			if($("input[name='memberPhone']").val()==""){
				alert("번호 입력");
				$("input[name='memberPhone']").focus();
				return false;
			}else{
				joinCheck["phoneCheck"]=true;
			}
			if($("input[name='memberEmail']").val()==""){
				alert("이메일 입력");
				$("input[name='memberEmail']").focus();
				return false;
			}else{
				joinCheck["emailCheck"]=true;
			}
			if(joinCheck["idCheck"]&&joinCheck["pwCheck"]&&joinCheck["nameCheck"]
			&&joinCheck["nickCheck"] && joinCheck["phoneCheck"] && joinCheck["emailCheck"]){
				return true;
			}
		})
})