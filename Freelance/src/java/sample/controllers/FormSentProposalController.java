/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import sample.payment.PaymentDAO;
import sample.project.ProjectDAO;
import sample.project.ProjectDTO;
import sample.proposal.ProposalDAO;
import sample.seeker.SeekerDTO;
import sample.user.UserDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "FormSentProposalController", urlPatterns = {"/FormSentProposalController"})
public class FormSentProposalController extends HttpServlet {

    private static final String ERROR = "ViewSeekerDashboardController";
    
    private static final String SUCCESS = "submitProposal.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            SeekerDTO seekerLogin = (SeekerDTO) session.getAttribute("USER_LOGIN");

            int projectID = Integer.parseInt(request.getParameter("projectID"));
            ProjectDAO dao = new ProjectDAO();
            ProjectDTO projectCurrent = dao.getProjectCurrent(projectID);
            List<String> skillneed = dao.getSkillNeedOfProject(projectCurrent.getProjectID());
            List<String> skillsOfSeeker = seekerLogin.getListSkill();
            
            
            ProposalDAO proposalDao = new ProposalDAO();
            proposalDao.deleteProposalInvitedByProjectID(seekerLogin.getSeekerID(),projectID,2);
            
            boolean checkMatchSkill = false;//rang buoc seeker phai co it nhat 1 skill trung voi skillNeed cua project
            for (String skillNeedOfProject : skillneed) {
                for (String skillOfSeeker : skillsOfSeeker) {
                    if (skillNeedOfProject.equalsIgnoreCase(skillOfSeeker)) {
                        checkMatchSkill = true;
                        break;
                    }
                }
            }

            if (projectCurrent != null) {
                request.setAttribute("SKILL_PROJECT_NEED", skillneed);
                request.setAttribute("PROJECT_CURRENT", projectCurrent);
                if (checkMatchSkill) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR_MESSAGE_1", "Please choose the suitable job for you!");
                }
            } else {
                request.setAttribute("ERROR_MESSAGE_2", "Job isn't exist anymore!");
            }

        } catch (Exception e) {
            log("Error at FormSentProposalController: " + e.toString());
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
