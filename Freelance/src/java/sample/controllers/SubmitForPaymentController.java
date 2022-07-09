/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import sample.proposal.ProposalDAO;
import sample.util.DBUtil;


/**
 *
 * @author Phat
 */
@WebServlet(name = "SubmitForPaymentController", urlPatterns = {"/SubmitForPaymentController"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 1000,
        maxRequestSize = 1024 * 1024 * 1000)
public class SubmitForPaymentController extends HttpServlet {

    PrintWriter out = null;
    Connection con = null;
    PreparedStatement ps = null;
    HttpSession session = null;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "error.html";
    private static final String SUCCESS = "ViewSeekerDashboardController";
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        try {
            out = response.getWriter();
            session = request.getSession(false);
            String folderName = "resources";
            String uploadPath = request.getServletContext().getRealPath("") + File.separator + folderName;
            File dir = new File(uploadPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            int proposalID = Integer.parseInt(request.getParameter("proposalID")); 
            Part filePart = request.getPart("file");
            String link = request.getParameter("link");
            String message = request.getParameter("message");
            String fileName = filePart.getSubmittedFileName();
            String path = folderName + File.separator + fileName;
            System.out.println("fileName: " + fileName);
            System.out.println("Path: " + uploadPath);
            InputStream is = filePart.getInputStream();
            Files.copy(is, Paths.get(uploadPath + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);
            try {
                con = DBUtil.getConnection();
                System.out.println("connection done");
                String sql = "UPDATE [Proposal] SET link = ?, message = ?, fileName = ?, path = ? WHERE proposalID = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, link);
                ps.setString(2, message);
                ps.setString(3, fileName);
                ps.setString(4, path);
                //cho nay dang co loi, vi chua lay duoc proposalID
                ps.setInt(5, proposalID);
                int status = ps.executeUpdate();
                
                if (status > 0) {
                    session.setAttribute("fileName", fileName);
                    String msg = "" + fileName + " File uploaded successfully...";
                    request.setAttribute("msg", msg);
                    ProposalDAO proposalDAO = new ProposalDAO();
                    proposalDAO.changeStatusProposal(proposalID, 5);
                    RequestDispatcher rd = request.getRequestDispatcher(SUCCESS);
                    rd.forward(request, response);
                    System.out.println("File uploaded successfully...");
                    System.out.println("Uploaded Path: " + uploadPath);
                }
            } catch (SQLException e) {
                out.println("Exception: " + e);
                System.out.println("Exception1: " + e);
                //phan no tu them vao
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SubmitForPaymentController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    out.println(e);
                }
            }
        } catch (IOException | ServletException e) {
            out.println("Exception: " + e);
            System.out.println("Exception2: " + e);
        }
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
