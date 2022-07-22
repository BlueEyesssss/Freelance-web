/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.seeker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import sample.util.DBUtil;

/**
 *
 * @author LENOVO
 */
public class SeekerDAO {

    private static final String UPDATE_HOUR_PER_WEEK = "UPDATE Seeker SET hourPerWeek = ? WHERE seekerID = ?";
    private static final String UPDATE_EDUCATION = "UPDATE Seeker SET education = ? WHERE seekerID = ?";
    private static final String UPDATE_DEGREE = "UPDATE Seeker SET degree = ? WHERE seekerID = ?";
    private static final String UPDATE_MAJOR = "UPDATE Seeker SET major = ? WHERE seekerID = ?";
    private static final String UPDATE_TITLE = "UPDATE Seeker SET titileBio = ? WHERE seekerID = ?";
    private static final String UPDATE_MONEY_PER_HOUR = "UPDATE Seeker SET moneyPerHour = ? WHERE seekerID = ?";
    private static final String UPDATE_OVERVIEW = "UPDATE Seeker SET overview = ? WHERE seekerID = ?";

    public boolean UpdateOverview(int seekerID, String overview) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(UPDATE_OVERVIEW);
                ptm.setString(1, overview);
                ptm.setInt(2, seekerID);
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

    public boolean UpdateMoneyPerHour(int seekerID, int moneyPerHour) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(UPDATE_MONEY_PER_HOUR);
                ptm.setInt(1, moneyPerHour);
                ptm.setInt(2, seekerID);
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

    public boolean Updatetitle(int seekerID, String titileBio) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(UPDATE_TITLE);
                ptm.setString(1, titileBio);
                ptm.setInt(2, seekerID);
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

    public boolean UpdateMajor(int seekerID, String major) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(UPDATE_MAJOR);
                ptm.setString(1, major);
                ptm.setInt(2, seekerID);
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

    public boolean UpdateDegree(int seekerID, String degree) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(UPDATE_DEGREE);
                ptm.setString(1, degree);
                ptm.setInt(2, seekerID);
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

    public boolean UpdateEducation(int seekerID, String education) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(UPDATE_EDUCATION);
                ptm.setString(1, education);
                ptm.setInt(2, seekerID);
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

    public boolean UpdateHourPerWeekSeeker(int seekerID, String hourPerWeek) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(UPDATE_HOUR_PER_WEEK);
                ptm.setString(1, hourPerWeek);
                ptm.setInt(2, seekerID);
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

    //ham them vo boi tanphat
    private static final String GET_SKILL_SEEKER_HAVE = "SELECT skillName\n"
            + "FROM Seeker A, HasSkill B, Skill C\n"
            + "WHERE A.seekerID = B.seekerID and B.skillID = C.skillID\n"
            + "and A.seekerID = ?";

    public List<String> getSkillSeekerHave(int seekerID) throws SQLException {
        List<String> skillHave = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_SKILL_SEEKER_HAVE);
                ptm.setInt(1, seekerID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String skillName = rs.getString("skillName");
                    skillHave.add(skillName);

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
        return skillHave;
    }

    private static final String GET_REVIEW_GRADE = "SELECT AVG(a.seekerGrade) AS reviewGrade\n"
            + "FROM Proposal a, Seeker b\n"
            + "WHERE a.seekerID = b.seekerID and (a.proposalStatusID = 6 or a.proposalStatusID = 7)\n"
            + "and a.seekerID = ?";

    public int getReviewGrade(int seekerID) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        int reviewGrade = 0;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_REVIEW_GRADE);
                ptm.setInt(1, seekerID);
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
    
    private static final String GET_LIST_ALL_SEEKRER = "SELECT * \n" +
" FROM Seeker";
    
    public List<SeekerDTO> getListSeeker() throws SQLException {
        List<SeekerDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
               
                stm = conn.prepareStatement(GET_LIST_ALL_SEEKRER);
            
                rs = stm.executeQuery();
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
