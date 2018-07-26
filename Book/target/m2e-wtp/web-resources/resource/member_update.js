
var joinCheck = {

		"nameCheck" : false,

		"nickCheck" : false,

		"phoneCheck" : false,

		"emailCheck" : false

	}



function phCheck() {

	$("input[name='phone']").val($("input[name='phone1']").val() + "-" 

			+ $("input[name='phone2']").val() + "-" + $("input[name='phone3']").val());

}



$(function() {

	

	$("form").submit(function() {

		

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

			if(joinCheck["nameCheck"] &&joinCheck["nickCheck"] && joinCheck["phoneCheck"] && joinCheck["emailCheck"]){

				return true;

			}else{

				alert("작성내용을 다시 확인해주세요.");

			}

		})

})