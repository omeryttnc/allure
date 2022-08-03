pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
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
            bat "allure generate"
                }
                                        }
        stage('generate allure report'){
           steps{
           allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
                }
                                        }
           stage('generate allure report'){
           steps{
emailext attachmentsPattern: '**/allure-report/index.html', body: '', recipientProviders: [buildUser()], subject: '', to: 'omeryttnc@gmail.com,omeryttnc2@gmail.com'                }
                                        }

            }
        }
