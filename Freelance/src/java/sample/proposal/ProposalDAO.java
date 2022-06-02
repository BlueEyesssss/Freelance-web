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

    private static final String VIEW_INVITATIONS_PROPOSAL = "SELECT proposalID, projectID, seekerID, paymentAmount, B.statusName, clientGrade, clientComment, seekerGrade "
            + " FROM Proposal A, ProposalStatus B"
            + " WHERE A.seekerID = ? AND B.statusName LIKE 'Invitation to interview' AND A.proposalStatusID = B.proposalStatusID ";
    
    private static final String VIEW_SUBMITTED_PROPOSAL = "SELECT proposalID, projectID, seekerID, paymentAmount, B.statusName, clientGrade, clientComment, seekerGrade "
            + " FROM Proposal A, ProposalStatus B"
            + " WHERE A.seekerID = ? AND B.statusName LIKE 'Submitted proposal' AND A.proposalStatusID = B.proposalStatusID ";
    
    private static final String VIEW_OFFER_PROPOSAL = "SELECT proposalID, projectID, seekerID, paymentAmount, B.statusName, clientGrade, clientComment, seekerGrade "
            + " FROM Proposal A, ProposalStatus B"
            + " WHERE A.seekerID = ? AND B.statusName LIKE 'Offer proposal' AND A.proposalStatusID = B.proposalStatusID ";
    
    private static final String VIEW_ACTIVE_PROPOSAL = "SELECT proposalID, projectID, seekerID, paymentAmount, B.statusName, clientGrade, clientComment, seekerGrade "
            + " FROM Proposal A, ProposalStatus B"
            + " WHERE A.seekerID = ? AND B.statusName LIKE 'Active proposal' AND A.proposalStatusID = B.proposalStatusID ";

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

                    list.add(new ProposalDTO(proposalID, projectID, seekerID, paymentAmount, proposalStatusName, clientGrade, clientComment, seekerGrade));
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

                    list.add(new ProposalDTO(proposalID, projectID, seekerID, paymentAmount, proposalStatusName, clientGrade, clientComment, seekerGrade));
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
    
    public List<ProposalDTO> getListActiveProposal(int userID) throws SQLException {
        List<ProposalDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_ACTIVE_PROPOSAL);
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

                    list.add(new ProposalDTO(proposalID, projectID, seekerID, paymentAmount, proposalStatusName, clientGrade, clientComment, seekerGrade));
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
    
    public List<ProposalDTO> getListOfferProposal(int userID) throws SQLException {
        List<ProposalDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_OFFER_PROPOSAL);
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

                    list.add(new ProposalDTO(proposalID, projectID, seekerID, paymentAmount, proposalStatusName, clientGrade, clientComment, seekerGrade));
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
}
