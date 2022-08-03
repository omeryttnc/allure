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
//                   bat '--clean allure generate'
//                 }
//                                         }
//         stage('generate allure report'){
//            steps{
//            allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
//                 }
//                                         }
           stage('create allure report'){
           steps{
emailext attachLog: true, attachmentsPattern: '\'**/allure-report.zip\'', body: '', compressLog: true, recipientProviders: [buildUser()], subject: 'email alolure', to: 'omeryttnc@gmail.com'                                        }

            }
        }
