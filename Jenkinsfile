def gv
pipeline {
    agent any //For any Jenkins agent available but could be specific if working on clusters, for example
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: 'Version to build and deploy')
        booleanParam(name: 'executeTests', defaultValue: true, description: 'Whether to run tests or not')
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load 'script.groovy'
                }
            }
        }
        stage("build") {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        stage("test") {
            when {
                expression {
                    params.executeTests == true
                }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }
    }
    //    post {
    //        always {          
    //        }
    //    }
}
