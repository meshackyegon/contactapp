/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;





/**
 *
 * @author FRIDAH
 */
@WebServlet(name = "ContactsApi", urlPatterns = {"/ContactsApi"})
public class ContactsApi extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   private static final String API_BASE_URL = "http://localhost:8080/contact-registry/api";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        
        String phoneHash = request.getParameter("phoneHash");
        String maskedName = request.getParameter("maskedName");
        String maskedPhone = request.getParameter("maskedPhone");
        String organization = request.getParameter("organization");
        
        String apiUrl = null;
        
        if (phoneHash != null && !phoneHash.isEmpty()) {
            apiUrl = API_BASE_URL + "/contacts/search?phoneHash=" + phoneHash;
        } else if (maskedName != null && maskedPhone != null) {
            apiUrl = API_BASE_URL + "/contacts/search?maskedName=" + maskedName + "&maskedPhone=" + maskedPhone;
        } else if (organization != null && !organization.isEmpty()) {
            apiUrl = API_BASE_URL + "/contacts/organization?name=" + organization;
        }
        
        if (apiUrl != null) {
            try {
                String jsonResponse = fetchApiResponse(apiUrl);
                out.print(jsonResponse);
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                out.print("{\"error\": \"Failed to retrieve contacts\"}");
            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"error\": \"Invalid search parameters\"}");
        }
    }
    
    private String fetchApiResponse(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        
        Scanner scanner = new Scanner(conn.getInputStream());
        StringBuilder response = new StringBuilder();
        while (scanner.hasNext()) {
            response.append(scanner.nextLine());
        }
        scanner.close();
        
        return response.toString();
    }

}
