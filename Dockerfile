# the base image
FROM gradle:8.10.0-jdk17-alpine

COPY . .

RUN gradle build -x test

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "build/libs/parcial-1.0.jar"]