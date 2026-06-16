def gv
pipeline {   
    agent any //For any Jenkins agent available but could be specific if working on clusters, for example
    tools {
        maven 'Maven'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    gv.buildJar()

                }
            }
        }

        stage("build image") {
            steps {
                script {
                    gv.buildImage()
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }               
    }
} 
