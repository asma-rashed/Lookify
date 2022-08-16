<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/show.css" />
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<div class="container">
		<h1><c:out value="${songs.title}"/></h1>
		<p>Artist: <c:out value="${songs.artist}"/></p>
		<p>Rating: <c:out value="${songs.rating}"/></p>
		<a href="/languages/delete/${songs.id}">Delete</a>
	</div>
</body>
</html>