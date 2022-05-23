/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.project;

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
public class ProjectDAO {

    public List<ProjectDTO> getListProjectByName(String search) throws SQLException {
        List<ProjectDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = " SELECT projectID, description, complexity, hireID, paymentAmount, expectedDurationID, deadlineDate "
                        + " FROM Project "
                        + " WHERE projectName like ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int projectID = Integer.parseInt(rs.getString("projectID"));
                    String description = rs.getString("description");
                    String complexity = rs.getString("complexity");
                    int hireID = Integer.parseInt(rs.getString("hireID"));
                    double paymentAmount = Double.parseDouble(rs.getString("paymentAmount"));
                    int expectedDurationID = Integer.parseInt(rs.getString("expectedDurationID"));
                    String deadlineDate = rs.getString("deadlineDate");

                    list.add(new ProjectDTO(projectID, description, complexity, hireID, paymentAmount, expectedDurationID, deadlineDate));
                }
            }
        } catch (Exception e) {
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

    public List<ProjectDTO> getListProjectBySkill(String skill) throws SQLException {
        List<ProjectDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {

                String sql = " SELECT projectID, description, complexity, hireID, paymentAmount, expectedDurationID, deadlineDate "
                        + " FROM Project P INNER JOIN (SELECT projectID FROM NeededSkills N, Skill S WHERE S.skillName like ? AND S.skillID = N.skillID) D "
                        + " ON P.projectID=D.projectID ";

                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + skill + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int projectID = Integer.parseInt(rs.getString("projectID"));
                    String description = rs.getString("description");
                    String complexity = rs.getString("complexity");
                    int hireID = Integer.parseInt(rs.getString("hireID"));
                    double paymentAmount = Double.parseDouble(rs.getString("paymentAmount"));
                    int expectedDurationID = Integer.parseInt(rs.getString("expectedDurationID"));
                    String deadlineDate = rs.getString("deadlineDate");

                    list.add(new ProjectDTO(projectID, description, complexity, hireID, paymentAmount, expectedDurationID, deadlineDate));
                }
            }
        } catch (Exception e) {
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

    public List<ProjectDTO> getListProjectBestMatch(String seekerID) throws SQLException {
        //Base on skill match
        List<ProjectDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {

                String sql = " SELECT projectID, description, complexity, hireID, paymentAmount, expectedDurationID, deadlineDate"
                        + " FROM Project P,"
                        + " (SELECT N.projectID, COUNT(skillID)AS matchSkill"
                        + " FROM NeededSkills N,HasSkill H"
                        + " WHERE H.seekerID = ? AND N.skillID = H.skillID"
                        + " GROUP BY N.projectID"
                        + " ORDER BY COUNT(skillID) DESC) Q"
                        + " WHERE P.projectID = Q.projectID";

                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + seekerID + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int projectID = Integer.parseInt(rs.getString("projectID"));
                    String description = rs.getString("description");
                    String complexity = rs.getString("complexity");
                    int hireID = Integer.parseInt(rs.getString("hireID"));
                    double paymentAmount = Double.parseDouble(rs.getString("paymentAmount"));
                    int expectedDurationID = Integer.parseInt(rs.getString("expectedDurationID"));
                    String deadlineDate = rs.getString("deadlineDate");

                    list.add(new ProjectDTO(projectID, description, complexity, hireID, paymentAmount, expectedDurationID, deadlineDate));
                }
            }
        } catch (Exception e) {
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
    
    public List<ProjectDTO> getListProjectBaseOnPrice(int price1, int price2) throws SQLException {
        //price1 < price2 
        List<ProjectDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {

                String sql = " SELECT projectID, description, complexity, hireID, paymentAmount, expectedDurationID, deadlineDate "
                        + " FROM Project"
                        + " WHERE paymentAmount BETWEEN ? AND ?";

                stm = conn.prepareStatement(sql);
                stm.setInt(1, price1);
                stm.setInt(2, price2);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int projectID = Integer.parseInt(rs.getString("projectID"));
                    String description = rs.getString("description");
                    String complexity = rs.getString("complexity");
                    int hireID = Integer.parseInt(rs.getString("hireID"));
                    double paymentAmount = Double.parseDouble(rs.getString("paymentAmount"));
                    int expectedDurationID = Integer.parseInt(rs.getString("expectedDurationID"));
                    String deadlineDate = rs.getString("deadlineDate");

                    list.add(new ProjectDTO(projectID, description, complexity, hireID, paymentAmount, expectedDurationID, deadlineDate));
                }
            }
        } catch (Exception e) {
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
    
    public List<ProjectDTO> getListProjectByMajor(String major) throws SQLException {
        List<ProjectDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = " SELECT projectID, description, complexity, hireID, paymentAmount, expectedDurationID, deadlineDate "
                        + " FROM Project P, Major M"
                        + " WHERE P.majorID = M.majorID AND M.majorName like ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + major + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int projectID = Integer.parseInt(rs.getString("projectID"));
                    String description = rs.getString("description");
                    String complexity = rs.getString("complexity");
                    int hireID = Integer.parseInt(rs.getString("hireID"));
                    double paymentAmount = Double.parseDouble(rs.getString("paymentAmount"));
                    int expectedDurationID = Integer.parseInt(rs.getString("expectedDurationID"));
                    String deadlineDate = rs.getString("deadlineDate");

                    list.add(new ProjectDTO(projectID, description, complexity, hireID, paymentAmount, expectedDurationID, deadlineDate));
                }
            }
        } catch (Exception e) {
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
    
    public List<ProjectDTO> getListProjectByExperienceLevel(String experienceLevel) throws SQLException {
        List<ProjectDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = " SELECT projectID, description, complexity, hireID, paymentAmount, expectedDurationID, deadlineDate "
                        + " FROM Project P, Complexity C"
                        + " WHERE P.complexityID = C.complexityID AND C.complexityName like ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + experienceLevel + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int projectID = Integer.parseInt(rs.getString("projectID"));
                    String description = rs.getString("description");
                    String complexity = rs.getString("complexity");
                    int hireID = Integer.parseInt(rs.getString("hireID"));
                    double paymentAmount = Double.parseDouble(rs.getString("paymentAmount"));
                    int expectedDurationID = Integer.parseInt(rs.getString("expectedDurationID"));
                    String deadlineDate = rs.getString("deadlineDate");

                    list.add(new ProjectDTO(projectID, description, complexity, hireID, paymentAmount, expectedDurationID, deadlineDate));
                }
            }
        } catch (Exception e) {
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
