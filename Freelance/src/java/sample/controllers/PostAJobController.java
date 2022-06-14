/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.project.ProjectDAO;
import sample.project.ProjectDTO;
import sample.user.UserDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "PostAJobController", urlPatterns = {"/PostAJobController"})
public class PostAJobController extends HttpServlet {

    private static final String ERROR = "error.html";
    private static final String SUCCESS = "hirerDashboard.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            UserDTO user = (UserDTO) session.getAttribute("USER_LOGIN");

            String projectName = request.getParameter("projectName");
            String description = request.getParameter("description");
            String complexity = request.getParameter("complexity");
            int hireID = user.getUserID();
            double budget = Double.parseDouble(request.getParameter("budget"));
            int durationID = Integer.parseInt(request.getParameter("durationID"));
            String deadline = request.getParameter("deadline");
            String location = request.getParameter("location");
            String createdDate = java.time.LocalDate.now() + "";
            int hourPerWeek = 0;
            String major = request.getParameter("major");

            String[] skillID = request.getParameterValues("skillID");

            ProjectDTO project = new ProjectDTO(projectName, description, complexity, hireID, budget, durationID + "", deadline, location, createdDate, hourPerWeek, major);

            ProjectDAO dao = new ProjectDAO();
            boolean checkCreateProject = dao.postAJob(project);
            if (checkCreateProject) {
                int projectID = dao.getProject(project);
                //check id
                if (projectID != -1) {
                    boolean checkCreateSkill = false;
                    for (String string : skillID) {
                        if (dao.createSkillProjectNeed(projectID, Integer.parseInt(string))) {
                            
                        } else {
                            checkCreateSkill = true;
                        }
                    }
                    if (checkCreateSkill) {
                        request.setAttribute("CREATE SKILL FOR PROJECT", "soomething wrong when create skill for project");
                        
                    }
                    url = SUCCESS;
                } else {
                    request.setAttribute("CREATE SKILL FOR PROJECT", "soomething wrong when get id project");
                }

            }
        } catch (Exception e) {
            System.out.println(e.toString());
            log("Error at PostAJobController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
