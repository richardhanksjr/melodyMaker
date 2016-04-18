<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap-3.3.6-dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/bootstrap-3.3.6-dist/css/style.css">
<title>Add Melody</title>
</head>
<body>
<div class = "container-fluid">
<div class = "jumbotron text-center">
		<h1>Create a New Phrase </h1>
		<p>Select a pitch, octave, and rhythmic value for each note</p>
		<p>When all notes have been entered, finalize the melody</p>
	</div>
<div class = "row text-center">
<div class = "col-md-12">
<audio src = "african0.mid"></audio>
	<form action="addNote.do" method="GET">
		<div class = "row">
						<div class = "col-md-lg">
							<h3> Rhythm:</h3>
						</div>
					</div>
		<select name = "duration" value = "Select Rhythm">
			<option value = "4.0">Whole Note</option>
			<option value = "2.0">Half Note</option>
			<option value = "1.0">Quarter Note</option>
			<option value = "0.5">Eighth Note</option>
		</select>
		<div class = "row">
						<div class = "col-md-lg">
							<h3> Pitch:</h3>
						</div>
					</div>
	
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
					<div class = "row">
						<div class = "col-md-lg">
							<h3> Octave:</h3>
						</div>
					</div>
				<select name = "octave">
					<option value = "1">1</option>
					<option value = "2">2</option>
					<option value = "3">3</option>
					<option value = "4">4</option>
					<option value = "5">5</option>
					<option value = "6">6</option>
				</select>
		<input type = "submit" name = "submit" value = "submit"/>
		</div>
	</form>
	<form action = "addMelody.do" method = "GET">
		
		<!--<input type = "text" name = "title" value = ""><br>  -->
		<div class = "row">
						<div class = "col-md-lg">
							<h2> Finalize Melody:</h2>
						</div>
					</div>
		<input type="submit" name="submit" value="submit"/>
	</form>
	</div>
	</div>
</div>
</body>
</html>