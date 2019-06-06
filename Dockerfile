FROM gizmotronic/oracle-java:java8
LABEL maintainer="krupakar.maadineni@goevive.com"
#RUN apt update ; apt install awscli telnet -y
#ADD aws /root/.aws
#ADD $DOCKER_SUBDIR /$DOCKER_SUBDIR
ADD /*.jar /gateway_Server.jar
ENTRYPOINT [ "java", "-Xmx512m", "gateway_server.jar", "-Dstagemonitor.property.overrides=stagemonitor-DEV.properties", "-jar", "DEV" ]
EXPOSE 10251 11251
