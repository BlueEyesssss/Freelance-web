/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.proposal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.util.DBUtil;

/**
 *
 * @author LENOVO
 */
public class ProposalDAO {

    private static final String VIEW_INVITATIONS_PROPOSAL = " SELECT proposalID, A.projectID, seekerID, A.paymentAmount, B.statusName, clientGrade, clientComment, seekerGrade,seekerComment,coverLetter,attachment,A.createdDate,A.expectedDurationID,C.projectName"
            + " FROM Proposal A, ProposalStatus B, Project C"
            + " WHERE A.seekerID = ? AND B.statusName LIKE 'proposal invite' AND A.proposalStatusID = B.proposalStatusID AND A.projectID = C.projectID ";

    private static final String VIEW_SUBMITTED_PROPOSAL = " SELECT proposalID, A.projectID, seekerID, A.paymentAmount, B.statusName, clientGrade, clientComment, seekerGrade,seekerComment,coverLetter,attachment,A.createdDate,A.expectedDurationID,C.projectName"
            + " FROM Proposal A, ProposalStatus B, Project C"
            + " WHERE A.seekerID = ? AND B.statusName LIKE 'proposal sent' AND A.proposalStatusID = B.proposalStatusID AND A.projectID = C.projectID ";

    private static final String VIEW_HISTORY_PROPOSAL = " SELECT proposalID, A.projectID, seekerID, A.paymentAmount, B.statusName, clientGrade, clientComment, seekerGrade,seekerComment,coverLetter,attachment,A.createdDate,A.expectedDurationID,C.projectName"
            + " FROM Proposal A, ProposalStatus B, Project C"
            + " WHERE A.seekerID = ? AND B.statusName LIKE 'job finished successfully' AND A.proposalStatusID = B.proposalStatusID AND A.projectID = C.projectID ";

    private static final String INSERT_PROPOSAL = "INSERT INTO Proposal(projectID,seekerID,paymentAmount,proposalStatusID,coverLetter,attachment)"
            + " VALUES(?,?,?,?,?,?)";

    private static final String CHECK_IS_PROPOSAL = " SELECT projectID FROM Proposal WHERE projectID =?";
    
    private static final String CHECK_PROPOSAL_ALREADY_SUBMIT = " SELECT projectID FROM Proposal WHERE projectID =? AND seekerID=?";
    
    private static final String VIEW_DONE_PROPOSAL = "SELECT B.projectName, a.createdDate\n" +
"FROM Proposal A, Project B\n" +
"WHERE A.projectID = B.projectID \n" +
"AND (A.proposalStatusID = 6 OR A.proposalStatusID = 7)\n" +
"AND A.seekerID = ?";
    private static final String VIEW_WAITING_PROPOSAL = "SELECT B.projectName, a.createdDate\n" +
"FROM Proposal A, Project B\n" +
"WHERE A.projectID = B.projectID \n" +
"AND A.proposalStatusID = 5\n" +
"AND A.seekerID = ?";
    private static final String VIEW_JOB_STARTED_PROPOSAL = "SELECT B.projectName, a.createdDate\n" +
"FROM Proposal A, Project B\n" +
"WHERE A.projectID = B.projectID \n" +
"AND A.proposalStatusID = 4\n" +
"AND A.seekerID = ?";
    
    public List<ProposalDTO> getListJobStartedProposal(int userID) throws SQLException {
        List<ProposalDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_JOB_STARTED_PROPOSAL);
                ptm.setInt(1, userID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String projectName = rs.getString("projectName");
                    String createdDate = rs.getString("createdDate");

                    list.add(new ProposalDTO(projectName, createdDate));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    
    
    public List<ProposalDTO> getListWaitingProposal(int userID) throws SQLException {
        List<ProposalDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_WAITING_PROPOSAL);
                ptm.setInt(1, userID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String projectName = rs.getString("projectName");
                    String createdDate = rs.getString("createdDate");

                    list.add(new ProposalDTO(projectName, createdDate));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    
    public List<ProposalDTO> getListDoneProposal(int userID) throws SQLException {
        List<ProposalDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_DONE_PROPOSAL);
                ptm.setInt(1, userID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String projectName = rs.getString("projectName");
                    String createdDate = rs.getString("createdDate");

                    list.add(new ProposalDTO(projectName, createdDate));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    
    public List<ProposalDTO> getListInvitationProposal(int userID) throws SQLException {
        List<ProposalDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_INVITATIONS_PROPOSAL);
                ptm.setInt(1, userID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int proposalID = rs.getInt("proposalID");
                    int projectID = rs.getInt("projectID");
                    int seekerID = rs.getInt("seekerID");
                    double paymentAmount = rs.getDouble("paymentAmount");
                    String proposalStatusName = rs.getString("statusName");
                    double clientGrade = rs.getDouble("clientGrade");
                    String clientComment = rs.getString("clientComment");
                    double seekerGrade = rs.getDouble("seekerGrade");
                    String seekerComment = rs.getString("seekerComment");
                    String coverLetter = rs.getString("coverLetter");
                    String attachment = rs.getString("attachment");
                    String createdDate = rs.getString("createdDate");
                    String expectedDurationID = rs.getString("expectedDurationID");
                    String projectName = rs.getString("projectName");

                    list.add(new ProposalDTO(proposalID, projectID, seekerID, paymentAmount, proposalStatusName, clientGrade, clientComment, seekerGrade, seekerComment, coverLetter, attachment, createdDate, expectedDurationID, projectName));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<ProposalDTO> getListSubmittedProposal(int userID) throws SQLException {
        List<ProposalDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_SUBMITTED_PROPOSAL);
                ptm.setInt(1, userID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int proposalID = rs.getInt("proposalID");
                    int projectID = rs.getInt("projectID");
                    int seekerID = rs.getInt("seekerID");
                    double paymentAmount = rs.getDouble("paymentAmount");
                    String proposalStatusName = rs.getString("statusName");
                    double clientGrade = rs.getDouble("clientGrade");
                    String clientComment = rs.getString("clientComment");
                    double seekerGrade = rs.getDouble("seekerGrade");
                    String seekerComment = rs.getString("seekerComment");
                    String coverLetter = rs.getString("coverLetter");
                    String attachment = rs.getString("attachment");
                    String createdDate = rs.getString("createdDate");
                    String expectedDurationID = rs.getString("expectedDurationID");
                    String projectName = rs.getString("projectName");

                    list.add(new ProposalDTO(proposalID, projectID, seekerID, paymentAmount, proposalStatusName, clientGrade, clientComment, seekerGrade, seekerComment, coverLetter, attachment, createdDate, expectedDurationID, projectName));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<ProposalDTO> getHistoryProject(int userID) throws SQLException {
        List<ProposalDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_HISTORY_PROPOSAL);
                ptm.setInt(1, userID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int proposalID = rs.getInt("proposalID");
                    int projectID = rs.getInt("projectID");
                    int seekerID = rs.getInt("seekerID");
                    double paymentAmount = rs.getDouble("paymentAmount");
                    String proposalStatusName = rs.getString("statusName");
                    double clientGrade = rs.getDouble("clientGrade");
                    String clientComment = rs.getString("clientComment");
                    double seekerGrade = rs.getDouble("seekerGrade");
                    String seekerComment = rs.getString("seekerComment");
                    String coverLetter = rs.getString("coverLetter");
                    String attachment = rs.getString("attachment");
                    String createdDate = rs.getString("createdDate");
                    String expectedDurationID = rs.getString("expectedDurationID");
                    String projectName = rs.getString("projectName");

                    list.add(new ProposalDTO(proposalID, projectID, seekerID, paymentAmount, proposalStatusName, clientGrade, clientComment, seekerGrade, seekerComment, coverLetter, attachment, createdDate, expectedDurationID, projectName));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean submitProposal(int projectID, int userID, double paymentAmount, String coverLetter, String attachment) throws SQLException {
        boolean checkSubmitProposal = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT_PROPOSAL);
                ptm.setInt(1, projectID);
                ptm.setInt(2, userID);
                ptm.setDouble(3, paymentAmount);
                ptm.setInt(4, 1);
                ptm.setString(5, coverLetter);
                ptm.setString(6, attachment);
                checkSubmitProposal = ptm.executeUpdate() > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkSubmitProposal;
    }

    public boolean isActiveProposal(int projectID) throws SQLException {
        boolean checkIsActiveProposal = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_IS_PROPOSAL);
                ptm.setInt(1, projectID);
                rs = ptm.executeQuery();
                if (rs != null) {
                    checkIsActiveProposal = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkIsActiveProposal;
    }
    
    public boolean alreadySubmitProposal(int projectID, int seekerID) throws SQLException {
        boolean checkAlreadySubmitProposal = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_PROPOSAL_ALREADY_SUBMIT);
                ptm.setInt(1, projectID);
                ptm.setInt(2, seekerID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    checkAlreadySubmitProposal = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkAlreadySubmitProposal;
    }

}
