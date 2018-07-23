$(function() {
	$("#updatebtn").click(function() {
		$("input[readonly='readonly']").prop("readonly", false);
	})
		
	var userId = ${sessionScope.loginId};
	
	$.ajax({
		url : "getMember.do",
		method : "post",
		data : {id : userId}, 
		datatype : "html",
		success : function(result) {
			
		},
		error : function(ex) {
			alert(ex);
		}	
	})
	
})