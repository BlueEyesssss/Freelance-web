<%-- 
    Document   : createAccForSeeker
    Created on : May 25, 2022, 4:22:15 PM
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
                <h3>Create Account for Seeker</h3>
        <form action="MainController">
            userName: <input type="text" name="userName" value="${param.userName}" required=""/>
                <font style="color: red">${requestScope.ERROR_CREATE.userName}</font>
                <font style="color: red">${requestScope.ERROR_CREATE.duplicate}</font><br>
            password: <input type="password" name="password" value="" required=""/>
                <font style="color: red">${requestScope.ERROR_CREATE.password}</font><br>
            confirm: <input type="password" name="conform" value="" required=""/>
                <font style="color: red">${requestScope.ERROR_CREATE.confirm}</font><br>
            fullName: <input type="text" name="fullName" value="${param.fullName}" required=""/>
                <font style="color: red">${requestScope.ERROR_CREATE.fullName}</font><br>
            email: <input type="text" name="email" value="${param.email}" required=""/>
                <font style="color: red">${requestScope.ERROR_CREATE.email}</font>
                <font style="color: red">${requestScope.ERROR_CREATE.emailExist}</font><br>
            phone: <input type="text" name="phone" value="${param.phone}" required=""/>
                <font style="color: red">${requestScope.ERROR_CREATE.phone}</font><br>
            location: <input type="text" name="location" value="${param.location}" required=""/>
                <font style="color: red">${requestScope.ERROR_CREATE.location}</font><br>
            balance: <input type="number" name="balance" value="0" required="" min="0" readonly=""/><br>
            
            
            overview: <input type="text" name="overview" value="${param.overview}" required=""/><br>
            titileBio: <input type="text" name="titileBio" value="${param.titileBio}" required=""/>
                <font style="color: red">${requestScope.ERROR_CREATE.titileBio}</font><br>
            moneyPerHour: <input type="number" name="moneyPerHour" value="${param.moneyPerHour}" required="" min="0"/><br>
            education: <input type="text" name="education" value="${param.education}" required=""/>
                <font style="color: red">${requestScope.ERROR_CREATE.education}</font><br>
            <input type="submit" value="Create Seeker" name="action" />
        </form>
    </body>
</html>
