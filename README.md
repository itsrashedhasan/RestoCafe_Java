# RestoCafe - Restaurant & Cafeteria Management System

RestoCafe is a desktop-based **Restaurant & Cafeteria Management System** developed using **Java Swing** and **MySQL**. The project was completed in **December 2023** as part of the **Object Oriented Programming LAB** course.

This application provides a graphical interface for managing restaurant activities such as user authentication, dashboard monitoring, menu display, order processing, billing, payment, table reservation, feedback, and reporting.

---

## Project Overview

Managing a restaurant manually can be time-consuming and error-prone, especially when handling customer orders, menu items, billing, reservations, and customer feedback. RestoCafe was developed as an academic desktop application to demonstrate how **Object-Oriented Programming**, **Java Swing GUI design**, and **MySQL database connectivity** can be used to build a practical restaurant management system.

The system is designed for restaurant staff or administrators who need a simple desktop-based interface to manage daily restaurant operations.

---

## Project Purpose

The main purpose of this project was to apply Java OOP concepts in a real-world style desktop application. Through this project, we practiced:

* Java Swing GUI development
* Event-driven programming
* JDBC database connectivity
* Form-based desktop application design
* User authentication workflow
* External JAR library integration
* Team-based software development
* Academic project documentation

This project represents my early hands-on experience with Java desktop application development.

---

## Key Features

* Get Started interface
* User signup system
* User login system
* Forgot password functionality using security question
* Dashboard with sales and income overview
* Pie chart, histogram, bar chart, and sales graph visualization
* Menu display with food items and prices
* Order management interface
* Billing and payment calculation
* Receipt generation interface
* Table reservation interface
* Feedback and report section
* Settings section
* Java Swing-based graphical user interface
* MySQL database connectivity

---

## Tech Stack

| Category              | Technology                                                                                 |
| --------------------- | ------------------------------------------------------------------------------------------ |
| Programming Language  | Java                                                                                       |
| GUI Framework         | Java Swing                                                                                 |
| Database              | MySQL                                                                                      |
| Database Connectivity | JDBC                                                                                       |
| IDE                   | NetBeans                                                                                   |
| Build System          | Apache Ant / NetBeans Build                                                                |
| External Libraries    | MySQL Connector/J, JFreeChart, FlatLaf, RS2XML, TimingFramework, AbsoluteLayout, RojeruSan |

---

## Course Information

| Item            | Details                         |
| --------------- | ------------------------------- |
| Course Code     | CSE-215                         |
| Course Title    | Object Oriented Programming LAB |
| Semester        | Fall 2023                       |
| Submission Date | 25 December 2023                |
| Project Type    | Academic Group Project          |
| Team Name       | Tech Titans                     |

---

## Team Members

* **Rashedul Hasan Shohan**
* Jalal Ahmmed
* MD. Al Mahmud

---

## My Contribution

I contributed to both frontend and backend development of the project.

My major responsibilities included:

* Designing and developing major Java Swing interfaces
* Implementing backend logic for core application flow
* Working on signup and login functionality
* Implementing forgot password workflow
* Connecting Java forms with MySQL database using JDBC
* Supporting backend work for Order and Menu functionalities
* Integrating external JAR libraries
* Testing, debugging, and improving application navigation
* Supporting project documentation and final presentation preparation

The frontend design of the Menu and Order sections was mainly handled by other team members, while I contributed to backend functionality and the overall system integration.

---

## Project Structure

```text id="q9pwwh"
RestoCafe_Java/
│
├── README.md
├── LICENSE
├── .gitignore
├── build.xml
├── manifest.mf
│
├── src/
│   ├── Icon/
│   └── restocafe_rms/
│       ├── CustomScrollPane.java
│       ├── Dashboard.java
│       ├── Feedback.java
│       ├── ForgetPassWord.java
│       ├── GetStarted.java
│       ├── JCheckBoxCustom.java
│       ├── Login.java
│       ├── RestoCafe_RMS.java
│       └── SignupForget.java
│
├── lib/
│   ├── AbsoluteLayout-RELEASE200.jar
│   ├── flatlaf-3.2.5.jar
│   ├── jcommon-1.0.23.jar
│   ├── jfreechart-1.0.19.jar
│   ├── mysql-connector-j-8.1.0.jar
│   ├── RojeruSan.parte1.jar
│   ├── rs2xml.jar
│   └── TimingFramework-0.55.jar
│
├── database/
│   └── schema.sql
│
├── docs/
│   ├── report/
│   │   └── Final_Project_Report.pdf
│   └── screenshots/
│       ├── get-started.jpg
│       ├── sign-up.jpg
│       ├── sign-in.jpg
│       ├── forget-password.jpg
│       ├── dashboard.jpg
│       ├── menu.jpg
│       ├── order.jpg
│       └── feedback.jpg
│
└── nbproject/
```

---

## Screenshots

### Get Started

![Get Started](docs/screenshots/get-started.jpg)

### Sign Up

![Sign Up](docs/screenshots/sign-up.jpg)

### Sign In

![Sign In](docs/screenshots/sign-in.jpg)

### Forgot Password

![Forgot Password](docs/screenshots/forget-password.jpg)

### Dashboard

![Dashboard](docs/screenshots/dashboard.jpg)

### Menu

![Menu](docs/screenshots/menu.jpg)

### Order

![Order](docs/screenshots/order.jpg)

### Feedback

![Feedback](docs/screenshots/feedback.jpg)

---

## Demo Video

A project demonstration video is available on YouTube:

[Watch Demo Video](https://youtu.be/TwdmiRSK3bw)

---

## Prerequisites

Before running the project, make sure you have installed:

* Java JDK
* NetBeans IDE
* MySQL Server
* MySQL Connector/J
* Apache Ant, if running from command line

---

## Database Setup

This project uses a MySQL database named `rasheddb`.

### 1. Create Database

Open MySQL and run:

```sql id="a376nb"
CREATE DATABASE IF NOT EXISTS rasheddb;
USE rasheddb;
```

### 2. Create User Table

Run the SQL file located at:

```text id="k2g7uu"
database/schema.sql
```

Or manually execute:

```sql id="a44y88"
CREATE TABLE IF NOT EXISTS user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    question VARCHAR(255) NOT NULL,
    answer VARCHAR(255) NOT NULL
);
```

### 3. Configure Database Credentials

Open the Java files where the database connection is used and update the MySQL credentials according to your local setup:

```java id="mzdnpp"
SUrl = "jdbc:mysql://localhost:3306/rasheddb";
SUser = "root";
SPass = "YOUR_MYSQL_PASSWORD";
```

Do not upload your real MySQL password publicly.

---

## How to Run the Project

### Option 1: Run with NetBeans

1. Clone this repository:

```bash id="sk1crk"
git clone https://github.com/itsrashedhasan/RestoCafe_Java.git
```

2. Open **NetBeans IDE**.

3. Go to:

```text id="oyxfra"
File → Open Project
```

4. Select the project folder.

5. Make sure MySQL Server is running.

6. Create the database and table using:

```text id="rdsrgg"
database/schema.sql
```

7. Update the database password in the Java source files.

8. Run the project from NetBeans.

---

### Option 2: Build with Apache Ant

If Apache Ant is installed, run:

```bash id="n5ux1c"
ant clean jar
```

Then run the generated JAR file:

```bash id="di3iyr"
java -jar dist/RestoCafe_RMS.jar
```

---

## Important Note About Security

This was an academic desktop project developed for learning purposes. The current implementation uses a basic authentication system and stores passwords in plain text.

For production-level use, the following improvements are necessary:

* Password hashing
* Prepared statements for SQL queries
* Better input validation
* Role-based access control
* Secure database configuration
* Separation of configuration files from source code

---

## Project Report

The full academic project report is available here:

```text id="ib5963"
docs/report/Final_Project_Report.pdf
```

---

## Learning Outcomes

Through this project, I learned:

* Java object-oriented programming
* Java Swing GUI development
* Event handling in desktop applications
* JDBC and MySQL database connectivity
* NetBeans project structure
* Working with external JAR libraries
* Designing multi-page desktop applications
* Debugging GUI-based Java programs
* Team collaboration in an academic software project
* Preparing project documentation and demo presentation

---

## Limitations

* This is an academic desktop application, not a production-ready restaurant system
* Passwords are not encrypted
* Database credentials need to be configured manually
* Some modules are UI-focused and not fully database-driven
* No advanced admin/staff role management
* No online ordering system
* No cloud database integration
* No mobile or web version

---

## Future Improvements

* Add password hashing
* Use prepared statements for safer SQL operations
* Add admin and staff role management
* Improve database design
* Add complete inventory database integration
* Add online ordering support
* Add table booking with database storage
* Add customer loyalty system
* Add employee scheduling module
* Add dark/light mode
* Improve reporting and analytics
* Develop a web or mobile version

---

## License

This project is licensed under the MIT License.

---

## Author

**Rashedul Hasan Shohan**
BSc in Computer Science and Engineering
Daffodil International University
