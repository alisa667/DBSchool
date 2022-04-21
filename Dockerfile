#syntax=docker/dockerfile:1

FROM openjdk:16-alpine3.13

EXPOSE 8080

WORKDIR /school

#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./

# RUN #./mvnw dependency:go-offline

#COPY src ./src

#CMD ["./mvnw", "spring-boot:run"]
# , "-Dspring-boot.run.profiles=mysql"

ARG JAR_FILE=target/school-1.0-SNAPSHOT.jar

ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]