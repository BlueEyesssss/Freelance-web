/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.seeker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            if(con != null){
                ptm = con.prepareStatement(UPDATE_TITLE);
                ptm.setString(1, overview);
                ptm.setInt(2, seekerID);
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
    
    public boolean UpdateMoneyPerHour(int seekerID, int moneyPerHour)throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if(con != null){
                ptm = con.prepareStatement(UPDATE_MONEY_PER_HOUR);
                ptm.setInt(1, moneyPerHour);
                ptm.setInt(2, seekerID);
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
    
    public boolean Updatetitle(int seekerID, String titileBio) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if(con != null){
                ptm = con.prepareStatement(UPDATE_TITLE);
                ptm.setString(1, titileBio);
                ptm.setInt(2, seekerID);
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
    
    public boolean UpdateMajor(int seekerID, String major)  throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if(con != null){
                ptm = con.prepareStatement(UPDATE_MAJOR);
                ptm.setString(1, major);
                ptm.setInt(2, seekerID);
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
    
    public boolean UpdateDegree(int seekerID, String degree) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if(con != null){
                ptm = con.prepareStatement(UPDATE_DEGREE);
                ptm.setString(1, degree);
                ptm.setInt(2, seekerID);
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
    
    public boolean UpdateEducation(int seekerID, String education) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if(con != null){
                ptm = con.prepareStatement(UPDATE_EDUCATION);
                ptm.setString(1, education);
                ptm.setInt(2, seekerID);
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
    
    public boolean UpdateHourPerWeekSeeker(int seekerID, String hourPerWeek) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if(con != null){
                ptm = con.prepareStatement(UPDATE_HOUR_PER_WEEK);
                ptm.setString(1, hourPerWeek);
                ptm.setInt(2, seekerID);
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


    

    

    

    


}
