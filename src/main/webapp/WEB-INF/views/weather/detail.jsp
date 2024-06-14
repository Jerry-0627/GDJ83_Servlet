<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>세부 날씨 정보</h1>
	<h1>${requestScope.dto.city}</h1>
	<h1>${requestScope.dto.gion}</h1>
	<h1>${requestScope.dto.status}</h1>
	<h1>${requestScope.dto.humidity}</h1>
	<form id="frm" action="./delete" method="post">
		<input type="hidden" name="num" value="${requestScope.dto.num}">
		 <!-- name은 파라미터에 이름으로 들어감 name에는 세터에서 대문자를 소문자로 바꾼 것을 넣자-->
		 <!-- 입력된 값이 value에 들어가고 파라미터로 가니까 미리 지우려는 번호를 넣어둬라 -->
		 <!-- 이엘의 문제점은 수정할 수 있다는 것, 따라서 readonly를 해줌 -->
	</form>


	
	<button id="btn">DELETE</button>
	<button id="up">UPDATE</button>
	
	<script type="text/javascript">
		const frm = document.getElementById("frm");
		const btn = document.getElementById("btn");
		const up = document.getElementById("up");
		
		up.addEventListener("click", function(){
			frm.setAttribute("action", "./update");
			frm.setAttribute("method", "get");
			frm.method="get"
			frm.submit();
		})
		btn.addEventListener("click", function(){
			frm.submit();
		})

	</script>
</body>
</html>