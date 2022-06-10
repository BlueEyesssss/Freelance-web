/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.project.ProjectDAO;
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
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String proposalID = request.getParameter("proposalID");
            ProposalDAO dao = new ProposalDAO();
            ProposalDTO proposal = dao.getProposal(Integer.parseInt(proposalID));
            if(proposal != null){
                ProjectDAO daoProject = new ProjectDAO();
                int hirerID = daoProject.getHirerIdFromProjectId(proposal.getProjectID());
                proposal.setHirerID(hirerID);
        
                
                request.setAttribute("PROPOSAL_DETAIL", proposal);
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
