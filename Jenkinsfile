pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub') // Docker Hub credentials in Jenkins
        GIT_CREDENTIALS = 'github-credentials'          // GitHub credentials in Jenkins
    }

    tools {
    maven 'maven' // the name you gave in Jenkins configuration
}


    stages {
        stage('Stage 1: Git Clone') {
            steps {
                git branch: 'master', url: 'https://github.com/saniyaismail/Calculator.git', credentialsId: GIT_CREDENTIALS
            }
        }

        stage('Stage 2: Build using Maven') {
            steps {
                echo 'Building the project with Maven...'
                sh 'mvn clean package'
            }
        }

        stage('Stage 3: Run Tests') {
            steps {
                echo 'Running JUnit tests...'
                sh 'mvn test'
            }
        }

        stage('Stage 4: Build & Push Docker Image') {
            steps {
                echo 'Building Docker image and pushing to Docker Hub...'
                sh '''
                # Build the Docker image
                docker build -t saniyaismail999/calculator:1.0 .

                # Log in to Docker Hub using stored credentials
                echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin

                # Push the image to Docker Hub
                docker push saniyaismail999/calculator:1.0
                '''
            }
        }

        stage('Stage 5: Clean docker images'){
            steps{
                echo 'Cleaning docker images...'
                sh 'docker container prune -f'
                sh 'docker image prune -f'
            }
        }

        stage('Stage 6: Deploy via Ansible') {
            steps {
                echo 'Running Ansible playbook to deploy container...'
                sh 'ansible --version'
                sh 'ansible-playbook -i ansible/inventory.ini ansible/deploy.yml'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished'
        }
        success {
            echo 'Deployment successful!'
        }
        failure {
            echo 'Pipeline failed. Check logs.'
        }
    }
}
