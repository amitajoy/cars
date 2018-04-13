#!/usr/bin/env bash
mvn clean compile install -DskipTests -U
export MAVEN_OPTS="-Xmx1g -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=5005,server=y,suspend=n"
#mvn spring-boot:run  -Dserver.port=9090 -DMESSAGE=tempmessage
mvn spring-boot:run  -Dserver.port=9090
