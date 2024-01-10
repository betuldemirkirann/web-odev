FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY target/rest-app-0.0.1-SNAPSHOT.jar */.jar

EXPOSE 8080

CMD ["java", "-jar", "*/.jar"]

