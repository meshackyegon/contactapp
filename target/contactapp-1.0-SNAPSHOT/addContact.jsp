<%-- 
    Document   : addContact.jsp
    Created on : Feb 16, 2025, 10:36:57 AM
    Author     : Meshack
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Contact</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        form {
            max-width: 400px;
            margin: auto;
        }
        input, select {
            width: 100%;
            padding: 8px;
            margin: 5px 0;
        }
        button {
            background-color: blue;
            color: white;
            padding: 10px;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>

    <h2>Add Contact</h2>
    
    <form action="/contact" method="post">
        <label>Full Name:</label>
        <input type="text" name="fullName" required>
        
        <label>Phone Number:</label>
        <input type="text" name="phoneNumber" required>
        
        <label>Email:</label>
        <input type="email" name="email">
        
        <label>ID Number:</label>
        <input type="text" name="idNumber">
        
        <label>Date of Birth:</label>
        <input type="date" name="dob">
        
        <label>Gender:</label>
        <select name="gender">
            <option value="Male">Male</option>
            <option value="Female">Female</option>
        </select>
        
        <label>Organization:</label>
        <input type="text" name="organization">
        
        <button type="submit">Save Contact</button>
    </form>

</body>
</html>
