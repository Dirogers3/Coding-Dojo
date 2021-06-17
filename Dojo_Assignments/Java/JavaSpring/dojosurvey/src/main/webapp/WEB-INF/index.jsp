<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey Index</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<form method="POST" action="/submit">
		<div class="container-main">
			<div class="leftcol">
				<label>Your Name:</label>
				<label>Dojo Location:</label>
				<label>Favorite Language:</label>
				<label>Comment (optional):</label>
			</div>
			<div class="rightcol">
				<input type="text" name="name" id="name">
				<select name="location" id="location">
		            <option value="Burbank">Burbank</option>
		            <option value="San Jose">San Jose</option>
		            <option value="Orange County">Orange County</option>
		            <option value="Seattle">Seattle</option>
		            <option value="Boise">Boise</option>
		            <option value="DC">DC</option>
	        	</select>
		        <select name="language" id="language">
		            <option value="Java">Java</option>
		            <option value="Python">Python</option>
		            <option value="C++">C++</option>
		            <option value="Ruby">Ruby</option>
		            <option value="Javascript">Javascript</option>
		        </select>
			</div>
		</div>
			<textarea name="comments" id="comments" cols="30" rows="3"></textarea>
			<button>Submit</button>
		</form>
	</div>
</body>
</html>