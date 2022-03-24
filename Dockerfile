FROM openjdk:17

MAINTAINER Jan <peltzer@jmpsoftware.com>

ADD backend/target/d2kserver.jar d2kserver.jar

CMD [ "sh", "-c", "java  -jar /d2kserver.jar" ]
#CMD [ "sh", "-c", "java -Dserver.port=$PORT -Dspring.data.mongodb.uri=$URI -jar /d2kserver.jar" ]
