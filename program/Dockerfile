FROM openjdk:8
EXPOSE 8090
ADD /target/program-0.0.1-SNAPSHOT.jar program.jar
ENTRYPOINT ["java" , "-jar" , "program.jar"]