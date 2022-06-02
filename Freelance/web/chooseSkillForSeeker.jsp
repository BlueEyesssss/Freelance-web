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
            List<SkillDTO> listSkill = (List<SkillDTO>)request.getAttribute("LIST_SKILL");
            UserDTO user = (UserDTO)request.getAttribute("CREATE_USER_SEEKER");
            SeekerDTO seeker = (SeekerDTO)request.getAttribute("CREATE_USER_SEEKER1");
        %>
        <form action="MainController">
            <%
                for (SkillDTO skill : listSkill) {
                        %>
                        <input type="checkbox" name="skillName" value="<%= skill.getSkillID()%>" /> <%= skill.getSkillName()%> <br>
            <%
                    }
            %>
            <input type="submit" value="Create Seeker" name="action" />
        </form>
    </body>
</html>
