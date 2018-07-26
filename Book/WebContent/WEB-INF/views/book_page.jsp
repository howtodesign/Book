<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
<script type="text/javascript">
	$(function() {
		$('#btnSearch').click(function(){
			var keyword=$('#keyword').val();
			if(keyword==null||keyword==''){
				alert('input keyword');
				return false;
			}
			$.ajax({
				url:'bookSearch.do', 
				method:'get',
				data:'keyword='+keyword,
				dataType:'text',
				success:function(result){
					var Ca=/\+/g;
					result = decodeURIComponent(result.replace(Ca, " "));
					xmlDoc=$.parseXML(result),
					$xml=$(xmlDoc);
					var addElement;
					$xml.find('item').each(function(){
						var title = $(this).find('title').text();	
						var image = $(this).find('image').text();
						var author = $(this).find('author').text();
						var price = $(this).find('price').text();
						var discount = $(this).find('discount').text();
						var publisher = $(this).find('publisher').text();
						
						addElement +='<tr>';
						addElement +='<td><img src="'+image+'"/></td>';
						addElement +='<td>'+title+'</td>';
						addElement +='<td>'+author+'</td>';
						addElement +='<td>'+price+'</td>';
						addElement +='<td>'+discount+'</td>';
						addElement +='<td>'+publisher+'</td>';
						addElement +='</tr>';
					});
					$('table tr:gt(0)').remove();
					$('table tr:first').after(addElement); 
				},
				error:function(ex){
					alert(ex.message);
				}
			})
		})
	})
</script>
<title></title>
</head>
<body>


<input type="text" id="keyword">
	<button id="btnSearch">search</button>
	<hr>
	<table border="1">
		<tr>
			<th>surface</th>
			<th>title</th>
			<th>author</th>
			<th>price</th>
			<th>discount</th>
			<th>publisher</th>
		</tr>




	</table>

</body>
</html>