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
	<h3>번호 : ${requestScope.detail.num}</h3>
	<h3>이름 : ${requestScope.detail.name}</h3>
	<h3>국어 점수 : ${requestScope.detail.kor}</h3>
	<h3>영어 점수 : ${requestScope.detail.eng}</h3>
	<h3>수학 점수 : ${requestScope.detail.math}</h3>
	<h3>총합 점수 : ${requestScope.detail.toal}</h3>
	<h3>평균 점수 : ${requestScope.detail.avg}</h3>
	

</body>
</html>