pipeline {
    agent any

    tools {
        jdk 'JDK25'
        maven 'Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/mdsofi1/Employee-Management-System.git'
            }
        }

        stage('Build') {
            steps {
                bat 'java -version'
                bat 'mvn -version'
                bat 'mvn clean package -DskipTests'
            }
        }
    }

    post {
        success {
            archiveArtifacts artifacts: 'target/*.war,target/*.jar', allowEmptyArchive: true
        }
    }
}
