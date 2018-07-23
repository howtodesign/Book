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
		
		var inputId = $("input[name='id']").val();
		
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
					$("input[name='id']").focus();
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
		
		var inputNick = $("input[name='nickname']").val();
		
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
					$("input[name='nickname']").focus();
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
		if($("input[name='password']").val() == $("input[name='passwordre']").val()){
			$("#pwCheckResult").text("비밀번호가 일치합니다.");
			$("#pwCheckResult").css("color", "green");
		}else{
			$("#pwCheckResult").text("비밀번호 불일치");
			$("#pwCheckResult").css("color", "red");
			joinCheck["pwCheck"]=false;
			$("input[name='passwordre']").focus();
		}
	}
	//전화번호 
	function phCheck() {
		$("input[name='phone']").val($("input[name='phone1']").val() + "-" 
				+ $("input[name='phone2']").val() + "-" + $("input[name='phone3']").val());
	}
	
	
$(function() {
	
	$("input[name='phone1']").keyup(function() {
		if($(this).val().length==$(this).attr('maxlength')){
			$(this).next(':input').focus();
		}
	})
	$("input[name='phone2']").keyup(function() {
		if($(this).val().length==$(this).attr('maxlength')){
			$(this).next(':input').focus();
		}
	})
	
	$("form").submit(function() {
		
			if($("input[name='id']").val() == ""){
				alert("ID를 입력하세요.");
				$("input[name='id']").focus();
				return false; 
			}else{
					idDuplicate();
			}
			if(joinCheck["idCheck"]==false){
				$("input[name='id']").focus();
				return false;
			}
			if($("input[name='password']").val() == ""){
				alert("비밀번호를 입력하세요.");
				$("input[name='password']").focus();
				return false;
			}
			if($("input[name='password']").val().length<4){
				alert("비밀번호가 너무 짧습니다.");
				$("input[name='password']").focus();
				return false;
			}else{
				joinCheck["pwCheck"]=true;
			}
			if($("input[name='name']").val()==""){
				alert("이름 입력");
				$("input[name='name']").focus();
				return false;
			}else{
				joinCheck["nameCheck"]=true;
			}
			if($("input[name='nickname']").val()==""){
				alert("닉네임 입력");
				$("input[name='nickname']").focus();
				return false;
			}else{
					nickDuplicate();
			}
			if(joinCheck["nickCheck"]==false){
				$("input[name='nickname']").focus();
				return false;
			}
			if($("input[name='phone']").val()=="--"){
				alert("번호 입력");
				$("input[name='phone1']").focus();
				return false;
			}else if(isNaN($("input[name='phone1']").val()) || isNaN($("input[name='phone2']").val()) 
					   ||isNaN($("input[name='phone3']").val())) {
				  joinCheck["phoneCheck"]=false;
				  alert("숫자만 입력");
				  return false;
			}else if ($("input[name='phone']").val().length != 13) {
				   joinCheck["phoneCheck"]=false;
				   alert("전화번호 확인");
				   return false;
			}else{
				   joinCheck["phoneCheck"]=true;
			}
			if($("input[name='email']").val()==""){
				alert("이메일 입력");
				$("input[name='email']").focus();
				return false;
			}else{
				joinCheck["emailCheck"]=true;
			}
			if(joinCheck["idCheck"]&&joinCheck["pwCheck"]&&joinCheck["nameCheck"]
			&&joinCheck["nickCheck"] && joinCheck["phoneCheck"] && joinCheck["emailCheck"]){
				return true;
			}else{
				alert("작성내용을 다시 확인해주세요.");
			}
		})
})