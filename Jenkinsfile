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


                       allure includeProperties: false, jdk: '', results: [[path: '**/allure-results']]

zip zipFile: 'allure-report', archive: false, glob: 'allure-report'
//     bat "zip -r allure-report.zip allure-report"

            emailext attachmentsPattern: 'allure-report.zip', body: '', recipientProviders: [buildUser()], subject: '', to: 'omeryttnc@gmail.com'

   // Change the recipent address
//     def mailRecipients = "omeryttnc@gmail.com"
//     env.ForEmailPlugin = env.WORKSPACE
//     if(fileExists('allure-report.zip')){
//         emailext(
//             to: "${mailRecipients}",
//             from: "omeryttnc@gmail.com",
//             subject: "Allure Report",
//             body: "PFA",
//             attachmentsPattern: 'allure-report.zip'
//         )
//     } else{
//         echo("COULD NOT FIND FILE TO ATTACH")
        }



       }
}
}