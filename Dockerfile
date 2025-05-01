FROM openjdk:17-jdk-alpine AS builder
WORKDIR /app
COPY src ./src
COPY .mvn ./.mvn
COPY mvnw .
COPY pom.xml .
RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder app/target/borrower-service.jar .
EXPOSE 8001
CMD [ "java", "-jar", "borrower-service.jar" ]