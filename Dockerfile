FROM openjdk:17
EXPOSE 8081
ADD target/Candidat2AL6-0.0.1-SNAPSHOT.jar Candidat.jar
ENTRYPOINT ["java","-jar","Candidat.jar"]
