FROM maven:3.8.1-jdk-11-slim as build
RUN mkdir -p /backend
COPY pom.xml /backend
COPY src /backend/src
WORKDIR /backend
RUN mvn -f pom.xml clean package

FROM openjdk:11.0-slim
COPY --from=build /backend/target/*.jar app.jar
COPY images /images
EXPOSE 9000
ENTRYPOINT ["java","-jar","app.jar"]
