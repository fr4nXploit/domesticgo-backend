FROM openjdk:17-jdk-slim

WORKDIR /app

# Copiar archivos de configuración de Maven
COPY pom.xml .
COPY mvnw .
COPY mvnw.cmd .
COPY .mvn/ .mvn/

# Copiar código fuente
COPY src/ src/

# Dar permisos de ejecución a mvnw
RUN chmod +x mvnw

# Compilar el proyecto (se genera un .jar en target/)
RUN ./mvnw clean package -DskipTests

EXPOSE 8086

# Usamos sh -c para permitir comodín *.jar
ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT:-8086} -jar target/*.jar"]
