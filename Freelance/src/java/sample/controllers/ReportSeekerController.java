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
import sample.project.ProjectDAO;
import sample.project.ProjectDTO;
import sample.proposal.ProposalDAO;
import sample.proposal.ProposalDTO;
import sample.sendemail.SendEmailForHirer;
import sample.user.UserDAO;
import sample.user.UserDTO;

/**
 *
 * @author Phat
 */
@WebServlet(name = "ReportSeekerController", urlPatterns = {"/ReportSeekerController"})
public class ReportSeekerController extends HttpServlet {

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
    private static final String SUCCESS = "ViewHirerDashboardController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            int proposalID = Integer.parseInt(request.getParameter("proposalID"));
            ProposalDAO proposalDAO = new ProposalDAO();
            boolean check = proposalDAO.changeStatusProposal(proposalID, 8);
            if (check) {
                url = SUCCESS;
                
                //send email
                SendEmailForHirer email = new SendEmailForHirer();
                
                //send cho admin
                ProposalDTO proposal = proposalDAO.getProposalByID(proposalID);
                //email admin
                //project name
                ProjectDAO projectdao = new ProjectDAO();
                ProjectDTO project = projectdao.getProjectByID(proposal.getProjectID());
                //hirer name
                UserDAO userdao = new UserDAO();
                UserDTO hirer = userdao.getUserByID(project.getHirerID());
                //value text
                String text = "Hirer \""+hirer.getFullName()+"\" reported the results of project \""+project.getProjectName()+"\".\n"
                        + "Please check to see who is right and who is wrong.";
                boolean checkSend = email.sendEmailAction(email.emailOfAdmin(), "Reported", text);
                
                //send cho seeker
                //email seeker
                UserDTO seeker = userdao.getUserByID(proposal.getSeekerID());
                //value text
                String textSeeker = "Hirer \""+hirer.getFullName()+"\" reported your submited of project \""+project.getProjectName()+"\".\n"
                        + "Wait for the admin to make a decision.";
                boolean checkSendSeeker = email.sendEmailAction(seeker.getEmail(), "Hirer reported", textSeeker);
            }

            

        } catch (Exception e) {
            log("Error at ReportSeekerController: " + e.toString());
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
