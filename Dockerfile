FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/KYC-APP-0.0.1-SNAPSHOT.jar /app/KYC-APP-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "KYC-APP-0.0.1-SNAPSHOT.jar"]