<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var = "note" items = "${notes}" varStatus = "status">
		<div>${note}</div>
		<form action = "editMelody.do" method = "GET">
			<input type = "hidden" name = "index" value = "${index}"><br>
			<input type ="text" name = "pitch" value = "${note.pitch}">Pitch<br>
			<input type = "hidden" name = "noteIndex" value = "${status.index}">
			<input type ="text" name = "rhythm" value = "${note.rhythmValue}">Duration<br>
			<input type = "text" name ="title" value = "${phrase.title}"><br>
			<input type = "submit" name = "submit" value = "Edit"><br>
		</form>
	</c:forEach>
</body>
</html>