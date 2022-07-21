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
import sample.project.ProjectDAO;
import sample.project.ProjectDTO;
import sample.proposal.ProposalDAO;
import sample.skill.SkillDAO;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "DeleteProjectOfAdminController", urlPatterns = {"/DeleteProjectOfAdminController"})
public class DeleteProjectOfAdminController extends HttpServlet {
    private static final String ERROR = "projectPostedAdminPage.jsp";
    private static final String SUCCESS = "projectPostedAdminPage.jsp";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            int projectID = Integer.parseInt(request.getParameter("projectID"));
            HttpSession session = request.getSession(false);
            
            ProjectDAO daoProject = new ProjectDAO();
            daoProject.deleteFavoriteProject(projectID);
            
            ProposalDAO daoProposal = new ProposalDAO();
            daoProposal.deleteProposalByProjectID(projectID);
            
            SkillDAO daoSkill = new SkillDAO();
            boolean checkForDeleteNeededSkill = daoSkill.deleteNeededSkillOfProject(projectID);
            boolean checkForDeleteProject = daoProject.deleteProject(projectID);
            

            if (checkForDeleteNeededSkill == true && checkForDeleteProject == true) {
                //lấy list các project đã post lên
                ProjectDAO projectDAO = new ProjectDAO();
                List<ProjectDTO> listProject = projectDAO.getListProjectByName(" ");
                session.setAttribute("LIST_PROJECT_POSTED", listProject);
                
                url = SUCCESS;
            }

        } catch (Exception e) {
            log("Error at ProposalDetailController: " + e.toString());
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
