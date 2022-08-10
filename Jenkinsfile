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
            emailext attachmentsPattern: 'allure-report/index.html', body: '', recipientProviders: [buildUser()], subject: '', to: 'omeryttnc@gmail.com'

                 }
            }
}
//       stages {
//               stage('omer branch calisti') {
//                   steps {
//                        bat 'mvn clean test -P omer'
//                       }
//                                             }
//                   }
//              post{
//                   always{
//                   emailext attachmentsPattern: 'allure-report/index.html', body: '', recipientProviders: [buildUser()], subject: '', to: 'omeryttnc@gmail.com'
//
//                        }
//                   }

//       stage('reports') {
//            steps {
//               script {
//                   allure([
//                     includeProperties: false,
//                     jdk: '',
//                     properties: [],
//                     reportBuildPolicy: 'ALWAYS',
//                     results: [[path: 'target/allure-results']]
//                         ])
//                      }
//                 }
//                        }



                       //allure includeProperties: false, jdk: '', results: [[path: '**/allure-results']]

// zip zipFile: 'allure-report', archive: false, glob: 'allure-report'
//     bat "zip -r allure-report.zip allure-report"


   // Change the recipent address
//     def mailRecipients = "omeryttnc@gmail.com"
//  git    env.ForEmailPlugin = env.WORKSPACE
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
