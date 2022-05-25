<%-- 
    Document   : SeekerDashboard
    Created on : May 24, 2022, 1:06:13 PM
    Author     : Admin
--%>

<%@page import="sample.seeker.SeekerDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.project.ProjectDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seeker Dashboard</title>
    </head>
    <body>
        <h1></h1>
        <a href="MainController?action=ViewAllProject">show all list</a>
        <a href="MainController?action=ViewFavoriteProject">show favorite list</a>
        
        
        
<!--        <form action="MainController">
            Search<input type="text" name="search" value="" required=""/>
            <input type="submit" name="action" value="Search"/>
        </form>-->
        <%
            SeekerDTO seeker = (SeekerDTO) session.getAttribute("USER_LOGIN"); //CHUA HIEU
            
        %>
        
        <%
            List<ProjectDTO> listProject = (List<ProjectDTO>) request.getAttribute("LIST_PROJECT");
            if (listProject != null) {
                if (listProject.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    
                    <th>NO</th>
                    <th>Project ID</th>
                    <th>Project Name</th>
                    <th>Description</th>
                    <th>Complexity</th>
                    <th>Payment Amount</th>
                    <th>Expected Duration</th>
                    <th>Deadline Date</th>
                    
                    
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (ProjectDTO project : listProject) {
                %>
                <tr>
                    <td><%= count++ %></td>
                    <td><%= project.getProjectID() %></td>
                    <td><%= project.getProjectName()%></td>
                    <td><%= project.getDescription()%></td>
                    <td><%= project.getComplexity()%></td>
                    <td><%= project.getPaymentAmount()%></td>
                    <td><%= project.getExpectedDurationID()%></td>
                    <td><%= project.getDeadlineDate()%></td>
                   
                    
                    
                    
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <%
                }
            }
        %>
    </body>
</html>
