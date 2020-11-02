<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Form</title>
</head>
<body>

	<form action="addBook" method="post">
		BookId : <input type="text" name="bookId"/>
		Title : <input type="text" name="title"/>
		Author : <input type="text" name="author"/>
		Price : <input type="text" name="price"/>
		<input type="submit" value="Add Book"/>
	</form>
	
</body>
</html>