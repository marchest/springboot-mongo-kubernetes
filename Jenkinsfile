pipeline {
    agent any
    environment{
        IMAGE_TAG=getDockerImageTag()
    }
    stages{
        stage('Building docker image'){
            sh "docker build -t furkankaya/springbootsample:${IMAGE_TAG}"
        }
    }
}
def getDockerImageTag(){
    def tag= sh script: 'git rev-parse HEAD', returnStdout: true
    return tag
}