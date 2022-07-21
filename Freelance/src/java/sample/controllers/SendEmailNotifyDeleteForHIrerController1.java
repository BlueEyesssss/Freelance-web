/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sample.hirer.HirerDTO;
import sample.project.ProjectDTO;
import sample.seeker.SeekerDTO;
import sample.sendemail.SendEmailForHirer;
import sample.skill.SkillDTO;
import sample.user.UserDAO;
import sample.user.UserDTO;

@WebServlet(name = "SendEmailNotifyDeleteForHIrerController1", urlPatterns = {"/SendEmailNotifyDeleteForHIrerController1"})
public class SendEmailNotifyDeleteForHIrerController1 extends HttpServlet {
    private static final String SUCCESS = "projectPostedAdminPage.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();

            //create instance object of the SendEmail Class
            SendEmailForHirer sm = new SendEmailForHirer();

            //get project deleted
            ProjectDTO projectdeleted = (ProjectDTO) session.getAttribute("PROJECT_DELETED");

            //lấy hirer cần gửi mail về
            UserDAO userDAO = new UserDAO();
            UserDTO user = userDAO.getUserByID(projectdeleted.getHirerID());
            
            //call the send email method
            boolean test = sm.sendEmailForHirerAboutDeteleProject(user, projectdeleted);

            //check if the email send successfully
            if (test) {
                request.getRequestDispatcher(SUCCESS).forward(request, response);
            } else {
                request.getRequestDispatcher(SUCCESS).forward(request, response);
            }
        }catch(Exception ex){
            log("error at SendEmailNotifyDeleteForHIrerController1: " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
