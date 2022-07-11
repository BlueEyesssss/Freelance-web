/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sample.util.DBUtil;

/**
 *
 * @author LENOVO
 */
public class PaymentDAO {

    private static final String GET_CLIENT_ID_SECRET = "SELECT userID, CLIENT_ID, CLIENT_SECRET\n"
            + "FROM PaymentFLC\n"
            + "WHERE userID = ?";
    
    private static final String UPDATE_CLIENT_ID_SECRET_OF_SEEKER = "UPDATE PaymentFLC\n" +
"SET CLIENT_ID = ?, CLIENT_SECRET = ?\n" +
"WHERE userID = ?";

    private static final String INSERT_NEW_PAYPAL_ACCOUNT_SEEKER = "INSERT INTO PaymentFLC(userID, CLIENT_ID, CLIENT_SECRET)\n" +
"VALUES\n" +
"(?, ?, ?)";
    
    public boolean createPayPalInf(PayPayDTO payPayDTO) throws SQLException {
         boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT_NEW_PAYPAL_ACCOUNT_SEEKER);
                ptm.setInt(1, payPayDTO.getSeekerID());
                ptm.setString(2, payPayDTO.getClient_id());
                ptm.setString(3, payPayDTO.getClient_secret());
                
                check = ptm.executeUpdate() > 0?true:false;
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
    
    
    public boolean updateClientIdSecretOfSeeker(int userID, String client_id, String client_secret) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_CLIENT_ID_SECRET_OF_SEEKER);
                ptm.setString(1, client_id);
                ptm.setString(2, client_secret);
                ptm.setInt(3, userID);
                check = ptm.executeUpdate() > 0?true:false;
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
    
    public String getClientID(int parseInt) throws SQLException {
        String id = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_CLIENT_ID_SECRET);
                ptm.setInt(1, parseInt);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    id = rs.getString("CLIENT_ID");
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
        return id;
    }

    public String getClientSecret(int parseInt) throws SQLException {
        String secret = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_CLIENT_ID_SECRET);
                ptm.setInt(1, parseInt);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    secret = rs.getString("CLIENT_SECRET");
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
        return secret;
    }

    

    

    
}
