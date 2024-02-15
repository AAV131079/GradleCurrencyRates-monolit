FROM gradle:latest AS GRADLE_BUILD
WORKDIR /app
COPY . .
RUN gradle clean
RUN gradle build
FROM amazoncorretto:19-alpine AS i_currency-rates-monolith-app
RUN apk update
RUN apk add curl
RUN apk add --no-cache tzdata
COPY --from=GRADLE_BUILD /app/build/libs/GradleExchangeRates-monolit-1.0.0.jar GradleExchangeRates-monolit.jar
EXPOSE 2504
ENV TZ="Europe/Kiev"
ENV DB_SCHEMAS="app"
ENV CONTAINER_NAME="currency-rates-postgresql-db"
ENV DB_PORT="5432"
ENV APP_PORT="2504"
ENV POSTGRES_DB="currencyratesdb"
ENV POSTGRES_USER="aav"
ENV POSTGRES_PASSWORD="13101979"
ENV PATH_DATABASE="jdbc:postgresql://${CONTAINER_NAME}:${DB_PORT}/${POSTGRES_DB}"
ENTRYPOINT ["java", "-jar", "GradleExchangeRates-monolit.jar"]