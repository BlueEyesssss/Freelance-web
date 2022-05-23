<%-- 
    Document   : SeekerPage
    Created on : May 23, 2022, 3:49:09 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seeker Page</title>
    </head>
    <body>
        <%           
            String search = (String) request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        <p>Hello ${sessionScope.USER_LOGIN.fullName}</p>
        <form action="MainController">
            Search Job<input type="text" name="search" value="<%= search%>" placeholder="input job name"/>
            <input type="submit" name="action" value="Search Job By Name"/>
        </form>
    </body>
</html>
