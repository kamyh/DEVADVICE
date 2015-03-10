<%-- 
    Document   : login
    Created on : 3 mars 2015, 15:49:50
    Author     : derua_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="j_security_check" method="POST">
            Username:<input type="text" name="j_username"><br>
            Password:<input type="password" name="j_password">
            <input type="submit" value="Login">
         </form>
    </body>
</html>
