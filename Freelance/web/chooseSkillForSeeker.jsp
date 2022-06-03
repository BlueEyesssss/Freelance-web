<%-- 
    Document   : chooseSkillForSeeker
    Created on : Jun 2, 2022, 10:02:27 AM
    Author     : LENOVO
--%>

<%@page import="sample.seeker.SeekerDTO"%>
<%@page import="sample.user.UserDTO"%>
<%@page import="sample.skill.SkillDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choose Skill Page</title>
    </head>
    <body>
        <h1>Hello Seeker!</h1>
        <%
            List<SkillDTO> listSkill = (List<SkillDTO>)session.getAttribute("LIST_SKILL");
        %>
        <form action="MainController">
            <%
                for (SkillDTO skill : listSkill) {
                        %>
                        <input type="checkbox" name="skillID" value="<%= skill.getSkillID()%>" /> <%= skill.getSkillName()%> <br>
            <%
                    }
            %>
            <input type="submit" value="Create Seeker" name="action" />
        </form>
            ${requestScope.chooseSkillForSeeker}
    </body>
</html>
