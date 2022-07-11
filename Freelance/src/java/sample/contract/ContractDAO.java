/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.contract;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import sample.util.DBUtil;

/**
 *
 * @author LENOVO
 */
public class ContractDAO {

    private static final String INSERT_CONTRACT = "INSERT INTO Contract(proposalID, paymentAmount,startTime, endtime) \n" +
"VALUES(?,?,?,'2020-01-01')";
    public boolean insertContract(int proposalID, float paymentAmount, LocalDate startTime) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;       
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT_CONTRACT);
                ptm.setInt(1, proposalID);
                ptm.setDouble(2, paymentAmount);
                ptm.setDate(3, Date.valueOf(startTime));
                
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

    private static final String UPDATE_ENDTIME_CONTRACT="UPDATE Contract \n" +
"SET endTime = ? \n" +
"WHERE proposalID = ?";
    public boolean updateEndTimeContract(int proposalID, LocalDate endTime) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;       
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_ENDTIME_CONTRACT);
                ptm.setDate(3, Date.valueOf(endTime));
                ptm.setInt(2, proposalID);               
                
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
   
}
