pipeline {
    agent any

    tools {
        jdk 'JDK25'
        maven 'Maven3'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Verify') {
            steps {
                bat 'java -version'
                bat 'mvn -version'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }
    }
}
