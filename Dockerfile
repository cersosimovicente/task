FROM openjdk:21
LABEL manteiner = "laboratorio.net"
ADD target/task-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]