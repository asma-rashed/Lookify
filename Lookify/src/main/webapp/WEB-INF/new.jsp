<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<div class="container">
		<h1>New Song</h1>
		<form:form action="/songs/new" method="post" modelAttribute="song">
			<p>
				<form:label path="title">Title</form:label>
				<form:errors path="title"/>
				<form:input path="title"/>
			</p>
			<p>
				<form:label path="artist">Artist</form:label>
				<form:errors path="artist"/>
				<form:input path="artist"/>
			</p>
			<p>
				<form:label path="rating">Rating (1-10)</form:label>
				<form:errors path="rating"/>
				<form:input type="number" path="rating"/>
			</p>
			<input type="submit" value="Add Song"/>
		</form:form>
	</div>
</body>
</html>