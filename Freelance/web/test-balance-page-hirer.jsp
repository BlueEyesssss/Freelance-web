<%-- 
    Document   : test-balance-page-hirer
    Created on : Jul 5, 2022, 10:53:29 PM
    Author     : LENOVO
--%>

<%@page import="sample.hirer.HirerDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blance hirer Page</title>
    </head>
    <body>
        <%
            HirerDTO hirer = (HirerDTO)session.getAttribute("USER_LOGIN");
        %>
        <h1>Hello <%= hirer.getFullName() %></h1>
        <form action="MainController">
            your balance: <input type="text" name="balance" value="" />
        </form>
        <p>Your balance: <%=  %></p>
    </body>
</html>
