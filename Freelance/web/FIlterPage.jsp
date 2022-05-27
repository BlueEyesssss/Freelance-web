<%-- 
    Document   : FIlterPage
    Created on : May 23, 2022, 3:49:45 PM
    Author     : Admin
--%>

<%@page import="java.util.List"%>
<%@page import="sample.project.ProjectDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String search = (String) request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        <form action="MainController">
            Search Job<input type="text" name="search" value="<%= search%>" placeholder="input job name"/>
            <input type="submit" name="action" value="Search Job By Name"/>
        </form>
            <a href="MainController?action=FilterHirer&hirer=KMS">hirer-KMS</a>
            <a href="MainController?action=FilterPrice&price1=300&price2=500">price 300-500</a>
            <a href="MainController?action=FilterLevel&level=Entry">level-Entry</a>
        <%            List<ProjectDTO> listProject = (List<ProjectDTO>) session.getAttribute("LIST_PROJECT");
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
                    <th>Company Name</th>
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
                    <td><%= count++%></td>
                    <td><%= project.getProjectID()%></td>
                    <td><%= project.getProjectName()%></td>
                    <td><%= project.getDescription()%></td>
                    <td><%= project.getComplexity()%></td>
                    <td><%= project.getHirer()%></td>
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
