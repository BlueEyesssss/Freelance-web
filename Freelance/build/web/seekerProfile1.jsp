<%-- 
    Document   : seekerProfile
    Created on : May 31, 2022, 3:57:47 PM
    Author     : LENOVO
--%>

<%@page import="sample.seeker.SeekerDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seeker profile Page</title>
    </head>
    <body>
        <%
            SeekerDTO seeker = (SeekerDTO)session.getAttribute("USER_LOGIN");
        %>
        <h1>Profile Detail</h1>
        <form action="MainController">
            <input type="hidden" name="userID" value="${sessionScope.USER_LOGIN.userID}" />
            <input type="hidden" name="seekerID" value="${sessionScope.USER_LOGIN.seekerID}" />
            username: <input type="text" name="userName" value="${sessionScope.USER_LOGIN.userName}" readonly=""/>
                <font style="color: red">${requestScope.ERROR_UPDATE.userName}</font><br>
            password <input type="text" name="password" value="${sessionScope.USER_LOGIN.password}" required=""/>
                <font style="color: red">${requestScope.ERROR_UPDATE.password}</font><br>
            fullName <input type="text" name="fullName" value="${sessionScope.USER_LOGIN.fullName}" required=""/>
                <font style="color: red">${requestScope.ERROR_UPDATE.fullName}</font><br>
            email <input type="text" name="email" value="${sessionScope.USER_LOGIN.email}" required=""/>
                <font style="color: red">${requestScope.ERROR_UPDATE.email}</font>
                <font style="color: red">${requestScope.ERROR_UPDATE.emailExist}</font><br>
            phone <input type="text" name="phone" value="${sessionScope.USER_LOGIN.phone}" required=""/>
                <font style="color: red">${requestScope.ERROR_UPDATE.phone}</font><br>
            location <input type="text" name="location" value="${sessionScope.USER_LOGIN.location}" required=""/>
                <font style="color: red">${requestScope.ERROR_UPDATE.location}</font><br>
            registrationDate <input type="text" name="registrationDate" value="${sessionScope.USER_LOGIN.registrationDate}" readonly=""/><br>
            balance <input type="text" name="balance" value="${sessionScope.USER_LOGIN.balance}" readonly=""/><br>
            avatar <input type="text" name="avatar" value="${sessionScope.USER_LOGIN.avatar}" />
                <font style="color: red">${requestScope.ERROR_UPDATE.avatar}</font><br>
            overview <input type="text" name="overview" value="${sessionScope.USER_LOGIN.overview}" required=""/>
                <font style="color: red">${requestScope.ERROR_UPDATE.titileBio}</font><br>
            titileBio <input type="text" name="titileBio" value="${sessionScope.USER_LOGIN.titileBio}" required=""/>
                <font style="color: red">${requestScope.ERROR_UPDATE.titileBio}</font><br>
            moneyPerHour <input type="number" name="moneyPerHour" value="${sessionScope.USER_LOGIN.moneyPerHour}" required="" min="0"/><br>
            education <input type="text" name="education" value="${sessionScope.USER_LOGIN.education}" required=""/>
                <font style="color: red">${requestScope.ERROR_UPDATE.education}</font><br>
            degree <select name="degree">
                        <option value="None" >None</option>
                        <option value="college degree" 
                                <%
                                    if(seeker.getDegree().equals("college degree")){
                                        %>
                                        selected
                                <%
                                    }
                                %>
                                >college degree</option>
                        <option value="university degree" 
                                <%
                                    if(seeker.getDegree().equals("university degree")){
                                        %>
                                        selected
                                <%
                                    }
                                %>
                                >university degree</option>
                        <option value="Master's degree"
                                <%
                                    if(seeker.getDegree().equals("Master's degree")){
                                        %>
                                        selected
                                <%
                                    }
                                %>
                                >Master's degree</option>
                      </select><br>
            major <input type="text" name="major" value="${sessionScope.USER_LOGIN.major}"/>
                <font style="color: red">${requestScope.ERROR_UPDATE.major}</font><br>
            <input type="submit" value="Update Profile" name="action" />
        </form>
            ${requestScope.UPDATE_STATUS}
    </body>
</html>
