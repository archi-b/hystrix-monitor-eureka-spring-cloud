FROM openjdk:8-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS="-Xmx2048m -Xms256m"

ADD hystrix-monitor/target/hystrix-monitor-*.jar /app.jar

CMD echo "The application will starting now..." && \
    sleep 0 && \
    java ${JAVA_OPTS} \
    -Djava.security.egd=file:/dev/./urandom -jar /app.jar

