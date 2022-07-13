FROM bellsoft/liberica-openjdk-alpine:latest
RUN apk add -U tzdata
ENV TZ America/Lima
RUN ln -snf /usr/share/zoneinfo/${TZ} /etc/localtime
RUN echo "${TZ}" > /etc/timezone
VOLUME /tmp
EXPOSE 9000
ADD ./target/citse-ms-ubigeo-0.0.1-SNAPSHOT.jar ubigeo.jar
ENTRYPOINT ["java", "-jar", "/ubigeo.jar"]
