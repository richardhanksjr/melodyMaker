<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type='text/javascript' src='http://www.midijs.net/lib/midi.js'></script>
    <link href="css/bootstrap-3.3.6-dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/bootstrap-3.3.6-dist/css/style.css">
	


<title>Sound Patterns</title>
</head>
<body>

<div class = "container-fluid">
	<div class = "jumbotron text-center">
		<h1>Sound Patterns </h1>
		<p>Create phrases and play them through various algorithms</p>
	</div>
	
<div class = "row top-section panel-body">

	<div class = "row text-center">
		<div class = "col-lg-4"></div>
		<div class = "col-lg-4">
			 <form action = "setTitle.do" method = "GET">
			  	<h3 class="text-center" >Add New Melody</h3>
		</div>
		<div class = "col-lg-4"></div>
	</div>
	<div class = "row">
			<div class = "col-lg-12">
		 		<input class = "center-block text-center" type = "text" name = "title" value = "Title" /></textarea>
		 	</div>
	 </div>
	 <div class = "row">
		 	<div class = "col-md-12">	
		 		<input class = "center-block btn btn-default " type = "submit" name = "Create New Melody" value = "Create New Melody"><br>
		 	</div>
		 	</form>  
	</div>
</div>
	
<div class = "row">
		
	 	 <c:forEach var = "phrases" items = "${melodies}">
	 	 
	 
	 <div class = "row">
		 
		 	<form action = "playMelody.do" method = "GET">
		 	<div class = "row">
		 		<h3 class = "col-md-12 text-center">"${phrases.title}"</h3>
		 	</div>
			
			
			 <input type = "hidden" name = "title" value = ${phrases.title}>
	<div class = "row">
		<div class = "col-md-12 text-center">
			<input class = "center-blocktype btn btn-default " type = "submit" name = "submit" value = "Play Melody">
			<input class = "center-blocktype btn btn-default " type = "submit" name = "submit" value = "Phase Melody">
			<input class = "center-blocktype btn btn-default " type = "submit" name = "submit" value = "Polyphony Melody">
			<input class = "center-blocktype btn btn-default " type = "submit" name = "submit" value = "Stop Playback">
			<input class = "center-blocktype btn btn-default " type = "submit" name = "submit" value = "Edit">
		</div>
	</div>
	</div>
		</form>
		</c:forEach> 
	
</div>
		<form action = "loadMelodies.do" method = "GET">
		<div class = "row load-row">
			<div class = "col-md- 12 text-center">
		  		<input class="btn btn-default" type = "submit" name = "loadMelodies" value = "Load Phrases From File">
			</div>
		</div>
		</form>
</div>
</body>
	
</html>