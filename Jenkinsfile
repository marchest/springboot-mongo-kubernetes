pipeline {
    agent any
    environment{
        IMAGE_TAG=getDockerImageTag()
         def dockerHome = tool 'myDocker'
         PATH = "${dockerHome}/bin:${env.PATH}"
    }
    stages{
         stage('Building docker image'){
            steps{
            sh "docker build . -t furkankaya/springbootsample:${IMAGE_TAG}"
            }
         }
        stage('push image to docker hub'){
            steps{
                withCredentials([usernamePassword(credentialsId: '92d33158-fd4b-4e6c-9a71-b635da00c56f', passwordVariable: 'Deneme21!', usernameVariable: 'furkankaya')]) {
                        sh "sudo docker login -u furkankaya -p ${dockerHubPassword}"
                        sh "sudo docker push furkankaya/springbootsample:${IMAGE_TAG}"
                }
           }
        }
        stage('Deploy to k8s'){
            steps{
                sh "chmod +x DynamicTagBuilder.sh"
                sh "./DynamicTagBuilder.sh ${IMAGE_TAG}"
                sshagent(['k8s-cluster']) {
                  sh "scp -o StrickHostKeyChecking=no  springboot-deployment.yml gcloudengine2@cloudshell:~/springboot/springboot-nongo-kubernetes"
                  script{
                       try{
                            sh "ssh gcloudengine2@cloudshell kubectl apply -f ."
                       }catch(error){
                            sh "ssh gcloudengine2@cloudshell kubectl create -f ."
                       }
                  }
                }
            }
        }
    }
}

def getDockerImageTag(){
    def tag= sh script: 'git rev-parse HEAD', returnStdout: true
    return tag
}
