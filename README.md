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

### Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/vamsinayak826742/RuleEngine-using-AST
