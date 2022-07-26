/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.contract.ContractDAO;
import sample.hirer.HirerDAO;
import sample.hirer.HirerDTO;
import sample.payment.PayPayDTO;
import sample.payment.PaymentDAO;
import sample.project.ProjectDAO;
import sample.project.ProjectDTO;
import sample.proposal.ProposalDAO;
import sample.proposal.ProposalDTO;
import sample.seeker.SeekerDTO;
import sample.skill.SkillDAO;
import sample.skill.SkillDTO;
import sample.transactionhandling.TransactionHandlingDAO;
import sample.transactionhandling.TransactionHandlingDTO;
import sample.user.UserDAO;
import sample.user.UserDTO;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private static final String ERROR = "login.jsp";
    private static final String SEEKER_PAGE = "ViewSeekerDashboardController";
    private static final String HIRER_PAGE = "ViewHirerDashboardController";
    private static final String ADMIN_PAGE = "index.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            String username = request.getParameter("userName");
            String password = request.getParameter("password");

            //check list các proposal seeker đã submit để check xem hirer đã duyệt chưa
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ProposalDAO proposalDao = new ProposalDAO();
            ContractDAO contractDao = new ContractDAO();
            Date dateSeekerDone = null;
            Date dateNow = dateFormat.parse(java.time.LocalDate.now().toString());
            long difference = 0;
            long differenceDays = 0;
            List<ProposalDTO> listProposalSeekerDone = proposalDao.getListProposalSeekerDone();
            if (listProposalSeekerDone != null) {
                for (ProposalDTO item : listProposalSeekerDone) {
                    dateSeekerDone = dateFormat.parse(item.getDateSeekerDone());
                    //tính ngày 
                    difference = dateNow.getTime() - dateSeekerDone.getTime();
                    differenceDays = difference / (24 * 60 * 60 * 1000);
                    if (differenceDays > 7) {
                        //set lại status 8 (job finished successfully) cho proposal này
                        proposalDao.changeStatusProposalSeekerDoneButHIrerNotCheck(item.getProposalID(), 7, item.getSeekerID());
                        //chuyển tiền vào balance web cho seeker
                        PaymentDAO paymentDAO = new PaymentDAO();
                        paymentDAO.addMoneyForSeeker(item.getSeekerID(), item.getPaymentAmount());
                        LocalDate endTime = LocalDate.now();
                        contractDao.updateEndTimeContract(item.getProposalID(), endTime);
                    }
                }
            }

            if (username.equals("admin") && password.equals("11")) {
                //HttpSession sessionAdmin = request.getSession();
                //lấy list transaction rút tiền từ web ra paypal
                TransactionHandlingDAO dao = new TransactionHandlingDAO();
                List<TransactionHandlingDTO> listTran = dao.getListTranStatus0();
                session.setAttribute("LIST_TRANS_STATUS_0", listTran);

                //lấy list các project đã post lên
                ProjectDAO projectDAO = new ProjectDAO();
                List<ProjectDTO> listProject = projectDAO.getListProjectByName(" ");

                //list project new
                List<ProjectDTO> listProjectNewNotHasSeeekr = new ArrayList<>();

                //take list projectID của project have proposal but not have any seeker
                List<Integer> listPrrojectIDNew = proposalDao.getListProjectNew();
                for (ProjectDTO projectDTO : listProject) {
                    for (Integer integer : listPrrojectIDNew) {
                        if (integer == projectDTO.getProjectID()) {
                            listProjectNewNotHasSeeekr.add(projectDTO);
                            break;
                        }
                    }
                }
                //take list project haven't any proposal
                for (ProjectDTO projectDTO : listProject) {
                    if (proposalDao.checkProjectNoProposal(projectDTO.getProjectID())) {
                        //đúng là project này chưa có proposal nào
                        listProjectNewNotHasSeeekr.add(projectDTO);
                    }
                }
                session.setAttribute("LIST_PROJECT_POSTED", listProjectNewNotHasSeeekr);

                url = ADMIN_PAGE;
            } else {
                UserDAO dao = new UserDAO();
                SkillDAO daoSkill = new SkillDAO();
                UserDTO user = new UserDTO();
                SeekerDTO seeker = new SeekerDTO();
                HirerDTO hirer = new HirerDTO();
                HirerDAO daoHirer = new HirerDAO();
                UserDAO daoUser = new UserDAO();
                user = dao.getUser(username, password);
                if (user != null) {

                    List<SkillDTO> listSkillAll = daoSkill.getListSkill();
                    session.setAttribute("LIST_SKILL_ALL", listSkillAll);

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
                        seeker.setAvatar(user.getAvatar());
                        seeker.setLanguage(user.getLanguage());
                        seeker.setLanguagelv(user.getLanguagelv());

                        session.setAttribute("USER_LOGIN", seeker);

                        //check seeker co nôp product chua khi het han duration
                        List<ProposalDTO> listJobActiveOfSeeker = proposalDao.getListJobStartedProposal(seeker.getSeekerID());
                        long endTimeExpected = 0;
                        for (ProposalDTO jobActive : listJobActiveOfSeeker) {
                            String startTime = proposalDao.getStartTimeOfContract(jobActive.getProjectID());
                            if (startTime != null) {
                                if(!startTime.equalsIgnoreCase("")){
                                Date startTimeJob = dateFormat.parse(startTime);

                                switch (jobActive.getExpectedDurationID()) {
                                    case "1":
                                        endTimeExpected = 30;
                                        break;
                                    case "2":
                                        endTimeExpected = 90;
                                        break;
                                    case "3":
                                        endTimeExpected = 180;
                                        break;
                                    case "4":
                                        endTimeExpected = 360;
                                        break;
                                    default:
                                }
                                difference = dateNow.getTime() - startTimeJob.getTime() + endTimeExpected;

                                differenceDays = difference / (24 * 60 * 60 * 1000);
                                if (differenceDays > 0) {
                                    //set lại status 6 (job finished unsuccessfully) cho proposal này
                                    proposalDao.changeStatusProposal(jobActive.getProposalID(), 6);
                                    //chuyển tiền vào balance web cho hirer
                                    PaymentDAO paymentDAO = new PaymentDAO();
                                    paymentDAO.addMoneyForSeeker(jobActive.getSeekerID(), jobActive.getPaymentAmount());
                                    LocalDate endTime = LocalDate.now();
                                    contractDao.updateEndTimeContract(jobActive.getProposalID(), endTime);
                                }
                            }
                            }
                        }

                        //lấy listID các skill của seeker
                        List<SkillDTO> listSkillSeeker = daoSkill.getListSkillIDOfSeeker(seeker.getSeekerID());
                        session.setAttribute("LIST_SKILL_OF_SEEKER", listSkillSeeker);

                        //lấy list skill trong Skill
                        List<HirerDTO> listHirer = daoHirer.getListHirer();
                        List<UserDTO> listUser = daoUser.getListUser();

                        for (UserDTO userDTO : listUser) {
                            for (HirerDTO hirerDTO : listHirer) {
                                if (userDTO.getUserID() == hirerDTO.getHirerID()) {
                                    hirerDTO.setLocation(userDTO.getLocation());
                                    hirerDTO.setRegistrationDate(userDTO.getRegistrationDate());
                                }
                                hirerDTO.setReviewGrade(daoHirer.getReviewGrade(hirerDTO.getHirerID()));
                                hirerDTO.setJobPosted(daoHirer.getJobPosted(hirerDTO.getHirerID()));
                            }
                        }

//                    for (HirerDTO element : listHirer) {
//                        element.setReviewGrade(daoHirer.getReviewGrade(element.getHirerID()));
//                        element.setJobPosted(daoHirer.getJobPosted(element.getHirerID()));
//                        
//                    }
                        //lấy client id và secret của seeker nếu có
                        PaymentDAO daoPayment = new PaymentDAO();
                        String client_id = daoPayment.getClientID(user.getUserID());
                        String client_secret = daoPayment.getClientSecret(user.getUserID());
                        PayPayDTO paypalInf = null;
                        if (client_id != null && client_secret != null) {
                            paypalInf = new PayPayDTO(user.getUserID(), client_id, client_secret);
                        }

                        session.setAttribute("PAYPAL_INF", paypalInf);
                        session.setAttribute("LIST_HIRER", listHirer);
                        url = SEEKER_PAGE;
                    } else { //tương tự vs Hirer
                        //1.lấy hirer
                        hirer = dao.checkAccHirer(user.getUserID());
                        //2.check hirer
                        if (hirer != null) {
                            hirer.setUserID(user.getUserID());
                            hirer.setHirerID(user.getUserID());
                            hirer.setPassword(user.getPassword());
                            hirer.setUserName(user.getUserName());
                            hirer.setFullName(user.getFullName());
                            hirer.setEmail(user.getEmail());
                            hirer.setPhone(user.getPhone());
                            hirer.setLocation(user.getLocation());
                            hirer.setRegistrationDate(user.getRegistrationDate());
                            hirer.setBalance(user.getBalance());
                            hirer.setAvatar(user.getAvatar());
                            hirer.setLanguage(user.getLanguage());
                            hirer.setLanguagelv(user.getLanguagelv());
                            hirer.setJobPosted(daoHirer.getJobPosted(user.getUserID()));

                            //lấy client id và secret của hirer nếu có
                            PaymentDAO daoPayment = new PaymentDAO();
                            String client_id = daoPayment.getClientID(user.getUserID());
                            String client_secret = daoPayment.getClientSecret(user.getUserID());
                            PayPayDTO paypalInf = null;
                            if (client_id != null && client_secret != null) {
                                paypalInf = new PayPayDTO(user.getUserID(), client_id, client_secret);
                            }

                            session.setAttribute("PAYPAL_INF", paypalInf);
                            session.setAttribute("USER_LOGIN", hirer);

                            url = HIRER_PAGE;
                        }
                    }
                } else {
                    request.setAttribute("LOGIN_ERROR", "username or password don't correct");
                }
            }

        } catch (Exception e) {
            log("error at LoginController: " + e.getMessage());
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
