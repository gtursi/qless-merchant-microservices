FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
COPY us-locator-etl.json us-locator-etl.json
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=spring-demo-mongo:27017","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]