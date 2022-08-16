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
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a href="/search/topTen" class="nav-link"> Top Songs</a>
      </li>
      <li class="nav-item active">
      	<a href="/songs/new" class="nav-link"><b>+</b> Add new songs</a>
      </li>
    </ul>
      
    <form class="form-inline my-2 my-lg-0" action="/search" method="get">
    	<input class="search form-control mr-sm-2" type="text" name="artist">
		<input class="submit btn btn-outline-success my-2 my-sm-0" type="submit" value="New Search">
    </form>
    
  </div>
</nav>
	
	<div class="container">
    	<div class="row col-md-6 col-md-offset-2 custyle">
    		<table class="table table-striped custab">
    			<thead>
        			<tr>
            			<th>ID</th>
            			<th>Song Name</th>
            			<th>Rating</th>
            			<th class="text-center">Action</th>
        			</tr>
    			</thead>
    			<tbody>
					<c:forEach items="${song}" var="songs">
					<tr>
						<td><c:out value="${songs.id}"/></td>
						<td><a href="/songs/${songs.id}"><c:out value="${songs.title}"/></a></td>
						<td><c:out value="${songs.rating}"/> <span class="glyphicon glyphicon-star"></span></td>
						<td class = "text-center"><a class='btn btn-danger btn-xs' href="/songs/delete/${songs.id}"><span class="glyphicon glyphicon-remove"></span>Delete</a></td>
					</tr>
					</c:forEach>
				</tbody>
    		</table>
    	</div>
	</div>
</body>
</html>