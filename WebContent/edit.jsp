<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib
uri="http://www.springframework.org/tags/form" prefix = "form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap-3.3.6-dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/bootstrap-3.3.6-dist/css/style.css">
<title>Edit Melody</title>
</head>
<body>
	<div class = "container-fluid">
		
		<div class = "jumbotron text-center">
			<h1>Edit the Phrase</h1>
			<p>This is a list of all notes in the phrase in the order they appear</p>
			<p>Edit each note as needed.  CLICKING DELETE WILL ERASE THE PHRASE</p>
			
		</div>
		<c:forEach var = "note" items = "${notes}" varStatus = "status">
		<div class = "row text-center">
		<div class = "col-md-12 add-button">
		<form action = "editMelody.do" method = "GET">
		<input type = "hidden" name = "index" value = "${index}"><br>
			
			
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
			<select name = "rhythm">
				<option value = "4.0">Whole Note</option>
				<option value = "2.0">Half Note</option>
				<option value = "1.0">Quarter Note</option>
				<option value = "0.5">Eighth Note</option>
			</select>
			<%-- <input type ="text" name = "rhythm" value = "${note.rhythmValue}">Duration<br> --%>
			<input type = "submit" name = "submit" value = "Edit">
			
				
		</form>
		</div>
		</div>
	</c:forEach>
	<div class = "row text-center">
	<div class = "col-md-12 add-button">
	<form action ="deleteMelody.do" method = "GET">
		<input type = "hidden" name = "index" value = "${index}"><br>
		<input class = "btn-danger" type = "submit" name = "submit" value = "Delete"> 
		<input type = "submit" name = "submit" value = "Cancel">
	</form>
	</div>
	</div>
</div>
</body>
</html>