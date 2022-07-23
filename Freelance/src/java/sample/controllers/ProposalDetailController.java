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
import sample.project.ProjectDAO;
import sample.project.ProjectDTO;
import sample.proposal.ProposalDAO;
import sample.proposal.ProposalDTO;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "ProposalDetailController", urlPatterns = {"/ProposalDetailController"})
public class ProposalDetailController extends HttpServlet {

    private static final String ERROR = "proposalDetail.jsp";
    private static final String SUCCESS = "proposalDetail.jsp";
//    private static final String SUCCESS1 = "proposalDetailInterview.jsp";
    private static final String SUCCESS1 = "invitedProjectDetail.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            String proposalID = request.getParameter("proposalID");
            String projectID = request.getParameter("projectID");
            String ac = request.getParameter("ac");
            ProjectDAO dao = new ProjectDAO();
            //lấy project
            ProjectDTO project = dao.getProjectByID(Integer.parseInt(projectID));
            //lấy skill project need
            List<String> listSkill = dao.getSkillNeedOfProject(Integer.parseInt(projectID));
            //lấy payment-amout và duration text của proposal
            ProposalDTO proposal = dao.getProposalPaymentAndDuration(Integer.parseInt(proposalID));

            session.setAttribute("PROJECT_DETAIL", project);
            session.setAttribute("SKILL_PROJECT_NEED", listSkill);
            session.setAttribute("PROPOSAL_PAYMENT_DURATION", proposal);

            //lehuu them moi 
            int proposalID1 = Integer.parseInt(request.getParameter("proposalID"));
            ProposalDAO proposalDao = new ProposalDAO();
            ProposalDTO proposal1 = proposalDao.getProposalByID(proposalID1);
            if (proposal1 != null) {
                request.setAttribute("PROPOSAL", proposal1);
            }
            
            
            if (ac.equals("interview")) {
                url = SUCCESS1;
            } else {
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
