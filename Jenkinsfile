pipeline {
    agent any
    triggers{
        github( triggerOnPush: true,
                triggerOnMergeRequest: true,
                branchFilterType: 'All')
    }
    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        disableConcurrentBuilds()
        timeout(time: 10, unit: 'MINUTES')
        timestamps()
    }
    stages {
        stage('on master branch') {
            when {
                branch 'master'
            }
            steps{
                sh '''
                    echo "This is on master branch."
                '''
            }
        }
        stage('on dev branch') {
            when {
                branch 'dev'
            }
            steps {
                sh '''
                    echo "This is on dev branch."
                '''
            }
        }
        stage('delete') {
            steps {
                echo 'clean workdir'
                cleanWs()
            }
        }
    }
    post {
        success {
            sh "echo success"
        }
        failure {
            sh "echo failure"
        }
    }
}
