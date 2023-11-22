pipeline {
    agent any
    stages {
        stage("build code") {
                steps {
                    bat "mvn clean install -DskipTests"
                }
        }

        stage("build Tests") {
                        steps {
                            bat "mvn test"
                        }
                }

        stage("Start container") {
            steps {
               bat "docker-compose up -d --no-color --wait"
               bat "docker-compose ps"
            }

        }

    }

}