<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/table.css" rel="stylesheet"> 
</head>
<body>
	<h1>날씨 정보 리스트</h1>
	
	<table class="tbl">
		<thead>
			<th>Num</th>
			<th>City</th>
			<th>Gion</th>
			<th>Status</th>
			<th>Humidity</th>
			
		</thead>	
		<tbody>
			<c:forEach items="${requestScope.list}" var="weather">
				<tr>
					<td>${pageScope.weather.num}</td>
					<td><a href="./detail">${pageScope.weather.city}</a></td>
					<td>${pageScope.weather.gion}</td>
					<td>${pageScope.weather.status}</td>
					<td>${pageScope.weather.humidity}</td>
				</tr>
			</c:forEach>
		</tbody>
			
			
			
	</table>
</body>
</html>