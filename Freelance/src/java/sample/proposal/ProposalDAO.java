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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sample.seeker.SeekerDTO;
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

    private static final String VIEW_HISTORY_PROPOSAL = " SELECT A.proposalID, A.projectID, seekerID, A.paymentAmount, B.statusName, clientGrade, clientComment, seekerGrade,seekerComment,coverLetter,attachment,A.createdDate,A.expectedDurationID,C.projectName, D.startTime, D.endTime, E.durationText "
            + " FROM Proposal A, ProposalStatus B, Project C, Contract D, ExpectedDuration E"
            + " WHERE A.seekerID = ? AND B.statusName LIKE 'job finished successfully' AND A.proposalStatusID = B.proposalStatusID AND A.projectID = C.projectID AND A.proposalID=D.proposalID AND A.expectedDurationID = E.expectedDurationID ";

    private static final String VIEW_HISTORY_PROPOSAL_OF_HIRER = " SELECT proposalID, A.projectID, seekerID, A.paymentAmount, B.statusName, clientGrade, clientComment, seekerGrade,seekerComment,coverLetter,attachment,A.createdDate,A.expectedDurationID,C.projectName"
            + " FROM Proposal A, ProposalStatus B, Project C, Hirer D"
            + " WHERE D.hirerID = ? AND D.hirerID=C.hirerID AND B.statusName LIKE 'job finished successfully' AND A.proposalStatusID = B.proposalStatusID AND A.projectID = C.projectID ";

    private static final String INSERT_PROPOSAL = "INSERT INTO Proposal(projectID,seekerID,paymentAmount,proposalStatusID,coverLetter,attachment,expectedDurationID)"
            + " VALUES(?,?,?,?,?,?,?)";

    private static final String CHECK_IS_ACTIVE_PROPOSAL = " SELECT projectID FROM Proposal WHERE projectID =? AND proposalStatusID IN(4,5,6,7)";

    private static final String CHECK_PROPOSAL_ALREADY_SUBMIT = " SELECT projectID FROM Proposal WHERE projectID =? AND seekerID=? AND proposalStatusID=1";

    private static final String VIEW_DONE_PROPOSAL = "SELECT A.proposalID, B.projectName, a.createdDate\n"
            + "FROM Proposal A, Project B\n"
            + "WHERE A.projectID = B.projectID \n"
            + "AND (A.proposalStatusID = 6 OR A.proposalStatusID = 7)\n"
            + "AND A.seekerID = ?";
    private static final String VIEW_WAITING_PROPOSAL = "SELECT B.projectName, a.createdDate\n"
            + "FROM Proposal A, Project B\n"
            + "WHERE A.projectID = B.projectID \n"
            + "AND A.proposalStatusID = 5\n"
            + "AND A.seekerID = ?";

    private static final String VIEW_DONE_PROPOSAL_OF_HIRER = "SELECT A.proposalID,B.projectName, a.createdDate\n"
            + "FROM Proposal A, Project B\n"
            + "WHERE A.projectID = B.projectID \n"
            + "AND (A.proposalStatusID = 6 OR A.proposalStatusID = 7)\n"
            + "AND B.hirerID = ?";
    private static final String VIEW_WAITING_PROPOSAL_OF_HIRER = "SELECT B.projectName, a.createdDate, A.proposalID\n"
            + "FROM Proposal A, Project B\n"
            + "WHERE A.projectID = B.projectID \n"
            + "AND A.proposalStatusID = 5\n"
            + "AND B.hirerID = ?";
    private static final String VIEW_JOB_STARTED_PROPOSAL_OF_HIRER = "SELECT B.projectName, a.createdDate, A.proposalID\n"
            + "FROM Proposal A, Project B\n"
            + "WHERE A.projectID = B.projectID \n"
            + "AND A.proposalStatusID = 4\n"
            + "AND B.hirerID = ?";

    private static final String GET_PROPOSAL = "SELECT pr.hirerID, p.proposalID, p.projectID,pr.projectName , p.seekerID, p.paymentAmount,p.proposalStatusID, ps.statusName, \n"
            + "p.clientGrade, p.clientComment, p.seekerGrade, p.seekerComment, p.coverLetter, p.attachment, p.createdDate,\n"
            + "p.expectedDurationID, E.durationText\n"
            + "FROM Proposal p, ExpectedDuration e, ProposalStatus ps, Project pr\n"
            + "WHERE p.proposalStatusID = ps.proposalStatusID\n"
            + "And e.expectedDurationID = p.expectedDurationID\n"
            + "AND p.projectID = pr.projectID\n"
            + "AND p.proposalID = ?";

    private static final String DELETE_PROPOSAL = "DELETE FROM PROPOSAL WHERE proposalID = ?";

    private static final String GET_LIST_INVITED_SEEKER = "SELECT seekerID,overview,titileBio,moneyPerHour,educationdegree,major,hourPerWeek "
            + " FROM Seeker A,Proposal B "
            + " WHERE B.projectID=? AND B.proposalStatusID =2";

    private static final String GET_LIST_APPLY_SEEKER = "SELECT seekerID,overview,titileBio,moneyPerHour,educationdegree,major,hourPerWeek "
            + " FROM Seeker A,Proposal B "
            + " WHERE B.projectID=? AND B.proposalStatusID =1";

    private static final String UPDATE_PROPOSAL_STATUS = "UPDATE Proposal\n"
            + "SET proposalStatusID = ?\n"
            + "WHERE projectID = ?";

    private static final String UPDATE_PROPOSAL_STATUS_FOR_STARTED = "UPDATE Proposal\n"
            + "SET proposalStatusID = 4\n"
            + "WHERE seekerID = ?\n"
            + "AND projectID = ?";

    private static final String UPDATE_FEEDBACK_OF_SEEKER = "UPDATE Proposal\n"
            + "SET clientGrade = ?, seekerComment=? \n"
            + "WHERE proposalID = ?";

    private static final String UPDATE_FEEDBACK_OF_HIRER = "UPDATE Proposal\n"
            + "SET seekerGrade = ?, clientComment=? \n"
            + "WHERE proposalID = ?";

    private static final String GET_END_DATE_OF_CONTRACT = "SELECT endTime FROM Contract WHERE proposalID = ?";
    
    private static final String GET_START_TIME_OF_CONTRACT = "SELECT startTime FROM Contract WHERE proposalID = ?";

    private static final String CANCEL_PROJECT = "update Proposal\n"
            + "set proposalStatusID = ?\n"
            + "where projectID = ? and proposalStatusID = 4";

    private static final String GET_LIST_PROJECT_NEW = "select projectID\n" +
"from Proposal\n" +
"where proposalStatusID NOT IN (4, 5, 6, 7, 8)\n" +
"group by projectID";
    //getListProjectNew
    public List<Integer> getListProjectNew() throws SQLException{
        List<Integer> listProjectNew = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(GET_LIST_PROJECT_NEW);
                rs = ptm.executeQuery();
                while (rs.next()) {                    
                    int projectID = rs.getInt("projectID");
                    listProjectNew.add(projectID);
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
            if (con != null) {
                con.close();
            }
        }
        return listProjectNew;
    }
    
    public boolean cancelProject(String projectID, int status) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(CANCEL_PROJECT);
                ptm.setInt(1, status);
                ptm.setString(2, projectID);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public boolean updateStatusProposal(int seekerID, int projectId) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(UPDATE_PROPOSAL_STATUS_FOR_STARTED);
                ptm.setInt(1, seekerID);
                ptm.setInt(2, projectId);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }
    private static final String UPDATE_PROPOSAL_STATUS_BY_ID = "UPDATE Proposal\n"
            + "SET proposalStatusID = ?\n"
            + "WHERE proposalID = ?";

    public boolean changeStatusProposal(int proposalID, int proposalStatusID) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(UPDATE_PROPOSAL_STATUS_BY_ID);
                ptm.setInt(1, proposalStatusID);
                ptm.setInt(2, proposalID);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }
    private static final String UPDATE_PROPOSAL_STATUS_ONLY_ONE_PROPOSAL = "UPDATE Proposal\n"
            + "SET proposalStatusID = ?\n"
            + "WHERE projectID = ? AND seekerID = ?";

    public boolean changeStatusProposalOnlyOne(int projectID, int proposalStatusID, int seekerID) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(UPDATE_PROPOSAL_STATUS_ONLY_ONE_PROPOSAL);
                ptm.setInt(1, proposalStatusID);
                ptm.setInt(2, projectID);
                ptm.setInt(3, seekerID);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }
    
    private static final String UPDATE_PROPOSAL_STATUS_BY_ID_SEEKERDONE = "update Proposal\n" +
"set proposalStatusID = ?\n" +
"where proposalID = ?\n" +
"and seekerID = ?";

    public boolean changeStatusProposalSeekerDoneButHIrerNotCheck(int proposalID, int proposalStatusID, int seekerid) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(UPDATE_PROPOSAL_STATUS_BY_ID_SEEKERDONE);
                ptm.setInt(1, proposalStatusID);
                ptm.setInt(2, proposalID);
                ptm.setInt(3, seekerid);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    //ham dung de chuyen trang thai cua nhung proposal nao ma thuoc project nao do (statusID 1 : 7)
    public boolean changeStatusProposalOfProject(int projectID, int proposalStatusID) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(UPDATE_PROPOSAL_STATUS);
                ptm.setInt(1, proposalStatusID);
                ptm.setInt(2, projectID);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }
    private static final String GET_PROPOSAL_BYID_WHEN_STATUS_JOB_WAITING = "SELECT p.proposalID, p.projectID,pr.projectName , p.seekerID, p.paymentAmount,p.proposalStatusID, ps.statusName, \n"
            + "p.clientGrade, p.clientComment, p.seekerGrade, p.seekerComment, p.coverLetter, p.attachment, p.createdDate,\n"
            + "p.expectedDurationID, E.durationText\n"
            + "FROM Proposal p, ExpectedDuration e, ProposalStatus ps, Project pr\n"
            + "WHERE p.proposalStatusID = ps.proposalStatusID\n"
            + "And e.expectedDurationID = p.expectedDurationID\n"
            + "AND p.projectID = pr.projectID\n"
            + "AND p.proposalID = ?";

    public ProposalDTO getProposalByIDReturnSeekerID(int proposalID) throws SQLException {
        ProposalDTO item = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_PROPOSAL_BYID_WHEN_STATUS_JOB_WAITING);
                ptm.setInt(1, proposalID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    proposalID = Integer.parseInt(rs.getString("proposalID"));
                    int projectID = Integer.parseInt(rs.getString("projectID"));
                    int seekerID = Integer.parseInt(rs.getString("seekerID"));
                    double paymentAmount = Double.parseDouble(rs.getString("paymentAmount"));
                    int proposalStatusID = Integer.parseInt(rs.getString("proposalStatusID"));
                    String proposalStatusName = rs.getString("statusName");

                    String coverLetter = rs.getString("coverLetter");
                    String attachment = rs.getString("attachment");
                    String createdDate = rs.getString("createdDate");
                    String expectedDurationID = rs.getString("expectedDurationID");
                    String projectName = rs.getString("projectName");
                    String durationText = rs.getString("durationText");

                    item = new ProposalDTO(proposalID, projectID, seekerID, paymentAmount, proposalStatusID,
                            proposalStatusName, coverLetter, attachment, createdDate, expectedDurationID, projectName, durationText);
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
        return item;
    }

    //ham nay can coi lai
    public ProposalDTO getProposal(int proposalID) throws SQLException {
        ProposalDTO item = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_PROPOSAL);
                ptm.setInt(1, proposalID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    proposalID = Integer.parseInt(rs.getString("proposalID"));
                    int projectID = Integer.parseInt(rs.getString("projectID"));
                    int seekerID = Integer.parseInt(rs.getString("seekerID"));
                    int hirerID = Integer.parseInt(rs.getString("hirerID"));
                    double paymentAmount = Double.parseDouble(rs.getString("paymentAmount"));
                    int proposalStatusID = Integer.parseInt(rs.getString("proposalStatusID"));
                    String proposalStatusName = rs.getString("statusName");
                    double clientGrade = Double.parseDouble(rs.getString("clientGrade"));
                    String clientComment = rs.getString("clientComment");
                    double seekerGrade = Double.parseDouble(rs.getString("seekerGrade"));
                    String seekerComment = rs.getString("seekerComment");
                    String coverLetter = rs.getString("coverLetter");
                    String attachment = rs.getString("attachment");
                    String createdDate = rs.getString("createdDate");
                    String expectedDurationID = rs.getString("expectedDurationID");
                    String projectName = rs.getString("projectName");
                    String durationText = rs.getString("durationText");

                    item = new ProposalDTO(hirerID, proposalID, projectID, seekerID, paymentAmount, proposalStatusID,
                            proposalStatusName, clientGrade, clientComment, seekerGrade, seekerComment,
                            coverLetter, attachment, createdDate, expectedDurationID, projectName, durationText);
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
        return item;
    }

    private static final String VIEW_JOB_STARTED_PROPOSAL = "SELECT A.proposalID, B.projectID, B.projectName, A.createdDate, A.expectedDurationID, A.paymentAmount, A.link \n"
            + "FROM Proposal A, Project B\n"
            + "WHERE A.projectID = B.projectID \n"
            + "AND A.proposalStatusID = 4\n"
            + "AND A.seekerID = ?";

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
                    int proposalID = rs.getInt("proposalID");
                    int projectID = rs.getInt("projectID");
                    String projectName = rs.getString("projectName");
                    String createdDate = rs.getString("createdDate");
                    String expectedDurationID = rs.getString("expectedDurationID");
                    double paymentAmount = rs.getDouble("paymentAmount");
                    String link = rs.getString("link");

                    list.add(new ProposalDTO(proposalID, projectID, projectName, createdDate,expectedDurationID,paymentAmount, link));
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
                    int proposalID = rs.getInt("proposalID");
                    String projectName = rs.getString("projectName");
                    String createdDate = rs.getString("createdDate");

                    list.add(new ProposalDTO(projectName, createdDate, proposalID));
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
                    String startTime = rs.getString("startTime");
                    String endTime = rs.getString("endTime");
                    String durationText = rs.getString("durationText");

                    list.add(new ProposalDTO(proposalID, projectID, seekerID, paymentAmount, proposalStatusName, clientGrade, clientComment, seekerGrade, seekerComment, coverLetter, attachment, createdDate, expectedDurationID, projectName,startTime,endTime,durationText));
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

    public List<ProposalDTO> getHistoryProjectOfHirer(int userID) throws SQLException {
        List<ProposalDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_HISTORY_PROPOSAL_OF_HIRER);
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

    public boolean submitProposal(int projectID, int userID, double paymentAmount, int durationID, String coverLetter, String attachment, int proposalStatus) throws SQLException {
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
                ptm.setInt(4, proposalStatus);
                ptm.setString(5, coverLetter);
                ptm.setString(6, attachment);
                ptm.setInt(7, durationID);
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
                ptm = conn.prepareStatement(CHECK_IS_ACTIVE_PROPOSAL);
                ptm.setInt(1, projectID);
                rs = ptm.executeQuery();
                if (rs.next()) {
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

    public boolean withdrawnProposal(int proposalID) throws SQLException {
        boolean checkForWithdrawn = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_PROPOSAL);
                ptm.setInt(1, proposalID);
                checkForWithdrawn = ptm.executeUpdate() > 0;

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
        return checkForWithdrawn;
    }

    public List<SeekerDTO> getInvitedList(int projectID) throws SQLException {
        List<SeekerDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_LIST_INVITED_SEEKER);
                ptm.setInt(1, projectID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int seekerID = rs.getInt("seekerID");
                    String overview = rs.getString("overview");
                    String titileBio = rs.getString("titileBio");
                    int moneyPerHour = rs.getInt("moneyPerHour");
                    String education = rs.getString("education");
                    String degree = rs.getString("degree");
                    String major = rs.getString("major");
                    String hourPerWeek = rs.getString("hourPerWeek");

                    list.add(new SeekerDTO(seekerID, overview, titileBio, moneyPerHour, education, degree, major, hourPerWeek));

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

    private static final String GET_APPLIED_PROPOSAL = "SELECT p.paymentAmount, p.coverLetter, p.attachment, e.durationText, p.proposalID, p.projectID, p.seekerID, p.proposalStatusID, p.createdDate, p.expectedDurationID, u.fullName, s.major, u.location, s.seekerID, u.avatar\n"
            + "FROM [User] u, Seeker s, Proposal p, ExpectedDuration e\n"
            + "WHERE u.userID = s.seekerID and s.seekerID = p.seekerID and e.expectedDurationID = p.expectedDurationID\n"
            + "and p.proposalStatusID = 1\n"
            + "and p.projectID = ?";

    public List<ProposalDTO> getAppliedProposals(int projectID) throws SQLException {
        List<ProposalDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_APPLIED_PROPOSAL);
                ptm.setInt(1, projectID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int proposalID = rs.getInt("proposalID");
                    int seekerID = rs.getInt("seekerID");
                    String fullName = rs.getString("fullName");
                    String major = rs.getString("major");
                    String location = rs.getString("location");
                    int proposalStatusID = rs.getInt("proposalStatusID");
                    double paymentAmount = rs.getDouble("paymentAmount");
                    String coverLetter = rs.getString("coverLetter");
                    String attachment = rs.getString("attachment");
                    String expectedDurationText = rs.getString("durationText");
                    String avatar = rs.getString("avatar");

                    SeekerDTO seeker = new SeekerDTO();
                    seeker.setMajor(major);
                    seeker.setFullName(fullName);
                    seeker.setLocation(location);
                    seeker.setSeekerID(seekerID);
                    seeker.setAvatar(avatar);

                    list.add(new ProposalDTO(proposalID, seekerID, proposalStatusID, paymentAmount, coverLetter, attachment, expectedDurationText, seeker));

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

    private static final String GET_PROPOSAL_BY_ID = "SELECT p.paymentAmount, p.coverLetter, p.attachment, e.durationText, p.proposalID, p.projectID, p.seekerID, p.proposalStatusID, p.createdDate, p.expectedDurationID, u.fullName, s.major, u.location, s.seekerID, u.avatar\n"
            + "FROM [User] u, Seeker s, Proposal p, ExpectedDuration e\n"
            + "WHERE u.userID = s.seekerID and s.seekerID = p.seekerID and e.expectedDurationID = p.expectedDurationID\n"
            + "and p.proposalID = ?";

    public ProposalDTO getProposalByID(int proposalID) throws SQLException {
        ProposalDTO proposal = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_PROPOSAL_BY_ID);
                ptm.setInt(1, proposalID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    proposalID = rs.getInt("proposalID");
                    int seekerID = rs.getInt("seekerID");
                    int projectID = rs.getInt("projectID");
                    String fullName = rs.getString("fullName");
                    String major = rs.getString("major");
                    String location = rs.getString("location");
                    int proposalStatusID = rs.getInt("proposalStatusID");
                    double paymentAmount = rs.getDouble("paymentAmount");
                    String coverLetter = rs.getString("coverLetter");
                    String attachment = rs.getString("attachment");
                    String expectedDurationText = rs.getString("durationText");
                    String avatar = rs.getString("avatar");

                    SeekerDTO seeker = new SeekerDTO();
                    seeker.setMajor(major);
                    seeker.setFullName(fullName);
                    seeker.setLocation(location);
                    seeker.setSeekerID(seekerID);
                    seeker.setAvatar(avatar);

                    proposal = new ProposalDTO(proposalID, seekerID, projectID, proposalStatusID, paymentAmount, coverLetter, attachment, expectedDurationText, seeker);

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
        return proposal;
    }

    public List<SeekerDTO> getApplyList(int projectID) throws SQLException {
        List<SeekerDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_LIST_APPLY_SEEKER);
                ptm.setInt(1, projectID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int seekerID = rs.getInt("seekerID");
                    String overview = rs.getString("overview");
                    String titileBio = rs.getString("titileBio");
                    int moneyPerHour = rs.getInt("moneyPerHour");
                    String education = rs.getString("education");
                    String degree = rs.getString("degree");
                    String major = rs.getString("major");
                    String hourPerWeek = rs.getString("hourPerWeek");

                    list.add(new SeekerDTO(seekerID, overview, titileBio, moneyPerHour, education, degree, major, hourPerWeek));

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

    private static final String DELETE_PROPOSAL_BY_PROJECT_ID = "DELETE FROM PROPOSAL WHERE projectID = ?";

    public boolean deleteProposalByProjectID(int projectID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_PROPOSAL_BY_PROJECT_ID);
                ptm.setInt(1, projectID);
                check = ptm.executeUpdate() > 0;

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
        return check;
    }

    public List<ProposalDTO> getListDoneProposalOfHirer(int userID) throws SQLException {
        List<ProposalDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_DONE_PROPOSAL_OF_HIRER);
                ptm.setInt(1, userID);
                rs = ptm.executeQuery();
                while (rs.next()) {

                    int proposalID = rs.getInt("proposalID");
                    String projectName = rs.getString("projectName");
                    String createdDate = rs.getString("createdDate");

                    list.add(new ProposalDTO(projectName, createdDate, proposalID));
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

    public List<ProposalDTO> getListWaitingProposalOfHirer(int userID) throws SQLException {
        List<ProposalDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_WAITING_PROPOSAL_OF_HIRER);
                ptm.setInt(1, userID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String projectName = rs.getString("projectName");
                    String createdDate = rs.getString("createdDate");
                    int proposalID = rs.getInt("proposalID");

                    list.add(new ProposalDTO(projectName, createdDate, proposalID));
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

    public List<ProposalDTO> getListActiveProposalOfHirer(int userID) throws SQLException {
        List<ProposalDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_JOB_STARTED_PROPOSAL_OF_HIRER);
                ptm.setInt(1, userID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String projectName = rs.getString("projectName");
                    String createdDate = rs.getString("createdDate");
                    int proposalID = rs.getInt("proposalID");

                    list.add(new ProposalDTO(projectName, createdDate, proposalID));
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

    public boolean seekerFeedback(int proposalID, int clientGrade, String seekerComment) throws SQLException {
        boolean checkFeedback = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_FEEDBACK_OF_SEEKER);
                ptm.setInt(1, clientGrade);
                ptm.setString(2, seekerComment);
                ptm.setInt(3, proposalID);

                checkFeedback = ptm.executeUpdate() > 0;
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
        return checkFeedback;
    }

    public boolean hirerFeedback(int proposalID, int seekerGrade, String clientComment) throws SQLException {
        boolean checkFeedback = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_FEEDBACK_OF_HIRER);
                ptm.setInt(1, seekerGrade);
                ptm.setString(2, clientComment);
                ptm.setInt(3, proposalID);

                checkFeedback = ptm.executeUpdate() > 0;
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
        return checkFeedback;
    }

    public String getEndDateOfContract(int proposalID) throws SQLException {
        String endDate = "";
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_END_DATE_OF_CONTRACT);
                ptm.setInt(1, proposalID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    endDate = rs.getString("endTime");
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
        return endDate;
    }
    public String getStartTimeOfContract(int proposalID) throws SQLException {
        String startTime = "";
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_START_TIME_OF_CONTRACT);
                ptm.setInt(1, proposalID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    startTime = rs.getString("startTime");
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
        return startTime;
    }

    String GET_SEEKER_ID_OF_CANCEL_PROJECT = "select seekerID\n"
            + "from Proposal\n"
            + "where projectID = ? and proposalStatusID = 6";

    public int getSeekerIDOfCancelProject(String projectID) throws SQLException {
        int seekerid = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_SEEKER_ID_OF_CANCEL_PROJECT);
                ptm.setString(1, projectID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    seekerid = rs.getInt("seekerID");
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
        return seekerid;
    }

    String GET_AMOUNT_MONNEY_OF_CANCEL_PROJECT = "select paymentAmount\n"
            + "from Proposal\n"
            + "where projectID = ? and proposalStatusID = 6";

    public int getAmountMoneyOfCancelProject(String projectID) throws SQLException {
        int money = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_AMOUNT_MONNEY_OF_CANCEL_PROJECT);
                ptm.setString(1, projectID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    money = rs.getInt("paymentAmount");
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
        return money;
    }

    String TRANSFER_MONEY_CANCEL_PROJECT_TO_SEEKER = "update [User]\n"
            + "set balance = balance + ?\n"
            + "where userID = ?";

    public boolean transferMoneyCancelProjectToSeeker(int seekerID, int amountMoney) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(TRANSFER_MONEY_CANCEL_PROJECT_TO_SEEKER);
                ptm.setInt(1, amountMoney);
                ptm.setInt(2, seekerID);
                check = ptm.executeUpdate() > 0 ? true : false;
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
        return check;
    }

    private static final String CHECK_FEEDBACK_OF_SEEKER = "SELECT clientGrade From Proposal WHERE proposalID = ?";

    public boolean checkFeedbackOfSeeker(int proposalID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_FEEDBACK_OF_SEEKER);
                ptm.setInt(1, proposalID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    if (rs.getInt("clientGrade") > 0) {
                        check = true;
                    }
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
        return check;
    }

    private static final String CHECK_FEEDBACK_OF_HIRER = "SELECT seekerGrade From Proposal WHERE proposalID = ?";

    public boolean checkFeedbackOfHirer(int proposalID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_FEEDBACK_OF_HIRER);
                ptm.setInt(1, proposalID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    if (rs.getInt("seekerGrade") > 0) {
                        check = true;
                    }
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
        return check;
    }

    private static final String VIEW_REPORTED_PROPOSAL = "SELECT B.projectName,B.description, A.createdDate,A.proposalID,A.link, A.message, A.fileName, A.path, A.paymentAmount \n"
            + "FROM Proposal A, Project B\n"
            + "WHERE A.projectID = B.projectID \n"
            + "AND A.proposalStatusID =8 \n";

    public List<ProposalDTO> getListReportedProposal() throws SQLException {
        List<ProposalDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_REPORTED_PROPOSAL);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String projectName = rs.getString("projectName");
                    String projectDescription = rs.getString("description");
                    String createdDate = rs.getString("createdDate");
                    int proposalID = rs.getInt("proposalID");
                    String fileName = rs.getString("fileName");
                    String link = rs.getString("link");
                    String message = rs.getString("message");
                    String path = rs.getString("path");
                    double paymentAmount = Double.parseDouble(rs.getString("paymentAmount"));

                    list.add(new ProposalDTO(projectName,projectDescription, createdDate, link, message, fileName, path, proposalID, paymentAmount));
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

    private static final String GET_PROPOSAL_BY_ID_FOR_ADMIN_PAGE = "SELECT pr.hirerID, p.proposalID, p.projectID , p.seekerID, p.paymentAmount,p.proposalStatusID,p.createdDate, pr.projectName \n"
            + "FROM Proposal p, Project pr\n"
            + "WHERE p.projectID = pr.projectID\n"
            + "AND p.proposalID = ?";

    public ProposalDTO getProposalByIDForAdminPage(int proposalID) throws SQLException {
        ProposalDTO item = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_PROPOSAL_BY_ID_FOR_ADMIN_PAGE);
                ptm.setInt(1, proposalID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    proposalID = Integer.parseInt(rs.getString("proposalID"));
                    int projectID = Integer.parseInt(rs.getString("projectID"));
                    int seekerID = Integer.parseInt(rs.getString("seekerID"));
                    int hirerID = Integer.parseInt(rs.getString("hirerID"));
                    double paymentAmount = Double.parseDouble(rs.getString("paymentAmount"));
                    int proposalStatusID = Integer.parseInt(rs.getString("proposalStatusID"));
                    String createdDate = rs.getString("createdDate");
                    String projectName = rs.getString("projectName");

                    item = new ProposalDTO(hirerID, proposalID, projectID, seekerID, paymentAmount, proposalStatusID, createdDate,projectName);

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
        return item;
    }

    //chua hoan thanh....
    private static final String VIEW_FEEDBACK_OF_SEEKER = "";

    public List<ProposalDTO> getFeedbackOfSeeker(int hirerID) throws SQLException {
        List<ProposalDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_FEEDBACK_OF_SEEKER);
                ptm.setInt(1, hirerID);
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

    public boolean updateDateSeekerDone(int proposalID, LocalDate date) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sqlQuery = "update Proposal\n" +
"set dateSeekerDone = ?\n" +
"where proposalID = ?";
                ptm = conn.prepareStatement(sqlQuery);
                ptm.setString(1, date.toString());
                ptm.setInt(2, proposalID);
                check = ptm.executeUpdate()>0?true:false;
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
        return check;
    }

    public List<ProposalDTO> getListProposalSeekerDone() throws SQLException {
        List<ProposalDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                
                String sqlQuery = "select proposalID, projectID, dateSeekerDone, paymentAmount, seekerID\n" +
"from Proposal\n" +
"where dateSeekerDone is not null\n" +
"and proposalStatusID = 5";
                
                
                ptm = conn.prepareStatement(sqlQuery);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int proposalID = rs.getInt("proposalID");
                    int projectID = rs.getInt("projectID");
                    double paymentAmount = rs.getDouble("paymentAmount");
                    int seekerID = rs.getInt("seekerID");
                    String dateSeekerDone = rs.getString("dateSeekerDone");

                    list.add(new ProposalDTO(proposalID, projectID, seekerID, paymentAmount, dateSeekerDone));
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

    public boolean checkProjectNoProposal(int projectID) throws SQLException {
        boolean check = true;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sqlQuery = "select *\n" +
"from Proposal\n" +
"where projectID = ?";
                ptm = conn.prepareStatement(sqlQuery);
                ptm.setInt(1, projectID);
                rs = ptm.executeQuery();
                if(rs.next()){
                    check = false;
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
        return check;
    }

}
