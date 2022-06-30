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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import sample.hirer.HirerDTO;
import sample.seeker.SeekerDTO;
import sample.skill.SkillDTO;
import sample.util.DBUtil;

/**
 *
 * @author LENOVO
 */
public class UserDAO {

    private static final String GET_USER = "SELECT userID, password, userName, fullName, email, phone, location, registrationDate, balance, avatar, language, languagelv FROM [User] WHERE userName = ? AND password = ?";
    private static final String CHECK_ACC_SEEKER = "SELECT seekerID, overview, titileBio, moneyPerHour, education, degree, major, hourPerWeek FROM Seeker WHERE seekerID = ?";
    private static final String CHECK_ACC_HIRER = "SELECT hirerID, companyName FROM Hirer WHERE hirerID = ?";
    private static final String CREATE_USER = "INSERT INTO [User](password, userName, fullName, email, phone, location, registrationDate, balance, avatar) VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String CREATE_HIRER = "INSERT INTO Hirer(hirerID, companyName) VALUES(?, ?)";
    private static final String CREATE_SEEKER = "INSERT INTO Seeker(seekerID, overview, titileBio, moneyPerHour, education, degree, major) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String COUNT_EMAIL = "SELECT COUNT(*) as countEmail FROM [User] WHERE email = ?";
    private static final String CHECK_EXIST_EMAIL = "USE FreelanceManagement\n" +
"SELECT email \n" +
"FROM [User] \n" +
"WHERE email = ?";
    private static final String UPDATE_USER_PROFILE = "UPDATE [User] SET userName = ?, fullName = ?, email = ?, location = ?,password = ? WHERE userID = ?";
    private static final String UPDATE_SEEKER_PROFILE = "UPDATE Seeker SET overview = ?, titileBio = ?, moneyPerHour = ?,education = ?, degree = ?, major = ?  WHERE seekerID = ?";
    private static final String GET_USER_BY_EMAIL = "SELECT  userID, password, userName, fullName, email, phone, location, registrationDate, balance, avatar FROM [User] WHERE email = ?";
    private static final String CHECK_DUPLICATE_USERNAME = "SELECT userName FROM [User] WHERE userName = ?";
    private static final String UPDATE_LANGUAGE_LV = "UPDATE [User] SET languagelv = ? WHERE userID = ?";
    private static final String UPDATE_PASSWORD = "UPDATE [User] SET password = ? WHERE userID = ?";
    
        private static final String GET_LIST_ALL_USER = "SELECT U.userID, U.location, U.registrationDate\n" +
"FROM [User] U";
        
        public List<UserDTO> getListUser() throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
               
                stm = conn.prepareStatement(GET_LIST_ALL_USER);
            
                rs = stm.executeQuery();
                while (rs.next()) {
                    int userID = rs.getInt("userID");
                    String location = rs.getString("location");
                    
                    String registrationDate = rs.getString("registrationDate");
                    
                    list.add(new UserDTO(userID, location, registrationDate));
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

        
        

    public boolean checkSkillMatch(int SkillID, List<SkillDTO> listSkill){
        boolean check = false;
        for (SkillDTO ele : listSkill) {
            if(ele.getSkillID() == SkillID){
                check = true;
            }
        }
        return check;
    }
    
    public boolean UpdatePassword(int seekerID, String newpassword) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if(con != null){
                ptm = con.prepareStatement(UPDATE_PASSWORD);
                ptm.setString(1, newpassword);
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
    
    public boolean UpdateLanguageLv(int seekerID, String languagelv) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if(con != null){
                ptm = con.prepareStatement(UPDATE_LANGUAGE_LV);
                ptm.setString(1, languagelv);
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
    
    public boolean checkDuplicateUsername(String userName) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(CHECK_DUPLICATE_USERNAME);
                ptm.setString(1, userName);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
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
        return check;
    }
    
    public UserDTO getUser(String email) throws SQLException {
        UserDTO user = null;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(GET_USER_BY_EMAIL);
                ptm.setString(1, email);
                
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int userID = rs.getInt("userID");
                    String password = rs.getString("password");
                    String userName = rs.getString("userName");
                    String fullName = rs.getString("fullName");
                    
                    String phone = rs.getString("phone");
                    String location = rs.getString("location");
                    String registrationDate = rs.getString("registrationDate");
                    float balance = rs.getFloat("balance");
                    String avatar = rs.getString("avatar");
                    user = new UserDTO(userID, password, userName, fullName, email, phone, location, registrationDate, balance, avatar);
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
    
    public boolean checkDuplicateEmail(String email) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(CHECK_EXIST_EMAIL);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                if(rs.next()){
                    check = true;
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
        return check;
    }

    public boolean UpdateSeekerProfile(SeekerDTO seeker) throws SQLException {
         boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(UPDATE_SEEKER_PROFILE);
                ptm.setString(1, seeker.getOverview());
                ptm.setString(2, seeker.getTitileBio());
                ptm.setInt(3, seeker.getMoneyPerHour());
                ptm.setString(4, seeker.getEducation());
                ptm.setString(5, seeker.getDegree());
                ptm.setString(6, seeker.getMajor());
                ptm.setInt(7, seeker.getSeekerID());
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
    
    public boolean UpdateUserProfile(UserDTO user) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(UPDATE_USER_PROFILE);
                ptm.setString(1, user.getUserName());
                ptm.setString(2, user.getFullName());
                ptm.setString(3, user.getEmail());
                ptm.setString(4, user.getLocation());
                ptm.setString(5, user.getPassword());
                ptm.setInt(6, user.getUserID());
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
    
    public int checkEmailExist(String email) throws SQLException {
        int check = 0;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(COUNT_EMAIL);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                if(rs.next()){
                    check = Integer.parseInt(rs.getString("countEmail"));
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
        return check;
    }
    
    public boolean createSeeker(SeekerDTO seeker) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(CREATE_SEEKER);
                ptm.setInt(1, seeker.getSeekerID());
                ptm.setString(2, seeker.getOverview());
                ptm.setString(3, seeker.getTitileBio());
                ptm.setInt(4, seeker.getMoneyPerHour());
                ptm.setString(5, seeker.getEducation());
                ptm.setString(6, seeker.getDegree());
                ptm.setString(7, seeker.getMajor());
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
    
    public boolean createHirer(HirerDTO hirer) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(CREATE_HIRER);
                ptm.setInt(1, hirer.getHirerID());
                ptm.setString(2, hirer.getCompanyName());
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
    
    public boolean createUser(UserDTO user) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(CREATE_USER);
                ptm.setString(1, user.getPassword());
                ptm.setString(2, user.getUserName());
                ptm.setString(3, user.getFullName());
                ptm.setString(4, user.getEmail());
                ptm.setString(5, user.getPhone());
                ptm.setString(6, user.getLocation());
                ptm.setString(7, user.getRegistrationDate());
                ptm.setFloat(8, user.getBalance());
                ptm.setString(9, user.getAvatar());
                check = ptm.executeUpdate()>0?true:false;
            }
        }  finally {
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }
    
    public HirerDTO checkAccHirer(int userID) throws SQLException {
        HirerDTO hirer = null;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(CHECK_ACC_HIRER);
                ptm.setInt(1, userID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int hirerID = rs.getInt("hirerID");
                    String conpanyName = rs.getString("companyName");
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
    
    public SeekerDTO checkAccSeeker(int userID) throws SQLException {
        SeekerDTO seeker = null;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(CHECK_ACC_SEEKER);
                ptm.setInt(1, userID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int seekerID = rs.getInt("seekerID");
                    String overview = rs.getString("overview");
                    String titileBio = rs.getString("titileBio");
                    int moneyPerHour = rs.getInt("moneyPerHour");
                    String education = rs.getString("education");
                    String degree = rs.getString("degree");
                    String major = rs.getString("major");
                    String hourPerWeek = rs.getString("hourPerWeek");
                    seeker = new SeekerDTO(seekerID, overview, titileBio, moneyPerHour, education, degree, major, hourPerWeek);
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
                    int userID = rs.getInt("userID");
                    password = rs.getString("password");
                    String userName = rs.getString("userName");
                    String fullName = rs.getString("fullName");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    String location = rs.getString("location");
                    String registrationDate = rs.getString("registrationDate");
                    float balance = rs.getFloat("balance");
                    String avatar = rs.getString("avatar");
                    String language = rs.getString("language");
                    String languagelv = rs.getString("languagelv");
                    user = new UserDTO(userID, password, userName, fullName, email, phone, location, registrationDate, balance, avatar, language, languagelv);
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
    
    private static final String ADD_MONEY_BY_USERID = "UPDATE [User] SET balance = ? WHERE userID = ?";
    public boolean addMoneyToUserByUserID(double paymentAmount, int userID) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(ADD_MONEY_BY_USERID);
                ptm.setDouble(1, paymentAmount);
                ptm.setInt(2, userID);
                
                check = ptm.executeUpdate() > 0?true:false;
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
    
    private static final String GET_USER_BY_ID = "SELECT userID, password, userName, fullName, email, phone, location, registrationDate, balance, avatar, language, languagelv FROM [User] WHERE userID = ?";;
    public UserDTO getUserByID(int userID) throws SQLException {
        UserDTO user = null;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(GET_USER_BY_ID);
                ptm.setInt(1, userID);
                
                rs = ptm.executeQuery();
                if (rs.next()) {
                    userID = rs.getInt("userID");
                    String password = rs.getString("password");
                    String userName = rs.getString("userName");
                    String fullName = rs.getString("fullName");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    String location = rs.getString("location");
                    String registrationDate = rs.getString("registrationDate");
                    float balance = rs.getFloat("balance");
                    String avatar = rs.getString("avatar");
                    String language = rs.getString("language");
                    String languagelv = rs.getString("languagelv");
                    user = new UserDTO(userID, password, userName, fullName, email, phone, location, registrationDate, balance, avatar, language, languagelv);
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
