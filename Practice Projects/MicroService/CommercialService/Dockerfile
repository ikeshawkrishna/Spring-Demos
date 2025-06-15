FROM openjdk:22-jdk

WORKDIR /myjarfiles
COPY target/CommercialService.jar CommercialService.jar

ENTRYPOINT ["java", "-jar", "CommercialService.jar"]