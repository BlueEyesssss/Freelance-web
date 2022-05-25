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
import sample.seeker.SeekerDTO;
import sample.user.UserDAO;
import sample.user.UserDTO;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "CreateSeekerController", urlPatterns = {"/CreateSeekerController"})
public class CreateSeekerController extends HttpServlet {
    private static final String ERROR = "createAccForSeeker.jsp";
    private static final String SUCCESS = "login.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String conform = request.getParameter("conform");
            String fullName = request.getParameter("fullName");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String location = request.getParameter("location");
            float balance = Float.parseFloat(request.getParameter("balance"));
            String registrationDate = java.time.LocalDate.now() + "";
            
            String overview = request.getParameter("overview");
            String titileBio = request.getParameter("titileBio");
            int moneyPerHour = Integer.parseInt(request.getParameter("moneyPerHour"));
            String education = request.getParameter("education");
            if(conform.equals(password)){
                //tạo user
                UserDTO user = new UserDTO(password, userName, fullName, email, phone, location, registrationDate, balance);

                UserDAO dao = new UserDAO();

                boolean checkCreateAcc = dao.createUser(user);
                if(checkCreateAcc){
                    //tạo seeker
                    int seekerID = dao.getUser(userName, password).getUserID();
                    SeekerDTO seeker = new SeekerDTO(seekerID, overview, titileBio, moneyPerHour, education);

                    boolean checkCreateHirer = dao.createSeeker(seeker);
                    if(checkCreateHirer){
                        url = SUCCESS;
                    }
                }
            }else{
                request.setAttribute("CONFIRM_ERROR", "conform not match, please enter again!!");
            }
            
        } catch (Exception e) {
            log("error at CreateHirerController: " + e.getMessage());
        }finally{
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
