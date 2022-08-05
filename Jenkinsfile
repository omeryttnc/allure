pipeline {
    agent any

    tools {
        maven "3.8.4"
    }

      stages {
        stage('omer branch calisti') {
            steps {
                 bat 'mvn clean test -P omer'
                }
                                      }


            }

       post{
            always{
              stage('generate allure report'){

                       allure includeProperties: false, jdk: '', results: [[path: '**/allure-results']]



            emailext attachmentsPattern: '**/allure-report/index.html', body: '', recipientProviders: [buildUser()], subject: '', to: 'omeryttnc@gmail.com'



            }

       }
}
}