FROM openjdk:17-alpine
VOLUME /tmp
EXPOSE 8080
ADD ./target/test-0.0.1-SNAPSHOT.jar test.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=default","/test.jar"]