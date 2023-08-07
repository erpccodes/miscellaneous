# Hospital Management System

The Hospital Management System is a web-based application for managing hospital staff and patient records. It allows hospital staff to sign up, log in, admit and discharge patients, and view the list of admitted patients. The system is built using Spring Boot for the backend, MySQL for the database, and provides basic authentication and authorization features.

##Note
This is fully functional application but few functionalities could be added for real world usage.
- Security Enhancement: 
Add more advanced security features, such as using JSON Web Tokens (JWT) for authentication

-Testing:
Develop Test Cases to ensure the system functions correctly.

** Because of the time constraint I was unable to add the above enhancement.
If you require I can add the above mentioned functionalities.

## Technologies Used

- Java
- Spring Boot
- MySQL
- Spring Security
- Hibernate
- BCrypt Password Encoder

## Features

- Hospital staff can sign up and log in.
- Hospital staff can admit and discharge patients.
- Admitted patients can be listed.
- Basic authentication and authorization.
- Secure password storage using BCrypt password encoder.

## Getting Started

To run this project locally, follow these steps:

1. Clone the repository:
2. Import the project into your preferred IDE (Eclipse, IntelliJ, etc.).

3. Configure the MySQL database settings in `src/main/resources/application.properties`.

4. Run the Spring Boot application.

5. Access the application at `http://localhost:8080`.

## Usage

1. Sign Up:
- Hospital staff can sign up using a unique username and password.

2. Log In:
- Hospital staff can log in using their registered credentials.

3. Admit Patient:
- Logged-in staff can admit patients by providing patient details.

4. Discharge Patient:
- Logged-in staff can discharge patients by providing the patient's ID.

5. View Admitted Patients:
- Logged-in staff can view the list of currently admitted patients.

## Endpoints

- POST `/api/signup`: Sign up for hospital staff.
- POST `/api/login`: Log in with credentials.
- POST `/api/patients/admit`: Admit a patient.
- GET `/api/patients/admitted`: Get the list of admitted patients.
- PUT `/api/patients/discharge/{id}`: Discharge a patient.
