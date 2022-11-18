FROM openjdk:19-alpine
ARG JAR_FILE=target/discuont_service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} discuont_service.jar

ENTRYPOINT ["java","-jar","/discuont_service.jar"]

EXPOSE 8080
