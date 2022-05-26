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

    private static final String VIEW_ALL_PROJECT = "SELECT projectID, description, complexity, projectName, paymentAmount, durationText, deadlineDate\n"
            + "FROM Project P, ExpectedDuration E\n"
            + "WHERE P.expectedDurationID = E.expectedDurationID";
    private static final String CREATE_NEW_FAVORITE_PROJECT = "INSERT INTO FavoriteProject(projectID, seekerID) VALUES(?,?)";
    private static final String VIEW_FAVORITE_PROJECT = "SELECT FavoriteProject.projectID, description, complexity, projectName, paymentAmount, durationText, deadlineDate FROM FavoriteProject, Project, Seeker, ExpectedDuration WHERE FavoriteProject.projectID = Project.projectID and FavoriteProject.seekerID = Seeker.seekerID and ExpectedDuration.expectedDurationID = Project.expectedDurationID and FavoriteProject.seekerID = ?";

    public List<ProjectDTO> getListFavoriteProject(int seekerID) throws SQLException {
        List<ProjectDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_FAVORITE_PROJECT);
                ptm.setInt(1, seekerID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int projectID = rs.getInt("projectID");
                    String description = rs.getString("description");
                    String complexity = rs.getString("complexity");
                    String projectName = rs.getString("projectName");
                    double paymentAmount = rs.getDouble("paymentAmount");
                    String durationText = rs.getString("durationText");
                    String deadlineDate = rs.getString("deadlineDate");

                    list.add(new ProjectDTO(projectID, projectName, description, complexity, paymentAmount, durationText, deadlineDate));

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

    public List<ProjectDTO> getListAllProject() throws SQLException {
        List<ProjectDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_ALL_PROJECT);
                //ptm.setString(1, "%"+search+"%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int projectID = rs.getInt("projectID");
                    String description = rs.getString("description");
                    String complexity = rs.getString("complexity");
                    String projectName = rs.getString("projectName");
                    double paymentAmount = rs.getDouble("paymentAmount");
                    String durationText = rs.getString("durationText");
                    String deadlineDate = rs.getString("deadlineDate");

                    list.add(new ProjectDTO(projectID, projectName, description, complexity, paymentAmount, durationText, deadlineDate));

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

    public boolean createNewFavoriteProject(int projectID, int seekerID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ProjectDTO project = new ProjectDTO();
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_NEW_FAVORITE_PROJECT);
                ptm.setInt(1, projectID);
                ptm.setInt(2, seekerID);
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

    public List<ProjectDTO> getListProjectByName(String search) throws SQLException {
        List<ProjectDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = " SELECT projectID, projectName, description, complexity, H.conpanyName, paymentAmount,P.expectedDurationID , E.durationText, deadlineDate "
                        + " FROM Project P, Hirer H, ExpectedDuration E "
                        + " WHERE P.projectName like ? AND P.hirerID = H.hirerID AND E.expectedDurationID = P.expectedDurationID";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int projectID = Integer.parseInt(rs.getString("projectID"));
                    String description = rs.getString("description");
                    String projectName = rs.getString("projectName");
                    String complexity = rs.getString("complexity");
                    String hirer = rs.getString("conpanyName");
                    double paymentAmount = Double.parseDouble(rs.getString("paymentAmount"));
                    String expectedDurationID = rs.getString("expectedDurationID");
                    String deadlineDate = rs.getString("deadlineDate");

                    list.add(new ProjectDTO(projectID, projectName, description, complexity, hirer, paymentAmount, expectedDurationID, deadlineDate));
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

    public List<ProjectDTO> getListProjectBySkill(String skill) throws SQLException {
        List<ProjectDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {

                String sql = " SELECT projectID,projectName, description, complexity, hireID, paymentAmount, expectedDurationID, deadlineDate "
                        + " FROM Project P INNER JOIN (SELECT projectID FROM NeededSkills N, Skill S WHERE S.skillName like ? AND S.skillID = N.skillID) D "
                        + " ON P.projectID=D.projectID";

                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + skill + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int projectID = Integer.parseInt(rs.getString("projectID"));
                    String description = rs.getString("description");
                    String projectName = rs.getString("projectName");
                    String complexity = rs.getString("complexity");
                    String hirer = rs.getString("hireID");
                    double paymentAmount = Double.parseDouble(rs.getString("paymentAmount"));
                    String expectedDurationID = rs.getString("expectedDurationID");
                    String deadlineDate = rs.getString("deadlineDate");

                    list.add(new ProjectDTO(projectID, projectName, description, complexity, hirer, paymentAmount, expectedDurationID, deadlineDate));
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

                String sql = " SELECT projectID,projectName, description, complexity, hireID, paymentAmount, expectedDurationID, deadlineDate"
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
                    String projectName = rs.getString("projectName");
                    String description = rs.getString("description");
                    String complexity = rs.getString("complexity");
                    String hirer = rs.getString("hireID");
                    double paymentAmount = Double.parseDouble(rs.getString("paymentAmount"));
                    String expectedDurationID = rs.getString("expectedDurationID");
                    String deadlineDate = rs.getString("deadlineDate");

                    list.add(new ProjectDTO(projectID, projectName, description, complexity, hirer, paymentAmount, expectedDurationID, deadlineDate));
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

                String sql = " SELECT projectID,projectName, description, complexity, hireID, paymentAmount, expectedDurationID, deadlineDate "
                        + " FROM Project"
                        + " WHERE paymentAmount BETWEEN ? AND ?";

                stm = conn.prepareStatement(sql);
                stm.setInt(1, price1);
                stm.setInt(2, price2);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int projectID = Integer.parseInt(rs.getString("projectID"));
                    String projectName = rs.getString("projectName");
                    String description = rs.getString("description");
                    String complexity = rs.getString("complexity");
                    String hirer = rs.getString("hireID");
                    double paymentAmount = Double.parseDouble(rs.getString("paymentAmount"));
                    String expectedDurationID = rs.getString("expectedDurationID");
                    String deadlineDate = rs.getString("deadlineDate");

                    list.add(new ProjectDTO(projectID, projectName, description, complexity, hirer, paymentAmount, expectedDurationID, deadlineDate));
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
                String sql = " SELECT projectID,projectName, description, complexity, hireID, paymentAmount, expectedDurationID, deadlineDate "
                        + " FROM Project P, Major M"
                        + " WHERE P.majorID = M.majorID AND M.majorName like ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + major + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int projectID = Integer.parseInt(rs.getString("projectID"));
                    String projectName = rs.getString("projectName");
                    String description = rs.getString("description");
                    String complexity = rs.getString("complexity");
                    String hirer = rs.getString("hireID");
                    double paymentAmount = Double.parseDouble(rs.getString("paymentAmount"));
                    String expectedDurationID = rs.getString("expectedDurationID");
                    String deadlineDate = rs.getString("deadlineDate");

                    list.add(new ProjectDTO(projectID, projectName, description, complexity, hirer, paymentAmount, expectedDurationID, deadlineDate));
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
                String sql = " SELECT projectID,projectName, description, complexity, hireID, paymentAmount, expectedDurationID, deadlineDate "
                        + " FROM Project"
                        + " WHERE experienceLevelRequire like ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + experienceLevel + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    int projectID = Integer.parseInt(rs.getString("projectID"));
                    String projectName = rs.getString("projectName");
                    String description = rs.getString("description");
                    String complexity = rs.getString("complexity");
                    String hirer = rs.getString("hireID");
                    double paymentAmount = Double.parseDouble(rs.getString("paymentAmount"));
                    String expectedDurationID = rs.getString("expectedDurationID");
                    String deadlineDate = rs.getString("deadlineDate");

                    list.add(new ProjectDTO(projectID, projectName, description, complexity, hirer, paymentAmount, expectedDurationID, deadlineDate));
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
