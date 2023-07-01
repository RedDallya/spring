FROM adoptopenjdk:17-jdk-hotspot

COPY target/spring-0.0.1-SNAPSHOT.jar /pia-app.jar

ENTRYPOINT ["java", "-jar", "/pia-app.jar"]