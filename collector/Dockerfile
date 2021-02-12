##### Run
FROM openjdk:8-jre-alpine

COPY ./build/libs/collector.jar /bin/runner/collector.jar
COPY ./bin/entry.sh /bin/runner/entry.sh

WORKDIR /bin/runner

CMD ["./entry.sh"]
