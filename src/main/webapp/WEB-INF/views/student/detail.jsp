<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 한명 정보</h1>
	<!-- 표현식 -->
	<!-- EL (Expression Language) 표현 언어 -->
	<%-- ${스코프영역명.속성명} --%>
	<!-- 꺼낼 때 getter의 이름 : get을 빼고 첫글자를 소문자로 바꾼것 -->
	<!-- 꺼낼 때 setter의 이름 : set을 빼고 첫글자를 소문자로 바꾼것 -->
	<!-- 꺼낼 때 setter의 이름 : set은 메서드에서 이름을 찾아야함. isFlag와 같은 것이 있어 변수명이라는 것은 보장이 안됨 -->
	<h3>${requestScope.s.name}</h3>
	<h3>${requestScope.s.num}</h3>
	<h3>${requestScope.s.avg}</h3>
</body>
</html>