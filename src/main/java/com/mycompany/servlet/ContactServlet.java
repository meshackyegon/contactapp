/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.servlet;

import com.mycompany.dao.ContactDAO;
import com.mycompany.model.Contact;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author FRIDAH
 */
@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
    private ContactDAO contactDAO;

    @Override
    public void init() throws ServletException {
        contactDAO = new ContactDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data
        String fullName = request.getParameter("fullName");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String idNumber = request.getParameter("idNumber");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String gender = request.getParameter("gender");
        String organization = request.getParameter("organization");
        System.out.println(fullName);
        // Create Contact object
        Contact contact = new Contact();
        contact.setFullName(fullName);
        contact.setGender(gender);
        contact.setEmail(email);
        contact.setIdNumber(idNumber);
        contact.setDob(dateOfBirth);
        contact.setOrganization(organization);
        contact.setMaskedPhone(phoneNumber);
       

        // Save contact to database
        try {
            contactDAO.addContact(contact);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Redirect back to the contact list
        response.sendRedirect("contact");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contact> contacts;
        try {
            contacts = contactDAO.getAllContacts();
            request.setAttribute("contacts", contacts);
            request.getRequestDispatcher("contact-list.jsp").forward(request, response);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}

