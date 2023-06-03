<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 가져오기</title>
</head>
<body>
	<input type="text" name="name">
	<p id="result"></p>
	<button id="getData">데이터 가져오기</button>
</body>
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<script>
	$("#getData").on("click", function(){
		$.ajax({
			url: "b.jsp",
			//			this = button  / input의 value 값
			data: {"name": $(this).prev().prev().val()},
			// 데이터가 저쪽으로 이동했다면 result에 callback함수를 넣어줘 라는 뜻
			success: function(result){
				$("#result").text(result);
			}
		});
	})
</script>
</html>







