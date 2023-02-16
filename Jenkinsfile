pipeline {
  agent any
  stages {
    stage('Build') {
      agent any
      environment {
        builder = 'bob'
      }
      steps {
        echo 'Build'
      }
    }

  }
}