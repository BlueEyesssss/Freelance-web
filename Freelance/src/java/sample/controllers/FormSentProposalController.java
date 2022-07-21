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
    private static final String ERROR_NOT_HAVE_BALANCE_KEY = "ViewSeekerProfileController";
    private static final String SUCCESS = "submitProposal.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            SeekerDTO seekerLogin = (SeekerDTO) session.getAttribute("USER_LOGIN");

            //check xem balance key của seeker có chưa
            //  1.lấy seeker
            SeekerDTO seeker = (SeekerDTO) session.getAttribute("USER_LOGIN");
            //  2.check balance key
            PaymentDAO paymentDAO = new PaymentDAO();
            String client_id = paymentDAO.getClientID(seeker.getUserID());
            String client_secret = paymentDAO.getClientSecret(seeker.getUserID());
            if (client_id == null || client_secret == null) {
                request.setAttribute("UNKNOWN_BALANCE_KEY", "please update your PayPal key (id, secret) and then you can do this previous action");
                //request.getRequestDispatcher("ViewSeekerProfileController").forward(request, response);
                url = ERROR_NOT_HAVE_BALANCE_KEY;
            } else {
                int projectID = Integer.parseInt(request.getParameter("projectID"));
                ProjectDAO dao = new ProjectDAO();
                ProjectDTO projectCurrent = dao.getProjectCurrent(projectID);
                List<String> skillneed = dao.getSkillNeedOfProject(projectCurrent.getProjectID());
                List<String> skillsOfSeeker = seekerLogin.getListSkill();
                boolean checkMatchSkill = false;//rang buoc seeker phai co it nhat 1 skill trung voi skillNeed cua project
                for (String skillNeedOfProject : skillneed) {
                    for (String skillOfSeeker : skillsOfSeeker) {
                        if (skillNeedOfProject.equalsIgnoreCase(skillOfSeeker)) {
                            checkMatchSkill = true;
                            break;
                        }
                    }
                }

                if (projectCurrent != null && checkMatchSkill) {
                    request.setAttribute("SKILL_PROJECT_NEED", skillneed);
                    request.setAttribute("PROJECT_CURRENT", projectCurrent);
                    url = SUCCESS;
                }
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
