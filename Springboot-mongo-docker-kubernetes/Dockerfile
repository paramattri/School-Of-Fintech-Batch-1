FROM openjdk:11-alpine
ADD target/tweet-app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]