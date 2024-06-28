# Etapa de construcción
FROM maven:3.8.6-openjdk-21-slim AS build

# Copiar los archivos de tu proyecto al contenedor
COPY . /app

# Establecer el directorio de trabajo en /app
WORKDIR /app

# Ejecutar Maven para construir el proyecto y generar el JAR
RUN mvn clean package -DskipTests

# Etapa final
FROM openjdk:21-jdk-slim

# Exponer el puerto 8080 (esto es más una documentación)
EXPOSE 8080

# Copiar el archivo JAR construido desde la etapa de construcción
COPY --from=build /app/target/*.jar /app.jar

# Configurar la aplicación para que use el puerto especificado por Render
ENV PORT 8080

# Establecer el punto de entrada para ejecutar el archivo JAR
ENTRYPOINT ["java", "-jar", "/app.jar"]