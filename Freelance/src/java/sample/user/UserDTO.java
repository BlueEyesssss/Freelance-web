/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

import java.time.LocalDate;

/**
 *
 * @author LENOVO
 */
public class UserDTO {
    private int userID;
    private String password;
    private String userName;
    private String fullName;
    private String email;
    private String phone;
    private String location;
    private String registrationDate;
    private float balance;
    private String avatar;
    private String language;
    private String languagelv;

    UserDTO(int userID, String location, String registrationDate) {
        this.userID = userID;
        this.location = location;
        this.registrationDate = registrationDate;
    }

    public String getLanguagelv() {
        return languagelv;
    }

    public void setLanguagelv(String languagelv) {
        this.languagelv = languagelv;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    //contructor ko có id, language, languagelv argument
    public UserDTO(String password, String userName, String fullName, String email, String phone, String location, String registrationDate, float balance, String avatar) {
        this.password = password;
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.registrationDate = registrationDate;
        this.balance = balance;
        this.avatar = avatar;
        this.language = "English";
        this.languagelv = "Basic";
    }
    
    //contructor ko có language, languagelv argument
    public UserDTO(int userID, String password, String userName, String fullName, String email, String phone, String location, String registrationDate, float balance, String avatar) {
        this.userID = userID;
        this.password = password;
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.registrationDate = registrationDate;
        this.balance = balance;
        this.avatar = avatar;
        this.language = "English";
        this.languagelv = "Basic";
    }

    public UserDTO(int userID, String password, String userName, String fullName, String email, String phone, String location, String registrationDate, float balance, String avatar, String language, String languagelv) {
        this.userID = userID;
        this.password = password;
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.registrationDate = registrationDate;
        this.balance = balance;
        this.avatar = avatar;
        this.language = language;
        this.languagelv = languagelv;
    }

    

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public UserDTO() {
        this.userID = 0;
        this.password = "";
        this.userName = "";
        this.fullName = "";
        this.email = "";
        this.phone = "";
        this.location = "";
        this.registrationDate = "";
        this.balance = 0;
        this.avatar = "https://anhdepfree.com/wp-content/uploads/2019/01/avatar-facebook-mau-den_015640017.jpg";
        this.language = "English";
    }
    

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", password=" + password + ", userName=" + userName + ", fullName=" + fullName + ", email=" + email + ", phone=" + phone + ", location=" + location + ", registrationDate=" + registrationDate + ", balance=" + balance + ", avatar=" + avatar + '}';
    }

    
}
