/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

/**
 *
 * @author FRIDAH
 */



import com.mycompany.config.DatabaseConnection;
import com.mycompany.model.Contact;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ContactDAO {
    
    public void addContact(Contact contact) throws SQLException {
        String sql = "INSERT INTO contacts (full_name, phone_number, email, id_number, dob, gender, organization, masked_name, masked_phone, hashed_phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contact.getFullName());
            stmt.setString(2, contact.getPhoneNumber());
            stmt.setString(3, contact.getEmail());
            stmt.setString(4, contact.getIdNumber());
            stmt.setString(5, contact.getDob());
            stmt.setString(6, contact.getGender());
            stmt.setString(7, contact.getOrganization());
            stmt.setString(8, maskName(contact.getFullName()));
            stmt.setString(9, maskPhone(contact.getPhoneNumber()));
            stmt.setString(10, hashPhone(contact.getPhoneNumber()));

            stmt.executeUpdate();
        }
    }

    public List<Contact> getAllContacts() throws SQLException {
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT * FROM contacts";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Contact contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setFullName(rs.getString("full_name"));
                contact.setPhoneNumber(rs.getString("phone_number"));
                contact.setEmail(rs.getString("email"));
                contact.setIdNumber(rs.getString("id_number"));
                contact.setDob(rs.getString("dob"));
                contact.setGender(rs.getString("gender"));
                contact.setOrganization(rs.getString("organization"));
                contact.setMaskedName(rs.getString("masked_name"));
                contact.setMaskedPhone(rs.getString("masked_phone"));
                contact.setHashedPhone(rs.getString("hashed_phone"));
                
                contacts.add(contact);
            }
        }
        return contacts;
    }

    private String maskName(String fullName) {
        return fullName.split(" ")[0] + " ***";
    }

    private String maskPhone(String phoneNumber) {
        return phoneNumber.substring(0, 3) + "***" + phoneNumber.substring(phoneNumber.length() - 3);
    }

    private String hashPhone(String phoneNumber) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(phoneNumber.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing phone number", e);
        }
    }
}
