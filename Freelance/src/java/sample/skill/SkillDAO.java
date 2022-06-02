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
    private final String GET_SKILL_NAME = "SELECT skillName FROM Skill WHERE skillID = ?";

    public String getSkillNameByID(int nameSkill) throws SQLException {
        String name = null;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(GET_SKILL_NAME);
                ptm.setInt(1, nameSkill);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    name = rs.getString("skillName");
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
        return name;
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
