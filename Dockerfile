# Paso 1: Usamos una imagen ligera de Java
FROM eclipse-temurin:21-jdk-slim

WORKDIR /app

# Paso 2: Copiamos el archivo JAR generado por Maven
# (Asegúrate de haber corrido 'mvn package' antes)
COPY target/*.jar app.jar

# Paso 3: Ejecutamos la app
# Render pasará las variables de entorno automáticamente
ENTRYPOINT ["java", "-jar", "app.jar"]