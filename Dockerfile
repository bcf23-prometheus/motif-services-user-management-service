FROM amazoncorretto:17

RUN mkdir -p /app

WORKDIR /app

COPY ./build/libs/user-management-service.jar /app

CMD ["java", "-jar", "user-management-service.jar"]
