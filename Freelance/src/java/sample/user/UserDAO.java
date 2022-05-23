/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sample.hirer.HirerDTO;
import sample.seeker.SeekerDTO;
import sample.util.DBUtil;

/**
 *
 * @author LENOVO
 */
public class UserDAO {

    private static final String GET_USER = "SELECT  userID, password, userName, fullName, email, phone, location, registrationDate, balance FROM [User] WHERE userName = ? AND password = ?";
    private static final String CHECK_ACC_SEEKER = "SELECT seekerID, overview, titileBio, moneyPerHour, education FROM Seeker WHERE seekerID = ?";
    private static final String CHECK_ACC_HIRER = "SELECT hirerID, conpanyName FROM Hirer WHERE hirerID = ?";

    public HirerDTO checkAccHirer(String userID) throws SQLException {
        HirerDTO hirer = null;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(CHECK_ACC_HIRER);
                ptm.setString(1, userID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int hirerID = rs.getInt("hirerID");
                    String conpanyName = rs.getString("conpanyName");
                    hirer = new HirerDTO(hirerID, conpanyName);
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
        return hirer;
    }
    
    public SeekerDTO checkAccSeeker(String userID) throws SQLException {
        SeekerDTO seeker = null;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(CHECK_ACC_SEEKER);
                ptm.setString(1, userID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int seekerID = rs.getInt("seekerID");
                    String overview = rs.getString("overview");
                    String titileBio = rs.getString("titileBio");
                    int moneyPerHour = rs.getInt("moneyPerHour");
                    String education = rs.getString("education");
                    seeker = new SeekerDTO(seekerID, overview, titileBio, moneyPerHour, education);
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
        return seeker;
    }

    public UserDTO getUser(String username, String password) throws SQLException {
        UserDTO user = null;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(GET_USER);
                ptm.setString(1, username);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String userID = rs.getString("userID");
                    String pass = rs.getString("password");
                    String userName = rs.getString("userName");
                    String fullName = rs.getString("fullName");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    String location = rs.getString("location");
                    String registrationDate = rs.getString("registrationDate");
                    float balance = rs.getFloat("balance");
                    user = new UserDTO(userID, password, userName, fullName, email, phone, location, registrationDate, balance);
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
        return user;
    }

    

}
