pipeline {
    agent any //For any Jenkins agent available but could be specific if working on clusters, for example
    tools {
        maven 'maven-3.9' // Specify the Maven version configured in Jenkins
    }
    stages {
        stage("build jar") {
            steps {
                script {
                    echo 'building the application...'
                    sh 'mvn package'
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo 'building the docker image...'
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                        sh '''
                            echo "Logging in to Docker Hub with username: $DOCKER_USERNAME"
                            echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin
                            docker build -t janetcruzangel/demo-app:jma-2.0 .
                            docker push janetcruzangel/demo-app:jma-2.0
                        '''
                    }
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo 'deploying the application...'
                }            
            }
        }
    }
}
