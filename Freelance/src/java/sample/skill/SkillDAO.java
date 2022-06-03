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

}
