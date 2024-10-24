![Screenshot (808)](https://github.com/user-attachments/assets/7f7256e5-eb60-49bc-9721-2da6c83a4210)
# Rule Engine using AST

This project is a dynamic **Rule Engine** built using **Spring Boot** and **MongoDB**. It allows users to:
- **Create custom rules** with conditional expressions (e.g., age, income, department, experience).
- **List, update, and delete rules** in a rules table.
- **Evaluate user eligibility** based on the defined rules.
The project uses an **Abstract Syntax Tree (AST)** to represent and evaluate user inputs dynamically.

## Prerequisites

Make sure you have the following installed:
- **Java 17**
- **Maven** for project build and dependency management
- **MongoDB** for storing the rules (MongoDB Compass recommended for an easy UI management)
- **Spring Boot** CLI (optional, for easier running of Spring applications)

**Note**: This is a Maven project. Use Eclipse IDE for executing this project.

## Project Hierarchy

The project is organized as follows:
- **Java code and classes** are saved under `src/main/java/com/ruleEngine/`.
- **Frontend files (HTML, CSS, JavaScript)** are saved under `src/main/resources/static/`.
- **Backend configuration and MongoDB setup** is in `application.properties` under `src/main/resources/`.

### Folder Structure

```
ruleEngineAST/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── ruleengine/
│   │   │           ├── ApplicationRunner.java          # Application entry runner
│   │   │           ├── RuleEngineApplication.java      # Main Spring Boot application class
│   │   │           ├── controller/
│   │   │           │   └── RuleController.java         # REST Controller to handle HTTP requests
│   │   │           ├── model/
│   │   │           │   ├── Rule.java                   # Model class for Rule entity
│   │   │           │   └── UserInput.java              # Model class for user input
│   │   │           ├── repository/
│   │   │           │   └── RuleRepository.java         # Repository interface for MongoDB
│   │   │           └── service/
│   │   │               └── RuleService.java            # Service class to handle business logic
│   ├── resources/
│   │   ├── static/
│   │   │   └── (Frontend files - HTML, CSS, JavaScript) # Frontend assets folder
│   │   └── application.properties                      # Configuration for MongoDB and other settings
│
├── target/                                              # Compiled output files
│   └── ruleEngineAST-0.0.1-SNAPSHOT.jar                 # JAR file after build
│
├── pom.xml                                              # Maven dependencies and build configurations
```

## Dependencies (pom.xml)

Ensure your `pom.xml` file contains the following dependencies (already included in the GitHub repository):

```xml
<dependencies>
    <!-- Spring Boot dependencies -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- MongoDB dependencies -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-mongodb</artifactId>
    </dependency>

    <!-- DevTools for live reloading -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Jackson for JSON processing -->
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
    </dependency>

    <!-- Testing dependencies -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Step-by-Step Guide for Execution

### 1. Clone the Repository

First, clone this repository from GitHub:
```bash
git clone https://github.com/your-repo/rule-engine.git
```

### 2. Setup MongoDB

- Start MongoDB and ensure it is running.
- Open **MongoDB Compass** and create a new database called `ruleEngineDB`.
- Inside `ruleEngineDB`, create a new **collection** named `rules` where the rule data will be stored.

### 3. Configure Application Properties

- Save the project (cloned from GitHub) in Eclipse and ensure the folder structure matches the **Project Hierarchy** mentioned above.
- In `src/main/resources/application.properties`, configure the MongoDB connection details:

```properties
spring.data.mongodb.database=ruleEngineDB
spring.data.mongodb.uri=mongodb://localhost:27017/ruleEngineDB
```

### 4. Build the Project

Use Maven commands in Eclipse to install dependencies and build the project:

- **Step 1**: Right-click on the project in Eclipse.
  - Select `Maven -> Update Project`.
  - Enable `Force Update` and click on `Update`.

- **Step 2**: Build the project.
  - Right-click on the project again.
  - Select `Run As -> Maven Build`.
  - In the input box, type `clean install` and press enter.

### 5. Run the Spring Boot Application

After the project is built, run the Spring Boot application by executing the main application file:

- Navigate to `src/main/java/com/ruleEngine/`.
- **Step 1**: Right-click on `RuleEngineApplication.java`.
  - Select `Run As -> Java Application` or `Spring Boot App`.

Alternatively, you can use Maven to run the application:
```bash
mvn spring-boot:run
```

### 6. Access the Application in the Browser

Once the application is running, open your web browser and go to:
```
http://localhost:8080
```

### 7. Interact with the Rule Engine

- **Create Rules**: In the UI, enter a rule name, condition, and action, and click "Create Rule."
- **List Rules**: After creating a rule, it will appear in the table under the "Rules List" section.
- **Delete Rules**: Each rule has a delete button to remove it from the table and MongoDB.
- **Update Rules**: (Optional) Edit rules directly from the list if this feature is implemented.

### 8. MongoDB Verification

Open **MongoDB Compass** and check the `rules` collection in `ruleEngineDB` to see the newly created rules stored in MongoDB.

---

### Output

# Rule Engine using AST

After the successful execution of the project, the webpage will look like the following:

![Screenshot (807)](https://github.com/user-attachments/assets/1f9ccf75-f241-478b-88e1-73c6cd6fb295)

![Screenshot (808)](https://github.com/user-attachments/assets/364ff195-2517-428a-9c6b-5827d9ca44f0)

Once the rules is created (e.g., "Age >= 30"), it will be saved in MongoDB and displayed in the rules table look like the following:

![Screenshot (809)](https://github.com/user-attachments/assets/60ab0481-45c9-46d4-a8af-07cc152bf19b)

If you want you can update or delete here. This is also stored in MongoDB database.

## Output for user egilibilty

![Screenshot (810)](https://github.com/user-attachments/assets/48f7578b-6d28-4b3d-aee5-59e053427c87)

Now, you're ready to use this dynamic rule engine! Feel free to modify the conditions and actions to suit your needs.
