FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/kycapp-0.0.1-SNAPSHOT.jar /app/kycapp-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "Kycapp-0.0.1-SNAPSHOT.jar"]