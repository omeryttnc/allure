pipeline {
    agent any

    tools {
        maven "3.8.4"
    }

      stages {
        stage('Build') {
            steps {
                 bat 'mvn clean test -P omer'
                }
                        }
//          stage('Create allure report'){
//             steps{
//                   bat 'allure generate --clean'
//                 }
//                                         }
        stage('generate allure report'){
           steps{
           allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
                }
                                        }
           stage('send report'){
           steps{
emailext attachmentsPattern: '**/allure-report.zip', body: '', recipientProviders: [buildUser()], subject: '', to: 'omeryttnc@gmail.com'

}}
            }
        }
