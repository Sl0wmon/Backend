FROM openjdk:17
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

ENV SERVER_PORT=8090

ENTRYPOINT ["java", "-jar", "/app.jar", "--server.port=8090"]
