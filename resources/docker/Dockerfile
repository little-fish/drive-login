FROM eclipse-temurin:17.0.10_7-jre-alpine
ARG JAR_FILE=*.jar
ENV LOG_HOME=/var/log/drive-login
RUN addgroup -S driver && adduser -S driver -G driver
RUN mkdir -p /opt/drive-login
RUN chown driver:driver /opt/drive-login
USER driver:driver
COPY ${JAR_FILE} /opt/drive-login/drive-login.jar
ENTRYPOINT ["java","-jar","/opt/drive-login/drive-login.jar"]
