# Rule Engine with AST (Abstract Syntax Tree)

## Project Overview
This project is a dynamic Rule Engine built using **Spring Boot** and **MongoDB** that allows users to:
- Create custom rules using conditional expressions.
- Store rules in a MongoDB database.
- Evaluate user eligibility based on conditions like age, income, department, and experience.

The project uses **Abstract Syntax Tree (AST)** to represent the rules and evaluate user input dynamically.

## Features
- **Create Rules**: Users can define custom rules through a web interface.
- **Update/Delete Rules**: Modify or remove existing rules in the MongoDB database.
- **Evaluate Eligibility**: Evaluate if a user is eligible based on predefined and custom rules.
- **MongoDB Integration**: All rules are stored and managed in a MongoDB database.
- **Spring Boot REST API**: Provides API endpoints for CRUD operations and eligibility evaluation.

## Technologies Used
- **Spring Boot**: Backend framework for RESTful API and business logic.
- **MongoDB**: NoSQL database for storing rules.
- **JavaScript (Vanilla JS)**: For dynamic interactions on the frontend.
- **HTML/CSS**: For the web interface.
- **Maven**: For project build and dependency management.

## Getting Started

### Prerequisites
- **Java 8+** installed
- **Maven** installed
- **MongoDB** installed and running

**Note:-** for more information I have provided to some PDF's refer them

### **Execution of Rule Engine Using AST**

#### **Prerequisites**
To run the Rule Engine project, ensure you have the following installed:
- **Java 8+**: The project is built using Java.
- **Maven**: To manage dependencies and build the project.
- **MongoDB**: A running instance of MongoDB to store rules.
- **Git**: To clone the repository.
- **Eclipse IDE**: Optional, if you wish to work with the project in Eclipse.

#### **Steps to Execute the Project**

1. **Clone the Repository**
   - First, clone the project from GitHub using the command below:
     ```bash
     git clone https://github.com/yourusername/rule-engine-ast.git
     ```

2. **Set Up MongoDB**
   - Make sure you have MongoDB installed and running on your local machine or on a server.
   - The default configuration assumes MongoDB is running locally at `localhost:27017`. You can adjust the MongoDB connection settings in the `application.properties` file:
     ```
     spring.data.mongodb.host=localhost
     spring.data.mongodb.port=27017
     spring.data.mongodb.database=rule_engine
     ```

3. **Build the Project with Maven**
   - Navigate to the project directory:
     ```bash
     cd rule-engine-ast
     ```
   - Use **Maven** to build the project and resolve dependencies:
     ```bash
     mvn clean install
     ```

4. **Run the Spring Boot Application**
   - Use the following command to run the Spring Boot application:
     ```bash
     mvn spring-boot:run
     ```
   - The application will start on the default port **8080**. You should see a message similar to:
     ```
     Tomcat started on port(s): 8080 (http) with context path ''
     Started RuleEngineASTApplication in 5.123 seconds (JVM running for 6.789)
     ```

5. **Access the Application**
   - Open your browser and go to:
     ```
     http://localhost:8080
     ```
   - You will be able to:
     - **Create Rules**: Add new rules through a form on the web interface.
     - **View and Manage Rules**: See the list of rules and update or delete them.
     - **Evaluate Eligibility**: Enter user details like age, income, department, and experience to check eligibility based on predefined and custom rules.

6. **Testing API Endpoints with Postman**
   - You can also interact with the API directly using tools like **Postman**. Here are some example requests:
   
   - **Create a Rule**:
     - **POST** request to `/rules`:
       ```json
       {
           "ruleName": "Test Rule",
           "ruleExpression": "age > 25 && income > 30000"
       }
       ```
   
   - **Evaluate Eligibility**:
     - **POST** request to `/rules/evaluate`:
       ```json
       {
           "age": 30,
           "income": 50000,
           "department": "IT",
           "experience": 5
       }
       ```
     - Response:
       ```json
       {
           "eligible": true
       }
       ```

7. **Stopping the Application**
   - To stop the running application, press **CTRL + C** in the terminal where the app is running.

8. **Troubleshooting**
   - If MongoDB is not running or misconfigured, the application may fail to start. Check the MongoDB logs and ensure the connection settings in `application.properties` are correct.

---

### **Summary of Commands**
- **Clone the project**:
  ```bash
  git clone https://github.com/yourusername/rule-engine-ast.git
  ```
- **Build with Maven**:
  ```bash
  mvn clean install
  ```
- **Run the project**:
  ```bash
  mvn spring-boot:run
  ```
- **Access the web interface**:
  ```
  http://localhost:8080
  ```

