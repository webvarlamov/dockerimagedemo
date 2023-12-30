FROM ubuntu:24.04
EXPOSE 8080
RUN apt-get update && apt install -y git openjdk-17-jre maven
WORKDIR codebase
RUN git clone https://github.com/webvarlamov/dockerimagedemo.git
WORKDIR dockerimagedemo
RUN mvn clean install -DskipTests
ENTRYPOINT mvn spring-boot:run
