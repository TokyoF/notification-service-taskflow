
# Usar una imagen base de JDK para ejecutar Spring Boot
FROM openjdk:17-jdk-alpine

# Copiar el archivo JAR generado
COPY target/notification-service-0.0.1-SNAPSHOT.jar notification-service.jar

# Exponer el puerto configurado
EXPOSE 8094

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/notification-service.jar"]
