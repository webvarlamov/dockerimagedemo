# Установка энвайромента
FROM ubuntu:24.04
EXPOSE 8080
RUN apt-get update && apt install -y git openjdk-17-jre maven

# Копирование приложения
WORKDIR codebase
RUN git clone https://github.com/webvarlamov/dockerimagedemo.git

# Сборка приложения
WORKDIR dockerimagedemo
RUN mvn clean install -DskipTests

# Запуск приложения
ENTRYPOINT mvn spring-boot:run
