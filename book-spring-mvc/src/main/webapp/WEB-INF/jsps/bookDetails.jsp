<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Details</title>
</head>
<body>

	<table cellspacing="3" cellpadding="3">
	
		<tr><th>Book ID</th><th>Book Title</th><th>Book Author</th><th>Book Price</th></tr>
		
		<c:forEach var="book" begin="0" items="${ books }">
		
		<tr>
		
			<td><c:out value="${ book.bookId }" /></td>
			<td><c:out value="${ book.title }" /></td>
			<td><c:out value="${ book.author }" /></td>
			<td><c:out value="${ book.price }" /></td>
		
		</tr>

		</c:forEach>

	</table>

	<br>
	<br>
	<a href="bookForm">Click Here to add more Books!</a>
	<br>
	<a href="">Home Page</a>

</body>
</html>