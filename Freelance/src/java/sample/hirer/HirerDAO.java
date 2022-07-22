/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.hirer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import sample.project.ProjectDTO;
import sample.util.DBUtil;

/**
 *
 * @author LENOVO
 */
public class HirerDAO {
    
    private static final String GET_REVIEW_GRADE = "SELECT AVG(a.clientGrade) AS reviewGrade\n" +
"FROM Proposal a, Project b, Hirer c\n" +
"WHERE c.hirerID = b.hirerID and a.projectID = b.projectID and c.hirerID = ? and (a.proposalStatusID = 6 or a.proposalStatusID = 7)";
    
    private static final String GET_LIST_ALL_HIRER = "SELECT hirerID, companyName, U.location, U.registrationDate\n" +
"FROM Hirer H, [User] U\n" +
"where H.hirerID = U.userID";
    
    private static final String GET_JOB_POSTED = "SELECT COUNT(P.projectID) AS jobPosted\n" +
"FROM Project P\n" +
"WHERE p.hirerID = ?";
    
    
    
    
    
    public int getJobPosted (int hirerID) throws SQLException {
       Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        int jobPosted = 0;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_JOB_POSTED);
                ptm.setInt(1, hirerID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    jobPosted = rs.getInt("jobPosted");
                }
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
            if (rs != null) {
                rs.close();
            }
        }
       return jobPosted;
    }
    
    
    
    
    public int getReviewGrade (int hirerID) throws SQLException {
       Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        int reviewGrade = 0;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_REVIEW_GRADE);
                ptm.setInt(1, hirerID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    reviewGrade = rs.getInt("reviewGrade");
                }
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
            if (rs != null) {
                rs.close();
            }
        }
       return reviewGrade;
    }

    public List<HirerDTO> getListHirer() throws SQLException {
        List<HirerDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
               
                stm = conn.prepareStatement(GET_LIST_ALL_HIRER);
            
                rs = stm.executeQuery();
                while (rs.next()) {
                    int hirerID = rs.getInt("hirerID");
                    String companyName = rs.getString("companyName");
                    String location = rs.getString("location");
                    LocalDate registrationDate = LocalDate.parse(rs.getString("registrationDate"));
                    
                    list.add(new HirerDTO(hirerID, companyName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    } 
}
