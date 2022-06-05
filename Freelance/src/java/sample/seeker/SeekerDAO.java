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
