FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/tweet-app.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]