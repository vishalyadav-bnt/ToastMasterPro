FROM mcr.microsoft.com/openjdk/jdk:21-ubuntu

WORKDIR /app

COPY build/libs/ToastMasterPro-0.0.1-SNAPSHOT.jar ToastMatser.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","ToastMatser.jar"]
