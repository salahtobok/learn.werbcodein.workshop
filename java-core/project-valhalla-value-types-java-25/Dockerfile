FROM eclipse-temurin:25-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","--enable-preview","-jar","/app.jar"]
