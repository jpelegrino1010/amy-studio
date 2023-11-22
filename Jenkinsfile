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

    }

}