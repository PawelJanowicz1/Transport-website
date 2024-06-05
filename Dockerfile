FROM maven:3.9.6-amazoncorretto-21 AS build
WORKDIR /build
COPY . .
RUN mvn clean install

FROM openjdk:21
COPY --from=build /build/target/sand-transport-2.1.1.jar /usr/local/lib/sand-transport-2.1.1.jar
EXPOSE 8064
CMD ["java", "-jar", "/usr/local/lib/sand-transport-2.1.1.jar"]
