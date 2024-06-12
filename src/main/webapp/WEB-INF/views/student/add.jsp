<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생정보입력 페이지</h1>
	
	<form action="/student/add" method="post">	
		<div>
			<label for="num">번호</label>
			<!-- 파라미터의 이름은 setter의 이름과 동일하게 맞춰라. -->
			<input type="text" id="num" name="num">
		</div>
		<div>
			<label for="name">이름</label>
			<input type="text" id="name" name="name">
		</div>	
		<div>
			<label for="avg">평균</label>
			<input type="text" id="avg" name="avg">
		</div>	
		<div>
			<label></label>
			<input type="radio" name="ch" value="여자">
			<input type="radio" name="ch" value="남자">
		</div>
		<div>
			<select name="mobile">
				<option value="KT">KT</option>
				<option value="LG">LG</option>
				<option value="SKT">SKT</option>
			</select>
		</div>		
		<div>
			<input type="checkbox" name="ch2" value="v1">
			<input type="checkbox" name="ch2" value="v2">
			<input type="checkbox" name="ch2" value="v3">
		</div>
		<div>
			<textarea rows="" cols="" name="content"></textarea>
		</div>
		
		<div>
			<input type="submit" value = "등록">
			<button type="submit">작성</button>
		</div>
	
	</form>
	
</body>
</html>