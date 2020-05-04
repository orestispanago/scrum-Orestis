<%-- 
    Document   : gandalf.jsp
    Created on : May 3, 2020, 10:33:21 PM
    Author     : Walter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css2?family=Spectral:wght@200&display=swap" rel="stylesheet">
        <title>JSP Page</title>
        <style>
            * {
                font-family: 'Spectral', serif;
                text-align:center; 
            }
            div {
                display: flex; 
                justify-content: center
            }
            p:first-of-type {
               margin-top: 1.5rem;
               font-weight: bold; 
               font-size: 1.1 rem;
            }
        </style>
    </head>
    <body>
        <div>
            <img src="img/gandalf2.png" height="300px" width="300px">
        </div>
        <p>YOU SHALL NOT PASS!</p>
        <p>Uh oh, Gandalf is blocking your way! Maybe you have a typo in the url? Or you meant to go to a different location?  Like.... Exam? Or... Hobbiton?</p>        
    </body>
</html>
