FROM openjdk:8
ADD target/myretail-docker.jar /myretail-docker.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/myretail-docker.jar"]