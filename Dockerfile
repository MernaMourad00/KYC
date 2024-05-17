FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/Kycapp-0.0.1-SNAPSHOT.jar /app/Kycapp-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "Kycapp-0.0.1-SNAPSHOT.jar"]