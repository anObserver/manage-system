#FROM olvlad/alpine-oraclejdk8:slim
FROM observer11/managesystem
VOLUME /tmp
ADD managesystem-0.0.1-SNAPSHOT.jar  app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]