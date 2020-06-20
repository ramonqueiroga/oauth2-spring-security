FROM adoptopenjdk/openjdk11:alpine-jre
COPY ./target/oauth2-poc-0.0.1-SNAPSHOT.jar /opt/oauth.jar
WORKDIR /opt
EXPOSE 8081
CMD ["java", "-jar", "oauth.jar"]