-- Create the database
CREATE DATABASE people_db;

-- Switch to the database

 USE people_db; 

-- Create the table
CREATE TABLE user_contacts (
    id SERIAL PRIMARY KEY,  -- Auto-incrementing primary key
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone_number VARCHAR(20) UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


