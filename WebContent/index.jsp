<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Create a Melody</title>
</head>
<body>
<form action="addMelody.do" method="GET">
	<input type = "radio" name = "duration" value = "WN"><img class = "note" src = "http://images.all-free-download.com/images/graphiclarge/whole_note_144266.jpg"><br>
	<input type = "radio" name = "duration" value = "HN><img class = "note" src = "https://giaoduccontusom.files.wordpress.com/2010/05/halfnote.jpg"><br>
	<input type = "radio" name = "duration" value = "QN"><img class = "note" src = "http://s3.amazonaws.com/static.graphemica.com/glyphs/i500s/000/001/751/original/1D15F-500x500.png?1275290601"><br>
	<input type = "radio" name = "duration" value = "EN"><img class = "note" src = "http://images.clipartpanda.com/eighth-note-clip-art-eighth_note-800px.png"><br>
	<div>PITCH</div>
	<input type="text" name="pitch" value=""><br>
	<div>OCTAVE</div>
	<input type = "radio" name = "octave" value = "1">1<br>
	<input type = "radio" name = "octave" value = "2">2<br>
	<input type = "radio" name = "octave" value = "3">3<br>
	<input type = "radio" name = "octave" value = "4">4<br>
	<input type = "radio" name = "octave" value = "5">5<br>
	<input type = "radio" name = "octave" value = "6">6<br>
	<input type="submit" name="submit" value="submit"/>
</form>
</body>
</html>