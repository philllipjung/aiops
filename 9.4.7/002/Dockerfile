FROM gradle:8.7.0-jdk21 AS build

WORKDIR /app
COPY . .

ARG GRADLE_PROJECT
RUN gradle ${GRADLE_PROJECT}:build

FROM eclipse-temurin:21-alpine AS run

RUN addgroup -S app-group && adduser -S -G app-group app-user

ARG PROJECT_PATH
COPY --from=build --chown=app-user:app-user /app/${PROJECT_PATH}/build/libs/*-SNAPSHOT.jar app.jar

EXPOSE 8080
USER app-user

CMD ["java", "-Dspring.profiles.active=dev", "-jar", "app.jar"]