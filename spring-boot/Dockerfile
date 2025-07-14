FROM eclipse-temurin:17
ARG JAR_FILE=target/*.jar
COPY ./target/friend-api-0.0.2-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]