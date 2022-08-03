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
         stage('Create allure report'){
            steps{
                  bat '--clean allure generate'
                }
                                        }
        stage('generate allure report'){
           steps{
           allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
                }
                                        }
           stage('create allure report'){
           steps{
emailext attachmentsPattern: '**/allure-report.zip', body: 'rapor from allure', recipientProviders: [buildUser()], subject: '', to: 'omeryttnc@gmail.com,omeryttnc2@gmail.com'                }
                                        }

            }
        }
