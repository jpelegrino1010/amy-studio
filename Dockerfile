FROM tomcat:9-jdk8-openjdk
COPY target/amy-studio.war /usr/local/tomcat/webapps/amy-studio.war
