FROM openjdk:18-jdk-alpine

ADD target/miniproject-rakharafifa.jar miniproject-rakharafifa.jar

ENTRYPOINT ["java", "-jar", "/miniproject-rakharafifa.jar"]