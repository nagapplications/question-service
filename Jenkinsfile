pipeline {
   // agent any
    //environment {
        // Set the MySQL client path in the environment
      //  PATH = "/opt/homebrew/Cellar/mysql-client/9.2.0/bin:$PATH"
    //}
    stages {
        stage('CLEAN') {
            steps {
                cleanWs()  // Clean workspace before build
            }
        }
        stage('Test MySQL Connection') {
            steps {
                script {
                    // Test MySQL connection
                    //sh 'mysql -u root -h localhost -e "SHOW DATABASES;"'
                    
                    //sh 'mysql -u root --socket=/opt/homebrew/var/mysql/mysql.sock -p -h localhost -e "SHOW DATABASES;"'

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
                    def mavenCMD = "${mavenHome}/bin/mvn"
                    sh "${mavenCMD} clean package"
                }
            }
        }
    }
}
