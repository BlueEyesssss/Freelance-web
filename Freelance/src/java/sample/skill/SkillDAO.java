/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.skill;

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
public class SkillDAO {

    private final String GET_LIST_SKILL = "SELECT skillID, skillName FROM Skill";
    private final String CREATE_SKILL_SEEKER_HAS = "INSERT INTO HasSkill(skillID, seekerID) VALUES (?, ?)";
    private final String CREATE_SKILL_NEED_FOR_PROJECT = "INSERT INTO NeededSkills(projectID, skillID) VALUES (?, ?)";
    private final String GET_LIST_SKILL_OF_SEEKER = "SELECT hs.seekerID ,hs.skillID, s.skillName FROM HasSkill hs inner join Skill s on hs.skillID = s.skillID WHERE seekerID = ?";
    private final String CLEAR_SKILL = "DELETE FROM HasSkill WHERE seekerID = ?";
    private final String CLEAR_SKILL_NEED_OF_PROJECT = "DELETE FROM NeededSkills WHERE projectID = ?";

    public boolean clearSkillSeeker(int seekerID)  throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(CLEAR_SKILL);
                ptm.setInt(1, seekerID);
                check = ptm.executeUpdate()>0?true:false;
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
    
    public List<SkillDTO> getListSkillIDOfSeeker(int seekerID) throws SQLException {
        List<SkillDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(GET_LIST_SKILL_OF_SEEKER);
                ptm.setInt(1, seekerID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int skillID = rs.getInt("skillID");
                    String skillName = rs.getString("skillName");
                    list.add(new SkillDTO(skillID, skillName));
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
        return list;
    }
    
    public boolean createSkillSeekerHas(int skillID, int seekerID) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(CREATE_SKILL_SEEKER_HAS);
                ptm.setInt(1, skillID);
                ptm.setInt(2, seekerID);
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
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public List<SkillDTO> getListSkill() throws SQLException {
        List<SkillDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(GET_LIST_SKILL);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int skillID = rs.getInt("skillID");
                    String skillName = rs.getString("skillName");
                    list.add(new SkillDTO(skillID, skillName));
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
        return list;
    }

    public boolean clearSkillNeedOfProject(int projectID) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(CLEAR_SKILL_NEED_OF_PROJECT);
                ptm.setInt(1, projectID);
                check = ptm.executeUpdate()>0;
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

    public boolean updateSkillNeedOfProject(int projectID,int skillID) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(CREATE_SKILL_NEED_FOR_PROJECT);
                ptm.setInt(1, projectID);
                ptm.setInt(2, skillID);
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
            if (con != null) {
                con.close();
            }
        }
        return check;
    }
    
    private static final String DELETE_NEEDED_SKILL = "DELETE FROM NeededSkills WHERE projectID = ?";
    public boolean deleteNeededSkillOfProject(int projectID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_NEEDED_SKILL);
                ptm.setInt(1, projectID);

                check = ptm.executeUpdate() > 0;
                if (check) {
                    check = true;
                }
//                
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

    

    

}
