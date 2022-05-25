<%-- 
    Document   : createAccForHirer
    Created on : May 25, 2022, 4:21:49 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account Page</title>
    </head>
    <body>
        <h3>Create Account for Hirer</h3>
        <form action="MainController">
            userName: <input type="text" name="userName" value="${param.userName}" required=""/><br>
            password: <input type="password" name="password" value="" required=""/><br>
            conform: <input type="password" name="conform" value="" required=""/>
                <font style="color: red">${CONFIRM_ERROR}</font><br>
            fullName: <input type="text" name="fullName" value="${param.fullName}" required=""/><br>
            email: <input type="text" name="email" value="${param.email}" required=""/><br>
            phone: <input type="text" name="phone" value="${param.phone}" required=""/><br>
            location: <input type="text" name="location" value="${param.location}" required=""/><br>
            balance: <input type="number" name="balance" value="${param.balance}" required="" min="0"/><br>
            
            
            conpanyName: <input type="text" name="conpanyName" value="${param.conpanyName}" required=""/><br>
            <input type="submit" value="Create Hirer" name="action" />
        </form>
    </body>
</html>
