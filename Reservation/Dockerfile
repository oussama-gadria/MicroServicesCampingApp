FROM openjdk:8
EXPOSE 8556
ADD /target/reservation-0.0.1-SNAPSHOT.jar reservation.jar
ENTRYPOINT ["java" , "-jar" , "reservation.jar"]