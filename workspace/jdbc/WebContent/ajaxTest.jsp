<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="joinAction.member" name="joinForm" method="post">
		<div>
			<input type="text" name="memberIdentification" placeholder="아이디">
			<p id="result"></p>
		</div>
		<div>
			<input type="text" name="memberPassword" placeholder="비밀번호">
		</div>
		<!-- class명 또는 id명은 예약어를 사용하지 말자! -->
		<input id="finish" type="button" value="완료">
	</form>		
</body>
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<script>
	$("input[name='memberIdentification']").on("blur", function({
		$.ajax({	//EL문에서 requset객체를 가져오는 방법
			url: "${pageContext.request.contextPath}/checkIdAction.member",
			data: {"memberIdentification": $("input[name='memberIdentification']").val()},
			//				이 result 값은 body태그 안에있는 text값 근데 JSON으로 작성이 되어있으니 parse를 씀
			success: function(result){
				result = JSON.parse(result);
				const $p = $("#result");
				if(!result.check){
					check = true;
					$p.css("color", "blue");
					$p.text("사용 가능한 아이디 입니다.")
				}else{
					check = false;
					$p.css("color","red")
					$p.text("중복된 아이디입니다.")
				}
			}
		})
	}))

	$("#finish").on("click", function(){
		const $identification = $("input[name='memberIdentification']");
		const $password = $("input[name='memberPassword']");
		
		if(!$identification.val()){
			return;
		}
		if(!$identification.val()){
			return;
		}
		if(!$password.val()) {
			return;
		}
		if(!globalThis.check) {
			return;
		}
		
		$password.val(btoa($password.val()));
		
		joinForm.submit();
	})

</script>