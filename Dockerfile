FROM openjdk:8
ADD target/simple-deploy.jar simple-deploy.jar
ENTRYPOINT ["java","-jar","simple-deploy.jar"]