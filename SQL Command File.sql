CREATE DATABASE `hospital_management`;

USE hospital_management;

-- Table for storing doctor information
CREATE TABLE doctors(
    doctor_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    specialization VARCHAR(100) NOT NULL,
    contact_number VARCHAR(15) NOT NULL
);

-- Table for storing patient information
CREATE TABLE patients(
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age INT CHECK(age > 0),
    contact_number VARCHAR(15) NOT NULL,
    address VARCHAR(255) NOT NULL
);

-- Table for storing appointment information
CREATE TABLE appointments(
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    doctor_id INT,
    patient_id INT,
    appointment_date DATE NOT NULL,
    appointment_time TIME NOT NULL,
    FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id),
    FOREIGN KEY (patient_id) REFERENCES patients(patient_id)
);

-- Table for storing disease information
CREATE TABLE diseases(
    disease_id INT PRIMARY KEY auto_increment,
    patient_id INT,
    disease_name VARCHAR(50) NOT NULL,
    current_status VARCHAR(50) NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES patients(patient_id)
);
