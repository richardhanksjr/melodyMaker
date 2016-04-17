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
			<%-- <input type ="text" name = "pitch" value = "${note.pitch}">Pitch<br> --%>
			
			<select name = "pitch">
				<option value = "21">A</option>
				<option value = "22">A#/Bb</option>
				<option value = "23">B</option>
				<option value = "24">C</option>
				<option value = "25">C#/Db</option>
				<option value = "26">D</option>
				<option value = "27">D#/Eb</option>
				<option value = "28">E</option>
				<option value = "29">F</option>
				<option value = "30">F#/Gb</option>
				<option value = "31">G</option>
				<option value = "32">G#/Ab</option>

			</select>
			<select name = "octave">
				<option value = "1">1</option>
				<option value = "2">2</option>
				<option value = "3">3</option>
				<option value = "4">4</option>
				<option value = "5">5</option>
				<option value = "6">6</option>
			</select>
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