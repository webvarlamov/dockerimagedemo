FROM ubuntu:24.04
RUN apt-get update && apt install git openjdk-17-jre && java --version
