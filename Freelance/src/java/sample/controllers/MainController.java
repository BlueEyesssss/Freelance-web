/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LENOVO
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.html";
    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String SEARCH_JOB_BY_NAME = "SearchJobByNameController";
    private static final String VIEW_ALL_PROJECT = "ViewAllProject";
    private static final String VIEW_ALL_PROJECT_CONTROLLER = "ViewAllProjectController";
    private static final String VIEW_FAVORITE_PROJECT = "ViewFavoriteProject";
    private static final String VIEW_FAVORITE_PROJECT_CONTROLLER = "ViewFavoriteProjectController";
    private static final String CREATE_ACC_HIRER = "Create Hirer";
    private static final String CREATE_ACC_HIRER_CONTROLLER = "CreateHirerController";
    private static final String CREATE_ACC_SEEKER= "Create Seeker";
    private static final String CREATE_ACC_SEEKER_CONTROLLER = "CreateSeekerController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if (LOGIN.equals(action)) {
                url = LOGIN_CONTROLLER;
                
            } else if ("Search Job By Name".equals(action)) {
                url = SEARCH_JOB_BY_NAME;
                
            } else if (VIEW_ALL_PROJECT.equals(action)) {
                url = VIEW_ALL_PROJECT_CONTROLLER;
                
            } else if (VIEW_FAVORITE_PROJECT.equals(action)) {
                url = VIEW_FAVORITE_PROJECT_CONTROLLER;
                
            } else if (CREATE_ACC_HIRER.equals(action)) {
                url = CREATE_ACC_HIRER_CONTROLLER;
                
            } else if (CREATE_ACC_SEEKER.equals(action)) {
                url = CREATE_ACC_SEEKER_CONTROLLER;
                
            }  else {
                HttpSession session = request.getSession();
                session.setAttribute("ERROR_MESSAGE", "function is not avaiable!");
            }
        } catch (Exception e) {
            log("Error at MainController:" + e.toString());
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
