pipeline {
    agent any
    stages {
        stage('CLEAN') {
            steps {
                cleanWs()
            }
        }
        stage('Test MySQL Connection') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'mysql-creds', usernameVariable: 'DB_USER', passwordVariable: 'DB_PASS')]) {
                    sh "mysql -u $DB_USER -p$DB_PASS -h localhost -e 'SHOW DATABASES;'"
                }
            }
        }
        stage('CLONE REPOSITORY') {
            steps {
                git branch: 'main', credentialsId: '8281b350-c5d1-4535-9bfe-9aa64c795f17', url: 'https://github.com/nagapplications/question-service.git'
            }
        }
        stage('MAVEN BUILD') {
            steps {
                script {
                    def mavenHome = tool name: "MAVEN3.9.9", type: "maven"
                    sh "${mavenHome}/bin/mvn clean package -B"
                }
            }
        }
    }
    post {
        always { echo "Pipeline finished." }
        failure { echo "Pipeline failed!" }
    }
}
