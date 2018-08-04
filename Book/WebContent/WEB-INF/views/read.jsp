<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	function recommend() {
		$.ajax({
			url : "processUpDown.do",
			method : "post",
			data : {code : "up", bookb_num:"${vo.bookb_num}"}, 
			datatype : "text",
			success : function(result) {
				if(result != "null"){
				var book = JSON.parse(result);
				$("#bookup").text(book.recommend);
				}
			},
			error : function(ex) {
				alert(ex);
			}
		})
	}
	
	function opposite() {
		$.ajax({
			url : "processUpDown.do",
			method : "post",
			data : {code : "down", bookb_num:"${vo.bookb_num}"}, 
			datatype : "text",
			success : function(result) {
				if(result != "null"){
				var book = JSON.parse(result);
				$("#bookdown").text(book.opposite);
				}
			},
			error : function(ex) {
				alert(ex);
			}
		})
	}
	
	  function checkValueDefault(target_comment){
	        
	    }
	    
	    function viewForm(target_comment){
	        var comment_num = "comment_"+target_comment;
	        $("#"+comment_num).toggle();
	    }

	
	 var commentCheck = {
			'pwCheck':false,
			'contentCheck':false
		}; 
	
	 function checkValue(comment_num) {
			 	if ($("#comment_pw"+comment_num).val()==''){
					alert('password should over 4');
					return false;
				}
				if ($('textarea[name="content"]').val()=='') {
					$('textarea[name="content"]').focus();
					return false;
				}
				if(commentCheck['pwCheck']&&commentCheck['contentCheck']){ 
					var bookb_num = $("input[name=bookb_num]").val();
					var commentData=$('#comment_'+comment_num).serialize();
					$.ajax({
		               url : "${pageContext.request.contextPath}/comment_request.do?comment_num="+comment_num,
		               type : "get",
		                dataType : "text", 
		               data : commentData, 
		               success : function(data) {
		                   if(data == 1){
		                       alert("success comment insert");
		                    
		                       $("input[type=password]").each(function() {
		                           $(this).val("");
		                       })
		                        $("textarea[name=content]").each(function() {
		                           $(this).val("");
		                       })
		                      $('#comment_'+comment_num).toggle();
		                       $('#'+bookb_num).empty();
		                       
		                       location.reload();


		                   }else{
		                       alert("fail to insert comment to data");    
		                   }
		               },
		               error : function name() {
		                   alert("ajax fail");
		               }
		           });
			
				 }  			
	   }
		
	$(function() {
		
		var bookb_num = $("input[name=bookb_num]").val();
		$("#horrorList").click(function() {
							var bb_code = $(this).val();
							location.href = "${pageContext.request.contextPath}/horror.do?bb_code="
									+ bb_code;
		return false;				
		})


		
		
	$.ajax({
			url : "processUpDown.do",
			method : "post",
			data : {code : "check", bookb_num:"${vo.bookb_num}"}, 
			datatype : "text",
			success : function(result) {
				if(result != "null"){
				var book = JSON.parse(result);
				$("#bookup").text(book.recommend);
				$("#bookdown").text(book.opposite);
				}
			},
			error : function(ex) {
				alert(ex);
			}
		})
	
	
})
</script>
<link type="text/css" rel="stylesheet" href="resource/style.css">
<title></title>
<style type="text/css">
.title{
color: white;
letter-spacing: .20em;
text-shadow: 1px -1px 0 #767676, -1px 2px 1px #737272, -2px 4px 1px #767474, -3px 6px 1px #787777, -4px 8px 1px #7b7a7a, -5px 10px 1px #7f7d7d, -6px 12px 1px #828181, -7px 14px 1px #868585, -8px 16px 1px #8b8a89, -9px 18px 1px #8f8e8d;
}
.genre {
font: 25px/25px Georgia,serif; padding: 10px; border-radius: 10px; border: 2px solid rgb(28, 110, 164); border-image: none; background-image: radial-gradient(at center, rgb(28, 110, 164) 0%, rgb(35, 136, 203) 14%, rgb(20, 78, 117) 100%); color: rgb(223, 255, 164); text-transform: none; text-decoration: none; box-shadow: 5px 5px 15px 5px #000000; display: inline-block;}
.genre:hover {
background: #1C6EA4; }
.genre:active {
background: #144E75; }

</style>
</head>
<body>


	<header>
		<h1 class="gradient">Book Review</h1>
		<h5>dreamING of breaking away from the routine of daily life</h5>
	</header>
	
	


	<section>
	
		<div class="col_3 sidebar">
			<div class="loginStation">
				${sessionScope.loginNick } welcome <a href="checkPassword.do">memberinfo</a><br>
				<a href="logout.do">logout</a>
			</div>

			<ul>
				<li id="bb101" value="horror" class="genre">HORROR</li>
				<li id="bb102" value="romance" class="genre">ROMANCE</li>
				<li id="cook" value="cook" class="genre">COOK</li>
				<li id="travel" value="travel" class="genre">TRAVEL</li>
			</ul>
		</div>


		<article class="col_9">
		<div id="scroller" style="overflow:auto; width:100%; height:400px;">
			<h1>read page</h1>

			<table border="1">
				

				<tr>
					<td width="10%">book_name</td>
					<td width="90%">${vo.book_name}</td>
				</tr>


				<tr>
					<td width="10%">title:</td>
					<td width="90%">${vo.title}</td>
				</tr>

				<c:choose>
					<c:when test="${empty fileList}">
						<tr>
							<td>file:</td>
							<td>no list uploaded</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${fileList}" var="fileList">
							<tr>
								<td>file:</td>
								<td><a
									href="download.do?bookb_num=${fileList.bookb_num}&file_num=${fileList.file_num}">${fileList.original_name}</a>
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>



				<tr>
					<td width="10%">writer:</td>
					<td width="90%">${vo.writer}</td>
				</tr>
				<tr>
					<td width="10%">content:</td>
					<td width="90%">${vo.content}</td>
				</tr>

				<tr>
					<td colspan="2"><button id="horrorList" value="bb101">horrorList</button>
				<a href="bookPage.do" target="_blank"><button id="bookAPI" value="bookAPI">bookAPI</button></a>
				<!-- <a href="bookPage.do" target="_blank">새창으로 가자</a> -->
						<%-- <%-- <a href="updateCheck.do?boardNum=${readBoard.boardNum}"><button>modify</button></a>
						<a href="deleteCheck.do?boardNum=${readBoard.boardNum}"><button>delete</button></a>
						<a href="replyForm.do?boardNum=${readBoard.boardNum}&p=${page}"><button>reply</button></a> --%>
					</td>
					<td>
						<button id="recommend" onclick="recommend()">↑</button><label for="recommend" id="bookup"></label> 
						 <button id="opposite" onclick="opposite()">↓</button><label for="opposite" id="bookdown"></label>
					</td>
				</tr>

			</table>


			<input type="hidden" name="bookb_num" value="${vo.bookb_num}">
			<input type="hidden" name="p" value="${p}">

			
			
			<div id="${vo.bookb_num}">
			 <c:choose>
            <c:when test="${empty commentList}">
                <h4>comments</h4>
                <form name="commentWriteDefault"
                    action="<%=request.getContextPath()%>/freebaord_comment_write_request">
                    ${vo.writer}
                    pw:<input type="password" name="password" size="10%"><hr>
                    <textarea style="vertical-align: 10%" cols="80%" rows="1" name="content"></textarea>
                    <input type="button" onclick="checkValueDefault()" value="send"/><br />
                </form>
            </c:when>
            
            <c:otherwise>
                <c:forEach items="${commentList}" var="k">
                    
                    <c:if test="${k.bookc_level ne 0}">
                        <c:forEach begin="1" end="${k.bookc_level}"
                            var="level">&nbsp;&nbsp;&nbsp;</c:forEach>
                    </c:if>
                    
                    <span>${k.comment_num}-${k.content} -
                        ${k.writer} - ${k.write_date}<input type="button" value="comment" onclick="viewForm(${k.comment_num})" name="commentWriteForm">
                        <input type="hidden" name="bookb_num" value="${vo.bookb_num}">
                   <input name="comment_num" type="hidden" value="${k.comment_num}">
                      
                        </span>
                
                     <form name="commentWrite" id="comment_${k.comment_num}" 
                           style="display: none;">
                           <input type="hidden" value="${vo.bookb_num}">
                           ${vo.writer}<br />
                            pw:<input type="password" name="comment_pw" id="comment_pw${k.comment_num}">
                            <br />
                            <textarea name="content"></textarea>
                           <input name="comment_num" type="hidden" value="${k.comment_num}">
                           
                            <input type="button" onclick="checkValue(${k.comment_num})" value="write" class="insertComment"> 
                        </form>
                   
                    <br />
 
                </c:forEach>
 
            </c:otherwise>
        </c:choose>

			</div>
		
			
			<%-- <div id="${comment.comment_num}" style="display: none;">
				${comment.writer}
				<textarea name="content" cols="60%" rows="2"></textarea>
				pw:<input type="password" name="commentPw" size="10"> <input
					type="submit" value="submit" id="submit">
				<hr>
				<button id="co_comment_${comment.commentNum}" value="${comment.comment_num}"
					style="vertical-align: middle;">${comment.comment_num}_comment</button>
			</div> --%>
			
			</div>
			<div>
			</div>
		</article>
	
	</section>
	
	<footer>
		<p>Footer</p>
	</footer>



</body>
</html>