FROM openjdk:22-jdk

COPY target/DockerDemo.jar DockerDemo.jar
WORKDIR /myJarFiles

ENTRYPOINT ["java", "-jar", "/DockerDemo.jar"]