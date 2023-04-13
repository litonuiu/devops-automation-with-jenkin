pipeline {
    agent any

    stages {
        stage('Compile Stage') {
            steps {
                withMaven(maven: 'maven_3_5_0') {
                    bat 'mvn clean package'
                }
            }
        }

        stage('Testing Stage') {
            steps {
                withMaven(maven: 'maven_3_5_0') {
                    bat 'mvn test'
                }
            }
            
            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }

        /*stage('Deployment Stage') {
            steps {
                withMaven(maven: 'maven_3_5_0') {
                    bat 'mvn deploy'
                }
            }
        }*/
    }
}
