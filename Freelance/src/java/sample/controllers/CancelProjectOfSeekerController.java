/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
import sample.seeker.SeekerDTO;
import sample.sendemail.SendEmailForHirer;
import sample.user.UserDAO;
import sample.user.UserDTO;

/**
 *
 * @author Phat
 */
@WebServlet(name = "CancelProjectOfSeekerController", urlPatterns = {"/CancelProjectOfSeekerController"})
public class CancelProjectOfSeekerController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "error.html";
    private static final String SUCCESS = "ViewMyJobController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
           
            int proposalID = Integer.parseInt(request.getParameter("proposalID"));
            ProposalDAO proposalDAO = new ProposalDAO();
            ProjectDAO projectDAO = new ProjectDAO();
            UserDAO userDAO = new UserDAO();
            
            //doi trang thai proposal sang finished unsuccessfully
            proposalDAO.changeStatusProposal(proposalID, 7);
            //lay proposalID (muc tieu de lay hirerID)
            ProposalDTO proposal = proposalDAO.getProposalByID(proposalID);
            //lay hirerID
            int hirerID = projectDAO.getHirerIdFromProjectId(proposal.getProjectID());
            //chuyen tien
            boolean check = userDAO.addMoneyToUserByUserID(proposal.getPaymentAmount(), hirerID);
            if (check) {
                url = SUCCESS;
                //send email
                //email hirer
                UserDTO hirer = userDAO.getUserByID(hirerID);
                //name seeker
                HttpSession session = request.getSession();
                SeekerDTO seeker = (SeekerDTO) session.getAttribute("USER_LOGIN");
                //project name
                ProjectDTO project = projectDAO.getProjectByID(proposal.getProjectID());
                
                SendEmailForHirer email = new SendEmailForHirer();
                boolean checkSend = email.sendEmailNotiFySeekerCancelActiveProjectForHirer(hirer.getEmail(), seeker.getFullName(), project.getProjectName());
            
            }
            
            
            
        } catch (Exception e) {
            log("Error at CancelProJectFromSeekerController: " + e.toString());
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
