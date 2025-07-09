FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/DomesticGO-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8086
ENTRYPOINT ["java", "-Dserver.port=${PORT:-8086}", "-jar", "app.jar"]
