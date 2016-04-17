<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib
uri="http://www.springframework.org/tags/form" prefix = "form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<div>${note}</div>
		<c:forEach var = "note" items = "${notes}" varStatus = "status">
		<form action = "editMelody.do" method = "GET">
		<input type = "hidden" name = "index" value = "${index}"><br>
			<input type ="text" name = "pitch" value = "${note.pitch}">Pitch<br>
			<input type = "hidden" name = "noteIndex" value = "${status.index}">
			<input type ="text" name = "rhythm" value = "${note.rhythmValue}">Duration<br>
			<input type = "submit" name = "submit" value = "Edit">
			<input type = "submit" name = "submit" value = "Cancel">
				
		</form>
	</c:forEach>
	
	<form action ="deleteMelody.do" method = "GET">
		<input type = "hidden" name = "index" value = "${index}"><br>
		<input type = "submit" name = "submit" value = "Delete"> 
	</form>
</body>
</html>