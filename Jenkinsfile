pipeline {
    agent any

    tools {
        jdk 'JDK17'        // Use the JDK defined in Jenkins global tools
        maven 'Maven3'     // Use the Maven defined in Jenkins global tools
    }

    environment {
        MAVEN_OPTS = "-Xmx2g" // Adjust memory options for Maven if needed
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from GitHub repository
                git branch: 'main', url: 'https://github.com/your-username/rule-engine.git'
            }
        }

        stage('Build') {
            steps {
                // Run Maven clean install to build the project
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                // Run Maven tests
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                // Package the application as a JAR
                sh 'mvn package'
            }
        }

        stage('Deploy') {
            steps {
                // Replace with actual deployment strategy
                echo 'Deploying application...'
                
                // Example: Securely copy JAR to server (adjust paths and credentials as needed)
                // sh 'scp target/ruleEngineAST-0.0.1-SNAPSHOT.jar user@server:/path/to/deploy'

                // Restart the service (example for a systemd service)
                // sh 'ssh user@server "sudo systemctl restart rule-engine-service"'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
            // Optional: Add success notifications here, like sending an email
        }
        failure {
            echo 'Pipeline failed.'
            // Optional: Add failure notifications here, like sending an alert
        }
    }
}
