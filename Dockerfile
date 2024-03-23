FROM openjdk:17-oracle
COPY target/user-details-service-0.0.1-SNAPSHOT.jar user-details-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/user-details-service-0.0.1-SNAPSHOT.jar"]