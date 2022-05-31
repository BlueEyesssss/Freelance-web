/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import sample.google.Constants;
import sample.hirer.HirerDTO;
import sample.project.ProjectDAO;
import sample.project.ProjectDTO;
import sample.seeker.SeekerDTO;
import sample.user.UserDAO;
import sample.user.UserDTO;
import sample.user.UserGoogleDTO;

/**
 *
 * @author Phat
 */
@WebServlet(name = "LoginGoogleController", urlPatterns = {"/LoginGoogleController"})
public class LoginGoogleController extends HttpServlet {

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
    private static final String SEEKER_PAGE = "ViewSeekerDashboardController";
    private static final String HIRER_PAGE = "";
//    private static final String SUCCESS = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String code = request.getParameter("code");
        String accessToken = getToken(code);
        UserGoogleDTO userGoogle = getUserInfo(accessToken);
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            UserDAO dao = new UserDAO();
            boolean check = dao.checkDuplicateEmail(userGoogle.getEmail());

            if (check) {
                UserDTO user = dao.getUser(userGoogle.getEmail());

         

                SeekerDTO seeker = new SeekerDTO();
                HirerDTO hirer = new HirerDTO();

                if (user != null) {

                    //check xem nó có phải seeker hay ko
                    //1.lấy seeker ra
                    seeker = dao.checkAccSeeker(user.getUserID());
                    //2.check null
                    if (seeker != null) {
                        seeker.setUserID(user.getUserID());
                        seeker.setPassword(user.getPassword());
                        seeker.setUserName(user.getUserName());
                        seeker.setFullName(user.getFullName());
                        seeker.setEmail(user.getEmail());
                        seeker.setPhone(user.getPhone());
                        seeker.setLocation(user.getLocation());
                        seeker.setRegistrationDate(user.getRegistrationDate());
                        seeker.setBalance(user.getBalance());
                        session.setAttribute("USER_LOGIN", seeker);
                        url = SEEKER_PAGE;
                    } else { //tương tự vs Hirer
                        //1.lấy hirer
                        hirer = dao.checkAccHirer(user.getUserID());
                        //2.check hirer
                        if (hirer != null) {
                            hirer.setUserID(user.getUserID());
                            hirer.setPassword(user.getPassword());
                            hirer.setUserName(user.getUserName());
                            hirer.setFullName(user.getFullName());
                            hirer.setEmail(user.getEmail());
                            hirer.setPhone(user.getPhone());
                            hirer.setLocation(user.getLocation());
                            hirer.setRegistrationDate(user.getRegistrationDate());
                            hirer.setBalance(user.getBalance());
                            session.setAttribute("USER_LOGIN", hirer);
                            url = HIRER_PAGE;
                        }
                    }
                }

            } else {
                url = "createAccForGoogleUser.jsp";
                session.setAttribute("USER_GOOGLE", userGoogle);

            }

        } catch (Exception e) {
            log("Error at loginGoogleController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }

    public static String getToken(String code) throws ClientProtocolException, IOException {
        // call api to get token
        String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
                        .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    public static UserGoogleDTO getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();

        UserGoogleDTO googlePojo = new Gson().fromJson(response, UserGoogleDTO.class);

        return googlePojo;
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginGoogleController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginGoogleController.class.getName()).log(Level.SEVERE, null, ex);
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
