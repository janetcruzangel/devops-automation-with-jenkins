pipeline {
    agent any //For any Jenkins agent available but could be specific if working on clusters, for example    
    stages {
        stage("test") {
            steps {
                script {
                    echo 'Testing the application...'
                    echo 'Executing pipeline for branch ${BRANCH_NAME}' //This env var is only available for multibranch pipelines
                }
            }
        }
        stage("build") {
            when{
                expression {
                    return env.BRANCH_NAME == 'main' //Only build if the branch is main
                }
            }
            steps {
                script {
                    echo 'building the application...'
                }
            }
        }
        stage("deploy") {
            when{
                expression {
                    return env.BRANCH_NAME == 'main' //Only build if the branch is main
                }
            }
            steps {
                script {
                    echo 'deploying the application...'
                }            
            }
        }
    }
}
