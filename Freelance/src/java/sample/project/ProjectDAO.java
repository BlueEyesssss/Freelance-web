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
    private static final String WIEW_BEST_MATCH_PROJECT = "SELECT P.projectID,projectName, description, complexity, H.conpanyName, paymentAmount, E.durationText, deadlineDate\n"
            + "                         FROM Project P,Hirer H, ExpectedDuration E,\n"
            + "                         (SELECT N.projectID, COUNT(N.skillID)AS matchSkill\n"
            + "                         FROM NeededSkills N,HasSkill H\n"
            + "                          WHERE H.seekerID = ? AND N.skillID = H.skillID\n"
            + "                         GROUP BY N.projectID) Q\n"
            + "						 WHERE P.projectID = Q.projectID AND P.hirerID = H.hirerID AND E.expectedDurationID = P.expectedDurationID\n"
            + "                         ORDER BY matchSkill DESC";
    private static final String WIEW_LIST_PROJECT_BASE_ON_NAME = " SELECT projectID, projectName, description, complexity, H.conpanyName, paymentAmount,P.expectedDurationID , E.durationText, deadlineDate "
            + " FROM Project P, Hirer H, ExpectedDuration E "
            + " WHERE P.projectName like ? AND P.hirerID = H.hirerID AND E.expectedDurationID = P.expectedDurationID";
    
    private static final String CHECK_DUPLICATE = "SELECT projectID, seekerID\n"
            + "FROM FavoriteProject\n"
            + "WHERE projectID = ? and seekerID = ?";
    private static final String DELETE_FAVORITE_PROJECT = "DELETE FROM FavoriteProject\n"
            + "WHERE projectID = ? and seekerID = ?";
    
     public boolean checkDuplicate(int projectID, int seekerID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setInt(1, projectID);
                ptm.setInt(2, seekerID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
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

        return check;
    }

    public boolean deleteFavoriteProject(int projectID, int seekerID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_FAVORITE_PROJECT);
                ptm.setInt(1, projectID);
                ptm.setInt(2, seekerID);
                check = ptm.executeUpdate() > 0;
                if (check) {
                    check = true;
                }
//                if (rs.next()) {
//                    check = true;
//                }
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
                String sql = WIEW_LIST_PROJECT_BASE_ON_NAME;
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

    public List<ProjectDTO> getListProjectBestMatch(int seekerID) throws SQLException {
        //Base on skill match
        List<ProjectDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {

                String sql = WIEW_BEST_MATCH_PROJECT;

                stm = conn.prepareStatement(sql);
                stm.setInt(1, seekerID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int projectID = Integer.parseInt(rs.getString("projectID"));
                    String projectName = rs.getString("projectName");
                    String description = rs.getString("description");
                    String complexity = rs.getString("complexity");
                    String hirer = rs.getString("conpanyName");
                    double paymentAmount = Double.parseDouble(rs.getString("paymentAmount"));
                    String expectedDurationID = rs.getString("durationText");
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
    
    public List<ProjectDTO> getListProjectByHirerName(List<ProjectDTO> listBeforeFilter, String hirer) throws SQLException {
        List<ProjectDTO> list = new ArrayList<>();

        try {
            for (ProjectDTO project : listBeforeFilter) {
                if (project.getHirer().equalsIgnoreCase(hirer)) {
                    list.add(project);
                }
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<ProjectDTO> getListProjectBaseOnPrice(List<ProjectDTO> listBeforeFilter,int price1, int price2) throws SQLException {
        //price1 < price2 
        List<ProjectDTO> list = new ArrayList<>();
        try {
            for (ProjectDTO project : listBeforeFilter) {
                if (project.getPaymentAmount() >= price1 & project.getPaymentAmount() <= price2) {
                    list.add(project);
                }
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<ProjectDTO> getListProjectByExperienceLevel(List<ProjectDTO> listBeforeFilter,String experienceLevel) throws SQLException {
        List<ProjectDTO> list = new ArrayList<>();
        try {
            for (ProjectDTO project : listBeforeFilter) {
                if (project.getComplexity().equalsIgnoreCase(experienceLevel)) {
                    list.add(project);
                }
            }
        } catch (Exception e) {
        }
        return list;
    }
}
