FROM openjdk:8-alpine

COPY target/uberjar/buddyhello.jar /buddyhello/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/buddyhello/app.jar"]
