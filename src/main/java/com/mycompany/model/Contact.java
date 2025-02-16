/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author FRIDAH
 */


public class Contact {
    private int id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String idNumber;
    private String dob;
    private String gender;
    private String organization;
    private String maskedName;
    private String maskedPhone;
    private String hashedPhone;

    // Getters
    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public String getIdNumber() { return idNumber; }
    public String getDob() { return dob; }
    public String getGender() { return gender; }
    public String getOrganization() { return organization; }
    public String getMaskedName() { return maskedName; }
    public String getMaskedPhone() { return maskedPhone; }
    public String getHashedPhone() { return hashedPhone; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmail(String email) { this.email = email; }
    public void setIdNumber(String idNumber) { this.idNumber = idNumber; }
    public void setDob(String dob) { this.dob = dob; }
    public void setGender(String gender) { this.gender = gender; }
    public void setOrganization(String organization) { this.organization = organization; }
    public void setMaskedName(String maskedName) { this.maskedName = maskedName; }
    public void setMaskedPhone(String maskedPhone) { this.maskedPhone = maskedPhone; }
    public void setHashedPhone(String hashedPhone) { this.hashedPhone = hashedPhone; }
}
