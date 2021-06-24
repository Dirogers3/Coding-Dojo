<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ninja Gold Game</title>
    <style>
        .options {
            display:inline-flex;
            justify-content: center;
        }
        .cards {
            border: 2px solid black;
            width: 120px;
            text-align: center;
            padding: 0px 10px 10px 10px;
            color: black;
            background-color: lightgray;
        }
        a {
            background-color: gray;
            padding: 4px;
            text-decoration: none;
        }
        p {
            margin-bottom: 35px;
        }
        .activities {
            border: 2px solid black;
            width: 500px;
            height: 100px;
        }
    </style>
</head>
<body>
    <h2>Your Gold:  ${gold}</h2>
    <div class="options">
        <div class="cards">
            <form action="/clickfarm" method="POST">
                <h3>Farm</h3>
                <p>(earns 10-20 gold)</p>
                <button>Find Gold!</button>
            </form>
        </div>
        <div class="cards">
            <form action="/clickcave" method="POST">
                <h3>Cave</h3>
                <p>(earns 5-10 gold)</p>
                <button>Find Gold!</button>
            </form>
        </div>
        <div class="cards">
            <form action="/clickhouse" method="POST">
                <h3>House</h3>
                <p>(earns 2-5 gold)</p>
                <button>Find Gold!</button>
            </form>
        </div>
        <div class="cards">
            <form action="/clickcasino" method="POST">
                <h3>Casino!</h3>
                <p>(earns/takes 0-50 gold)</p>
                <button>Find Gold!</button>
            </form>
        </div>
    </div>
    <h2>Activities: </h2>
    <textarea cols="67" rows="5">
        <c:forEach var="item" items="${ledger}">
            <c:out value="${item}"/>
        </c:forEach>
    </textarea>
</body>
</html>