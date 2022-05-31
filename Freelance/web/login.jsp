<%-- 
    Document   : login
    Created on : May 23, 2022, 4:13:35 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            username: <input type="text" name="userName" value="" /><br>
            password: <input type="password" name="password" value="" /><br>
            <input type="submit" value="Login" name="action" />
            <input type="reset" value="Reset" />
        </form>
        <font style="color: red">${requestScope.LOGIN_ERROR}</font><br>
        <a href="createAcc.jsp">Sign up</a>
        <a href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:8080/Freelance/LoginGoogleController&response_type=code
		   &client_id=540837116728-5a0vpu4mt0ll88qmcb76m7l9ulltkbqu.apps.googleusercontent.com&approval_prompt=force">Login with google</a>
    </body>
</html>
