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
import sample.project.ProjectDTO;
import sample.proposal.ProposalDAO;
import sample.sendemail.SendEmailForHirer;
import sample.user.UserDAO;
import sample.user.UserDTO;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "CancelProJectFromHirerController", urlPatterns = {"/CancelProJectFromHirerController"})
public class CancelProJectFromHirerController extends HttpServlet {
    private static final String ERROR = "error.html";
    private static final String SUCCESS = "ViewContractOfHirerController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String projectID = request.getParameter("projectID");
            
            ProposalDAO dao = new ProposalDAO();
            //chuyển trang thaio1 sang job finish unsucessfully
            if(dao.cancelProject(projectID, 6)){
                //lấy seeker id từ proposal
                int seekerID = dao.getSeekerIDOfCancelProject(projectID);
                //lấy amountMoney của proposal cancel
                int amountMoney = dao.getAmountMoneyOfCancelProject(projectID);
                //chuyển tiền porject đó cho seeker
                if(dao.transferMoneyCancelProjectToSeeker(seekerID, amountMoney)){
                    url = SUCCESS;
                    
                    //send email
                    //tên project
                    ProjectDAO projectDAO = new ProjectDAO();
                    ProjectDTO project = projectDAO.getProjectByID(Integer.parseInt(projectID));
                    //tên hirer
                    UserDAO userDAO = new UserDAO();
                    UserDTO hirer = userDAO.getUserByID(project.getHirerID());
                    //email seeker
                    UserDAO userDAo = new UserDAO();
                    UserDTO seeker  = userDAo.getUserByID(seekerID);
                    
                    SendEmailForHirer email = new SendEmailForHirer();
                    boolean checkSend = email.sendEmailNotifyHirerCancelProject(seeker.getEmail(), hirer.getFullName(), project.getProjectName());
                
                }
            }
            
        } catch (Exception e) {
            log("Error at CancelProJectFromHirerController: " + e.toString());
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
