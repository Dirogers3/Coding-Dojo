<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey Index</title>
<link rel="stylesheet" href="css/styles.css" />
</head>
<body>
    <div class="container">
        <form action="/submit" method="POST">
            <div class="cols">
                <div class="survey">
                    <label for="name">Your name:</label>
                    <input type="text" name="name" id="name">
                </div>
                <div class="survey">
                    <label for="location">Dojo Location:</label>
                    <select name="location" id="location">
                        <option value="sanjose">San Jose</option>
                        <option value="boise">Boise</option>
                        <option value="seattle">Seattle</option>
                        <option value="dc">DC</option>
                    </select>
                </div>
                <div class="survey">
                    <label for="language">Favorite Language</label>
                    <select name="language" id="language">
                        <option value="python">Python</option>
                        <option value="java">Java</option>
                        <option value="ruby">Ruby</option>
                    </select>
                </div>
            </div>
            <label for="comment">Comment (optional)</label>
            <br>
            <textarea name="comment" id="comment" cols="30" rows="4"></textarea>
            <br>
            <button>Button</button>
        </form>
    </div>
    
</body>
</html>