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

    private static final String GET_CLIENT_ID_SECRET = "SELECT seekerID, CLIENT_ID, CLIENT_SECRET\n"
            + "FROM PaymentFLC\n"
            + "WHERE seekerID = ?";

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
