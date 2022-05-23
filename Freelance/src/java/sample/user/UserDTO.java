/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

/**
 *
 * @author LENOVO
 */
public class UserDTO {
    private String userID;
    private String password;
    private String userName;
    private String fullName;
    private String email;
    private String phone;
    private String location;
    private String registrationDate;
    private float balance;

    public UserDTO() {
        this.userID = "";
        this.password = "";
        this.userName = "";
        this.fullName = fullName;
        this.email = "";
        this.phone = "";
        this.location = "";
        this.registrationDate = "";
        this.balance = 0;
    }

    public UserDTO(String userID, String password, String userName, String fullName, String email, String phone, String location, String registrationDate, float balance) {
        this.userID = userID;
        this.password = password;
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.location = location;
        this.registrationDate = registrationDate;
        this.balance = balance;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
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
    
}
