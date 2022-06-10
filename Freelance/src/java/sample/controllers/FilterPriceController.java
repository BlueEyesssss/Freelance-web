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

/**
 *
 * @author Admin
 */
@WebServlet(name = "FilterPriceController", urlPatterns = {"/FilterPriceController"})
public class FilterPriceController extends HttpServlet {

    private static final String ERROR = "filterPage.jsp";
    private static final String SUCCESS = "filterPage.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            int price1 = 0;
            int price2 = 0;
            String price = request.getParameter("price");
            switch(price){
                case "lessThan100":
                    price1 = 0;
                    price2 = 100;
                    break;
                case "100To500":
                    price1 = 100;
                    price2 = 500;
                    break;
                case "500To1k":
                    price1 = 500;
                    price2 = 1000;
                    break;
                case "1kTo5k":
                    price1 = 1000;
                    price2 = 5000;
                    break;
                case "largerThan5k":
                    price1 = 5000;
                    price2 = 99999999;
                    break;
            }
            
            ProjectDAO dao = new ProjectDAO();
            HttpSession session = request.getSession();
            List<ProjectDTO> listBeforeFilter = (List<ProjectDTO>) session.getAttribute("LIST_PROJECT");
            List<ProjectDTO> list = dao.getListProjectBaseOnPrice(listBeforeFilter,price1, price2);
            if(!list.isEmpty()) {
                session.setAttribute("LIST_PROJECT", list);
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at SearchController: " + e.toString());
        }finally {
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
